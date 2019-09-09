package dao.impl;


import dao.ReplayDAO;
import model.Invitation;
import model.Replay_detail;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

@Repository("replayDAOImpl")
public class ReplayDAOImpl implements ReplayDAO {
    @Autowired
   private  HibernateTemplate hibernateTemplate;
    @Override
    public List<Replay_detail> queryReplayByTitleId(int id)throws Exception {
        List<Replay_detail> replay_detailList =hibernateTemplate.execute(new HibernateCallback<List<Replay_detail>>() {
            @Override
            public List<Replay_detail> doInHibernate(Session session) throws HibernateException {
                String sql = "from Replay_detail where invid=:iid";
                Query<Replay_detail> replay_detailQuery =session.createQuery(sql,Replay_detail.class);
                replay_detailQuery.setParameter("iid",id);
                return replay_detailQuery.list();
            }
        });
        return replay_detailList;


    }

    @Override
    public Integer addReplay(String content, String author, Date createdate,int invid)throws Exception {
        Replay_detail replay_detail = new Replay_detail();
        Invitation invitation = new Invitation();
        invitation.setId(invid);
        replay_detail.setInvitation(invitation);
//        replay_detail.setInvid(invid);
        replay_detail.setContent(content);
        replay_detail.setAuthor(author);
        replay_detail.setCreatedate(createdate);

        Integer result =(Integer) hibernateTemplate.save(replay_detail);
        return result;
    }
    @Override
    public Integer delete(int invid)throws Exception {
        Integer result = hibernateTemplate.execute(new HibernateCallback<Integer>() {
            @Override
            public Integer doInHibernate(Session session) throws HibernateException {
                String hql = " DELETE from Replay_detail where invid =:iid";
               return session.createQuery(hql).setParameter("iid", invid).executeUpdate();
            }
        });
       return result;

    }




}
