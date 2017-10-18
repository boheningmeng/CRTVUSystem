package cn.lh.service.impl;

import cn.lh.mapper.CourseMapper;
import cn.lh.pojo.Course;
import cn.lh.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/18
 * Time: 20:00
 * To change this template use File | Settings | File Templates.
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService{

    @Autowired
    CourseMapper courseMapper;

    @Override
    public Course getCourse(int id) {
        return courseMapper.selectByPrimaryKey(id);
    }
}
