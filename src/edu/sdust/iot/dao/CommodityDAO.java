package edu.sdust.iot.dao;

import edu.sdust.iot.model.BuyHistory;
import edu.sdust.iot.model.Commodity;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by WSL on 2017/5/23.
 */
@Repository
public class CommodityDAO extends DAO {

    /**
     * 获得所有商品信息
     *
     * @return
     */
    public List<Commodity> queryForAll() {
        String sql = "select * from store_commodity";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Commodity.class));
    }

    /**
     * 根据顾客获得历史记录信息
     *
     * @param uid
     * @return
     */
    public List<BuyHistory> queryHistoryByUser(int uid) {
        String sql = "select * from buy_history where guest_id = " + uid + " ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(BuyHistory.class));
    }

    /**
     * 根据rfid标签号获得商品的信息
     *
     * @param rfids
     * @return
     */
    public List<Commodity> queryByRFID(String[] rfids) {
        String sql = "select * from store_commodity where commodity_rfid_uid = '" + rfids[0] + "'";
        for (int i = 1; i < rfids.length; i++)
            sql += " or  commodity_rfid_uid= '" + rfids[i] + "'";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Commodity.class));
    }

    /**
     * 添加购买记录
     *
     * @param rfids
     * @param commoids
     * @param uid
     * @param storeid
     * @return
     */
    public boolean insertBuyHistory(String[] rfids, String[] commoids, int uid, int storeid) {
        //添加
        String sql = "INSERT INTO buy_history (guest_id, commodity_id, rfid_id, store_id, buy_date) VALUES (?, ?, ?, ?, ?)";
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, uid);
                ps.setInt(2, Integer.valueOf(commoids[i]));
                ps.setString(3, rfids[i]);
                ps.setInt(4, storeid);
                ps.setString(5, sdf.format(new Date()));
            }

            @Override
            public int getBatchSize() {
                return rfids.length;
            }
        }).length == rfids.length ? true : false;
    }

    /**
     * 删除商品记录
     *
     * @param rfids
     * @return
     */
    public boolean deleteByRFID(String[] rfids) {
        String sql = "delete from store_commodity where commodity_rfid_uid = ?";
        int a[] = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, rfids[i]);
            }

            @Override
            public int getBatchSize() {
                return rfids.length;
            }
        });
        return a.length == rfids.length ? true : false;
    }

    /**
     * 插入新的商品
     *
     * @param commo_name
     * @param price
     * @param rfid_number
     * @param in_store_number
     * @param aff
     * @return
     */
    public boolean addNewCommo(String commo_name, double price, String rfid_number, int in_store_number, String aff) {
        String sql = "insert into store_commodity(commodity_name, commodity_price, commodity_rfid_uid, in_store_number, aff) " +
                "values('" + commo_name + "'," + price + ",'" + rfid_number + "', '" + in_store_number + "', '" + aff + "')";
        System.out.println(sql);
        return jdbcTemplate.update(sql) == 1 ? true : false;
    }
}
