package bean;

public class MapBean {
    private int mapId;  //��ͼid
    private String prvince; //ʡ��
    private String city; //����
    private float latitude; //ά��
    private float longitude;//����

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
