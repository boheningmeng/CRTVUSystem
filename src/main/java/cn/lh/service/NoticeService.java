package cn.lh.service;

import cn.lh.pojo.Notice;
import cn.lh.pojo.Page;
import cn.lh.vo.VoNotice;

import java.util.List;

/**
 * Created by LENOVO on 2017/9/27.
 */
public interface NoticeService {
    public List<VoNotice> list(Page page);
}
