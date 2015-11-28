package internetshop.niva.il.database.hibernate;

import internetshop.niva.il.database.CustomerDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.jdbc.DAOImplement;
import internetshop.niva.il.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    public Customer getById(Long id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.createCriteria(Customer.class).list();
    }

    public void delete(Long id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        Customer user = (Customer) session.get(Customer.class, id);
        session.delete(user);
    }

    public void update(Customer user) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public List<Customer> getAll() throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Customer.class).list();
    }

    public int recordscount() throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Customer.class).hashCode();
    }
}
