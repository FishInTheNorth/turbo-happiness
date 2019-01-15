package extraBean;

import java.util.Date;
import java.util.List;

public class AddTrain {
    private String schoolYear;
    private Date shixiBeginTime;
    private Date shixiEndTime;
    private Date shixunBeginTime;
    private Date shixunEndTime;
    private Date shijianBeginTime;
    private Date shijianEndTime;
    private List<String> shixiTeacherId;
    private List<String> shixunTeacherId;
    private List<String> shijianTeacherId;
    private List<String> studntId;

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public Date getShixiBeginTime() {
        return shixiBeginTime;
    }

    public void setShixiBeginTime(Date shixiBeginTime) {
        this.shixiBeginTime = shixiBeginTime;
    }

    public Date getShixiEndTime() {
        return shixiEndTime;
    }

    public void setShixiEndTime(Date shixiEndTime) {
        this.shixiEndTime = shixiEndTime;
    }

    public Date getShixunBeginTime() {
        return shixunBeginTime;
    }

    public void setShixunBeginTime(Date shixunBeginTime) {
        this.shixunBeginTime = shixunBeginTime;
    }

    public Date getShixunEndTime() {
        return shixunEndTime;
    }

    public void setShixunEndTime(Date shixunEndTime) {
        this.shixunEndTime = shixunEndTime;
    }

    public Date getShijianBeginTime() {
        return shijianBeginTime;
    }

    public void setShijianBeginTime(Date shijianBeginTime) {
        this.shijianBeginTime = shijianBeginTime;
    }

    public Date getShijianEndTime() {
        return shijianEndTime;
    }

    public void setShijianEndTime(Date shijianEndTime) {
        this.shijianEndTime = shijianEndTime;
    }

    public List<String> getShixiTeacherId() {
        return shixiTeacherId;
    }

    public void setShixiTeacherId(List<String> shixiTeacherId) {
        this.shixiTeacherId = shixiTeacherId;
    }

    public List<String> getShixunTeacherId() {
        return shixunTeacherId;
    }

    public void setShixunTeacherId(List<String> shixunTeacherId) {
        this.shixunTeacherId = shixunTeacherId;
    }

    public List<String> getShijianTeacherId() {
        return shijianTeacherId;
    }

    public void setShijianTeacherId(List<String> shijianTeacherId) {
        this.shijianTeacherId = shijianTeacherId;
    }

    public List<String> getStudntId() {
        return studntId;
    }

    public void setStudntId(List<String> studntId) {
        this.studntId = studntId;
    }
    public boolean comperTo(){
        boolean isTrue = false;
        if ((this.getShixiBeginTime().compareTo(this.getShixiEndTime()) == -1) &&
                (this.getShixunBeginTime().compareTo(this.getShixunEndTime()) == -1) &&
                (this.getShijianBeginTime().compareTo(this.getShijianEndTime()) == -1)){
            if ((this.getShixiEndTime().compareTo(this.getShixunBeginTime()) == -1) &&
                    (this.getShixunEndTime().compareTo(this.getShijianBeginTime()) ==-1)){
                isTrue = true;
            }
        }
        return isTrue;
    }
}
