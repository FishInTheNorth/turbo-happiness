package bean;

import java.util.Date;

public class ShixiReportBean {
    private int shixiReportId; //ʵϰ����id
    private String studentId; //ѧ��id
    private String shixiId; //ʵϰid
    private int week; //����
    private String address;  //ʵϰ�㱨�ύ��ַ
    private Date beginTime; //��Ӧ����ʵϰ��ʼʱ��
    private Date endTime;//��Ӧ����ʵϰ����ʱ��
    private float grade; //ʵϰ����ɼ�
    private String opinion; //ʵϰ�������
    private final String stage="ʵϰ�׶�";

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
