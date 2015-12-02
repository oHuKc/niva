package internetshop.niva.il.database.hibernate;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.TVDAO;
import internetshop.niva.il.database.jdbc.DAOImplement;
import internetshop.niva.il.domain.TV;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilugovecs on 2015.11.05..
 */
@Component("TVDAOImpl_Hibernate")
public class TVDAOImpl extends DAOImplement implements TVDAO {


    @Autowired
    private SessionFactory sessionFactory;

    public void create(TV tv) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(tv);
    }

    public TV getById(Long id) throws DBException {
       Session session = sessionFactory.getCurrentSession();
        return (TV) session.get(TV.class, id);
    }

    public void delete(Long id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        TV tv = (TV) session.get(TV.class, id);
        if(tv != null) {
            session.delete(tv);
        }
    }

    public void update(TV tv) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.update(tv);
    }

    public List<TV> getAll() throws DBException {
        List<TV> tv = new ArrayList<TV>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TV.class);
        return  tv = (List<TV>) criteria.list();

    }

    public List<TV> get4KUHD(int id) throws DBException {
       Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(TV.class).addOrder(Order.desc("id")).list();
    }

    public TV getByScreenSize(String id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return (TV) session.get(TV.class, id);
    }


    public TV getById(String id) throws DBException {
        TV tv;
        Long  tvid=Long.valueOf(id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TV.class);
        criteria.add(Restrictions.eq("tvid", tvid));
        return tv = (TV) criteria.uniqueResult();
    }

    public byte[] getImage(int id) throws DBException {
        TV tv;
        byte[] imgData = new byte[0];
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TV.class);
        criteria.add(Restrictions.eq("IMAGE", id));
        return imgData;
    }

}
