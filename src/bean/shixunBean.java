package bean;

public class shixunBean {
    private int shixunId; //实训id
    private String teacherId; //实训老师id
    private String trainId; //实训id
    private String beginTime; //实训开始时间
    private String endTime; //实训结束实践
    private int isUse; //是否可用
    private final String stage="实训阶段";

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
