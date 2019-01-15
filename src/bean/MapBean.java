package bean;

public class MapBean {
    private int mapId;  //地图id
    private String prvince; //省份
    private String city; //城市
    private float latitude; //维度
    private float longitude;//经度

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public String getPrvince() {
        return prvince;
    }

    public void setPrvince(String prvince) {
        this.prvince = prvince;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
