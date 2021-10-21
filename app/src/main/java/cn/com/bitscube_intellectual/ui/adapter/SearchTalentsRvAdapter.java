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
import cn.com.bitscube_intellectual.model.bean.Search;
import cn.com.bitscube_intellectual.ui.activity.ThinkTankTalentsInfoActivity;
import cn.com.bitscube_intellectual.ui.view.FlowGroupView;

/**
 * 搜索人才适配器
 * Created by Emily on 9/6/21
 */
public class SearchTalentsRvAdapter extends RecyclerView.Adapter<SearchTalentsRvAdapter.ViewHolder> implements View.OnClickListener {
    public Context context;
    public final List<Search.Data.Talents.TalentsList> list;
    public String tag_name;

    public SearchTalentsRvAdapter(Context context, List<Search.Data.Talents.TalentsList> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_talents_detail_rv_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        try {
            String avatar = list.get(position).getInfo().getAvatar();
            String name = list.get(position).getInfo().getName();

            //头像
            Utils.getPicasso(
                    context,
                    avatar,
                    holder.mImgSearchResultTalentAvatar,
                    name,
                    holder.mTvSearchResultTalentAvatar
            );

            String jobTitle = list.get(position).getInfo().getJob_title();
            if (!jobTitle.isEmpty()) {
                holder.mTvSearchResultTalentsTitle.setText(name + " " + "|" + " " + jobTitle);
            } else {
                holder.mTvSearchResultTalentsTitle.setText(name);
            }

            String dept_name = list.get(position).getInfo().getDept_name();
            holder.mTvSearchTalentsPost.setText(dept_name);


            //添加标签
            List<Search.Data.Talents.TalentsList.Tags> tags = list.get(position).getTags();
            holder.mFlowSearchResultTalents.setVisibility(View.VISIBLE);
            int size = tags.size() - 1;
            for (int i = 0; i < size; i++) {
                tag_name = tags.get(i).getTag_name();
                Utils.addNoBackgroundTalentsTagsTextView(
                        context,
                        holder.mFlowSearchResultTalents,
                        "*" + tag_name + "*",
                        "*"
                );
            }

            //有多个电话时，并排展示电话图标和电话号码
            String mobile = list.get(position).getInfo().getMobile();
            if (mobile.length() > 10) {
                holder.mLlSearchTalentsPhone.setVisibility(View.VISIBLE);
                String firstMobile = mobile.substring(0, 11);
                holder.mTvSearchTalentsPhone.setText(firstMobile);

                holder.mLlSearchTalentsPhone.setOnClickListener(v -> {
                    Utils.goToPhone(context, firstMobile);
                });
            }

            if (mobile.length() > 12) {
                holder.mLlSearchTalentsPhone2.setVisibility(View.VISIBLE);
                String secondMobile = mobile.substring(12, 23);
                holder.mTvSearchTalentsPhone2.setText(secondMobile);

                holder.mLlSearchTalentsPhone2.setOnClickListener(v -> {
                    Utils.goToPhone(context, secondMobile);
                });
            }

            holder.mLlSearchResultTalent.setOnClickListener(v -> {
                Intent intent = new Intent(context, ThinkTankTalentsInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(Const.OA_UID, list.get(position).getInfo().getOa_uid());
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
        private LinearLayout mLlSearchResultTalent;
        private TextView mTvSearchResultTalentAvatar;
        private ImageView mImgSearchResultTalentAvatar;
        private TextView mTvSearchResultTalentsTitle;
        private TextView mTvSearchTalentsPost;
        private FlowGroupView mFlowSearchResultTalents;
        private LinearLayout mLlSearchTalentsPhone;
        private TextView mTvSearchTalentsPhone;
        private LinearLayout mLlSearchTalentsPhone2;
        private TextView mTvSearchTalentsPhone2;

        ViewHolder(View view) {
            super(view);
            mLlSearchResultTalent = (LinearLayout) view.findViewById(R.id.ll_search_result_talent);
            mTvSearchResultTalentAvatar = (TextView) view.findViewById(R.id.tv_search_result_talent_avatar);
            mImgSearchResultTalentAvatar = (ImageView) view.findViewById(R.id.img_search_result_talent_avatar);
            mTvSearchResultTalentsTitle = (TextView) view.findViewById(R.id.tv_search_result_talents_title);
            mTvSearchTalentsPost = (TextView) view.findViewById(R.id.tv_search_talents_post);
            mFlowSearchResultTalents = (FlowGroupView) view.findViewById(R.id.flow_search_result_talents);
            mLlSearchTalentsPhone = (LinearLayout) view.findViewById(R.id.ll_search_talents_phone);
            mTvSearchTalentsPhone = (TextView)view.findViewById(R.id.tv_search_talents_phone);
            mLlSearchTalentsPhone2 = (LinearLayout) view.findViewById(R.id.ll_search_talents_phone2);
            mTvSearchTalentsPhone2 = (TextView) view.findViewById(R.id.tv_search_talents_phone2);
        }
    }
}

