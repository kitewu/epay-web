package edu.sdust.iot.model;

/**
 * 管理员类
 * Created by WSL on 2017/7/15.
 */
public class Admin {
    private int id;
    private String admin_id;
    private String admin_email;
    private String admin_name;
    private String admin_password;
    private String aff;

    public void setId(int id) {
        this.id = id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public void setAff(String aff) {
        this.aff = aff;
    }

    public Admin() {
    }


    public int getId() {
        return id;
    }

    public String getAdmin_id() {
        return admin_id;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public String getAff() {
        return aff;
    }

    public Admin(int id, String admin_id, String admin_email, String admin_name, String admin_password, String aff) {
        this.id = id;

        this.admin_id = admin_id;
        this.admin_email = admin_email;
        this.admin_name = admin_name;
        this.admin_password = admin_password;
        this.aff = aff;
    }


}
