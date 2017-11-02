package edu.sdust.iot.model;

/**
 * Created by WSL on 2017/7/21.
 */
public class History_T {
    int id;
    String commodity_id;
    String store_id;
    String buy_date;
    double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(String commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(String buy_date) {
        this.buy_date = buy_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public History_T(int id, String commodity_id, String store_id, String buy_date, double price) {
        this.id = id;
        this.commodity_id = commodity_id;
        this.store_id = store_id;
        this.buy_date = buy_date;
        this.price = price;
    }
}
