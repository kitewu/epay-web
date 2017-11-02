package edu.sdust.iot.model;

/**
 * 商店
 * Created by WSL on 2017/5/22.
 */
public class Store {

    private int id;         //id
    private int number;     //编号
    private String location;//位置
    private int if_use;     //是否使用
    private String aff;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getIf_use() {
        return if_use;
    }

    public void setIf_use(int if_use) {
        this.if_use = if_use;
    }

    public String getAff() {
        return aff;
    }

    public void setAff(String aff) {
        this.aff = aff;
    }


    public Store(int id, int number, String position, int if_use, String aff) {
        this.id = id;
        this.number = number;
        this.location = position;
        this.if_use = if_use;
        this.aff = aff;
    }

    public Store() {
    }

    public String toString() {
        return "{\"id\":" + id + ",\"number\":" + number +
                ",\"location\":" + "\"" + location + "\"" + ",\"if_use\":" + if_use +
                ",\"aff\":" + "\"" + aff + "\"" + "}";
    }
}
