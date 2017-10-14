package cn.lh.service.impl;

import cn.lh.mapper.SystemddlMapper;
import cn.lh.pojo.Systemddl;
import cn.lh.pojo.SystemddlExample;
import cn.lh.service.SystemDDLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by LENOVO on 2017/9/28.
 */
 @Service("systemddlService")
  public class SystemDDLServiceImpl implements SystemDDLService {
    @Autowired
    SystemddlMapper systemddlMapper;


    @Override
    public String getDDLNameByDDLCode(String keyword, int ddlcode) {
        SystemddlExample systemddlExample = new SystemddlExample();
        SystemddlExample.Criteria criteria = systemddlExample.createCriteria();
        criteria.andDdlcodeEqualTo(ddlcode);
        criteria.andKeywordEqualTo(keyword);
        List<Systemddl> systemddlList = systemddlMapper.selectByExample(systemddlExample);
        if(systemddlList!=null &&systemddlList.size()>0){
            return systemddlList.get(0).getDdlname();
        }else{
            return null;
        }

    }

    @Override
    public String getIsChoose(int number) {
        if(number == 1){
            return "是";
        }else{
            return "否";
        }

    }

    @Override
    public List<Systemddl> getListByKeyWorld(String keyWord) {

       SystemddlExample systemddlExample = new SystemddlExample();
       SystemddlExample.Criteria criteria = systemddlExample.createCriteria();
       criteria.andKeywordEqualTo(keyWord);
       List<Systemddl> systemddlList = systemddlMapper.selectByExample(systemddlExample);

      return systemddlList;
    }

    @Override
    public List<Systemddl> getKeywold() {
      /*  SystemddlExample systemddlExample = new SystemddlExample();
        return systemddlMapper.selectByExample();*/
//      错了
        return systemddlMapper.getKeyword();

    }

    @Override
    public void add(Systemddl systemddl) {
        List<Systemddl> systemddlList = getListByKeyWorld(systemddl.getKeyword());
        systemddl.setDdlcode(systemddlList.size()+1);
        systemddlMapper.insertSelective(systemddl);
    }

    @Override
    public void updates(Systemddl systemddl) {
        systemddlMapper.updateByPrimaryKeySelective(systemddl);
    }

    @Override
    public void deletion(String uuid) {
//        有主键的时候这样写，没主键的时候创造条件
        systemddlMapper.deleteByPrimaryKey(uuid);
    }


}
