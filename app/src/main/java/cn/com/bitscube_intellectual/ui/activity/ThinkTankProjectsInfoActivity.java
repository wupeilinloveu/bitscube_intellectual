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
import cn.com.bitscube_intellectual.model.bean.ThinkTankProjectInfo;
import cn.com.bitscube_intellectual.ui.adapter.ThinkTankProjectsCurrentStepsRvAdapter;
import cn.com.bitscube_intellectual.ui.adapter.ThinkTankProjectsMemberRvAdapter;

/**
 * 项目详情页
 * Created by Emily on 9/7/21
 */
public class ThinkTankProjectsInfoActivity extends BaseActivity {
    private ImageView mImgHomeProjectsDetailBack;
    private TextView mToolbarTv;
    private Toolbar mToolbar;
    private TextView mTvHomeProjectsDetailTitle;
    private TextView mTvProjectLeaderName;
    private TextView mTvHomeProjectsDeptName;
    private TextView mTvHomeProjectKind;
    private TextView mTvHomeProjectsSubKind;
    private TextView mTvHomeProjectProjectCode;
    private TextView mTvHomeProjectScale;
    private TextView mTvHomeProjectArea;
    private TextView mTvProjectsTeamMembers;
    private LinearLayout mLlHomeProjectTeamMembers;
    private LinearLayout mLlHomeProjectsNoTeamMembers;
    private RecyclerView mRvHomeProjectTeamMembers;
    private ImageView mImgProjectsTeamMembersArrowDown;
    private RelativeLayout mRlHomeProjectTeamMembers;
    private RecyclerView mRvHomeProjectsStep;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_home_projects_detail;
    }

    @Override
    public void initView() {
        mImgHomeProjectsDetailBack = findViewById(R.id.img_home_projects_detail_back);
        mToolbarTv = findViewById(R.id.toolbarTv);
        mToolbar = findViewById(R.id.toolbar);
        mTvHomeProjectsDetailTitle = findViewById(R.id.tv_home_projects_detail_title);
        mTvProjectLeaderName = findViewById(R.id.tv_project_leader_name);
        mTvHomeProjectsDeptName = findViewById(R.id.tv_home_projects_dept_name);
        mTvHomeProjectKind = findViewById(R.id.tv_home_project_kind);
        mTvHomeProjectsSubKind = findViewById(R.id.tv_home_projects_sub_kind);
        mTvHomeProjectProjectCode = findViewById(R.id.tv_home_project_project_code);
        mTvHomeProjectScale = findViewById(R.id.tv_home_project_scale);
        mTvHomeProjectArea = findViewById(R.id.tv_home_project_area);
        mTvProjectsTeamMembers = findViewById(R.id.tv_projects_team_members);
        mLlHomeProjectTeamMembers = findViewById(R.id.ll_home_project_team_members);
        mLlHomeProjectsNoTeamMembers = findViewById(R.id.ll_home_projects_no_team_members);
        mRvHomeProjectTeamMembers = findViewById(R.id.rv_home_project_team_members);
        mImgProjectsTeamMembersArrowDown = findViewById(R.id.img_projects_team_members_arrow_down);
        mRlHomeProjectTeamMembers = findViewById(R.id.rl_home_project_team_members);
        mRvHomeProjectsStep = findViewById(R.id.rv_home_projects_step);

        mRvHomeProjectTeamMembers.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL, false));
        mRvHomeProjectsStep.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initListener() {
        mImgHomeProjectsDetailBack.setOnClickListener(v -> finish());
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String projectName = bundle.getString(Const.PROJECT_NAME);
        String leaderName = bundle.getString(Const.PROJECT_LEADER_NAME);
        String deptName = bundle.getString(Const.PROJECT_DEPT_NAME);
        String kind = bundle.getString(Const.PROJECT_KIND);
        String subKid = bundle.getString(Const.PROJECT_SUB_KIND);
        String code = bundle.getString(Const.PROJECT_CODE);
        String scale = bundle.getString(Const.PROJECT_SCALE);
        String area = bundle.getString(Const.PROJECT_AREA);

        mTvHomeProjectsDetailTitle.setText(projectName);
        mTvProjectLeaderName.setText(leaderName);
        mTvHomeProjectsDeptName.setText(deptName);
        mTvHomeProjectKind.setText(kind);
        mTvHomeProjectsSubKind.setText(subKid);
        mTvHomeProjectProjectCode.setText(code);
        mTvHomeProjectScale.setText(scale);
        mTvHomeProjectArea.setText(area);

        ThinkTankProjectInfo thinkTankProjectInfo = GsonUtil.GsonToBean(readLocalJson(this, "ThinkTankProjectInfo.json"), ThinkTankProjectInfo.class);
        //项目成员
        if (thinkTankProjectInfo.getData().getMembers().size() > 0) {
            mLlHomeProjectsNoTeamMembers.setVisibility(View.GONE);
            mRlHomeProjectTeamMembers.setVisibility(View.VISIBLE);
            ThinkTankProjectsMemberRvAdapter thinkTankProjectsMemberRvAdapter = new ThinkTankProjectsMemberRvAdapter(this, thinkTankProjectInfo.getData().getMembers());
            mRvHomeProjectTeamMembers.setAdapter(thinkTankProjectsMemberRvAdapter);
        }else {
            mLlHomeProjectsNoTeamMembers.setVisibility(View.VISIBLE);
            mRlHomeProjectTeamMembers.setVisibility(View.GONE);
        }
        //项目的任务流
        if (thinkTankProjectInfo.getData().getSteps().size() > 0) {
            ThinkTankProjectsCurrentStepsRvAdapter thinkTankProjectsCurrentStepsRvAdapter = new ThinkTankProjectsCurrentStepsRvAdapter(this, thinkTankProjectInfo.getData().getSteps());
            mRvHomeProjectsStep.setAdapter(thinkTankProjectsCurrentStepsRvAdapter);
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
