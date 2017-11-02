package edu.sdust.iot.service;

import edu.sdust.iot.dao.StoreDAO;
import edu.sdust.iot.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WSL on 2017/5/22.
 */

@Service
public class StoreService {
    @Autowired
    private StoreDAO storeDAO;

    /**
     * 获得所有店铺信息
     *
     * @return
     */
    public List<Store> getAllStore() {
        return storeDAO.queryForAll();
    }

    /**
     * 获得指定店铺信息
     *
     * @param storeid
     * @return
     */
    public List<Store> getStore(int storeid) {
        return storeDAO.queryStoreId(storeid);
    }

    /**
     * 返回销售总数
     *
     * @param storeid
     * @return
     */
    public int getTotalNum(int storeid) {
        return storeDAO.queryTotalNum(storeid);
    }

    /**
     * 返回总销售收入
     *
     * @param storeid
     * @return
     */
    public double getTotalSales(int storeid) {
        return storeDAO.queryTotalSales(storeid);
    }

    /**
     * 返回总顾客数
     *
     * @param storeid
     * @return
     */
    public int getTotalCustomers(int storeid) {
        return storeDAO.queryTotalCustomers(storeid);
    }

    /**
     * 返回剩余商品数
     *
     * @param storeid
     * @return
     */
    public int getLeftNum(int storeid) {
        return storeDAO.queryLeftNum(storeid);
    }

    /**
     * 添加新店铺
     *
     * @param address
     * @param is_use
     * @param add
     * @return
     */
    public boolean addNewStore(String address, int is_use, String add) {
        return storeDAO.addNewStore(address, is_use, add);
    }
}
