package cn.lh.service;

import cn.lh.pojo.Systemddl;

import java.util.List;

/**
 * Created by LENOVO on 2017/9/28.
 */
public interface SystemDDLService {

    public String getDDLNameByDDLCode(String keyword,int ddlcode);

    public String getIsChoose(int number);

    public List<Systemddl> getListByKeyWorld(String keyWord);
}
