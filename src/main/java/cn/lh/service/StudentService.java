package cn.lh.service;

import cn.lh.pojo.Page;
import cn.lh.pojo.Student;
import cn.lh.pojo.Systemddl;
import cn.lh.vo.VoStudent;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/9
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */
public interface StudentService {
    public long getTotal();

    public List<VoStudent> getList(Page page);

    public void addition(Student student);

    public void update(Student student);

    public void delete(String id);

    public List<VoStudent>  getListByYear(int grade,Page page);

    public Student getStudent(int id);

}
