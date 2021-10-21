package cn.com.bitscube_intellectual.model.bean;

import java.util.List;

/**
 * Created by Emily on 9/13/21
 */
public class Search {
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
        private List<?> history;
        private Talents talents;
        private Projects projects;

        public List<?> getHistory() {
            return history;
        }

        public void setHistory(List<?> history) {
            this.history = history;
        }

        public Talents getTalents() {
            return talents;
        }

        public void setTalents(Talents talents) {
            this.talents = talents;
        }

        public Projects getProjects() {
            return projects;
        }

        public void setProjects(Projects projects) {
            this.projects = projects;
        }

        public static class Talents {
            private Integer show_more;
            private List<TalentsList> list;

            public Integer getShow_more() {
                return show_more;
            }

            public void setShow_more(Integer show_more) {
                this.show_more = show_more;
            }

            public List<TalentsList> getList() {
                return list;
            }

            public void setList(List<TalentsList> list) {
                this.list = list;
            }

            public static class TalentsList {
                private Info info;
                private List<Tags> tags;
                private List<Projects> projects;

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

                public List<Projects> getProjects() {
                    return projects;
                }

                public void setProjects(List<Projects> projects) {
                    this.projects = projects;
                }

                public static class Info {
                    private Integer oa_uid;
                    private String name;
                    private String avatar;
                    private String mobile;
                    private String job_title;
                    private Integer dept_id;
                    private String dept_name;

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

                    public String getMobile() {
                        return mobile;
                    }

                    public void setMobile(String mobile) {
                        this.mobile = mobile;
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
                private String project_obj;
                private String leader_name;
                private String domain;
                private String kind;
                private String sub_kind;
                private String area;

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

                public String getProject_obj() {
                    return project_obj;
                }

                public void setProject_obj(String project_obj) {
                    this.project_obj = project_obj;
                }

                public String getLeader_name() {
                    return leader_name;
                }

                public void setLeader_name(String leader_name) {
                    this.leader_name = leader_name;
                }


                public String getDomain() {
                    return domain;
                }

                public void setDomain(String domain) {
                    this.domain = domain;
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

                public String getArea() {
                    return area;
                }

                public void setArea(String area) {
                    this.area = area;
                }
            }
        }
    }
}
