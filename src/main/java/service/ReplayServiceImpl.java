package service;


import dao.ReplayDAO;
import model.Replay_detail;
import model.resp.BaseResp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("replayServiceImpl")
@Transactional(readOnly = true)
public class ReplayServiceImpl implements ReplayService {
    @Resource(name = "replayDAOImpl")
    ReplayDAO replayDAO;

    @Override
    public BaseResp queryReplayByTitleIdResult(int id) throws Exception {
        BaseResp baseResp = new BaseResp();
        List<Replay_detail> replay_detailList = replayDAO.queryReplayByTitleId(id);
        if (replay_detailList != null){
            baseResp.setOk(1);
            baseResp.setData(replay_detailList);
        }else {
            baseResp.setOk(0);
            baseResp.setMsg("该帖子没有回复");
        }
        return baseResp;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public BaseResp addReplayResult(String content, String author, Date createdate, int invid)throws Exception  {
        BaseResp baseResp = new BaseResp();
        int i = replayDAO.addReplay(content,author,createdate,invid);

        if (i !=0){
            baseResp.setOk(1);
            baseResp.setKeynum(i);
        }else {
            baseResp.setOk(0);
            baseResp.setMsg("添加失败");
        }
        return baseResp;
    }
}
