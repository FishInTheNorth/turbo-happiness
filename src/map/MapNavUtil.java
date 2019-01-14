package map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * �ߵµ�ͼ����������
 * @������ tiddler
 * @��дʱ�� 2018��8��14�� ����10:01:05
 * @�ļ��� MapNavUtil.java
 * @���� MapNavUtil
 */
public class MapNavUtil {
	private String startCoordinate;
	private String endCoordinate;
	private String applicationKey;
	private String param;
	/**
	 * ����Ҫ�������
	 * @param startCoordinate ��㾭γ�� ������ǰ��γ���ں�
	 * @param endCoordinate �յ㾭γ�� ������ǰ��γ���ں�
	 * @param applicationKey �ߵµ�ͼӦ��key����ҪWeb�������͵�key
	 */
	public MapNavUtil(String startCoordinate, String endCoordinate,
			String applicationKey) {
		this.startCoordinate = startCoordinate;
		this.endCoordinate = endCoordinate;
		this.applicationKey = applicationKey;
		this.param="origin="+this.startCoordinate+"&destination="+this.endCoordinate+"&key="+this.applicationKey;
	}
	/**
	 * ��ȡ��ͼ��������ֵ
	 * @return
	 */
	public MapNavResults getResults(){
		String sendGet = HttpRequest.sendGet("https://restapi.amap.com/v3/direction/driving", param);
		JSONObject jsonObject=JSONObject.fromObject(sendGet);
		String routeJsonString = jsonObject.get("route").toString();
		JSONObject routeObject=JSONObject.fromObject(routeJsonString);
		JSONArray jsonArray = routeObject.getJSONArray("paths");
		JSONObject zuiJson = jsonArray.getJSONObject(0);
		MapNavResults mapResult=new MapNavResults();
		mapResult.setDistance(zuiJson.get("distance").toString());
		//mapResult.setDuration(zuiJson.get("duration").toString());
		//mapResult.setTolls(zuiJson.get("tolls").toString());
		return mapResult;
	}
	
	
}