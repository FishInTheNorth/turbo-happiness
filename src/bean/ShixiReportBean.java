package bean;

import java.util.Date;

public class ShixiReportBean {
    private int shixiReportId; //实习报告id
    private String studentId; //学生id
    private String shixiId; //实习id
    private int week; //周数
    private String address;  //实习汇报提交地址
    private Date beginTime; //对应周数实习开始时间
    private Date endTime;//对应周数实习结束时间
    private float grade; //实习报告成绩
    private String opinion; //实习报告意见
    private final String stage="实习阶段";

    public String getStage() {
        return stage;
    }

    public String getShixiId() {
        return shixiId;
    }

    public void setShixiId(String shixiId) {
        this.shixiId = shixiId;
    }

    public int getShixiReportId() {
        return shixiReportId;
    }

    public void setShixiReportId(int shixiReportId) {
        this.shixiReportId = shixiReportId;
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
