package internetshop.niva.il.database.hibernate;

import internetshop.niva.il.database.CartDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.jdbc.DAOImplement;
import internetshop.niva.il.domain.Cart;
import internetshop.niva.il.domain.TV;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hsqldb.QuerySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.hsqldb.util.*;
import org.hibernate.internal.QueryImpl;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilugovecs on 2015.12.01..
 */
@Component(value="CartDAOImpl_Hibernate")
@Transactional
public class CartDAOImpl extends DAOImplement implements CartDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void create(Cart cart) throws DBException {
        sessionFactory.getCurrentSession().persist(cart);
    }

    public Cart getById(Long id) throws DBException {
        Cart cart;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cart.class);
        criteria.add(Restrictions.eq("productid", id));
        return cart = (Cart) criteria.uniqueResult();
    }

    public void delete(Long id) throws DBException {
        Cart cart = null;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cart.class);
        criteria.add(Restrictions.eq("productid", id));
        sessionFactory.getCurrentSession().delete(cart);
    }

    public List<Cart> getAll() throws DBException {
        List<Cart> cart = new ArrayList<Cart>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cart.class);
        return  cart = (List<Cart>) criteria.list();
    }

    public List<Cart> CartSelectHQL() {
        Session session = sessionFactory.openSession();

        List<Cart> cart   = new ArrayList<Cart>();

        String hql = "FROM internetshop.niva.il.domain.Cart";
        Query query = (Query) session.createQuery(hql);
        List results = query.list();

        return cart = (List<Cart>) query.list();
    }


}
