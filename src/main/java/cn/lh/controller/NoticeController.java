package cn.lh.controller;

import cn.lh.mapper.NoticeMapper;
import cn.lh.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
