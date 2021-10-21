package cn.com.bitscube_intellectual.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
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

/**
 * 成员列表适配器
 * Created by Emily on 9/6/21
 */
public class MemberListRvAdapter extends RecyclerView.Adapter<MemberListRvAdapter.ViewHolder> implements View.OnClickListener {
    public Context context;
    public final List<ThinkTankDeptInfo.Data.Members> list;

    public MemberListRvAdapter(Context context, List<ThinkTankDeptInfo.Data.Members> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_list_rv_item, parent, false);
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
                    holder.mImgMemberListAvatar,
                    name,
                    holder.mTvMemberListAvatar
            );

            String jobTitle = list.get(position).getJob_title();
            if (!jobTitle.isEmpty()) {
                holder.mTvMemberListName.setVisibility(View.VISIBLE);
                holder.mTvMemberListName.setText(name + " " + "|" + " " + jobTitle);
            } else {
                holder.mTvMemberListName.setText(name);
            }

            String dept_name = list.get(position).getState();
            holder.mTvMemberListJobTitle.setText(dept_name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout mRvMemberListAvatar;
        private TextView mTvMemberListAvatar;
        private ImageView mImgMemberListAvatar;
        private TextView mTvMemberListName;
        private TextView mTvMemberListJobTitle;

        ViewHolder(View view) {
            super(view);
            mRvMemberListAvatar = (RelativeLayout) view.findViewById(R.id.rv_member_list_avatar);
            mTvMemberListAvatar = (TextView) view.findViewById(R.id.tv_member_list_avatar);
            mImgMemberListAvatar = (ImageView) view.findViewById(R.id.img_member_list_avatar);
            mTvMemberListName = (TextView) view.findViewById(R.id.tv_member_list_name);
            mTvMemberListJobTitle = (TextView) view.findViewById(R.id.tv_member_list_job_title);
        }
    }
}

