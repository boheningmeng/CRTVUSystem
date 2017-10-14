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

    public List<Systemddl> getKeywold();

    public void add(Systemddl systemddl);

    public void updates(Systemddl systemddl);

    public void deletion(String uuid);
}
