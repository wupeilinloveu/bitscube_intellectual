package cn.com.bitscube_intellectual.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.model.bean.Home;

/**
 * 首页任务流适配器
 * Created by Emily on 9/6/21
 */
public class HomeCurrentStepsRvAdapter extends RecyclerView.Adapter<HomeCurrentStepsRvAdapter.ViewHolder> implements View.OnClickListener {
    public Context context;
    public final List<Home.HomeData.ProjectInfo.Steps> list;

    public HomeCurrentStepsRvAdapter(Context context, List<Home.HomeData.ProjectInfo.Steps> list) {
        this.context = context;
        this.list = list;
    }

    private OnRecyclerViewListener mOnRecyclerViewListener = null;

    @Override
    public void onClick(View v) {
        if (mOnRecyclerViewListener != null) {
            mOnRecyclerViewListener.onItemClick(v, (Home.HomeData.ProjectInfo.Steps) v.getTag());
        }
    }

    public interface OnRecyclerViewListener {
        void onItemClick(View view, Home.HomeData.ProjectInfo.Steps stepsBean);
    }

    public void setOnItemClickListener(OnRecyclerViewListener listener) {
        this.mOnRecyclerViewListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_current_steps_rv_item, parent, false);
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
                holder.mImgCurrentTaskStatus.setBackground(context.getDrawable(R.drawable.bg_line));
            } else if (current == 1) {
                holder.mImgCurrentTaskStatus.setBackground(context.getDrawable(R.drawable.bg_line_focused));
            }

            //最后一条item添加自定义圆圈
            if (position == list.size() - 1) {
                holder.mImgCurrentTaskStatus.setVisibility(View.GONE);
            }

            String step_name = list.get(position).getStep_name();
            holder.mTvStepName.setText(step_name);
            String step_date = list.get(position).getStep_date();
            holder.mTvStepDate.setText(step_date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvProjectName;
        private TextView mTvLeaderName;
        private ImageView mImgCurrentTaskStatus;
        private ImageView mImgCurrentStepsLastCircle;
        private TextView mTvStepName;
        private TextView mTvStepDate;

        ViewHolder(View view) {
            super(view);
            mImgCurrentTaskStatus = view.findViewById(R.id.img_current_task_status);
            mTvStepName = view.findViewById(R.id.tv_step_name);
            mTvStepDate = view.findViewById(R.id.tv_step_date);
        }
    }
}

