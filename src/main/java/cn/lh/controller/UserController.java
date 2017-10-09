package cn.lh.controller;

import cn.lh.pojo.User;
import cn.lh.service.UserInfoService;
import cn.lh.util.ContantKey;
import cn.lh.vo.Vouser;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value="/user"/*,produces = {"application/json;charset=UTF-8"}*/ )
public class UserController {

    @Autowired
    UserInfoService userService;


    @RequestMapping("/login")
   /* @ResponseBody*/
    public String login(User user, HttpSession session){
        System.out.println("user:\t" + user);
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
            return "/index";
        }catch (UnknownAccountException uae){
            System.out.println("用户名错误");
        }
        return "/login";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public void logout(){
        System.out.println("logout started");
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return ;
    }

}
