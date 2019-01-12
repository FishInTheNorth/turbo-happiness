package extraBean;

import java.util.Date;

public class studentsubmitBean {
	private int  trainId;//实训编号
	private Date beginTime;//开始时间
	private Date endTime;//结束时间
	private int week;//周数
	private String stage;//实训阶段

	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
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
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	
}
