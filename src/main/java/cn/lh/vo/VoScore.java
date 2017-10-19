package cn.lh.vo;

import cn.lh.pojo.Score;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/18
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
public class VoScore  extends Score {

    public String clazz;
    public String name;
    public String number;
    public String courseName;
    public int courseCredit;
    public int courseLearnTime;

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public int getCourseLearnTime() {
        return courseLearnTime;
    }

    public void setCourseLearnTime(int courseLearnTime) {
        this.courseLearnTime = courseLearnTime;
    }

    @Override
    public String toString() {
        return "VoScore{" +
                "clazz='" + clazz + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseCredit=" + courseCredit +
                ", courseLearnTime=" + courseLearnTime +
                '}';
    }
}
