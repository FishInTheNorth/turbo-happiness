package bean;

public class ShixiBean {
    private int shixiId; //实习id
    private String teacherId; //实习老师id
    private String trainId; //实训id
    private String beginTime; //实习开始时间
    private String endTime; //实习结束实践
    private int isUse; //是否可用
    private final String stage="实习阶段";

    public String getStage() {
        return stage;
    }
    public int getShixiId() {
        return shixiId;
    }

    public void setShixiId(int shixiId) {
        this.shixiId = shixiId;
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
