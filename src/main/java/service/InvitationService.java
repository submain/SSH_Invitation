package service;

import model.resp.BaseResp;

public interface InvitationService {
    //默认按创建时间降序查询所有的帖子列表
    BaseResp queryAllOrderByTimeResult(String pageStr, String pageSizeStr) throws Exception ;
    //模糊查询，帖子标题
    BaseResp queryBytitleKry(String key, String pageStr, String pageSizeStr) throws Exception ;
    //删除帖子
    BaseResp deleteInvitation(String id) throws Exception ;
}
