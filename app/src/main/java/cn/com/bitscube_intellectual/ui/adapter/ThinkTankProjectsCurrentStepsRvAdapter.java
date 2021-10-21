package cn.com.bitscube_intellectual.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.model.bean.ThinkTankProjectInfo;

/**
 * 项目详情页任务流适配器
 * Created by Emily on 9/6/21
 */
public class ThinkTankProjectsCurrentStepsRvAdapter extends RecyclerView.Adapter<ThinkTankProjectsCurrentStepsRvAdapter.ViewHolder> implements View.OnClickListener {
    public Context context;
    public final List<ThinkTankProjectInfo.Data.Steps> list;

    public ThinkTankProjectsCurrentStepsRvAdapter(Context context, List<ThinkTankProjectInfo.Data.Steps> list) {
        this.context = context;
        this.list = list;
    }

    private OnRecyclerViewListener mOnRecyclerViewListener = null;

    @Override
    public void onClick(View v) {
        if (mOnRecyclerViewListener != null) {
            mOnRecyclerViewListener.onItemClick(v, (ThinkTankProjectInfo.Data.Steps) v.getTag());
        }
    }

    public interface OnRecyclerViewListener {
        void onItemClick(View view, ThinkTankProjectInfo.Data.Steps stepsBean);
    }

    public void setOnItemClickListener(OnRecyclerViewListener listener) {
        this.mOnRecyclerViewListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_projects_detail_steps_rv_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        try {
            //设置高亮的颜色
            int current = list.get(position).getCurrent();
            if (current == 0) {
                holder.mViewProjectsDetail.setBackground(context.getDrawable(R.drawable.bg_line));
            } else if (current == 1) {
                holder.mViewProjectsDetail.setBackground(context.getDrawable(R.drawable.bg_line_focused));
            }

            //最后一条item
            if (position == list.size() - 1) {
                holder.mViewProjectsDetail.setVisibility(View.GONE);
            }

            String step_name = list.get(position).getStep_name();
            holder.mTvProjectsDetailStepName.setText(step_name);
            String step_date = list.get(position).getStep_date();
            holder.mTvProjectsDetailStepDate.setText(step_date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private View mViewProjectsDetail;
        private TextView mTvProjectsDetailStepName;
        private TextView mTvProjectsDetailStepDate;

        ViewHolder(View view) {
            super(view);
            mViewProjectsDetail = (View) view.findViewById(R.id.view_projects_detail);
            mTvProjectsDetailStepName = (TextView) view.findViewById(R.id.tv_projects_detail_step_name);
            mTvProjectsDetailStepDate = (TextView) view.findViewById(R.id.tv_projects_detail_step_date);
        }
    }
}

