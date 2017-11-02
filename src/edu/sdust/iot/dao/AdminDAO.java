package edu.sdust.iot.dao;

import edu.sdust.iot.model.Admin;
import edu.sdust.iot.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 管理员Dao
 * Created by WSL on 2017/07/15.
 */
@Repository
public class AdminDAO extends DAO {

    private String TABLE_NAME = "admin";

    /**
     * 查询所有的管理员
     *
     * @return
     */
    public List<User> queryAll() {
        String sql = "select * from " + TABLE_NAME + "";
        System.out.println(sql);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Admin.class));
    }

    /**
     * 删除一个用户
     *
     * @param admin_id
     * @return
     */
    public boolean deleteAdmin(int admin_id) {
        String sql = "delete from " + TABLE_NAME + " where admin_id = " + admin_id;
        System.out.println(sql);
        return jdbcTemplate.update(sql) > 0 ? true : false;
    }

//    /**
//     * 插入一条用户记录
//     *
//     * @param args
//     * @return
//     */
//    public boolean insert(String... args) {
//        String sql = "insert into t_user values(?, ?, ?, ?, ?, ?, 1, now(), 0)";
//        return jdbcTemplate.update(sql, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps) throws SQLException {
//                for (int j = 0; j < args.length; j++)
//                    ps.setObject(j + 1, args[j]);
//            }
//        }) == 1 ? true : false;
//    }

    /**
     * 查询指定用户
     *
     * @param admin_id
     * @param passwd
     * @return
     */
    public List<Admin> queryWithAdminId(String admin_id, String passwd) {
        String sql = "select * from " + TABLE_NAME + " where admin_id = '" + admin_id + "' and admin_password = '" + passwd + "'";
        System.out.println(sql);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class));
    }
}
