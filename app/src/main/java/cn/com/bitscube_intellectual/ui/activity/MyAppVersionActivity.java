package cn.com.bitscube_intellectual.ui.activity;

import android.annotation.SuppressLint;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.BaseActivity;

/**
 * 版本信息页
 * Created by Emily on 9/9/21
 */
public class MyAppVersionActivity extends BaseActivity {
    private ImageView mIvMyAppVersionBack;
    private TextView mToolbarTv;
    private Toolbar mToolbar;
    private TextView mTvVersionCode;
    private TextView mTvAppDate;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_my_app_version;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void initView() {
        mIvMyAppVersionBack = findViewById(R.id.iv_my_app_version_back);
        mToolbarTv = findViewById(R.id.toolbarTv);
        mToolbar = findViewById(R.id.toolbar);
        mTvVersionCode = findViewById(R.id.tv_version_code);
        mTvAppDate = findViewById(R.id.tv_app_date);

        String versionName=getCurrentVersion(this);
        mTvVersionCode.setText("V"+versionName+"版本");
    }

    @Override
    public void initListener() {
        mIvMyAppVersionBack.setOnClickListener(v -> finish());
    }

    @Override
    public void initData() {

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
