package cn.lh.controller;

import cn.lh.mapper.NoticeMapper;
import cn.lh.pojo.Notice;
import cn.lh.pojo.Page;
import cn.lh.service.NoticeService;
import cn.lh.util.PageUtil;
import cn.lh.vo.VoNotice;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping(value = "/addition",method= RequestMethod.POST)
    @ResponseBody
    public String addition(VoNotice notice, @RequestParam("file")CommonsMultipartFile file, HttpServletRequest request)throws Exception{
        notice.setAnnex(PageUtil.uploadAnnex(request,file,"notice",notice.getTitle()));
        try{
            noticeService.add(notice);
            return JSON.toJSONString("操作成功");
        }catch (Exception e){
            return JSON.toJSONString("操作失败");
        }
    }

   @RequestMapping(value = "/download/{uuid}")
   @ResponseBody
    public void download(@PathVariable String uuid, HttpServletResponse response)throws Exception{
    PageUtil.downloadFile(noticeService.getAnnex(uuid),response);
    return ;
   }

   @RequestMapping(value = "/updates/{uuid}")
    @ResponseBody
    public String update(@PathVariable String uuid, @RequestParam("file")CommonsMultipartFile file, Notice notice,HttpServletRequest request)throws Exception{
        notice.setUuid(uuid);
//        加一个判断
       if(!file.isEmpty()) {
           notice.setAnnex(PageUtil.uploadAnnex(request, file, "notice", notice.getTitle()));
       }
        try{
            noticeService.update(notice);
            return JSON.toJSONString("操作成功");
        }catch (Exception e){
            return JSON.toJSONString("操作失败");
        }
   }

//   删除通知
    @RequestMapping(value = "/deletion/{uuid}")
    @ResponseBody
    public String deletion(@PathVariable String uuid){
        try{
            noticeService.delete(uuid);
            return JSON.toJSONString("操作成功");
        }catch (Exception e){
            return JSON.toJSONString("操作失败");
        }
    }


}
