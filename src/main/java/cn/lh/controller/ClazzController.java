package cn.lh.controller;

import cn.lh.pojo.Clazz;
import cn.lh.service.ClazzService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/10
 * Time: 21:26
 * To change this template use File | Settings | File Templates.
 */
@Controller
//@RequestMapping(value = "/clazz",produces = "{application/json,charset=UTF-8}")
@RequestMapping(value = "/clazz",produces = {"application/json;charset=UTF-8"} )
public class ClazzController {
    @Autowired
    ClazzService clazzService;

    @RequestMapping(value = "/getList")
    @ResponseBody
    public String getList(){
        return JSON.toJSONString(clazzService.getList());
    }
}
