package dao.impl;

import dao.InvitationDao;
import model.Invitation;
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

import java.util.List;

@Repository("dao")
public class InvitationDaoImpl implements InvitationDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Override
    public List<Invitation> queryAllOrderByTime(int page, int pageSize) throws Exception {
        int firstResult = (page-1)*pageSize;
        int maxResult = pageSize;
        List<Invitation> invitationList = hibernateTemplate.execute(new HibernateCallback<List<Invitation>>() {
            @Override
            public List<Invitation> doInHibernate(Session session) throws HibernateException {
                String sql = "from Invitation ORDER BY createdate DESC";
                Query<Invitation> invitationQuery = session.createQuery(sql,Invitation.class);
                invitationQuery.setFirstResult(firstResult);
                invitationQuery.setMaxResults(maxResult);

                return invitationQuery.list();
            }
        });
        return invitationList;
    }

    @Override
    public List<Invitation> queryBytitleKry(String key, int page, int pageSize) throws Exception {
        int firstResult = (page-1)*pageSize;
        int maxResult = pageSize;
        List<Invitation> invitationList = hibernateTemplate.execute(new HibernateCallback<List<Invitation>>() {
            @Override
            public List<Invitation> doInHibernate(Session session) throws HibernateException {
                String keystr = "%"+key+"%";
                String sql = "from Invitation where title LIKE :keys";
                Query<Invitation> invitationQuery = session.createQuery(sql,Invitation.class);
                invitationQuery.setFirstResult(firstResult);
                invitationQuery.setMaxResults(maxResult);
                invitationQuery.setParameter("keys",keystr);
                return invitationQuery.list();
            }
        });

    return invitationList;
    }

    @Override
    public Integer deleteInvitation(int id) throws Exception {
        Invitation invitation = new Invitation();
        invitation.setId(id);

        try {
            hibernateTemplate.delete(invitation);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public List<Invitation> queryAllOrderByTimeNum() throws Exception {
        List<Invitation> invitationList = hibernateTemplate.execute(new HibernateCallback<List<Invitation>>() {
            @Override
            public List<Invitation> doInHibernate(Session session) throws HibernateException {
                String sql = " from Invitation ORDER BY createdate DESC";
                Query<Invitation> invitationQuery = session.createQuery(sql,Invitation.class);
                return invitationQuery.list();
            }
        });

      return invitationList;
    }
}
