package cn.lh.service.impl;

import cn.lh.mapper.NoticeMapper;
import cn.lh.pojo.Notice;
import cn.lh.pojo.NoticeExample;
import cn.lh.pojo.Page;
import cn.lh.service.NoticeService;
import cn.lh.service.SystemDDLService;
import cn.lh.vo.VoNotice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2017/9/27.
 */
@Service("noticeService")
 public class NoticeServiceImpl implements NoticeService {

    public long total;
    @Autowired
    NoticeMapper noticeMapper;
    @Autowired
    SystemDDLService systemDDLService;

    @Override
    public List<VoNotice> list(Page page) {
     //开始分页
        PageHelper.startPage(page.getPage(),page.getRows());
     //构造查询条件
        NoticeExample noticeExample = new NoticeExample();
        //用到条件的时候才会这样
      //  NoticeExample.Criteria criteria = noticeExample.createCriteria();
        List<Notice> noticeList = noticeMapper.selectByExample(noticeExample);
        //获取分页信息
        PageInfo<Notice> pageInfo = new PageInfo<>(noticeList);
        this.total = pageInfo.getTotal();
        //对数字表示的字段进行可视化处理
        List<VoNotice> voNoticeList = new ArrayList<>();
        for(Notice notice:
                noticeList){
            VoNotice voNotice = new VoNotice();
            voNotice.setVoNoticeType(systemDDLService.getDDLNameByDDLCode("noticetype",notice.getNoticetype()));
            voNotice.setContent(notice.getContent());
            voNotice.setPublisher(notice.getPublisher());
            voNotice.setTime(notice.getTime());
            voNotice.setTitle(notice.getTitle());
            voNotice.setUuid(notice.getUuid());
            voNoticeList.add(voNotice);
        }
        return voNoticeList;

    }
}
