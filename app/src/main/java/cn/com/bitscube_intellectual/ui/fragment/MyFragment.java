package cn.com.bitscube_intellectual.ui.fragment;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.BaseFragment;
import cn.com.bitscube_intellectual.common.base.Const;
import cn.com.bitscube_intellectual.common.util.SharedPreUtil;
import cn.com.bitscube_intellectual.common.util.Utils;
import cn.com.bitscube_intellectual.ui.activity.MyEditTagsActivity;
import cn.com.bitscube_intellectual.ui.activity.MyProjectActivity;
import cn.com.bitscube_intellectual.ui.activity.MySettingActivity;
import cn.com.bitscube_intellectual.ui.view.FlowGroupView;

/**
 * 我的
 * Created by Emily on 9/6/21
 */
public class MyFragment extends BaseFragment {
    private TextView mToolbarTv;
    private Toolbar mToolbar;
    private TextView mTvMy;
    private ImageView mImgMy;
    private TextView mTvMyName;
    private TextView mTvMyDept;
    private TextView mTvMyPhone;
    private LinearLayout mLlMyPhone;
    private LinearLayout mLlMy;
    private TextView mTvMyEdit;
    private FlowGroupView mFlow;
    private LinearLayout mLlMyTags;
    private TextView mTvNoEditTags;
    private LinearLayout mLlNoTags;
    private TextView mTvMyProject;
    private ImageView mImgMyProject;
    private RelativeLayout mRlMyProject;
    private TextView mTvMySetting;
    private ImageView mImgMySetting;
    private RelativeLayout mRlMySetting;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_my;
    }

    @Override
    public void initView() {
        mToolbarTv = findView(R.id.toolbarTv);
        mToolbar = findView(R.id.toolbar);
        mTvMy = findView(R.id.tv_my);
        mImgMy = findView(R.id.img_my);
        mTvMyName = findView(R.id.tv_my_name);
        mTvMyDept = findView(R.id.tv_my_dept);
        mTvMyPhone = findView(R.id.tv_my_phone);
        mLlMyPhone = findView(R.id.ll_my_phone);
        mLlMy = findView(R.id.ll_my);
        mTvMyEdit = findView(R.id.tv_my_edit);
        mFlow = findView(R.id.flow);
        mLlMyTags = findView(R.id.ll_my_tags);
        mTvNoEditTags = findView(R.id.tv_no_edit_tags);
        mLlNoTags = findView(R.id.ll_no_tags);
        mTvMyProject = findView(R.id.tv_my_project);
        mImgMyProject = findView(R.id.img_my_project);
        mRlMyProject = findView(R.id.rl_my_project);
        mTvMySetting = findView(R.id.tv_my_setting);
        mImgMySetting = findView(R.id.img_my_setting);
        mRlMySetting = findView(R.id.rl_my_setting);

        String useName=SharedPreUtil.getString(_mActivity, Const.USERNAME,"");
        //头像
        Utils.getPicasso(
                _mActivity,
                Const.MY_LOGO,
                mImgMy,
                useName,
                mTvMy
        );
        mTvMyName.setText(useName);
        mTvMyDept.setText(_mActivity.getString(R.string.default_department));
        mLlMyPhone.setVisibility(View.VISIBLE);
        mTvMyPhone.setText(_mActivity.getString(R.string.default_phone));
    }

    @Override
    public void initListener() {
        mLlMyTags.setOnClickListener(v -> goToMyEditTags());
        mRlMyProject.setOnClickListener(v -> goToMyProject());
        mRlMySetting.setOnClickListener(v -> goToMySetting());
    }

    public void goToMyEditTags() {
        startActivity(new Intent(_mActivity, MyEditTagsActivity.class));
    }

    public void goToMyProject() {
        startActivity(new Intent(_mActivity, MyProjectActivity.class));
    }

    public void goToMySetting() {
        startActivity(new Intent(_mActivity, MySettingActivity.class));
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
