package bean;

public class ShijianBean {
    private int shijianId; //ʵ��id
    private String teacherId; //ʵ����ʦid
    private String trainId; //ʵѵid
    private String beginTime; //ʵ����ʼʱ��
    private String endTime; //ʵ������ʵ��
    private int isUse; //�Ƿ����
    private final String stage="ʵ���׶�";

    public String getStage() {
        return stage;
    }

    public int getShijianId() {
        return shijianId;
    }

    public void setShijianId(int shijianId) {
        this.shijianId = shijianId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }
}
