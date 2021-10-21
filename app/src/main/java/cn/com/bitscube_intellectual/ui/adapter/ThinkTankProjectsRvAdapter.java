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
import cn.com.bitscube_intellectual.model.bean.ThinkTankProjects;
import cn.com.bitscube_intellectual.ui.activity.ThinkTankProjectsInfoActivity;

/**
 * 智库项目适配器
 * Created by Emily on 9/6/21
 */
public class ThinkTankProjectsRvAdapter extends RecyclerView.Adapter<ThinkTankProjectsRvAdapter.ViewHolder> implements View.OnClickListener {
    public Context context;
    public final List<ThinkTankProjects.Data.Projects> list;

    public ThinkTankProjectsRvAdapter(Context context, List<ThinkTankProjects.Data.Projects> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.think_tank_projects_rv_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        try {
            String project_name = list.get(position).getProject_name();
            holder.mTvThinkTankProjectsName.setText(project_name);

           String leader_name= list.get(position).getLeader_name();
           holder.mTvThinkTankProjectsPersonName.setText(leader_name);

            String kind = list.get(position).getKind();
            String sub_kind=list.get(position).getSub_kind();
            if(!sub_kind.isEmpty()){
                holder.mTvThinkTankProjectsCity.setText(kind +"-"+sub_kind);
            }else{
                holder.mTvThinkTankProjectsCity.setText(kind);
            }

            holder.mLlThinkTankProjectsRvItem.setOnClickListener(v -> {
                Intent intent = new Intent(context, ThinkTankProjectsInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(Const.PROJECT_ID, list.get(position).getProject_id());
                bundle.putString(Const.PROJECT_NAME, project_name);
                bundle.putString(Const.PROJECT_LEADER_NAME, leader_name);
                bundle.putString(Const.PROJECT_DEPT_NAME, context.getString(R.string.default_department));
                bundle.putString(Const.PROJECT_KIND, kind);
                bundle.putString(Const.PROJECT_SUB_KIND, sub_kind);
                bundle.putString(Const.PROJECT_CODE, context.getString(R.string.home_project_item_no_content));
                bundle.putString(Const.PROJECT_SCALE, context.getString(R.string.home_project_scale_content));
                bundle.putString(Const.PROJECT_AREA, context.getString(R.string.home_project_location_content));
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
        private TextView mTvThinkTankProjectsName;
        private TextView mTvThinkTankProjectsPersonName;
        private TextView mTvThinkTankProjectsCity;
        private LinearLayout mLlThinkTankProjectsRvItem;

        ViewHolder(View view) {
            super(view);
            mTvThinkTankProjectsName = view.findViewById(R.id.tv_think_tank_projects_name);
            mTvThinkTankProjectsPersonName = view.findViewById(R.id.tv_think_tank_projects_person_name);
            mTvThinkTankProjectsCity = view.findViewById(R.id.tv_think_tank_projects_city);
            mLlThinkTankProjectsRvItem = view.findViewById(R.id.ll_think_tank_projects_rv_item);
        }
    }
}


