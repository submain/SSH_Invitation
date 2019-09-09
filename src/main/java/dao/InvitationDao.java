package dao;

import model.Invitation;

import java.util.List;

public interface InvitationDao {
    //默认按创建时间降序查询所有的帖子列表
    List<Invitation> queryAllOrderByTime(int page, int pageSize) throws Exception;
    //模糊查询，帖子标题
    List<Invitation> queryBytitleKry(String key, int page, int pageSize)throws Exception;
    //删除帖子
    Integer deleteInvitation(int id)throws Exception;
    //查询所有
    List<Invitation> queryAllOrderByTimeNum()throws Exception;
}
