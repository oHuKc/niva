package internetshop.niva.il.database.hibernate;
import internetshop.niva.il.database.CustomerDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.jdbc.DAOImplement;
import internetshop.niva.il.domain.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by voyager on 2015.11.27..
 */
@Component("CustomerDAOImpl_Hibernate")
@Transactional
public class CustomerDAOImpl extends DAOImplement implements CustomerDAO {


    @Autowired
    private SessionFactory sessionFactory;



    public void create(Customer user) throws DBException {
        sessionFactory.getCurrentSession().save(user);
    }

    public Customer getById(long id) throws DBException {
        Customer user;
        long userid = id;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("userId", userid));
        return user = (Customer) criteria.uniqueResult();
    }

    public void delete(Long id) throws DBException {
        Customer user;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("userId", id));
        user = (Customer) criteria.uniqueResult();
        sessionFactory.getCurrentSession().delete(user);
    }


    public void update(Customer user) throws DBException {
        //Customer user;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("userId", user));
        user = (Customer) criteria.uniqueResult();
        sessionFactory.getCurrentSession().update(user);
    }


    public List<Customer> getAll() throws DBException {
    List<Customer> user = new ArrayList<Customer>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq("userId", 1L));
        return  user = (List<Customer>) criteria.list();
    }


}
