package dao;

import model.Replay_detail;

import java.util.Date;
import java.util.List;

public interface ReplayDAO {
    //通过帖子标题ID查找回复
    List<Replay_detail> queryReplayByTitleId(int id)throws Exception;
    //添加回复
    Integer addReplay(String content, String author, Date createdate, int invid)throws Exception;
    //通过帖子标题ID删除回复
    Integer delete(int id)throws Exception;

}
