package bean;

public class TeacherBean {
    private String teacherId; //教师id
    private String teacherName; //教师姓名
    private String major; //教师专业
    private int sex; //教师性别
    private String teacherPhone; //教师手机号
    private String teacherQq; //教师QQ
    private String password; //教师密码
    private int isUse; //教师是否可用

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getMajor1() {
        return major;
    }

    public void setMajor1(String major) {
        this.major = major;
    }

    public int getSex1() {
        return sex;
    }

    public void setSex1(int sex) {
        this.sex = sex;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherQq() {
        return teacherQq;
    }

    public void setTeacherQq(String teacherQq) {
        this.teacherQq = teacherQq;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }
}
