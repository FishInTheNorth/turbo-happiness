package bean;

import java.util.Date;

public class ShijianReportBean {
    private int shijianReportId; //实践报告id
    private String studentId; //学生id
    private String shijianId; //实践id
    private int week; //周数
    private String address;  //实践汇报提交地址
    private Date beginTime; //对应周数实践开始时间
    private Date endTime;//对应周数实践结束时间
    private float grade; //实践报告成绩
    private String opinion; //实践报告意见
    private final String stage="实践阶段";

    public String getStage() {
        return stage;
    }

    public int getShijianReportId() {
        return shijianReportId;
    }

    public void setShijianReportId(int shijianReportId) {
        this.shijianReportId = shijianReportId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getShijianId() {
        return shijianId;
    }

    public void setShijianId(String shijianId) {
        this.shijianId = shijianId;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
