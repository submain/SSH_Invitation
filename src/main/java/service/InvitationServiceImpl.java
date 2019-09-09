package service;

import dao.InvitationDao;
import dao.impl.ReplayDAOImpl;
import model.Invitation;
import model.Replay_detail;
import model.resp.BaseResp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("invitationService")
@Transactional(readOnly = true)
public class InvitationServiceImpl implements InvitationService{

    @Resource(name = "dao")
    private InvitationDao invitationDao;

    @Resource(name = "replayDAOImpl")
    private ReplayDAOImpl replayDAO;



//    public List<Invitation> queryAllOrderByTime() throws Exception{
//        return invitationDao.queryAllOrderByTime(1,2);
//    }
//
//    public List<Invitation> queryBytitleKry() throws Exception{
//        return invitationDao.queryBytitleKry("川",1,3);
//    }
//    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
//    public Integer deleteInvitation() throws Exception{
//        return invitationDao.deleteInvitation(2);
//    }


    @Override
    public BaseResp queryAllOrderByTimeResult(String pageStr, String pageSizeStr) throws Exception {
        BaseResp baseResp = new BaseResp();
        int page =1;
        int pageSize=4;
        try {
            page = Integer.parseInt(pageStr);
            pageSize = Integer.parseInt(pageSizeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Invitation> invitationList = invitationDao.queryAllOrderByTime(page,pageSize);
        List<Invitation> invitationList1 = invitationDao.queryAllOrderByTimeNum();
        int count = invitationList1.size();


        if (invitationList !=null){
            for (Invitation invitation:invitationList){
                int invitationId = invitation.getId();
                List<Replay_detail> replay_detailList = replayDAO.queryReplayByTitleId(invitationId);
                invitation.setReplay_detailList(replay_detailList);
            }
            baseResp.setOk(1);
            baseResp.setData(invitationList);
            baseResp.setCount(count);
        }else {
            baseResp.setOk(0);
            baseResp.setMsg("没有找到帖子");
        }
        return baseResp;
    }

    @Override
    public BaseResp queryBytitleKry(String key, String pageStr, String pageSizeStr) throws Exception {
        BaseResp baseResp = new BaseResp();
        int page =1;
        int pageSize=4;
        try {
            page = Integer.parseInt(pageStr);
            pageSize = Integer.parseInt(pageSizeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Invitation> invitationList = invitationDao.queryBytitleKry(key,page,pageSize);
        int count = invitationList.size();

        if (invitationList !=null){
            for (Invitation invitation:invitationList){
                int invitationId = invitation.getId();
                List<Replay_detail> replay_detailList = replayDAO.queryReplayByTitleId(invitationId);
                invitation.setReplay_detailList(replay_detailList);
            }
            baseResp.setOk(1);
            baseResp.setCount(count);
            baseResp.setData(invitationList);
        }else {
            baseResp.setOk(0);
            baseResp.setMsg("没有找到帖子");
        }
        return baseResp;
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
    @Override
    public BaseResp deleteInvitation(String idStr) throws Exception {
        BaseResp baseResp = new BaseResp();
        int id = Integer.parseInt(idStr);

        int i = invitationDao.deleteInvitation(id);

       int k = replayDAO.delete(id);
        if (id !=0){

                baseResp.setOk(1);



        }else {
            baseResp.setMsg("删除失败");
        }
        return baseResp;
    }
}
