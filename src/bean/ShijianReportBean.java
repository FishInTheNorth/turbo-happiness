package bean;

import java.util.Date;

public class ShijianReportBean {
    private int shijianReportId; //ʵ������id
    private String studentId; //ѧ��id
    private String shijianId; //ʵ��id
    private int week; //����
    private String address;  //ʵ���㱨�ύ��ַ
    private Date beginTime; //��Ӧ����ʵ����ʼʱ��
    private Date endTime;//��Ӧ����ʵ������ʱ��
    private float grade; //ʵ������ɼ�
    private String opinion; //ʵ���������
    private final String stage="ʵ���׶�";

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
