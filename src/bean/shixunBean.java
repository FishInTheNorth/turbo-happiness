package bean;

public class shixunBean {
    private int shixunId; //ʵѵid
    private String teacherId; //ʵѵ��ʦid
    private String trainId; //ʵѵid
    private String beginTime; //ʵѵ��ʼʱ��
    private String endTime; //ʵѵ����ʵ��
    private int isUse; //�Ƿ����
    private final String stage="ʵѵ�׶�";

    public String getStage() {
        return stage;
    }

    public int getShixunId() {
        return shixunId;
    }

    public void setShixunId(int shixunId) {
        this.shixunId = shixunId;
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
