package bean;

public class StudentTrainBean {
    private int studentTrainId; //学生实训Id
    private String studentId; //学生id
    private int trainId; //实训id
    private String province; //实训所在省
    private String city; //实训所在市
    private String company; //实训所在公司
    private String contactName; //公司联系人姓名
    private String contactPhone; //公司联系人电话
    private int isUse; //此字段是否可用

    public int getStudentTrainId() {
        return studentTrainId;
    }

    public void setStudentTrainId(int studentTrainId) {
        this.studentTrainId = studentTrainId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity1() {
        return city;
    }

    public void setCity1(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public int getIsUse() {
        return isUse;
    }

    public void setIsUse(int isUse) {
        this.isUse = isUse;
    }
}
