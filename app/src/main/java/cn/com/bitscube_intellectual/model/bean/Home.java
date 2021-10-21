package cn.com.bitscube_intellectual.model.bean;

import java.util.List;

/**
 * Created by Emily on 9/6/21
 */
public class Home {
    private Integer code;
    private List<HomeData> data;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<HomeData> getData() {
        return data;
    }

    public void setData(List<HomeData> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class HomeData {
        private ProjectInfo project_info;
        private List<TalentsRecommend> talents_recommend;
        private List<DeptsRecommend> depts_recommend;
        private List<ProjectsRecommend> projects_recommend;

        public ProjectInfo getProject_info() {
            return project_info;
        }

        public void setProject_info(ProjectInfo project_info) {
            this.project_info = project_info;
        }

        public List<TalentsRecommend> getTalents_recommend() {
            return talents_recommend;
        }

        public void setTalents_recommend(List<TalentsRecommend> talents_recommend) {
            this.talents_recommend = talents_recommend;
        }

        public List<DeptsRecommend> getDepts_recommend() {
            return depts_recommend;
        }

        public void setDepts_recommend(List<DeptsRecommend> depts_recommend) {
            this.depts_recommend = depts_recommend;
        }

        public List<ProjectsRecommend> getProjects_recommend() {
            return projects_recommend;
        }

        public void setProjects_recommend(List<ProjectsRecommend> projects_recommend) {
            this.projects_recommend = projects_recommend;
        }

        public static class ProjectInfo {
            private Integer project_id;
            private String project_name;
            private String leader_id;
            private String leader_name;
            private String kind;
            private String sub_kind;
            private List<Steps> steps;

            public Integer getProject_id() {
                return project_id;
            }

            public void setProject_id(Integer project_id) {
                this.project_id = project_id;
            }

            public String getProject_name() {
                return project_name;
            }

            public void setProject_name(String project_name) {
                this.project_name = project_name;
            }

            public String getLeader_id() {
                return leader_id;
            }

            public void setLeader_id(String leader_id) {
                this.leader_id = leader_id;
            }

            public String getLeader_name() {
                return leader_name;
            }

            public void setLeader_name(String leader_name) {
                this.leader_name = leader_name;
            }

            public String getKind() {
                return kind;
            }

            public void setKind(String kind) {
                this.kind = kind;
            }

            public String getSub_kind() {
                return sub_kind;
            }

            public void setSub_kind(String sub_kind) {
                this.sub_kind = sub_kind;
            }

            public List<Steps> getSteps() {
                return steps;
            }

            public void setSteps(List<Steps> steps) {
                this.steps = steps;
            }

            public static class Steps {
                private String step_name;
                private String step_date;
                private Integer current;

                public String getStep_name() {
                    return step_name;
                }

                public void setStep_name(String step_name) {
                    this.step_name = step_name;
                }

                public String getStep_date() {
                    return step_date;
                }

                public void setStep_date(String step_date) {
                    this.step_date = step_date;
                }

                public Integer getCurrent() {
                    return current;
                }

                public void setCurrent(Integer current) {
                    this.current = current;
                }
            }
        }

        public static class TalentsRecommend {
            private Integer oa_uid;
            private String name;
            private String avatar;
            private String job_title;
            private List<Tags> tags;

            public Integer getOa_uid() {
                return oa_uid;
            }

            public void setOa_uid(Integer oa_uid) {
                this.oa_uid = oa_uid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getJob_title() {
                return job_title;
            }

            public void setJob_title(String job_title) {
                this.job_title = job_title;
            }

            public List<Tags> getTags() {
                return tags;
            }

            public void setTags(List<Tags> tags) {
                this.tags = tags;
            }

            public static class Tags {
                private Integer tag_id;
                private String tag_name;

                public Integer getTag_id() {
                    return tag_id;
                }

                public void setTag_id(Integer tag_id) {
                    this.tag_id = tag_id;
                }

                public String getTag_name() {
                    return tag_name;
                }

                public void setTag_name(String tag_name) {
                    this.tag_name = tag_name;
                }
            }
        }

        public static class DeptsRecommend {
            private Integer dept_id;
            private String dept_name;
            private String dept_logo;
            private Integer member_count;

            public Integer getDept_id() {
                return dept_id;
            }

            public void setDept_id(Integer dept_id) {
                this.dept_id = dept_id;
            }

            public String getDept_name() {
                return dept_name;
            }

            public void setDept_name(String dept_name) {
                this.dept_name = dept_name;
            }

            public String getDept_logo() {
                return dept_logo;
            }

            public void setDept_logo(String dept_logo) {
                this.dept_logo = dept_logo;
            }

            public Integer getMember_count() {
                return member_count;
            }

            public void setMember_count(Integer member_count) {
                this.member_count = member_count;
            }
        }

        public static class ProjectsRecommend {
            private Integer project_id;
            private String project_name;
            private String kind;
            private String date;

            public Integer getProject_id() {
                return project_id;
            }

            public void setProject_id(Integer project_id) {
                this.project_id = project_id;
            }

            public String getProject_name() {
                return project_name;
            }

            public void setProject_name(String project_name) {
                this.project_name = project_name;
            }

            public String getKind() {
                return kind;
            }

            public void setKind(String kind) {
                this.kind = kind;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }
    }
}
