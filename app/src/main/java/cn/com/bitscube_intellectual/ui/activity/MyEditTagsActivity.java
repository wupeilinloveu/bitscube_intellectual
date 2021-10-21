package cn.com.bitscube_intellectual.ui.activity;

import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.BaseActivity;
import cn.com.bitscube_intellectual.ui.view.FlowGroupView;

/**
 * 编辑标签页
 * Created by Emily on 9/9/21
 */
public class MyEditTagsActivity extends BaseActivity {
    private ImageView mImgMyEditTagsBack;
    private TextView mToolbarTv;
    private Button mBtnOk;
    private Toolbar mToolbar;
    private LinearLayout mLlMyProfessionalAttributes;
    private ImageView mImgMyProfessionalAttributes;
    private FlowGroupView mFlowMyProfessionalAttributes;
    private LinearLayout mLlMyKnowledgeExpertise;
    private ImageView mImgMyKnowledgeExpertise;
    private FlowGroupView mFlowMyKnowledgeExpertise;
    private LinearLayout mLlMyPlanVarieties;
    private ImageView mImgMyPlanVarieties;
    private FlowGroupView mFlowMyPlanVarieties;
    private LinearLayout mLlMySpecialPlanObject;
    private ImageView mImgMySpecialPlanObject;
    private FlowGroupView mFlowMySpecialPlanObject;
    private LinearLayout mLlMyWorkInterests;
    private ImageView mImgMyWorkInterest;
    private FlowGroupView mFlowMyWorkInterest;
    private LinearLayout mLlMySkills;
    private ImageView mImgMySkills;
    private FlowGroupView mFlowMySkills;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_my_edit_tags;
    }

    @Override
    public void initView() {
        mImgMyEditTagsBack = findViewById(R.id.img_my_edit_tags_back);
        mToolbarTv = findViewById(R.id.toolbarTv);
        mBtnOk = findViewById(R.id.btn_ok);
        mToolbar = findViewById(R.id.toolbar);
        mLlMyProfessionalAttributes = findViewById(R.id.ll_my_professional_attributes);
        mImgMyProfessionalAttributes = findViewById(R.id.img_my_professional_attributes);
        mFlowMyProfessionalAttributes = findViewById(R.id.flow_my_professional_attributes);
        mLlMyKnowledgeExpertise = findViewById(R.id.ll_my_knowledge_expertise);
        mImgMyKnowledgeExpertise = findViewById(R.id.img_my_knowledge_expertise);
        mFlowMyKnowledgeExpertise = findViewById(R.id.flow_my_knowledge_expertise);
        mLlMyPlanVarieties = findViewById(R.id.ll_my_plan_varieties);
        mImgMyPlanVarieties = findViewById(R.id.img_my_plan_varieties);
        mFlowMyPlanVarieties = findViewById(R.id.flow_my_plan_varieties);
        mLlMySpecialPlanObject = findViewById(R.id.ll_my_special_plan_object);
        mImgMySpecialPlanObject = findViewById(R.id.img_my_special_plan_object);
        mFlowMySpecialPlanObject = findViewById(R.id.flow_my_special_plan_object);
        mLlMyWorkInterests = findViewById(R.id.ll_my_work_interests);
        mImgMyWorkInterest = findViewById(R.id.img_my_work_interest);
        mFlowMyWorkInterest = findViewById(R.id.flow_my_work_interest);
        mLlMySkills = findViewById(R.id.ll_my_skills);
        mImgMySkills = findViewById(R.id.img_my_skills);
        mFlowMySkills = findViewById(R.id.flow_my_skills);
    }

    @Override
    public void initListener() {
        mImgMyEditTagsBack.setOnClickListener(v -> finish());
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
