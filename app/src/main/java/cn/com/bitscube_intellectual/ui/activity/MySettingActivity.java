package cn.com.bitscube_intellectual.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.Const;
import cn.com.bitscube_intellectual.common.util.SharedPreUtil;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * 设置页
 * Created by Emily on 9/9/21
 */
public class MySettingActivity extends SupportActivity {
    private ImageView mImgMySettingBack;
    private TextView mToolbarTv;
    private Toolbar mToolbar;
    private TextView mTvAppVersion;
    private ImageView mImgAppVersion;
    private RelativeLayout mRlAppVersion;
    private TextView mTvMyLogout;
    private ImageView mImgMyLogout;
    private RelativeLayout mRlMyLogout;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_setting);
        //初始化View
        initView();
        initListener();
    }

    private void initView() {
        mImgMySettingBack = findViewById(R.id.img_my_setting_back);
        mToolbarTv = findViewById(R.id.toolbarTv);
        mToolbar = findViewById(R.id.toolbar);
        mTvAppVersion = findViewById(R.id.tv_app_version);
        mImgAppVersion = findViewById(R.id.img_app_version);
        mRlAppVersion = findViewById(R.id.rl_app_version);
        mTvMyLogout = findViewById(R.id.tv_my_logout);
        mImgMyLogout = findViewById(R.id.img_my_logout);
        mRlMyLogout = findViewById(R.id.rl_my_logout);
    }

    private void initListener() {
        mImgMySettingBack.setOnClickListener(v -> finish());
        mRlAppVersion.setOnClickListener(v -> goToMyAppVersion());
        mRlMyLogout.setOnClickListener(v -> goToLogin());
    }

    public void goToMyAppVersion(){
        startActivity(new Intent(this, MyAppVersionActivity.class));
        finish();
    }

    public void goToLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        SharedPreUtil.saveString(this, Const.APP_IS_LOGIN, "");
        SharedPreUtil.saveString(this, Const.USERNAME, "");
        finish();
    }
}
