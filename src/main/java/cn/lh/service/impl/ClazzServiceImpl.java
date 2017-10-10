package cn.lh.service.impl;

import cn.lh.mapper.ClazzMapper;
import cn.lh.pojo.Clazz;
import cn.lh.pojo.ClazzExample;
import cn.lh.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/9
 * Time: 19:56
 * To change this template use File | Settings | File Templates.
 */
@Service("clazzService")
 public class ClazzServiceImpl implements ClazzService {
    @Autowired
    ClazzMapper clazzMapper;

    @Override
    public String getClazz(int id) {
//        两个方法 selectByExample 和 selectbyPrimaryKey 用第二个
        String clazz = clazzMapper.selectByPrimaryKey(id).getName();
        return clazz;
    }

    @Override
    public List<Clazz> getList() {
        ClazzExample clazzExample = new ClazzExample();
        return clazzMapper.selectByExample(clazzExample);
    }
}
