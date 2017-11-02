package edu.sdust.iot.model;

/**
 * 购买历史纪录
 * Created by WSL on 2017/5/23.
 */
public class BuyHistory {
    private int id;
    private int guest_id;
    private int commodity_id;
    private String rfid_id;
    private int store_id;
    private String buy_date;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BuyHistory() {
    }

    public BuyHistory(int id, int guest_id, int commodity_id, String rfid_id, int store_id, String buy_date, double price) {
        this.id = id;
        this.guest_id = guest_id;
        this.commodity_id = commodity_id;
        this.rfid_id = rfid_id;
        this.store_id = store_id;
        this.buy_date = buy_date;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public int getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(int commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getRfid_id() {
        return rfid_id;
    }

    public void setRfid_id(String rfid_id) {
        this.rfid_id = rfid_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(String buy_date) {
        this.buy_date = buy_date;
    }
}
