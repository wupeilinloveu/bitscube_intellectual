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
import cn.com.bitscube_intellectual.model.bean.ThinkTankProjects;
import cn.com.bitscube_intellectual.ui.adapter.ThinkTankProjectsRvAdapter;

/**
 * 智库项目
 * Created by Emily on 9/7/21
 */
public class ThinkTankProjectsFragment extends BaseFragment {
    private RecyclerView mRvThinkTankProjects;
    private LinearLayout mLlThinkTankProjectsBottom;
    private SmartRefreshLayout mSlThinkTankProjects;
    private TextView mTvContent01;
    private LinearLayout mLlThinkTankProjectsNetworkError;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment_think_tank_projects;
    }

    @Override
    public void initView() {
        mRvThinkTankProjects = findView(R.id.rv_think_tank_projects);
        mLlThinkTankProjectsBottom = findView(R.id.ll_think_tank_projects_bottom);
        mSlThinkTankProjects = findView(R.id.sl_think_tank_projects);
        mTvContent01 = findView(R.id.tv_content01);
        mLlThinkTankProjectsNetworkError = findView(R.id.ll_think_tank_projects_network_error);
        mRvThinkTankProjects.setLayoutManager(new LinearLayoutManager(_mActivity));
    }

    @Override
    public void initListener() {
        ThinkTankProjects thinkTankProjects = GsonUtil.GsonToBean(readLocalJson(_mActivity, "ThinkTankProjects.json"), ThinkTankProjects.class);
        ThinkTankProjectsRvAdapter adapter=new ThinkTankProjectsRvAdapter(_mActivity,thinkTankProjects.getData().getProjects());
        mRvThinkTankProjects.setAdapter(adapter);
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
