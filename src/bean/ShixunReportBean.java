package bean;

import java.util.Date;

public class ShixunReportBean {
    private int shixunReportId; //ʵѵ����id
    private String studentId; //ѧ��id
    private String shixunId; //ʵѵid
    private int week; //����
    private String address;  //ʵѵ�㱨�ύ��ַ
    private Date beginTime; //��Ӧ����ʵѵ��ʼʱ��
    private Date endTime;//��Ӧ����ʵѵ����ʱ��
    private float grade; //ʵѵ����ɼ�
    private String opinion; //ʵѵ�������
    private final String stage="ʵѵ�׶�";

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
