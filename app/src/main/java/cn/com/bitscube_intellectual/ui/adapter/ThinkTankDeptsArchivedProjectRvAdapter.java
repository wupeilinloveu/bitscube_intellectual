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
import cn.com.bitscube_intellectual.model.bean.ThinkTankDeptInfo;
import cn.com.bitscube_intellectual.ui.activity.ThinkTankProjectsInfoActivity;

/**
 * 部门详情页归档的项目适配器
 * Created by Emily on 9/9/21
 */
public class ThinkTankDeptsArchivedProjectRvAdapter extends RecyclerView.Adapter<ThinkTankDeptsArchivedProjectRvAdapter.ViewHolder> implements View.OnClickListener {
    public Context context;
    public final List<ThinkTankDeptInfo.Data.Projects.ProjectsList> list;


    public ThinkTankDeptsArchivedProjectRvAdapter(Context context, List<ThinkTankDeptInfo.Data.Projects.ProjectsList> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_depts_archived_detail_rv_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        try {
            String project_name = list.get(position).getProject_name();
            holder.mTvHomeDeptsArchived.setText(project_name);

            holder.mLlHomeDeptsArchived.setOnClickListener(v -> {
                Intent intent = new Intent(context, ThinkTankProjectsInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(Const.PROJECT_ID, list.get(position).getProject_id());
                bundle.putString(Const.PROJECT_NAME, project_name);
                bundle.putString(Const.PROJECT_LEADER_NAME, context.getString(R.string.home_project_person_content));
                bundle.putString(Const.PROJECT_DEPT_NAME, context.getString(R.string.default_department));
                bundle.putString(Const.PROJECT_KIND, context.getString(R.string.default_kind));
                bundle.putString(Const.PROJECT_SUB_KIND, context.getString(R.string.home_project_subtype_content));
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
        private TextView mTvHomeDeptsArchived;
        private LinearLayout mLlHomeDeptsArchived;

        ViewHolder(View view) {
            super(view);
            mTvHomeDeptsArchived = view.findViewById(R.id.tv_home_depts_archived);
            mLlHomeDeptsArchived = view.findViewById(R.id.ll_home_depts_archived);
        }
    }
}

