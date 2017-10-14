package cn.lh.vo;

import cn.lh.pojo.Notice;

/**
 * Created by LENOVO on 2017/9/28.
 */
// 接口与文件上传和下载有关
public class VoNotice extends Notice implements Comparable<VoNotice> {
    private String voNoticeType ;

    private String voFile;

    public String getVoFile() {
        return voFile;
    }

    public void setVoFile(String voFile) {
        this.voFile = voFile;
    }

    public String getVoNoticeType() {
        return voNoticeType;
    }

    public void setVoNoticeType(String voNoticeType) {
        this.voNoticeType = voNoticeType;
    }



    @Override
    public int compareTo(VoNotice o) {
        return 0;
    }
}
