package edu.sdust.iot.controller;

import edu.sdust.iot.model.Admin;
import edu.sdust.iot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 管理员登录后台登录管理
 * Created by WSL on 2017/07/15.
 */

@Controller
public class AdminLoginController {

    @Autowired
    private AdminService admminService;

    /**
     * 登录主页控制器
     */
    @RequestMapping(value = "/back/checkadminlogin")
    public void adminLogin(@RequestParam("uid") String uid, @RequestParam("passwd") String passwd, HttpSession session, HttpServletResponse response) {
        try {
            Admin admin = admminService.checkLogin(uid, passwd);
            if (null != admin) {
                session.setAttribute("admin", admin);
                response.getWriter().print("true");
            } else {
                response.getWriter().print("false");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 注销，返回登录界面
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout()
            throws Exception {
        return "redirect:/signin";
    }

    /**
     * 返回登录界面
     *
     * @return
     */
    @RequestMapping("/signin")
    public String signIn() {
        return "view/sign-in";
    }

    /**
     * 返回注册界面
     *
     * @return
     */
    @RequestMapping("/signup")
    public String signUp() {
        return "view/sign-up";
    }

    /**
     * 返回登录界面
     *
     * @return
     */
    @RequestMapping("/")
    public String loginConsole() {
        return "view/sign-in";
    }
}
