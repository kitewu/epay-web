package edu.sdust.iot.controller;

import edu.sdust.iot.model.User;
import edu.sdust.iot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户
 * Created by WSL on 2017/05/23.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录控制器
     *
     * @param uid
     * @param passwd
     * @param session
     * @param response
     */
    @RequestMapping(value = "/loginUser")
    public void loginUser(@RequestParam("uid") String uid, @RequestParam("passwd") String passwd, HttpSession session, HttpServletResponse response) {
        try {
            User user = userService.checkLogin(Integer.valueOf(uid), passwd);
            if (null != user) {
                session.setAttribute("user", user);
                response.getWriter().print("true");
            } else {
                response.getWriter().print("false");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
