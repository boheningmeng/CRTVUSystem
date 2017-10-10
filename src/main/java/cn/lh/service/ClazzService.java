package cn.lh.service;

import cn.lh.pojo.Clazz;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/9
 * Time: 19:55
 * To change this template use File | Settings | File Templates.
 */
public interface ClazzService {

    public String getClazz(int id);

    public List<Clazz> getList();
}
