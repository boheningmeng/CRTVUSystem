package cn.lh.service.impl;

import cn.lh.mapper.StudentMapper;
import cn.lh.pojo.Page;
import cn.lh.pojo.Student;
import cn.lh.pojo.StudentExample;
import cn.lh.pojo.Systemddl;
import cn.lh.service.ClazzService;
import cn.lh.service.StudentService;
import cn.lh.service.SystemDDLService;
import cn.lh.vo.VoStudent;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/9
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
@Service("studentServcie")
public class StudentServiceImpl implements StudentService {
    public long total;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    SystemDDLService systemDDLService;

    @Autowired
    ClazzService clazzService;

//    public void setTotal(long total) {
//        this.total = total;
//    }

    @Override
    public long getTotal() {
        return total;
    }
/*1、一次性添加多行注释的快捷键
首先选中要注释区域，然后
ctrl+/        这个是多行代码分行注释，每行一个注释符号
ctrl+shift+/    这个是多行代码注释在一个块里，只在开头和结尾有注释符号

2、取消多行注释快捷键
怎样添加快捷键的，用相同方法取消，
如 ctrl+/  添加注释，则ctrl+/取消注释
ctrl+shift+/添加注释，则ctrl+shift+/取消注释*/
    @Override
    public List<VoStudent> getList(Page page) {
//      设置分页
        PageHelper.startPage(page.getPage(),page.getRows());
//        创建查询规则
        StudentExample studentExample = new StudentExample();
//        查询
        List<Student> studentList = studentMapper.selectByExample(studentExample);
//        获取查询信息
        PageInfo<Student> pageInfo = new PageInfo<>(studentList);
        this.total = pageInfo.getTotal();
//        vo化
        List<VoStudent> voStudentList = new ArrayList<>();

//        System.out.println(studentList);
        for(Student student:
                studentList){
            VoStudent voStudent = new VoStudent();
            voStudent.setSex(student.getSex());
            voStudent.setName(student.getName());
            voStudent.setNumber(student.getNumber());
            voStudent.setEmail(student.getEmail());
            voStudent.setVoGrade(systemDDLService.getDDLNameByDDLCode("grade",student.getGrade()));
            voStudent.setVoClazz(clazzService.getClazz(student.getClazzid()));
            voStudent.setVoMajor(systemDDLService.getDDLNameByDDLCode("major",student.getMajor()));
            voStudent.setVoIsChoose(systemDDLService.getIsChoose(student.getIschoose()));
//           把voStudent加入到list中
            voStudentList.add(voStudent);
        }

        return voStudentList;

    }

    @Override
    public void addition(Student student) {
        studentMapper.insertSelective(student);
    }

    @Override
    public void update(Student student) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andNumberEqualTo(student.getNumber());

        System.out.println(student);
        studentMapper.updateByExampleSelective(student,studentExample);
    }

    @Override
    public void delete(String id) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andNumberEqualTo(id);
        studentMapper.deleteByExample(studentExample);
    }

    @Override
    public List<VoStudent> getListByYear(int grade, Page page) {
        //      设置分页
        PageHelper.startPage(page.getPage(),page.getRows());
//        创建查询规则
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andGradeEqualTo(grade);
//        查询
        List<Student> studentList = studentMapper.selectByExample(studentExample);
//        获取查询信息
        PageInfo<Student> pageInfo = new PageInfo<>(studentList);
        this.total = pageInfo.getTotal();
//        vo化
        List<VoStudent> voStudentList = new ArrayList<>();


        for(Student student:
                studentList){

            VoStudent voStudent = new VoStudent();
            voStudent.setName(student.getName());
            voStudent.setSex(student.getSex());
            voStudent.setNumber(student.getNumber());
            voStudent.setEmail(student.getEmail());
            voStudent.setVoGrade(systemDDLService.getDDLNameByDDLCode("grade",student.getGrade()));
            voStudent.setVoClazz(clazzService.getClazz(student.getClazzid()));
            voStudent.setVoMajor(systemDDLService.getDDLNameByDDLCode("major",student.getMajor()));
            voStudent.setVoIsChoose(systemDDLService.getIsChoose(student.getIschoose()));
//           把voStudent加入到list中
            voStudentList.add(voStudent);
        }

        return voStudentList;

    }

    @Override
    public Student getStudent(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }


}
