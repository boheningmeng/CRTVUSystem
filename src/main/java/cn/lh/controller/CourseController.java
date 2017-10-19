package cn.lh.controller;

import cn.lh.mapper.CourseMapper;
import cn.lh.service.CourseService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/18
 * Time: 19:58
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/course",produces = {"application/json;charset=UTF-8"})
public class CourseController {
    @Autowired
    CourseService courseService;

    @RequestMapping("/list/{name}")
    @ResponseBody
    public String getNameList(@PathVariable String  name){
        return JSON.toJSONString(courseService.getNameList());
    }
}
