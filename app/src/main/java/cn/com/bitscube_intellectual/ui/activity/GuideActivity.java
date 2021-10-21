package cn.com.bitscube_intellectual.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import cn.com.bitscube_intellectual.R;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * 引导页
 * Created by Emily on 9/9/21
 */
public class GuideActivity extends SupportActivity {
    private ViewPager mMViewPager;
    private ImageView mPoint1;
    private ImageView mPoint2;
    private ImageView mPoint3;
    private LinearLayout mMLinearLayout;
    private Button mBtnStart;

    ArrayList<View> mList=new  ArrayList<View>();

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        //初始化View
        initView();
    }

    private void initView() {
        mMViewPager = findViewById(R.id.mViewPager);
        mPoint1 = findViewById(R.id.point1);
        mPoint2 = findViewById(R.id.point2);
        mPoint3 = findViewById(R.id.point3);
        mMLinearLayout = findViewById(R.id.mLinearLayout);
        mBtnStart = findViewById(R.id.btn_start);

        //设置默认图片
        setPointImg(true, false, false);

        //第三页的按钮点击事件
        mBtnStart.setOnClickListener(v -> goToLogin()); {
        }

        View view1=View.inflate(this, R.layout.guide_pager_item_talents, null);
        View view2=View.inflate(this, R.layout.guide_pager_item_depts, null);
        View view3=View.inflate(this, R.layout.guide_pager_item_projects, null);

        mList.add(view1);
        mList.add(view2);
        mList.add(view3);

        //设置适配器
        mMViewPager.setAdapter(new GuideAdapter());

        //监听ViewPager的滑动
        mMViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
              if(position==0){
                  setPointImg(true, false, false);
                  mBtnStart.setVisibility(View.GONE);
              }else if(position==1){
                  setPointImg(false, true, false);
                  mBtnStart.setVisibility(View.GONE);
              }else if(position==2){
                  setPointImg(false, false, true);
                  mBtnStart.setVisibility(View.VISIBLE);
              }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void goToLogin(){
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void setPointImg(Boolean isCheck1, Boolean isCheck2, Boolean isCheck3){
        if (isCheck1) {
            mPoint1.setBackgroundResource(R.drawable.point_talents_on);
        } else {
            mPoint1.setBackgroundResource(R.drawable.point_off);
        }
        if (isCheck2) {
            mPoint2.setBackgroundResource(R.drawable.point_depts_on);
        } else {
            mPoint2.setBackgroundResource(R.drawable.point_off);
        }
        if (isCheck3) {
            mPoint3.setBackgroundResource(R.drawable.point_projects_on);
        } else {
            mPoint3.setBackgroundResource(R.drawable.point_off);
        }
    }

    class GuideAdapter extends PagerAdapter {
        @Override
        public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
            return true;
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @NonNull
        @NotNull
        @Override
        public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
            return mList.get(position);
        }

        @Override
        public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
            mMViewPager.removeView(mList.get(position));
        }
    }
}
