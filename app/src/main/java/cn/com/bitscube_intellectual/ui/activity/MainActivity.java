package cn.com.bitscube_intellectual.ui.activity;

import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.BaseActivity;
import cn.com.bitscube_intellectual.ui.fragment.HomeFragment;
import cn.com.bitscube_intellectual.ui.fragment.MyFragment;
import cn.com.bitscube_intellectual.ui.fragment.ThinkTankFragment;

/**
 * 主页
 * Created by Emily on 9/6/21
 */
public class MainActivity extends BaseActivity {
    private FrameLayout mContainer;
    private RadioButton mRbHome;
    private RadioButton mRbIntellctual;
    private RadioButton mRbMy;
    private RadioGroup mRadioGroup;
    private RelativeLayout mRlBottomLayout;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mContainer = findViewById(R.id.container);
        mRbHome = findViewById(R.id.rb_home);
        mRbIntellctual = findViewById(R.id.rb_intellctual);
        mRbMy = findViewById(R.id.rb_my);
        mRadioGroup = findViewById(R.id.radioGroup);
        mRlBottomLayout = findViewById(R.id.rl_bottom_layout);

        HomeFragment homeFragment=new HomeFragment();
        ThinkTankFragment thinkTankFragment=new ThinkTankFragment();
        MyFragment myFragment=new MyFragment();

        loadMultipleRootFragment(
                R.id.container,
                0,
                homeFragment,
                thinkTankFragment,
                myFragment
        );

        mRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId==R.id.rb_home){
                showHideFragment(homeFragment);
            }
            if(checkedId==R.id.rb_intellctual){
                showHideFragment(thinkTankFragment);
            }
            if (checkedId==R.id.rb_my){
                showHideFragment(myFragment);
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
