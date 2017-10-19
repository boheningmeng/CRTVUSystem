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
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.io.InputStream;
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

    @Override
    public int getId(String number) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andNumberEqualTo(number);
        List<Student> studentList = studentMapper.selectByExample(studentExample);
        if(studentList.size()!= 0 ){
            return studentList.get(0).getId();
        }else{
            return 0;
        }
    }
    @Override
    public void importToMysql(CommonsMultipartFile file) throws IOException {

        List<Student> list = readXls(file.getInputStream());
        for(int i=0;i< list.size();i++){
            Student student = list.get(i);
            studentMapper.insertSelective(student);
        }
    }

    public List<Student> readXls(InputStream inputStream) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
       Student student;
        List<Student> list = new ArrayList<>();

        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    student = new Student();
//  学号 姓名 性别 年级 班级  专业 入学时间 邮件 手机号
                    HSSFCell number = hssfRow.getCell(0);
                    HSSFCell name = hssfRow.getCell(1);
                    HSSFCell sex = hssfRow.getCell(2);
                    HSSFCell grade = hssfRow.getCell(3);
                    HSSFCell clazzid = hssfRow.getCell(4);
                    HSSFCell major= hssfRow.getCell(5);
                    HSSFCell Entime = hssfRow.getCell(6);
                    HSSFCell email = hssfRow.getCell(7);
                    HSSFCell phone = hssfRow.getCell(8);

                    student.setNumber(getValue(number));
                    student.setName(getValue(name));
                    student.setSex(getValue(sex));
                    student.setGrade((int)Double.parseDouble(getValue(name)));
                    student.setPassword(getValue(number));
                    student.setIschoose(0);
                    student.setClazzid((int)Double.parseDouble(getValue(grade)));
                    student.setMajor((int)Double.parseDouble(getValue(major)));
                    student.setEntime((int)Double.parseDouble(getValue(Entime)));
                    student.setEmail(getValue(email));
                    student.setPhone(getValue(phone));
                    list.add(student);

                }
            }
        }
        return list;
    }

    public String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {

            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {

            return String.valueOf(hssfCell.getNumericCellValue());
        } else {

            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}


