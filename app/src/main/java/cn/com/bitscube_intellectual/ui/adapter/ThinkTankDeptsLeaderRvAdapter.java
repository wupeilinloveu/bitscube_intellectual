package cn.com.bitscube_intellectual.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.util.Utils;
import cn.com.bitscube_intellectual.model.bean.ThinkTankDeptInfo;

/**
 * 部门详情页部门负责人适配器
 * Created by Emily on 9/9/21
 */
public class ThinkTankDeptsLeaderRvAdapter extends RecyclerView.Adapter<ThinkTankDeptsLeaderRvAdapter.ViewHolder> implements View.OnClickListener {
    public Context context;
    public final List<ThinkTankDeptInfo.Data.Managers> list;

    public ThinkTankDeptsLeaderRvAdapter(Context context, List<ThinkTankDeptInfo.Data.Managers> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_depts_phone_rv_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        try {
            String project_name = list.get(position).getName();
            holder.mTvHomeDeptsPersonName.setText(project_name);
            String mobile=list.get(position).getMobile();

            if (mobile.length() > 10) {
                holder.mTvHomeDeptsPersonPhone.setVisibility(View.VISIBLE);
                String firstMobile = mobile.substring(0, 11);
                holder.mTvHomeDeptsPersonPhone.setText(firstMobile);

                holder.mTvHomeDeptsPersonPhone.setOnClickListener(v -> {
                    Utils.goToPhone(context, firstMobile);
                });
            }

            if (mobile.length() > 12) {
                holder.mTvHomeDeptsPersonPhone2.setVisibility(View.VISIBLE);
                String secondMobile = mobile.substring(12, 23);
                holder.mTvHomeDeptsPersonPhone2.setText(secondMobile);

                holder.mTvHomeDeptsPersonPhone2.setOnClickListener(v -> {
                    Utils.goToPhone(context, secondMobile);
                });
            }else{
                holder.mTvHomeDeptsPersonPhone2.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvHomeDeptsPersonName;
        private TextView mTvHomeDeptsPersonPhone;
        private TextView mTvHomeDeptsPersonPhone2;
        private RelativeLayout mRlHomeDeptsPhone;

        ViewHolder(View view) {
            super(view);
            mTvHomeDeptsPersonName = view.findViewById(R.id.tv_home_depts_person_name);
            mTvHomeDeptsPersonPhone = view.findViewById(R.id.tv_home_depts_person_phone);
            mTvHomeDeptsPersonPhone2 = view.findViewById(R.id.tv_home_depts_person_phone2);
            mRlHomeDeptsPhone = view.findViewById(R.id.rl_home_depts_phone);
        }
    }
}

