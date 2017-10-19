package cn.lh.service.impl;

import cn.lh.mapper.ScoreMapper;
import cn.lh.pojo.Page;
import cn.lh.pojo.Score;
import cn.lh.pojo.ScoreExample;
import cn.lh.pojo.Student;
import cn.lh.service.*;
import cn.lh.vo.VoScore;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/18
 * Time: 20:00
 * To change this template use File | Settings | File Templates.
 */
@Service("scoreService")
 public class ScoreServiceImpl implements ScoreService{

    @Autowired
    ScoreMapper scoreMapper;

    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    @Autowired
    SystemDDLService systemDDLService;

    @Autowired
    ClazzService clazzService;

    public long total;

    public long getTotal() {
        return total;
    }

    //获得学生成绩列表
    @Override
    public List<VoScore> getList(Page page) {
//        获取分页信息
        PageHelper.startPage(page.getPage(),page.getRows());
//        创建查询规则
        ScoreExample scoreExample = new ScoreExample();
        List<Score> scoreList = scoreMapper.selectByExample(scoreExample);
        //        获取查询信息
        PageInfo<Score> pageInfo = new PageInfo<>(scoreList);
        this.total = pageInfo.getTotal();

        List<VoScore> voScoreList = new ArrayList<>();
//        vo 化
        for(Score score:
                scoreList){
            VoScore voScore = new VoScore();
            voScore.setClazz(clazzService.getClazz(studentService.getStudent(score.getSid()).getClazzid()));
            voScore.setName(studentService.getStudent(score.getSid()).getName());
            voScore.setNumber(studentService.getStudent(score.getSid()).getNumber());
            voScore.setScore(score.getScore());
            voScore.setCourseName(courseService.getCourse(score.getCourseid()).getName());
            voScore.setCourseCredit(courseService.getCourse(score.getCourseid()).getCredit());
            voScore.setCourseLearnTime(courseService.getCourse(score.getCourseid()).getLearntime());
            voScoreList.add(voScore);
        }
        return voScoreList;
    }

    @Override
    public void add(VoScore voScore) {
        voScore.setSubmitstatus(1);
        voScore.setSid(studentService.getId(voScore.getNumber()));
//        疑问  为什么 vouser也可以用？

        scoreMapper.insertSelective(voScore);

    }

    @Override
    public void updates(VoScore voScore) {
        voScore.setSid(studentService.getId(voScore.getNumber()));
        ScoreExample scoreExample = new ScoreExample();
        scoreMapper.updateByExampleSelective(voScore,scoreExample);
    }

}
