package cn.lh.service;

import cn.lh.pojo.Page;
import cn.lh.vo.VoScore;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 刘莉慧
 * Date: 2017/10/18
 * Time: 21:10
 * To change this template use File | Settings | File Templates.
 */
public interface ScoreService {

    public long getTotal();
    public List<VoScore> getList(Page page);
}
