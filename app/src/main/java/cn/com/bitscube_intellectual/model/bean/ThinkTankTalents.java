package cn.com.bitscube_intellectual.model.bean;

import java.util.List;

/**
 * Created by Emily on 9/7/21
 */
public class ThinkTankTalents {
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
        private List<Talents> talents;
        private Integer counts;

        public List<Talents> getTalents() {
            return talents;
        }

        public void setTalents(List<Talents> talents) {
            this.talents = talents;
        }

        public Integer getCounts() {
            return counts;
        }

        public void setCounts(Integer counts) {
            this.counts = counts;
        }

        public static class Talents {
            private Integer oa_uid;
            private String mobile;
            private String name;
            private String avatar;
            private String job_title;
            private Integer dept_id;
            private String dept_name;
            private List<Tags> tags;
            private List<Projects> projects;

            public Integer getOa_uid() {
                return oa_uid;
            }

            public void setOa_uid(Integer oa_uid) {
                this.oa_uid = oa_uid;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
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

            public List<Tags> getTags() {
                return tags;
            }

            public void setTags(List<Tags> tags) {
                this.tags = tags;
            }

            public List<Projects> getProjects() {
                return projects;
            }

            public void setProjects(List<Projects> projects) {
                this.projects = projects;
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

            public static class Projects {
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
    }
}
