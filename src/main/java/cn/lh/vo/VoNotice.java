package cn.lh.vo;

import cn.lh.pojo.Notice;

/**
 * Created by LENOVO on 2017/9/28.
 */
public class VoNotice extends Notice{
    private String voNoticeType ;

    public String getVoNoticeType() {
        return voNoticeType;
    }

    public void setVoNoticeType(String voNoticeType) {
        this.voNoticeType = voNoticeType;
    }

    @Override
    public String toString() {
        return "VoNotice{" +
                "voNoticeType='" + voNoticeType + '\'' +
                '}';
    }
}
