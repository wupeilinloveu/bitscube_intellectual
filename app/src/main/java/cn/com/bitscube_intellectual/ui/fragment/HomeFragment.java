package cn.com.bitscube_intellectual.ui.fragment;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.BaseFragment;
import cn.com.bitscube_intellectual.common.util.GsonUtil;
import cn.com.bitscube_intellectual.model.bean.Home;
import cn.com.bitscube_intellectual.ui.activity.SearchActivity;
import cn.com.bitscube_intellectual.ui.adapter.HomeProjectInfoRvAdapter;

/**
 * 首页
 * Created by Emily on 9/6/21
 */
public class HomeFragment extends BaseFragment {
    private TextView mToolbarTv;
    private ImageView mHomeImgSearch;
    private Toolbar mToolbar;
    private ImageView mHomeImg;
    private LinearLayout mLlHomeImg;
    private TextView mTvContent01;
    private LinearLayout mLlHomeNetworkError;
    private RecyclerView mRvHome;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        mToolbarTv = findView(R.id.toolbarTv);
        mHomeImgSearch = findView(R.id.home_img_search);
        mToolbar = findView(R.id.toolbar);
        mHomeImg = findView(R.id.home_img);
        mLlHomeImg = findView(R.id.ll_home_img);
        mTvContent01 = findView(R.id.tv_content01);
        mLlHomeNetworkError = findView(R.id.ll_home_network_error);
        mRvHome = findView(R.id.rv_home);
        mRvHome.setLayoutManager(new LinearLayoutManager(_mActivity));
    }

    @Override
    public void initListener() {
        mHomeImgSearch.setOnClickListener(v -> goToSearch());
    }

    public void goToSearch(){
        startActivity(new Intent(_mActivity, SearchActivity.class));
    }

    
    @Override
    public void initData() {
        Home home = GsonUtil.GsonToBean(readLocalJson(_mActivity, "Home.json"), Home.class);
        if (home.getData().size() > 0) {
            //展示首页数据
            mRvHome.setVisibility(View.VISIBLE);
            mLlHomeNetworkError.setVisibility(View.GONE);
            HomeProjectInfoRvAdapter adapter = new HomeProjectInfoRvAdapter(_mActivity, home.getData());
            mRvHome.setAdapter(adapter);
            mRvHome.setNestedScrollingEnabled(false);
        } else {
            //展示首页无数据
            mRvHome.setVisibility(View.GONE);
            mLlHomeNetworkError.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v, int id) {
    }

    @Override
    public void onHttpSuccess(int reqType, Message msg) {
    }

    @Override
    public void onHttpError(int reqType, int code, ArrayList<String> error) {
    }

    @Override
    public void onHttpFailure(int reqType) {
    }

    @Override
    public void onServerError(int reqType) {
    }
}
