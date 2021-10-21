package cn.com.bitscube_intellectual.ui.activity;

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
import cn.com.bitscube_intellectual.common.util.GsonUtil;
import cn.com.bitscube_intellectual.model.bean.ThinkTankDeptInfo;
import cn.com.bitscube_intellectual.ui.adapter.MemberListRvAdapter;

/**
 * 成员列表页
 * Created by Emily on 9/13/21
 */
public class MemberListActivity extends BaseActivity {
    private Toolbar mToolbar;
    private ImageView mIvMemberListBack;
    private TextView mToolbarTv;
    private RecyclerView mRvMemberList;
    private LinearLayout mLlMemberListBottom;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_member_list;
    }

    @Override
    public void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mIvMemberListBack = (ImageView) findViewById(R.id.iv_member_list_back);
        mToolbarTv = (TextView) findViewById(R.id.toolbarTv);
        mRvMemberList = (RecyclerView) findViewById(R.id.rv_member_list);
        mRvMemberList.setLayoutManager(new LinearLayoutManager(this));
        mLlMemberListBottom = (LinearLayout) findViewById(R.id.ll_member_list_bottom);
    }

    @Override
    public void initListener() {
        mIvMemberListBack.setOnClickListener(v -> finish());
    }

    @Override
    public void initData() {
        ThinkTankDeptInfo list = GsonUtil.GsonToBean(readLocalJson(this, "ThinkTankDeptInfo.json"), ThinkTankDeptInfo.class);
        MemberListRvAdapter adapter=new MemberListRvAdapter(this,list.getData().getMembers());
        mRvMemberList.setAdapter(adapter);
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
