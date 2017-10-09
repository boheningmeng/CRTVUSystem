package cn.lh.vo;

import cn.lh.pojo.Student;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/9
 * Time: 11:39
 * To change this template use File | Settings | File Templates.
 */
public class VoStudent extends Student {
    private String voGrade;

    private  String voClazz;

    private String voMajor;

    private String voEntime;

    private String voIsChoose;

    public String getVoGrade() {
        return voGrade;
    }

    public void setVoGrade(String voGrade) {
        this.voGrade = voGrade;
    }

    public String getVoClazz() {
        return voClazz;
    }

    public void setVoClazz(String voClazz) {
        this.voClazz = voClazz;
    }

    public String getVoMajor() {
        return voMajor;
    }

    public void setVoMajor(String voMajor) {
        this.voMajor = voMajor;
    }

    public String getVoEntime() {
        return voEntime;
    }

    public void setVoEntime(String voEntime) {
        this.voEntime = voEntime;
    }

    public String getVoIsChoose() {
        return voIsChoose;
    }

    public void setVoIsChoose(String voIsChoose) {
        this.voIsChoose = voIsChoose;
    }
}
