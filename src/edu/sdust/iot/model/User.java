package edu.sdust.iot.model;

/**
 * 用户类
 * Created by WSL on 2017/05/23.
 */
public class User {
    private int id;
    private String user_id;
    private String user_email;
    private String user_password;
    private String user_name;
    private String aff;

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setAff(String aff) {
        this.aff = aff;
    }

    public int getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getAff() {
        return aff;
    }


    public User() {
    }

    public User(int id, String user_id, String user_email, String user_password, String user_name, String aff) {
        this.id = id;
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_name = user_name;
        this.aff = aff;
    }
}

