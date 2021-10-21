package cn.com.bitscube_intellectual.model.bean;

import java.util.List;

/**
 * Created by Emily on 9/7/21
 */
public class ThinkTankProjectInfo {

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
        private List<Members> members;
        private List<Steps> steps;

        public Info getInfo() {
            return info;
        }

        public void setInfo(Info info) {
            this.info = info;
        }

        public List<Members> getMembers() {
            return members;
        }

        public void setMembers(List<Members> members) {
            this.members = members;
        }

        public List<Steps> getSteps() {
            return steps;
        }

        public void setSteps(List<Steps> steps) {
            this.steps = steps;
        }

        public static class Info {
            private Integer project_id;
            private String project_name;
            private Integer leader_id;
            private String leader_name;
            private String kind;
            private String sub_kind;
            private String project_code;
            private Integer dept_id;
            private String dept_name;
            private String area;
            private String scale;
            private Integer is_join;

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

            public Integer getLeader_id() {
                return leader_id;
            }

            public void setLeader_id(Integer leader_id) {
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

            public String getProject_code() {
                return project_code;
            }

            public void setProject_code(String project_code) {
                this.project_code = project_code;
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

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getScale() {
                return scale;
            }

            public void setScale(String scale) {
                this.scale = scale;
            }

            public Integer getIs_join() {
                return is_join;
            }

            public void setIs_join(Integer is_join) {
                this.is_join = is_join;
            }
        }

        public static class Members {
            private Integer oa_uid;
            private String name;
            private String avatar;
            private String job_title;
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

            public String getJob_title() {
                return job_title;
            }

            public void setJob_title(String job_title) {
                this.job_title = job_title;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }
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
}
