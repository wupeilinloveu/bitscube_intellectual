package cn.com.bitscube_intellectual.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.Const;
import cn.com.bitscube_intellectual.common.util.Utils;
import cn.com.bitscube_intellectual.model.bean.ThinkTankTalents;
import cn.com.bitscube_intellectual.ui.activity.ThinkTankTalentsInfoActivity;
import cn.com.bitscube_intellectual.ui.view.FlowGroupView;

/**
 * 智库人才适配器
 * Created by Emily on 9/6/21
 */
public class ThinkTankTalentsRvAdapter extends RecyclerView.Adapter<ThinkTankTalentsRvAdapter.ViewHolder> implements View.OnClickListener {
    public Context context;
    public final List<ThinkTankTalents.Data.Talents> list;
    public String tag_name;

    public ThinkTankTalentsRvAdapter(Context context, List<ThinkTankTalents.Data.Talents> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.think_tank_talents_rv_item, parent, false);
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
                    holder.mImgThinkTankTalentAvatar,
                    name,
                    holder.mTvThinkTankTalentAvatar
            );

            String jobTitle = list.get(position).getJob_title();
            if (!jobTitle.isEmpty()) {
                holder.mTvThinkTankTalentsTitle.setText(name + " " + "|" + " " + jobTitle);
            } else {
                holder.mTvThinkTankTalentsTitle.setText(name);
            }

            String dept_name =list.get(position).getDept_name();
            holder.mTvThinkTankTalentsPost.setText(dept_name);

            //添加标签
            List<ThinkTankTalents.Data.Talents.Tags> tags = list.get(position).getTags();
            holder.mFlowThinkTankTalents.setVisibility(View.VISIBLE);
            int size = tags.size() - 1;
            for (int i = 0; i < size; i++) {
                 tag_name = tags.get(i).getTag_name();
                Utils.addNoBackgroundTalentsTagsTextView(
                        context,
                        holder.mFlowThinkTankTalents,
                        "*" + tag_name + "*",
                        "*"
                );
            }

            //有多个电话时，并排展示电话图标和电话号码
            String mobile = list.get(position).getMobile();
            if (mobile.length() > 10) {
                holder.mLlThinkTankTalentsPhone.setVisibility(View.VISIBLE);
                String firstMobile = mobile.substring(0, 11);
                holder.mTvThinkTankTalentsPhone.setText(firstMobile);

                holder.mLlThinkTankTalentsPhone.setOnClickListener(v -> {
                    Utils.goToPhone(context, firstMobile);
                });
            }

            if (mobile.length() > 12) {
                holder.mLlThinkTankTalentsPhone2.setVisibility(View.VISIBLE);
                String secondMobile = mobile.substring(12, 23);
                holder.mTvThinkTankTalentsPhone2.setText(secondMobile);

                holder.mLlThinkTankTalentsPhone2.setOnClickListener(v -> {
                    Utils.goToPhone(context, secondMobile);
                });
            }

            holder.mLlThinkTankTalentsRvItem.setOnClickListener(v -> {
                Intent intent = new Intent(context, ThinkTankTalentsInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(Const.OA_UID, list.get(position).getOa_uid());
                bundle.putString(Const.TALENTS_LOGO, avatar);
                bundle.putString(Const.TALENTS_NAME, name);
                bundle.putString(Const.TALENTS_DEPT_NAME, context.getString(R.string.default_department));
                bundle.putString(Const.TALENTS_JOB_TITLE, jobTitle);
                bundle.putString(Const.TALENTS_TAG_NAME, tag_name);
                bundle.putString(Const.TALENTS_MOBILE, context.getString(R.string.default_phone));
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
        private TextView mTvThinkTankTalentAvatar;
        private ImageView mImgThinkTankTalentAvatar;
        private TextView mTvThinkTankTalentsTitle;
        private TextView mTvThinkTankTalentsPost;
        private FlowGroupView mFlowThinkTankTalents;
        private LinearLayout mLlThinkTankTalentsRvItem;
        private ImageView mImgThinkTankTalentsPhone;
        private TextView mTvThinkTankTalentsPhone;
        private LinearLayout mLlThinkTankTalentsPhone;
        private TextView mTvThinkTankTalentsPhone2;
        private LinearLayout mLlThinkTankTalentsPhone2;

        ViewHolder(View view) {
            super(view);
            mTvThinkTankTalentAvatar = view.findViewById(R.id.tv_think_tank_talent_avatar);
            mImgThinkTankTalentAvatar = view.findViewById(R.id.img_think_tank_talent_avatar);
            mTvThinkTankTalentsTitle = view.findViewById(R.id.tv_think_tank_talents_title);
            mTvThinkTankTalentsPost = view.findViewById(R.id.tv_think_tank_talents_post);
            mFlowThinkTankTalents = view.findViewById(R.id.flow_think_tank_talents);
            mLlThinkTankTalentsRvItem = view.findViewById(R.id.ll_think_tank_talents_rv_item);
            mImgThinkTankTalentsPhone = view.findViewById(R.id.img_think_tank_talents_phone);
            mTvThinkTankTalentsPhone = view.findViewById(R.id.tv_think_tank_talents_phone);
            mLlThinkTankTalentsPhone = view.findViewById(R.id.ll_think_tank_talents_phone);
            mTvThinkTankTalentsPhone2 = view.findViewById(R.id.tv_think_tank_talents_phone2);
            mLlThinkTankTalentsPhone2 = view.findViewById(R.id.ll_think_tank_talents_phone2);
        }
    }
}

