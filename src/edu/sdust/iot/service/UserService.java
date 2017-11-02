package edu.sdust.iot.service;

import edu.sdust.iot.dao.UserDAO;
import edu.sdust.iot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WSL on 2016/10/23.
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDao;

    /**
     * 验证登录信息
     *
     * @param uid
     * @param passwd
     * @return
     */
    public User checkLogin(int uid, String passwd) {
        String sql = "select * from guest where id = " + uid + " and password = \"" + passwd + "\"";
        List<User> list = userDao.queryAllWithOption(sql);
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
        return userDao.queryAll();
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
