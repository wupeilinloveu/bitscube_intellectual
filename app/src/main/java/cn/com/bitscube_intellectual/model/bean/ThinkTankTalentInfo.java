package cn.com.bitscube_intellectual.model.bean;

import java.util.List;

/**
 * Created by Emily on 9/7/21
 */
public class ThinkTankTalentInfo {

    private Integer code;
    private Data data;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class Data {
        private Info info;
        private List<Tags> tags;
        private Projects projects;

        public Info getInfo() {
            return info;
        }

        public void setInfo(Info info) {
            this.info = info;
        }

        public List<Tags> getTags() {
            return tags;
        }

        public void setTags(List<Tags> tags) {
            this.tags = tags;
        }

        public Projects getProjects() {
            return projects;
        }

        public void setProjects(Projects projects) {
            this.projects = projects;
        }

        public static class Info {
            private Integer oa_uid;
            private String name;
            private String avatar;
            private Integer dept_id;
            private String dept_name;
            private String job_title;
            private String mobile;
            private String state;

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

            public String getJob_title() {
                return job_title;
            }

            public void setJob_title(String job_title) {
                this.job_title = job_title;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }
        }

        public static class Projects {
            private Integer show_more;
            private List<ProjectsList> list;

            public Integer getShow_more() {
                return show_more;
            }

            public void setShow_more(Integer show_more) {
                this.show_more = show_more;
            }

            public List<ProjectsList> getList() {
                return list;
            }

            public void setList(List<ProjectsList> list) {
                this.list = list;
            }

            public static class ProjectsList {
                private Integer project_id;
                private String project_name;

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
            }
        }

        public static class Tags {
            private Integer tag_id;
            private String tag_name;
            private List<SubTags> sub_tags;

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

            public List<SubTags> getSub_tags() {
                return sub_tags;
            }

            public void setSub_tags(List<SubTags> sub_tags) {
                this.sub_tags = sub_tags;
            }

            public static class SubTags {
                private Integer tag_id;
                private String tag_name;
                private Integer selected;

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

                public Integer getSelected() {
                    return selected;
                }

                public void setSelected(Integer selected) {
                    this.selected = selected;
                }
            }
        }
    }
}
