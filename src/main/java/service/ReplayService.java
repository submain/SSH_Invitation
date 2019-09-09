package service;


import model.resp.BaseResp;

import java.util.Date;


public interface ReplayService {
    //通过帖子标题ID查找回复
    BaseResp queryReplayByTitleIdResult(int id)throws Exception ;
    //添加回复结果
    BaseResp addReplayResult(String content, String author, Date createdate, int invid)throws Exception ;
}
