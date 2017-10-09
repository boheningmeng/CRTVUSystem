package cn.lh.controller;

import cn.lh.pojo.DataGrid;
import cn.lh.pojo.Page;
import cn.lh.service.StudentService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/9
 * Time: 11:13
 * To change this template use File | Settings | File Templates.
 */
@Controller
//@RequestMapping(value = "/student",produces={"application/json;charset=UTF-8"})
@RequestMapping(value = "/student", produces = {"application/json;charset=UTF-8"})
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public String getList(Page page)throws Exception{

        System.out.println(page);
        DataGrid dateGrid =new DataGrid();

        dateGrid.setRows(studentService.getList(page));
        dateGrid.setTotal(studentService.getTotal());
        return JSON.toJSONString(dateGrid);
    }

}
