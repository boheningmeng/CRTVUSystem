package cn.lh.controller;

import cn.lh.service.SystemDDLService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/10
 * Time: 20:
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/systemddl",produces = {"application/json;charset=UTF-8"})
public class SystemDDLController {

    @Autowired
    SystemDDLService systemDDLService;

    @RequestMapping("/list/{keyword}")
    @ResponseBody
//    spring mvc中的@PathVariable是用来获得请求url中的动态参数的
    public String getList(@PathVariable String keyword){
        return JSON.toJSONString(systemDDLService.getListByKeyWorld(keyword));
    }

    @RequestMapping("/keyword")
    @ResponseBody
    public String getKeyWorld(){
        return JSON.toJSONString(systemDDLService.getKeywold());
    }
}
