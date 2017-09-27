package cn.lh.mapper;

import cn.lh.pojo.Notice;
import cn.lh.pojo.NoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {
    long countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExample(NoticeExample example);

    Notice selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}