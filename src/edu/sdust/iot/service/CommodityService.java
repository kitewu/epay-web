package edu.sdust.iot.service;

import edu.sdust.iot.dao.CommodityDAO;
import edu.sdust.iot.model.BuyHistory;
import edu.sdust.iot.model.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品服务
 * Created by WSL on 2017/5/23.
 */
@Service
public class CommodityService {

    @Autowired
    private CommodityDAO commoDAO;


    /**
     * 根据顾客获得历史记录信息
     *
     * @param uid
     * @return
     */
    public List<BuyHistory> getHistoryByUser(int uid) {
        return commoDAO.queryHistoryByUser(uid);
    }

    /**
     * 根据商品rfid标签号获得商品信息
     *
     * @param rfids
     * @return
     */
    public List<Commodity> getCommoListByRfid(String[] rfids) {
        return commoDAO.queryByRFID(rfids);
    }

    /**
     * 处理购买纪录
     *
     * @param rfids
     * @param commoids
     * @param uid
     * @param storeid
     * @return
     */
    public boolean dealBuyHistory(String[] rfids, String[] commoids, int uid, int storeid) {
        return commoDAO.insertBuyHistory(rfids, commoids, uid, storeid) && commoDAO.deleteByRFID(rfids);
    }

    /**
     * 添加新商品
     *
     * @param commo_name
     * @param price
     * @param rfid_number
     * @param store_id
     * @param aff
     * @return
     */
    public boolean addNewCommo(String commo_name, double price, String rfid_number, int store_id, String aff) {
        return commoDAO.addNewCommo(commo_name, price, rfid_number, store_id, aff);
    }

    /**
     * 返回所有的商品
     *
     * @return
     */
    public List<Commodity> getAllCommo() {
        return commoDAO.queryForAll();
    }
}
