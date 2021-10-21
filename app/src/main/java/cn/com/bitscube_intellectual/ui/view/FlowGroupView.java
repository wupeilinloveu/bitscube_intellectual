package cn.com.bitscube_intellectual.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义的动态布局控件
 * Created by Emily on 2021/8/16
 */
public class FlowGroupView extends ViewGroup {
    /**
     * 储存所有的view 按行记录
     */
    private List<List<View>> mAllViews = new ArrayList<List<View>>();
    /**
     * 记录每一行的高度
     */
    private List<Integer> mLineHeight = new ArrayList<Integer>();
    private String TAG = "TAG";

    public FlowGroupView(Context context, AttributeSet attrs,
                         int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FlowGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowGroupView(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mAllViews.clear();
        mLineHeight.clear();
        //得到上级容器为其推荐的宽高和计算模式
        int specWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int specHeighMode = MeasureSpec.getMode(heightMeasureSpec);
        int specWidthSize = MeasureSpec.getSize(widthMeasureSpec);
        int specHeighSize = MeasureSpec.getSize(heightMeasureSpec);
        int width = 0;
        int height = 0;
        // 得到子view的个数
        int cCount = getChildCount();
        /**
         * 记录每一行的宽度，width不断取最大宽度
         */
        int lineWidth = 0;
        /**
         * 每一行的高度，累加至height
         */
        int lineHeight = 0;

        // 存储每一行所有的childView
        List<View> lineViews = new ArrayList<View>();

        for (int i = 0; i < cCount; i++) {
            // 得到每个子View
            View child = getChildAt(i);
            // 测量每个子View的宽高
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            // 当前子view的lp
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            // 子view的宽和高
            int cWidth = 0;
            int cheight = 0;

            cWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;

            cheight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            lineHeight = cheight;

            if (lineWidth + cWidth > specWidthSize) {
                width = Math.max(lineWidth, cWidth);
                lineWidth = cWidth;

                mAllViews.add(lineViews);
                mLineHeight.add(cheight);
                lineViews = new ArrayList<>();

                lineViews.add(child);
                height += cheight;
                Log.e("需要换行", "hight--" + height);
                Log.e("onMeasure", "AllViews.size()  --  > " + mAllViews.size());
            } else {

                lineWidth += cWidth;
                Log.e("不需要换行", "hight--" + height);

                lineViews.add(child);
            }

            if (i == cCount - 1) {
                // 如果是最后一个view
                width = Math.max(lineWidth, cWidth);
                height += cheight;
                Log.e("最后一个view", "hight--" + height);
            }
        }

        mLineHeight.add(lineHeight);
        mAllViews.add(lineViews);

        setMeasuredDimension(
                specWidthMode == MeasureSpec.EXACTLY ? specWidthSize : width,
                specHeighMode == MeasureSpec.EXACTLY ? specHeighSize : height
        );
        Log.e("onMeasure", "mAllViews.size() -- > " + mAllViews.size() + "   mLineHeight.size() -- > " + mLineHeight.size() + "Height -- > " + height);
    }

    /**
     * 所有childView的位置的布局
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int lineHeight = 0;

        List<View> lineViews = new ArrayList<View>();
        int left = 0;
        int top = 0;

        int lineNums = mAllViews.size();
        for (int i = 0; i < lineNums; i++) {

            lineViews = mAllViews.get(i);

            lineHeight = mLineHeight.get(i);

            Log.e("onLayout", "第" + i + "行 ：" + lineViews.size() + "-------lineHeight" + lineHeight);

            // 遍历当前行所有的View
            for (int j = 0; j < lineViews.size(); j++) {
                View child = lineViews.get(j);
                if (child.getVisibility() == View.GONE) {
                    continue;
                }
                MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

                //计算childView的left,top,right,bottom
                int lc = left + lp.leftMargin;
                int tc = top + lp.topMargin;
                int rc = lc + child.getMeasuredWidth();
                int bc = tc + child.getMeasuredHeight();

                child.layout(lc, tc, rc, bc);

                left += child.getMeasuredWidth() + lp.rightMargin + lp.leftMargin;
            }
            left = 0;
            top += lineHeight;
        }
        Log.v("onLayout", "onLayout   mAllViews.size() -- > " + mAllViews.size() + "   mLineHeight.size() -- > " + mLineHeight.size());
    }


    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {

        return new MarginLayoutParams(getContext(), attrs);
    }

}
