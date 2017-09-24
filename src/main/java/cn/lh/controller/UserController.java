package cn.lh.controller;

import cn.lh.pojo.User;
import cn.lh.service.UserInfoService;
import cn.lh.util.ContantKey;
import cn.lh.vo.Vouser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;

/**
 * Created by LENOVO on 2017/9/20.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    UserInfoService userService;


    @RequestMapping("/login")
   /* @ResponseBody*/
    public String login(User user,HttpSession session){
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(
                user.getNumber(),
                user.getPassword()
        );
        try{
            currentUser.login(token);
            System.out.println("login successful!!");
            User user1 = userService.getUserByNumber(user.getNumber());
            session.setAttribute(ContantKey.GLOBLE_USER_INFO,new Vouser(user1));
            return "/WEB-INF/jsp/index.jsp";
        }catch (UnknownAccountException uae){
            System.out.println("用户名错误");
        }
        return "/login.jsp";
    }

}
