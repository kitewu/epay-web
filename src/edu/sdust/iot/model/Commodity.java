package edu.sdust.iot.model;

/**
 * 商品
 * Created by WSL on 2017/5/22.
 */
public class Commodity {
    private int id;                     //id
    private String commodity_name;      //商品名
    private float commodity_price;      //价格
    private String commodity_rfid_uid;  //rfid
    private int in_store_number;        //在哪个商品里
    private String aff;

    public Commodity() {
    }

    public Commodity(int id, String commodity_name, float commodity_price, String commodity_rfid_uid, int in_store_number, String aff) {
        this.id = id;
        this.commodity_name = commodity_name;
        this.commodity_price = commodity_price;
        this.commodity_rfid_uid = commodity_rfid_uid;
        this.in_store_number = in_store_number;
        this.aff = aff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public float getCommodity_price() {
        return commodity_price;
    }

    public void setCommodity_price(float commodity_price) {
        this.commodity_price = commodity_price;
    }

    public String getCommodity_rfid_uid() {
        return commodity_rfid_uid;
    }

    public void setCommodity_rfid_uid(String commodity_rfid_uid) {
        this.commodity_rfid_uid = commodity_rfid_uid;
    }

    public int getIn_store_number() {
        return in_store_number;
    }

    public void setIn_store_number(int in_store_number) {
        this.in_store_number = in_store_number;
    }

    public String getAff() {
        return aff;
    }

    public void setAff(String aff) {
        this.aff = aff;
    }

    public String toString() {
        String str = "{" +
                "\"id\":" + id + "," +
                "\"commodity_name\":" + "\"" + commodity_name + "\"" + "," +
                "\"commodity_price\":" + commodity_price + "," +
                "\"commodity_rfid_uid\":" + "\"" + commodity_rfid_uid + "\"" + "," +
                "\"in_store_number\":" + in_store_number + "," +
                "\"aff\":" + "\"" + aff + "\"" +
                "}";
        return str;
    }
}
