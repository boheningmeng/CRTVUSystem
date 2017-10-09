package cn.lh.service;

/**
 * Created by LENOVO on 2017/9/28.
 */
public interface SystemDDLService {

    public String getDDLNameByDDLCode(String keyword,int ddlcode);

    public String getIsChoose(int number);
}
