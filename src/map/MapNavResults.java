package map;

public class MapNavResults {
	private String distance;//��ʻ����
	private String duration;//��ʻʱ�䣨��λ���룩
	private String tolls;//��·�շѣ���λ��Ԫ��


	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTolls() {
		return tolls;
	}
	public void setTolls(String tolls) {
		this.tolls = tolls;
	}
	@Override
	public String toString() {
		return distance;
	}
	
	
	
}