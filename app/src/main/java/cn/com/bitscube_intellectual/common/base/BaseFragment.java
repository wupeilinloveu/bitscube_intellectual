package cn.com.bitscube_intellectual.common.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.InputStream;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.util.LoadingUtil;
import cn.com.bitscube_intellectual.common.util.Utils;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * 封装Fragment的基类
 * Created by Emily on 9/6/21
 */
public abstract class BaseFragment extends SupportFragment
        implements IUIOperation, BaseView {
    protected BaseActivity mActivity;
    //自定义Loading进度条
    private LoadingUtil loading;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onCurrentAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (BaseActivity) getActivity();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mRoot == null) {
            mRoot = inflater.inflate(getLayoutRes(), null);

            Utils.findButtonAndSetOnClickListener(mRoot, this);
            //初始化View
            initView();
            //初始化数据
            initData();
            //初始化监听器
            initListener();
        } else {
            unbindWidthParent(mRoot);
        }
        return mRoot;
    }

    /**
     * Rewriting this method to replace onAttach,
     * High and low versions are incompatible
     */
    protected void onCurrentAttach(Context mContext) {
    }

    public View mRoot;

    /**
     * Decoupling the parent-child control relationship
     */
    public void unbindWidthParent(View view) {
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
    }

    public <T> T findView(int id) {
        @SuppressWarnings("unchecked")
        T view = (T) mRoot.findViewById(id);
        return view;
    }

    @Override
    public void onClick(View v) {
        onClick(v, v.getId());
    }

    @Override
    public void onStop() {
        super.onStop();
        if (loading != null) {
            if (loading.isShowing()) {
                loading.dismiss();
                loading=null;
            }
        }
    }

    public void showLoading() {
        loading = new LoadingUtil(getActivity(), R.style.CustomDialog);
        loading.show();
    }

    public void dismissLoading() {
        loading.dismiss();
    }

    /**
     * 读取本地json文件
     */
    public String readLocalJson(Context context, String fileName) {
        String jsonString = "";
        String resultString = "";
        try {
            InputStream inputStream = context.getResources().getAssets().open(fileName);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            resultString = new String(buffer, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }
}

