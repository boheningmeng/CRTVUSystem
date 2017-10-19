package cn.lh.controller;

import cn.lh.pojo.DataGrid;
import cn.lh.pojo.Page;
import cn.lh.service.ScoreService;
import cn.lh.vo.VoScore;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value = "/score", produces = {"application/json;charset=UTF-8"})
public class ScoreController {

  @Autowired
  ScoreService  scoreService ;

  @RequestMapping("/list")
  @ResponseBody
  public String  getList(Page page){
    DataGrid dateGrid = new DataGrid();
    dateGrid.setRows(scoreService.getList(page));
    dateGrid.setTotal(scoreService.getTotal());
    return JSON.toJSONString(dateGrid);
  }

  @RequestMapping("/addition")
  @ResponseBody
  public String add(VoScore voScore){
    try{
       scoreService.add(voScore);
      return JSON.toJSONString("操作成功");
    }catch (Exception e){
      return JSON.toJSONString("操作失败");
    }
  }

  @RequestMapping("/updates")
  @ResponseBody
  public String update(VoScore voScore){
    try{
      scoreService.updates(voScore);
      return  JSON.toJSONString("操作成功");
    }catch (Exception e){
      return JSON.toJSONString("操作失败");
    }
  }



}
