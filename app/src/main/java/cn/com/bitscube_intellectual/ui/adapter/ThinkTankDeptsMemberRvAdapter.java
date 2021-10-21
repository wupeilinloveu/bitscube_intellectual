package cn.com.bitscube_intellectual.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.util.Utils;
import cn.com.bitscube_intellectual.model.bean.ThinkTankDeptInfo;
import cn.com.bitscube_intellectual.ui.activity.MemberListActivity;

/**
 * 部门详情页部门成员适配器
 * Created by Emily on 9/9/21
 */
public class ThinkTankDeptsMemberRvAdapter extends RecyclerView.Adapter<ThinkTankDeptsMemberRvAdapter.ViewHolder> implements View.OnClickListener {
    public Context context;
    public final List<ThinkTankDeptInfo.Data.Members> list;

    public ThinkTankDeptsMemberRvAdapter(Context context, List<ThinkTankDeptInfo.Data.Members> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_depts_team_members_rv_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        try {
            String avatar = list.get(position).getAvatar();
            String name = list.get(position).getName();

            //头像
            Utils.getPicasso(
                    context,
                    avatar,
                    holder.mImgHomeDeptsTeamMember,
                    name,
                    holder.mTvHomeDeptsTeamMember
            );

            holder.mRvHomeDeptsTeamMember.setOnClickListener(v -> {
                context.startActivity(new Intent(context, MemberListActivity.class));
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
        private TextView mTvHomeDeptsTeamMember;
        private ImageView mImgHomeDeptsTeamMember;
        private RelativeLayout mRvHomeDeptsTeamMember;

        ViewHolder(View view) {
            super(view);
            mTvHomeDeptsTeamMember = view.findViewById(R.id.tv_home_depts_team_member);
            mImgHomeDeptsTeamMember = view.findViewById(R.id.img_home_depts_team_member);
            mRvHomeDeptsTeamMember = view.findViewById(R.id.rv_home_depts_team_member);
        }
    }
}


