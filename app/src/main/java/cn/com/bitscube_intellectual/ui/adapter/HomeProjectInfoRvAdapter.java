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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.com.bitscube_intellectual.R;
import cn.com.bitscube_intellectual.common.base.Const;
import cn.com.bitscube_intellectual.model.bean.Home;
import cn.com.bitscube_intellectual.ui.activity.ThinkTankProjectsInfoActivity;

/**
 * 首页项目适配器
 * Created by Emily on 9/6/21
 */
public class HomeProjectInfoRvAdapter extends RecyclerView.Adapter<HomeProjectInfoRvAdapter.ViewHolder> implements View.OnClickListener {
    public Context context;
    private final List<Home.HomeData> list;
    private int pageNumTalents = 1;
    private int totalPageTalents = 0;
    private int pageNumProjects = 1;
    private int totalPageProjects = 0;

    public HomeProjectInfoRvAdapter(Context context, List<Home.HomeData> list) {
        this.context = context;
        this.list = list;
    }

    private OnRecyclerViewListener mOnRecyclerViewListener = null;

    @Override
    public void onClick(View v) {
        if (mOnRecyclerViewListener != null) {
            mOnRecyclerViewListener.onItemClick(v, (Home.HomeData) v.getTag());
        }
    }

    public interface OnRecyclerViewListener {
        void onItemClick(View view, Home.HomeData homeBean);
    }

