package edu.sdust.iot.service;

import edu.sdust.iot.dao.AdminDAO;
import edu.sdust.iot.model.Admin;
import edu.sdust.iot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员service
 * Created by WSL on 2017/07/15.
 */
@Service
public class AdminService {

    @Autowired
    private AdminDAO adminDao;

    /**
     * 验证登录信息
     *
     * @param admin_id
     * @param passwd
     * @return
     */
    public Admin checkLogin(String admin_id, String passwd) {
        List<Admin> list = adminDao.queryWithAdminId(admin_id, passwd);
        if (list.isEmpty() || null == list)
            return null;
        else
            return list.get(0);
    }

    /**
     * 获得所有的用户
     *
     * @return
     */
    public List<User> getAllUser() {
        return adminDao.queryAll();
    }

//    /**
//     * 删除用户
//     *
//     * @param uid
//     * @return
//     */
//    public boolean deleteUser(int uid) {
//        return userDao.deleteUser(uid);
//    }

//    /**
//     * 用户注册
//     *
//     * @param req
//     * @return
//     */
//    public String saveUserInfo(HttpServletRequest req) {
//        if (!checkUidAvailable(req.getParameter("uid")))
//            return "用户名已存在";
//        else {
//            if (userDao.insert(
//                    req.getParameter("uid"),
//                    req.getParameter("uemail"),
//                    req.getParameter("passwd"),
//                    req.getParameter("uname"),
//                    req.getParameter("uclass"),
//                    req.getParameter("uphone")))
//                return "注册成功";
//            else
//                return "SaveUserInfo Error";
//        }
//    }

//    /**
//     * 检查uid是否可用
//     *
//     * @param uid
//     * @return
//     */
//    public boolean checkUidAvailable(String uid) {
//        String sql = "select uid from t_user where uid = \"" + uid + "\"";
//        return userDao.queryAllWithOption(sql).isEmpty();
//    }

}
