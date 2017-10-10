package cn.lh.controller;

import cn.lh.mapper.NoticeMapper;
import cn.lh.pojo.Page;
import cn.lh.service.NoticeService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LENOVO on 2017/9/27.
 */
@Controller
@RequestMapping(value = "/notice",produces = {"application/json;charset=UTF-8"} )
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @Autowired
    NoticeMapper noticeMapper;

    @RequestMapping(value = "/list")
    @ResponseBody
    public String getlist(Page page){
        return JSON.toJSONString(noticeService.list(page));

    }


}
