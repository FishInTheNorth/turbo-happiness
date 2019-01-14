package map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 高德地图导航工具类
 * @开发者 tiddler
 * @编写时间 2018年8月14日 上午10:01:05
 * @文件名 MapNavUtil.java
 * @类名 MapNavUtil
 */
public class MapNavUtil {
	private String startCoordinate;
	private String endCoordinate;
	private String applicationKey;
	private String param;
	/**
	 * 必须要构造参数
	 * @param startCoordinate 起点经纬度 经度在前，纬度在后
	 * @param endCoordinate 终点经纬度 经度在前，纬度在后
	 * @param applicationKey 高德地图应用key，需要Web服务类型的key
	 */
	public MapNavUtil(String startCoordinate, String endCoordinate,
			String applicationKey) {
		this.startCoordinate = startCoordinate;
		this.endCoordinate = endCoordinate;
		this.applicationKey = applicationKey;
		this.param="origin="+this.startCoordinate+"&destination="+this.endCoordinate+"&key="+this.applicationKey;
	}
	/**
	 * 获取地图导航返回值
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