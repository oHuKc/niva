package internetshop.niva.il.database.hibernate;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.TVDAO;
import internetshop.niva.il.database.jdbc.DAOImplement;
import internetshop.niva.il.domain.TV;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
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

    }

    public TV getById(Long id) throws DBException {
        return null;
    }

    public void delete(Long id) throws DBException {

    }

    public void update(TV tv) throws DBException {

    }

    public List<TV> getAll() throws DBException {
        return null;
    }

    public int recordscount() throws DBException {
        return 0;
    }

    public List<TV> get4KUHD(int id) throws DBException {
        return null;
    }

    public TV getByScreenSize(String id) throws DBException {
        return null;
    }


    public TV getById(String id) throws DBException {
        TV tv;
        Long  tvid=Long.valueOf(id);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TV.class);
        criteria.add(Restrictions.eq("tvid", tvid));
        return tv = (TV) criteria.uniqueResult();
    }


}
