package cn.com.bitscube_intellectual.ui.activity;

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
import cn.com.bitscube_intellectual.common.base.BaseActivity;
import cn.com.bitscube_intellectual.common.util.GsonUtil;
import cn.com.bitscube_intellectual.model.bean.ThinkTankTalentInfo;
import cn.com.bitscube_intellectual.ui.adapter.ThinkTankTalentInfoRvAdapter;

/**
 * 我的项目页
 * Created by Emily on 9/9/21
 */
public class MyProjectActivity extends BaseActivity {
    private ImageView mIvMyProjectBack;
    private TextView mToolbarTv;
    private Toolbar mToolbar;
    private ImageView mMyProjectImg;
    private LinearLayout mLlMyProjectImg;
    private TextView mTvContent01;
    private LinearLayout mLlMyProjectNetworkError;
    private RecyclerView mRvMyProject;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_my_project;
    }

    @Override
    public void initView() {
        mIvMyProjectBack = findViewById(R.id.iv_my_project_back);
        mToolbarTv = findViewById(R.id.toolbarTv);
        mToolbar = findViewById(R.id.toolbar);
        mMyProjectImg = findViewById(R.id.my_project_img);
        mLlMyProjectImg = findViewById(R.id.ll_my_project_img);
        mTvContent01 = findViewById(R.id.tv_content01);
        mLlMyProjectNetworkError = findViewById(R.id.ll_my_project_network_error);
        mRvMyProject = findViewById(R.id.rv_my_project);
        mRvMyProject.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initListener() {
        mIvMyProjectBack.setOnClickListener(v -> finish());
    }

    @Override
    public void initData() {
        //参与的项目
        ThinkTankTalentInfo thinkTankTalentInfo = GsonUtil.GsonToBean(readLocalJson(this, "ThinkTankTalentInfo.json"), ThinkTankTalentInfo.class);

        if (thinkTankTalentInfo.getData().getProjects().getList().size() > 0) {
            mLlMyProjectNetworkError.setVisibility(View.GONE);
            mRvMyProject.setVisibility(View.VISIBLE);
            ThinkTankTalentInfoRvAdapter thinkTankTalentInfoRvAdapter = new ThinkTankTalentInfoRvAdapter(this, thinkTankTalentInfo.getData().getProjects().getList());
            mRvMyProject.setAdapter(thinkTankTalentInfoRvAdapter);
        }else {
            mLlMyProjectNetworkError.setVisibility(View.VISIBLE);
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
