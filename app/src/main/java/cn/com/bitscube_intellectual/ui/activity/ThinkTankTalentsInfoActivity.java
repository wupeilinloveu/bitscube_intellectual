package cn.com.bitscube_intellectual.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.BaseActivity;
import cn.com.bitscube_intellectual.common.base.Const;
import cn.com.bitscube_intellectual.common.util.GsonUtil;
import cn.com.bitscube_intellectual.common.util.Utils;
import cn.com.bitscube_intellectual.model.bean.ThinkTankTalentInfo;
import cn.com.bitscube_intellectual.ui.adapter.ThinkTankTalentInfoRvAdapter;
import cn.com.bitscube_intellectual.ui.view.FlowGroupView;

/**
 * 人才详情页
 * Created by Emily on 9/7/21
 */
public class ThinkTankTalentsInfoActivity extends BaseActivity {
    private ImageView mImgHomeTalentsDetailBack;
    private TextView mToolbarTv;
    private Toolbar mToolbar;
    private TextView mTvHomeTalentDetailAvatar;
    private ImageView mImgHomeTalentDetailAvatar;
    private TextView mTvHomeTalentsName;
    private TextView mTvHomeTalentsPost;
    private FlowGroupView mFlowHomeTalentsTagName;
    private TextView mTvHomeTalentsPhone;
    private LinearLayout mLlHomeTalentsPhone;
    private TextView mTvHomeTalentsPhone2;
    private LinearLayout mLlHomeTalentsPhone2;
    private LinearLayout mLlHomeTalentsProject;
    private LinearLayout mLlHomeTalentsProjectContent;
    private RecyclerView mRvHomeTalentsDetail;
    private LinearLayout mLlHomeTalentsDetailBottom;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_home_talents_detail;
    }

    @Override
    public void initView() {
        mImgHomeTalentsDetailBack = findViewById(R.id.img_home_talents_detail_back);
        mToolbarTv = findViewById(R.id.toolbarTv);
        mToolbar = findViewById(R.id.toolbar);
        mTvHomeTalentDetailAvatar = findViewById(R.id.tv_home_talent_detail_avatar);
        mImgHomeTalentDetailAvatar = findViewById(R.id.img_home_talent_detail_avatar);
        mTvHomeTalentsName = findViewById(R.id.tv_home_talents_name);
        mTvHomeTalentsPost = findViewById(R.id.tv_home_talents_post);
        mFlowHomeTalentsTagName = findViewById(R.id.flow_home_talents_tag_name);
        mTvHomeTalentsPhone = findViewById(R.id.tv_home_talents_phone);
        mLlHomeTalentsPhone = findViewById(R.id.ll_home_talents_phone);
        mTvHomeTalentsPhone2 = findViewById(R.id.tv_home_talents_phone2);
        mLlHomeTalentsPhone2 = findViewById(R.id.ll_home_talents_phone2);
        mLlHomeTalentsProject = findViewById(R.id.ll_home_talents_project);
        mLlHomeTalentsProjectContent = findViewById(R.id.ll_home_talents_project_content);
        mRvHomeTalentsDetail = findViewById(R.id.rv_home_talents_detail);
        mRvHomeTalentsDetail.setLayoutManager(new LinearLayoutManager(this));
        mLlHomeTalentsDetailBottom = findViewById(R.id.ll_home_talents_detail_bottom);
    }

    @Override
    public void initListener() {
        mImgHomeTalentsDetailBack.setOnClickListener(v -> finish());
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String logo = bundle.getString(Const.TALENTS_LOGO);
        String name = bundle.getString(Const.TALENTS_NAME);
        String deptName=bundle.getString(Const.TALENTS_DEPT_NAME);
        String job_title = bundle.getString(Const.TALENTS_JOB_TITLE);
        String tag_name=bundle.getString(Const.TALENTS_TAG_NAME);
        String mobile=bundle.getString(Const.TALENTS_MOBILE);

        //头像
        Utils.getPicasso(
                this,
                logo,
                mImgHomeTalentDetailAvatar,
                name,
                mTvHomeTalentDetailAvatar
        );

        if (!job_title.isEmpty()) {
            mTvHomeTalentsName.setText(name + " " + "|" + " " + deptName);
        } else {
            mTvHomeTalentsName.setText(name);
        }

        mTvHomeTalentsPost.setText(job_title);

        //有多个电话时，并排展示电话图标和电话号码
        if (mobile.length() > 10) {
            mLlHomeTalentsPhone.setVisibility(View.VISIBLE);
            String firstMobile = mobile.substring(0, 11);
            mTvHomeTalentsPhone.setText(firstMobile);

            mLlHomeTalentsPhone.setOnClickListener(v -> {
                    Utils.goToPhone(this, firstMobile);
            });
        }

        if (mobile.length() > 12) {
            mLlHomeTalentsPhone2.setVisibility(View.VISIBLE);
            String secondMobile = mobile.substring(12, 23);
            mTvHomeTalentsPhone2.setText(secondMobile);

            mLlHomeTalentsPhone2.setOnClickListener(v -> {
                    Utils.goToPhone(this, secondMobile);
            });
        }

        //添加个人标签
        Utils.addNoBackgroundTalentsTagsTextView(
                this,
                mFlowHomeTalentsTagName,
                "*" + tag_name + "*",
                "*"
        );

//        List<ThinkTankTalentInfo.Data.Tags> tags = thinkTankTalentInfo.getData().getTags();
//        int size = tags.size() - 1;
//        for (int i = 0; i < size; i++) {
//            List<ThinkTankTalentInfo.Data.Tags.SubTags> sub_tags = tags.get(i).getSub_tags();
//            for(int j=0;j<sub_tags.size()-1;j++){
//                int selected=sub_tags.get(j).getSelected();
//                if(selected==1){
//                    String tag_name=sub_tags.get(j).getTag_name();
//                    Utils.addNoBackgroundTalentsTagsTextView(
//                            this,
//                            mFlowHomeTalentsTagName,
//                            "*" + tag_name + "*",
//                            "*"
//                    );
//                }
//            }
//        }

        //参与的项目
        ThinkTankTalentInfo thinkTankTalentInfo = GsonUtil.GsonToBean(readLocalJson(this, "ThinkTankTalentInfo.json"), ThinkTankTalentInfo.class);
        if (thinkTankTalentInfo.getData().getProjects().getList().size() > 0) {
            mLlHomeTalentsProjectContent.setVisibility(View.GONE);
            mLlHomeTalentsProject.setVisibility(View.VISIBLE);
            ThinkTankTalentInfoRvAdapter thinkTankTalentInfoRvAdapter = new ThinkTankTalentInfoRvAdapter(this, thinkTankTalentInfo.getData().getProjects().getList());
            mRvHomeTalentsDetail.setAdapter(thinkTankTalentInfoRvAdapter);
        }else {
            mLlHomeTalentsProjectContent.setVisibility(View.VISIBLE);
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
