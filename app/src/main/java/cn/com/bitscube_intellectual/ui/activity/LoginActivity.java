package cn.com.bitscube_intellectual.ui.activity;

import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import java.util.ArrayList;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.BaseActivity;
import cn.com.bitscube_intellectual.common.base.Const;
import cn.com.bitscube_intellectual.common.util.SharedPreUtil;
import cn.com.bitscube_intellectual.common.util.Utils;

/**
 * 登录页
 * Created by Emily on 9/9/21
 */
public class LoginActivity extends BaseActivity {
    private EditText mEtUsername;
    private ToggleButton mToggleClear;
    private LinearLayout mLlUsername;
    private EditText mEtPassword;
    private ToggleButton mTogglePwd;
    private LinearLayout mLlPassword;
    private Button mBtnLogin;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        mEtUsername = findViewById(R.id.et_username);
        mToggleClear = findViewById(R.id.toggleClear);
        mLlUsername = findViewById(R.id.ll_username);
        mEtPassword = findViewById(R.id.et_password);
        mTogglePwd = findViewById(R.id.togglePwd);
        mLlPassword = findViewById(R.id.ll_password);
        mBtnLogin = findViewById(R.id.btn_login);
    }

    @Override
    public void initListener() {
        //一键删除文本
        mEtUsername.addTextChangedListener(Utils.textClearWatcher(mToggleClear, mEtUsername));
        mToggleClear.setOnClickListener(this);
        mToggleClear.setOnClickListener(v -> {
            mEtUsername.setText("");
            mBtnLogin.setBackground(getDrawable(R.drawable.bg_blue_radius));
        });

        //密码的显示与隐藏
        mEtPassword.addTextChangedListener(Utils.togglePassword(this, mTogglePwd, mEtPassword, mBtnLogin));
        mTogglePwd.setOnClickListener(this);

        //点击登录
        mBtnLogin.setOnClickListener(v -> {
            hideKeyboard();

            String username = mEtUsername.getText().toString().trim();
            String password = mEtPassword.getText().toString().trim();

            if (TextUtils.isEmpty(username)) {
                Utils.showToast(this,getString(R.string.login_empty_username));
            } else if (TextUtils.isEmpty(password)) {
                Utils.showToast(this,getString(R.string.login_empty_password));
            } else {
                goToMain();
            }
        });
    }

    public void goToMain(){
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        SharedPreUtil.saveString(this,  Const.APP_IS_LOGIN, Const.APP_IS_LOGIN);
        SharedPreUtil.saveString(this,  Const.USERNAME, mEtUsername.getText().toString());
        finish();
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
