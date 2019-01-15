package bean;

import java.util.Date;

public class ShixunReportBean {
    private int shixunReportId; //实训报告id
    private String studentId; //学生id
    private String shixunId; //实训id
    private int week; //周数
    private String address;  //实训汇报提交地址
    private Date beginTime; //对应周数实训开始时间
    private Date endTime;//对应周数实训结束时间
    private float grade; //实训报告成绩
    private String opinion; //实训报告意见
    private final String stage="实训阶段";

    public String getStage() {
        return stage;
    }

    public String getShixunId() {
        return shixunId;
    }

    public void setShixunId(String shixunId) {
        this.shixunId = shixunId;
    }

    public int getShixunReportId() {
        return shixunReportId;
    }

    public void setShixunReportId(int shixunReportId) {
        this.shixunReportId = shixunReportId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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
