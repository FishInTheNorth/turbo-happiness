package bean;

public class ShijianBean {
    private int shijianId; //实践id
    private String teacherId; //实践老师id
    private String trainId; //实训id
    private String beginTime; //实践开始时间
    private String endTime; //实践结束实践
    private int isUse; //是否可用
    private final String stage="实践阶段";

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
