package cn.com.bitscube_intellectual.model.bean;

import java.util.List;

/**
 * Created by Emily on 9/7/21
 */
public class ThinkTankProjects {

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
        private List<Projects> projects;
        private Integer counts;

        public List<Projects> getProjects() {
            return projects;
        }

        public void setProjects(List<Projects> projects) {
            this.projects = projects;
        }

        public Integer getCounts() {
            return counts;
        }

        public void setCounts(Integer counts) {
            this.counts = counts;
        }

        public static class Projects {
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