    public void setOnItemClickListener(OnRecyclerViewListener listener) {
        this.mOnRecyclerViewListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_project_info_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            //项目信息
            int project_id = list.get(position).getProject_info().getProject_id();
            String project_name = list.get(position).getProject_info().getProject_name();
            holder.mTvProjectName.setText(project_name);
            String leader_name = list.get(position).getProject_info().getLeader_name();
            holder.mTvLeaderName.setText(leader_name);

            //项目类型
            String kind = list.get(position).getProject_info().getKind();
            String sub_kind = list.get(position).getProject_info().getSub_kind();
            if (!sub_kind.isEmpty()) {
                holder.mTvKind.setText(kind + "-" + sub_kind);
            } else {
                holder.mTvKind.setText(kind);
            }

            //跳转
            holder.mLlHomeProjectInfo.setOnClickListener(v->{
                Intent intent = new Intent(context, ThinkTankProjectsInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(Const.PROJECT_ID, list.get(position).getProject_info().getProject_id());
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

            //当前阶段
            holder.mRvHomeCurrentStep.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
            HomeCurrentStepsRvAdapter homeCurrentStepsRvAdapter = new HomeCurrentStepsRvAdapter(context, list.get(position).getProject_info().getSteps());
            if (homeCurrentStepsRvAdapter == null) {
                homeCurrentStepsRvAdapter =
                        new HomeCurrentStepsRvAdapter(context, list.get(position).getProject_info().getSteps());
            }
            holder.mRvHomeCurrentStep.setAdapter(homeCurrentStepsRvAdapter);

            //跳转
            homeCurrentStepsRvAdapter.setOnItemClickListener((view, stepsBean) -> {
                Intent intent = new Intent(context, ThinkTankProjectsInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(Const.PROJECT_ID, list.get(position).getProject_info().getProject_id());
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

            //智库人才
            holder.mRvHomeTalentsRecommend.setLayoutManager(new LinearLayoutManager(context));
            List<Home.HomeData.TalentsRecommend> recommendListTalents = list.get(position).getTalents_recommend();
            int totalNumTalents = recommendListTalents.size(); //总条数

            if (totalNumTalents <= pageNumTalents) {
                totalPageTalents = 1;
            } else {
                if (totalNumTalents % Const.pageSizeTalents > 0) {
                    totalPageTalents = totalNumTalents / Const.pageSizeTalents + 1;
                } else {
                    totalPageTalents = totalNumTalents / Const.pageSizeTalents;
                }
            }

            if (totalNumTalents <= Const.pageSizeTalents) {
                holder.mImgThinkTankReload.setVisibility(View.GONE);   //总条数<=4条 隐藏刷新按钮
            }
            List<Home.HomeData.TalentsRecommend> recommendShowListTalents =
                    showTalentsRecommendList(pageNumTalents, recommendListTalents);
            holder.mRvHomeTalentsRecommend.setAdapter(new HomeTalentsRecommendRvAdapter(context, recommendShowListTalents));

            //换一批
            holder.mImgThinkTankReload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pageNumTalents++;
                    if (pageNumTalents > totalPageTalents) {
                        pageNumTalents = 1;
                    } else {
                        pageNumTalents=pageNumTalents;
                    }
                    List<Home.HomeData.TalentsRecommend> list = showTalentsRecommendList(pageNumTalents, recommendListTalents);
                    holder.mRvHomeTalentsRecommend.setAdapter(null);
                    holder.mRvHomeTalentsRecommend.setAdapter(new HomeTalentsRecommendRvAdapter(context, list));
                }
            });

            //专业部门
            holder.mRvHomeDeptsRecommend.setLayoutManager(new LinearLayoutManager(context));
            HomeDeptsRecommendRvAdapter homeDeptsRecommendRvAdapter = new HomeDeptsRecommendRvAdapter(context, list.get(position).getDepts_recommend());
            if (homeDeptsRecommendRvAdapter == null) {
                homeDeptsRecommendRvAdapter =
                        new HomeDeptsRecommendRvAdapter(context, list.get(position).getDepts_recommend());
            }
            holder.mRvHomeDeptsRecommend.setAdapter(homeDeptsRecommendRvAdapter);

            //同类项目
            holder.mRvHomeProjectsRecommend.setLayoutManager(new LinearLayoutManager(context));
            List<Home.HomeData.ProjectsRecommend> recommendListProjects = list.get(position).getProjects_recommend();
            int totalNumProjects = recommendListProjects.size(); //总条数

             if (totalNumProjects <= pageNumProjects) {
                 totalPageProjects=1;
            } else {
                if (totalNumProjects % Const.pageSizeProjects > 0) {
                    totalPageProjects=totalNumProjects / Const.pageSizeProjects + 1;
                } else {
                    totalPageProjects=totalNumProjects / Const.pageSizeProjects;
                }
            }

            if (totalNumProjects <= Const.pageSizeProjects) {
                holder.mImgProjectsReload.setVisibility(View.GONE );   //总条数<=3条 隐藏刷新按钮
            }
            List<Home.HomeData.ProjectsRecommend> recommendShowList =
                    showProjectsRecommendList(pageNumProjects, recommendListProjects);
            holder.mRvHomeProjectsRecommend.setAdapter(new HomeProjectsRecommendRvAdapter(context,recommendShowList));

            //换一批
            holder.mImgProjectsReload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pageNumProjects++;
                    if (pageNumProjects > totalPageProjects) {
                        pageNumProjects = 1;
                    } else {
                        pageNumProjects=pageNumProjects;
                    }
                    List<Home.HomeData.ProjectsRecommend> list = showProjectsRecommendList(pageNumProjects, recommendListProjects);
                    holder.mRvHomeProjectsRecommend.setAdapter(null);
                    holder.mRvHomeProjectsRecommend.setAdapter(new HomeProjectsRecommendRvAdapter(context,list));
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Home.HomeData.TalentsRecommend> showTalentsRecommendList(
            int page,
            List<Home.HomeData.TalentsRecommend> list
    ) {
        int totalCount = list.size();

        int startIndexProjects = (page - 1) * Const.pageSizeTalents;
        int endIndexProjects =
                startIndexProjects + Const.pageSizeTalents;
        if (endIndexProjects > totalCount) endIndexProjects = totalCount;

        return list.subList(startIndexProjects, endIndexProjects);
    }

    private List<Home.HomeData.ProjectsRecommend> showProjectsRecommendList(
            int page,
            List<Home.HomeData.ProjectsRecommend> list
    ) {
        int totalCount = list.size();

        int startIndexProjects = (page - 1) * Const.pageSizeProjects;
        int endIndexProjects =
                startIndexProjects + Const.pageSizeProjects;
        if (endIndexProjects > totalCount) endIndexProjects = totalCount;

        return list.subList(startIndexProjects, endIndexProjects);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvProjectName;
        private TextView mTvLeaderName;
        private TextView mTvKind;
        private RecyclerView mRvHomeCurrentStep;
        private LinearLayout mLlHomeProjectInfo;
        private ImageView mImgThinkTankReload;
        private RecyclerView mRvHomeTalentsRecommend;
        private ImageView mImgDeptsReload;
        private RecyclerView mRvHomeDeptsRecommend;
        private ImageView mImgProjectsReload;
        private RecyclerView mRvHomeProjectsRecommend;

        ViewHolder(View view) {
            super(view);
            mTvProjectName = view.findViewById(R.id.tv_project_name);
            mTvLeaderName = view.findViewById(R.id.tv_leader_name);
            mTvKind = view.findViewById(R.id.tv_kind);
            mRvHomeCurrentStep = view.findViewById(R.id.rv_home_current_step);
            mLlHomeProjectInfo = view.findViewById(R.id.ll_home_project_info);
            mImgThinkTankReload = view.findViewById(R.id.img_think_tank_reload);
            mRvHomeTalentsRecommend = view.findViewById(R.id.rv_home_talents_recommend);
            mImgDeptsReload = view.findViewById(R.id.img_depts_reload);
            mRvHomeDeptsRecommend = view.findViewById(R.id.rv_home_depts_recommend);
            mImgProjectsReload = view.findViewById(R.id.img_projects_reload);
            mRvHomeProjectsRecommend = view.findViewById(R.id.rv_home_projects_recommend);
        }
    }
}
