package cn.com.bitscube_intellectual.ui.fragment;

import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.BaseFragment;
import cn.com.bitscube_intellectual.common.util.GsonUtil;
import cn.com.bitscube_intellectual.model.bean.ThinkTankTalents;
import cn.com.bitscube_intellectual.ui.adapter.ThinkTankTalentsRvAdapter;

/**
 * 智库人才
 * Created by Emily on 9/7/21
 */
public class ThinkTankTalentsFragment extends BaseFragment {
    private RecyclerView mRvThinkTankTalents;
    private LinearLayout mLlThinkTankTalentsBottom;
    private SmartRefreshLayout mSlThinkTankTalents;
    private TextView mTvContent01;
    private LinearLayout mLlThinkTankTalentsNetworkError;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_think_tank_talents;
    }

    @Override
    public void initView() {
        mRvThinkTankTalents = findView(R.id.rv_think_tank_talents);
        mLlThinkTankTalentsBottom = findView(R.id.ll_think_tank_talents_bottom);
        mSlThinkTankTalents = findView(R.id.sl_think_tank_talents);
        mTvContent01 = findView(R.id.tv_content01);
        mLlThinkTankTalentsNetworkError = findView(R.id.ll_think_tank_talents_network_error);
        mRvThinkTankTalents.setLayoutManager(new LinearLayoutManager(_mActivity));
    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {
        ThinkTankTalents thinkTankTalents = GsonUtil.GsonToBean(readLocalJson(_mActivity, "ThinkTankTalents.json"), ThinkTankTalents.class);
        ThinkTankTalentsRvAdapter adapter=new ThinkTankTalentsRvAdapter(_mActivity,thinkTankTalents.getData().getTalents());
        mRvThinkTankTalents.setAdapter(adapter);
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
