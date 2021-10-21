package cn.com.bitscube_intellectual.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.BaseActivity;
import cn.com.bitscube_intellectual.common.base.Const;
import cn.com.bitscube_intellectual.common.util.GsonUtil;
import cn.com.bitscube_intellectual.model.bean.ThinkTankDeptInfo;
import cn.com.bitscube_intellectual.ui.adapter.ThinkTankDeptsArchivedProjectRvAdapter;
import cn.com.bitscube_intellectual.ui.adapter.ThinkTankDeptsLeaderRvAdapter;
import cn.com.bitscube_intellectual.ui.adapter.ThinkTankDeptsMemberRvAdapter;
import cn.com.bitscube_intellectual.ui.view.FlowGroupView;

/**
 * 部门详情页
 * Created by Emily on 9/7/21
 */
public class ThinkTankDeptInfoActivity extends BaseActivity {
    private ImageView mImgHomeDeptsDetailBack;
    private TextView mToolbarTv;
    private Toolbar mToolbar;
    private cn.com.bitscube_intellectual.ui.view.RoundImageView mImgDeptDetailLogo;
    private TextView mTvDeptDetailName;
    private FlowGroupView mFlowHomeDeptsDetail;
    private LinearLayout mLlHomeDeptsLeader;
    private RecyclerView mRvHomeDeptsPhone;
    private TextView mTvDeptsTeamMembers;
    private LinearLayout mLlHomeDeptsTeamMembers;
    private RecyclerView mRvHomeDeptsTeamMembers;
    private ImageView mImgDeptsTeamMembersArrowDown;
    private RelativeLayout mRlHomeDeptsTeamMembers;
    private LinearLayout mLlHomeDeptsArchived;
    private RecyclerView mRvHomeDeptsArchived;
    private LinearLayout mLlHomeDeptsDetailBottom;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_home_depts_detail;
    }

    @Override
    public void initView() {
        mImgHomeDeptsDetailBack = findViewById(R.id.img_home_depts_detail_back);
        mToolbarTv = findViewById(R.id.toolbarTv);
        mToolbar = findViewById(R.id.toolbar);
        mImgDeptDetailLogo = findViewById(R.id.img_dept_detail_logo);
        mTvDeptDetailName = findViewById(R.id.tv_dept_detail_name);
        mFlowHomeDeptsDetail = findViewById(R.id.flow_home_depts_detail);
        mLlHomeDeptsLeader = findViewById(R.id.ll_home_depts_leader);
        mRvHomeDeptsPhone = findViewById(R.id.rv_home_depts_phone);
        mTvDeptsTeamMembers = findViewById(R.id.tv_depts_team_members);
        mLlHomeDeptsTeamMembers = findViewById(R.id.ll_home_depts_team_members);
        mRvHomeDeptsTeamMembers = findViewById(R.id.rv_home_depts_team_members);
        mImgDeptsTeamMembersArrowDown = findViewById(R.id.img_depts_team_members_arrow_down);
        mRlHomeDeptsTeamMembers = findViewById(R.id.rl_home_depts_team_members);
        mLlHomeDeptsArchived = findViewById(R.id.ll_home_depts_archived);
        mRvHomeDeptsArchived = findViewById(R.id.rv_home_depts_archived);
        mLlHomeDeptsDetailBottom = findViewById(R.id.ll_home_depts_detail_bottom);

        mRvHomeDeptsPhone.setLayoutManager(new LinearLayoutManager(this));
        mRvHomeDeptsTeamMembers.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false));
        mRvHomeDeptsArchived.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initListener() {
        mImgHomeDeptsDetailBack.setOnClickListener(v -> finish());
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String deptName = bundle.getString(Const.DEPT_NAME);
        mTvDeptDetailName.setText(deptName);

        ThinkTankDeptInfo thinkTankDeptInfo = GsonUtil.GsonToBean(readLocalJson(this, "ThinkTankDeptInfo.json"), ThinkTankDeptInfo.class);
        //部门负责人
        if (thinkTankDeptInfo.getData().getProjects().getList().size() > 0) {
            mLlHomeDeptsLeader.setVisibility(View.GONE);
            ThinkTankDeptsLeaderRvAdapter thinkTankDeptsLeaderRvAdapter = new ThinkTankDeptsLeaderRvAdapter(this, thinkTankDeptInfo.getData().getManagers());
            mRvHomeDeptsPhone.setAdapter(thinkTankDeptsLeaderRvAdapter);
        }else {
            mLlHomeDeptsLeader.setVisibility(View.VISIBLE);
        }

        //部门成员
        if (thinkTankDeptInfo.getData().getMembers().size() > 0) {
            mLlHomeDeptsTeamMembers.setVisibility(View.GONE);
            mRlHomeDeptsTeamMembers.setVisibility(View.VISIBLE);
            ThinkTankDeptsMemberRvAdapter thinkTankDeptsMemberRvAdapter = new ThinkTankDeptsMemberRvAdapter(this, thinkTankDeptInfo.getData().getMembers());
            mRvHomeDeptsTeamMembers.setAdapter(thinkTankDeptsMemberRvAdapter);
        }else {
            mLlHomeDeptsTeamMembers.setVisibility(View.VISIBLE);
            mRlHomeDeptsTeamMembers.setVisibility(View.GONE);
        }

        //归档的项目
        if (thinkTankDeptInfo.getData().getProjects().getList().size() > 0) {
            mLlHomeDeptsArchived.setVisibility(View.GONE);
            ThinkTankDeptsArchivedProjectRvAdapter thinkTankDeptsArchivedProjectRvAdapter = new ThinkTankDeptsArchivedProjectRvAdapter(this, thinkTankDeptInfo.getData().getProjects().getList());
            mRvHomeDeptsArchived.setAdapter(thinkTankDeptsArchivedProjectRvAdapter);
        }else {
            mLlHomeDeptsArchived.setVisibility(View.VISIBLE);
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
