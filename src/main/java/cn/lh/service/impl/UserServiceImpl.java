package cn.lh.service.impl;

import cn.lh.mapper.UserMapper;
import cn.lh.pojo.User;
import cn.lh.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LENOVO on 2017/9/20.
 */
@Service("userService")
public class UserServiceImpl implements UserInfoService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserByNumber(String userNumber) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andNumberEqualTo(userNumber);

        List<User> userList = userMapper.selectByExample(userExample);
        if(userList!=null && userList.size()>0){
            return userList.get(0);
        }else{
            return null;
        }

    }
}
