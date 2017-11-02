package edu.sdust.iot.dao;

import edu.sdust.iot.model.Store;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WSL on 2016/10/25.
 */
@Repository
public class StoreDAO extends DAO {

    /**
     * 获得所有店铺信息
     *
     * @return
     */
    public List<Store> queryForAll() {
        String sql = "select * from store_number";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Store.class));
    }

    /**
     * 获得指定店铺信息
     *
     * @param storeid
     * @return
     */
    public List<Store> queryStoreId(int storeid) {
        String sql = "select * from store_number where id=" + storeid + "";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Store.class));
    }

    /**
     * 总购买量
     *
     * @param storeid
     * @return
     */
    public int queryTotalNum(int storeid) {
        String sql = "select * from buy_history where store_id = " + storeid;
        System.out.println(sql);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Store.class)).size();
    }

    /**
     * 总收入
     *
     * @param storeid
     * @return
     */
    public double queryTotalSales(int storeid) {
        String sql = "select price from buy_history where store_id = " + storeid;
        System.out.println(sql);
        List<Double> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Double.class));
        double sum = 0;
        for (double d : list)
            sum += d;
        return sum;
    }

    /**
     * 总顾客量
     *
     * @param storeid
     * @return
     */
    public int queryTotalCustomers(int storeid) {
        String sql = "select distinct guest_id from buy_history where store_id = " + storeid;
        System.out.println(sql);
        List<Double> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Integer.class));
        return list.size();
    }

    /**
     * 剩余商品总量
     *
     * @param storeid
     * @return
     */
    public int queryLeftNum(int storeid) {
        String sql = "select id from store_commodity where in_store_number = " + storeid;
        System.out.println(sql);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Integer.class)).size();
    }

    /**
     * 插入新的商店
     *
     * @param address
     * @param is_use
     * @param add
     * @return
     */
    public boolean addNewStore(String address, int is_use, String add) {
        String sql = "insert into store_number(location, if_use, aff) values('" + address + "'," + is_use + ",'" + add + "')";
        System.out.println(sql);
        return jdbcTemplate.update(sql) == 1 ? true : false;
    }
}