package cn.com.bitscube_intellectual.ui.fragment;

import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.BaseFragment;

/**
 * 智库
 * Created by Emily on 9/6/21
 */
public class ThinkTankFragment extends BaseFragment {
    private TextView mToolbarTv;
    private Toolbar mToolbar;
    private RadioButton mRbTalents;
    private RadioButton mRbProjects;
    private RadioGroup mRadioGroup;
    private RelativeLayout mRlBottomLayout;
    private FrameLayout mContainer;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_think_tank;
    }

    @Override
    public void initView() {
        mToolbarTv = findView(R.id.toolbarTv);
        mToolbar = findView(R.id.toolbar);
        mRbTalents = findView(R.id.rb_talents);
        mRbProjects = findView(R.id.rb_projects);
        mRadioGroup = findView(R.id.radioGroup);
        mRlBottomLayout = findView(R.id.rl_bottom_layout);
        mContainer = findView(R.id.container);

        ThinkTankTalentsFragment thinkTankTalentsFragment=new ThinkTankTalentsFragment();
        ThinkTankProjectsFragment thinkTankProjectsFragment=new ThinkTankProjectsFragment();

        loadMultipleRootFragment(
                R.id.container,
                0,
                thinkTankTalentsFragment,
                thinkTankProjectsFragment
        );

        mRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId==R.id.rb_talents){
                showHideFragment(thinkTankTalentsFragment);
            }
            if(checkedId==R.id.rb_projects){
                showHideFragment(thinkTankProjectsFragment);
            }
        });
    }

    @Override
    public void initListener() {
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
