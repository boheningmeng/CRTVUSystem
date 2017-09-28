package cn.lh.service.impl;

import cn.lh.mapper.SystemddlMapper;
import cn.lh.pojo.Systemddl;
import cn.lh.pojo.SystemddlExample;
import cn.lh.service.SystemDDLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
