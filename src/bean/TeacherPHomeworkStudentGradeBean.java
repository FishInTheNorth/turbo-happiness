package bean;

import java.util.Date;

public class TeacherPHomeworkStudentGradeBean {
    private String studentId; //ѧ��id
    private String trainId; //ʵѵid
    private int week; //����
    private Date beginTime; //��Ӧ����ʵѵ��ʼʱ��
    private Date endTime;//��Ӧ����ʵѵ����ʱ��
    private float grade; //ʵѵ����ɼ�
    private String opinion; //ʵѵ�������
    private String address; //ʵѵ�����ŵ�ַ


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
