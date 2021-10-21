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
import cn.com.bitscube_intellectual.model.bean.Search;
import cn.com.bitscube_intellectual.ui.activity.ThinkTankProjectsInfoActivity;

/**
 * 搜索项目适配器
 * Created by Emily on 9/6/21
 */
public class SearchProjectsRvAdapter extends RecyclerView.Adapter<SearchProjectsRvAdapter.ViewHolder> implements View.OnClickListener {
    public Context context;
    public final List<Search.Data.Projects.ProjectsList> list;

    public SearchProjectsRvAdapter(Context context, List<Search.Data.Projects.ProjectsList> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_project_detail_rv_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        try {
            String project_name = list.get(position).getProject_name();
            holder.mTvSearchProjectsName.setText(project_name);

            String leader_name = list.get(position).getLeader_name();
            holder.mTvSearchProjectsPersonName.setText(leader_name);

            String kind = list.get(position).getKind();
            String sub_kind = list.get(position).getSub_kind();
            if (!sub_kind.isEmpty()) {
                holder.mTvSearchProjectsDepts.setText(kind + "-" + sub_kind);
            } else {
                holder.mTvSearchProjectsDepts.setText(kind);
            }

            holder.mLlHomeSearchProjects.setOnClickListener(v -> {
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
        private LinearLayout mLlHomeSearchProjects;
        private TextView mTvSearchProjectsName;
        private TextView mTvSearchProjectsKindStar;
        private TextView mTvSearchProjectsDepts;
        private TextView mTvSearchProjectsKindStar2;
        private TextView mTvSearchProjectsPersonName;

        ViewHolder(View view) {
            super(view);
            mLlHomeSearchProjects = (LinearLayout) view.findViewById(R.id.ll_home_search_projects);
            mTvSearchProjectsName = (TextView) view.findViewById(R.id.tv_search_projects_name);
            mTvSearchProjectsKindStar = (TextView)view. findViewById(R.id.tv_search_projects_kind_star);
            mTvSearchProjectsDepts = (TextView) view.findViewById(R.id.tv_search_projects_depts);
            mTvSearchProjectsKindStar2 = (TextView) view.findViewById(R.id.tv_search_projects_kind_star2);
            mTvSearchProjectsPersonName = (TextView) view.findViewById(R.id.tv_search_projects_person_name);
        }
    }
}


