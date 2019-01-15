package bean;

public class StudentBean {
    private String studentId; //学生id
    private String studentsName; //学生姓名
    private String major; //学生专业
    private int sex; //学生性别
    private String studentPhone;  //学生手机号
    private String studentQq; //学生qq
    private float grade; //学生成绩（最后计算出）
    private String Class; //学生年级
    private String password; //学生密码
    private int isUse; //学生信息是否可用

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentsName() {
        return studentsName;
    }

    public void setStudentsName(String studentsName) {
        this.studentsName = studentsName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSex1() {
        return sex;
    }

    public void setSex1(int sex) {
        this.sex = sex;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentQq() {
        return studentQq;
    }

    public void setStudentQq(String studentQq) {
        this.studentQq = studentQq;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getClass1() {
        return Class;
    }

    public void setClass1(String aClass) {
        Class = aClass;
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
