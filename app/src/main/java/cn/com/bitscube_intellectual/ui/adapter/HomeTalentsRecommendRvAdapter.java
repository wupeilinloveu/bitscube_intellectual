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
import cn.com.bitscube_intellectual.model.bean.Home;
import cn.com.bitscube_intellectual.ui.activity.ThinkTankTalentsInfoActivity;
import cn.com.bitscube_intellectual.ui.view.FlowGroupView;


/**
 * 首页人才模块适配器
 * Created by Emily on 9/6/21
 */
public class HomeTalentsRecommendRvAdapter extends RecyclerView.Adapter<HomeTalentsRecommendRvAdapter.ViewHolder> implements View.OnClickListener {
    public Context context;
    public final List<Home.HomeData.TalentsRecommend> list;
    String tag_name="";

    public HomeTalentsRecommendRvAdapter(Context context, List<Home.HomeData.TalentsRecommend> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_talents_recommend_rv_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        try {
            //智库人才
            String avatar = list.get(position).getAvatar();
            String name = list.get(position).getName();

            //头像
            Utils.getPicasso(
                    context,
                    avatar,
                    holder.mImgHomeTalentAvatar,
                    name,
                    holder.mTvHomeTalentAvatar
            );

            String jobTitle = list.get(position).getJob_title();
            if (!jobTitle.isEmpty()) {
                holder.mTvThinkTankPersonName.setText(name + " " + "|" + " " + jobTitle);
            }else{
                holder.mTvThinkTankPersonName.setText(name);
            }

            //添加标签
            List<Home.HomeData.TalentsRecommend.Tags> tags=list.get(position).getTags();
            int size = tags.size() - 1;

            for (int i=0; i<size;i++) {
                 tag_name = tags.get(i).getTag_name();
                Utils.addNoBackgroundTalentsTagsTextView(
                        context,
                        holder.mFlowHomeTalents,
                        "*" + tag_name + "*",
                        "*"
                );
            }

            holder.mLlTalentsRecommend.setOnClickListener(v -> {
                Intent intent = new Intent(context, ThinkTankTalentsInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(Const.OA_UID, list.get(position).getOa_uid());
                bundle.putString(Const.TALENTS_LOGO, avatar);
                bundle.putString(Const.TALENTS_NAME, name);
                bundle.putString(Const.TALENTS_DEPT_NAME, context.getString(R.string.default_department));
                bundle.putString(Const.TALENTS_JOB_TITLE, jobTitle);
                bundle.putString(Const.TALENTS_TAG_NAME,  context.getString(R.string.default_tag));
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
        private TextView mTvHomeTalentAvatar;
        private ImageView mImgHomeTalentAvatar;
        private TextView mTvThinkTankPersonName;
        private FlowGroupView mFlowHomeTalents;
        private LinearLayout mLlTalentsRecommend;

        ViewHolder(View view) {
            super(view);
            mTvHomeTalentAvatar = view.findViewById(R.id.tv_home_talent_avatar);
            mImgHomeTalentAvatar =view. findViewById(R.id.img_home_talent_avatar);
            mTvThinkTankPersonName = view.findViewById(R.id.tv_think_tank_person_name);
            mFlowHomeTalents = view.findViewById(R.id.flow_home_talents);
            mLlTalentsRecommend = view.findViewById(R.id.ll_talents_recommend);
        }
    }
}

