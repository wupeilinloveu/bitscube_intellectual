package cn.com.bitscube_intellectual.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.Const;
import cn.com.bitscube_intellectual.model.bean.Home;
import cn.com.bitscube_intellectual.ui.activity.ThinkTankDeptInfoActivity;

/**
 * 首页部门模块适配器
 * Created by Emily on 9/6/21
 */
public class HomeDeptsRecommendRvAdapter extends RecyclerView.Adapter<HomeDeptsRecommendRvAdapter.ViewHolder> implements View.OnClickListener {
    public Context context;
    private final List<Home.HomeData.DeptsRecommend> list;

    public HomeDeptsRecommendRvAdapter(Context context, List<Home.HomeData.DeptsRecommend> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_depts_recommend_rv_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @SuppressLint({"SetTextI18n", "ResourceType"})
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        try {
            //专业部门
            int dept_id = list.get(position).getDept_id();
            String dept_logo = list.get(position).getDept_logo();
            String dept_name = list.get(position).getDept_name();
            holder.mTvDeptName.setText(dept_name);
            int member_count = list.get(position).getMember_count();
            holder.mTvMemberCount.setText(member_count + "人");

            holder.mLlHomeDeptsRecommend.setOnClickListener(v -> {
                Intent intent = new Intent(context, ThinkTankDeptInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(Const.DEPT_ID, dept_id);
                bundle.putString(Const.DEPT_LOGO,dept_logo);
                bundle.putString(Const.DEPT_NAME,dept_name);
                intent.putExtras(bundle);
                context.startActivity(intent);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private cn.com.bitscube_intellectual.ui.view.RoundImageView mImgDeptLogo;
        private TextView mTvDeptName;
        private TextView mTvMemberCount;
        private LinearLayout mLlHomeDeptsRecommend;

        ViewHolder(View view) {
            super(view);
            mImgDeptLogo = view.findViewById(R.id.img_dept_logo);
            mTvDeptName = view.findViewById(R.id.tv_dept_name);
            mTvMemberCount = view.findViewById(R.id.tv_member_count);
            mLlHomeDeptsRecommend = view.findViewById(R.id.ll_home_depts_recommend);
        }
    }

}

