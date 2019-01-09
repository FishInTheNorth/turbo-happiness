package bean;

public class adminBean {
    private String adminId;  //管理员id
    private String password; //管理员密码
    private String adminName; //管理员姓名
    private int sex; //管理员性别
    private String adminPhone; //管理员手机号
    private String adminQq; //管理员QQ

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getAdminQq() {
        return adminQq;
    }

    public void setAdminQq(String adminQq) {
        this.adminQq = adminQq;
    }
}
