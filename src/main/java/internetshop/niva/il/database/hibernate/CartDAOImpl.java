package internetshop.niva.il.database.hibernate;

import internetshop.niva.il.database.CartDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.jdbc.DAOImplement;
import internetshop.niva.il.domain.Cart;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Cart> gateAll() throws DBException {
        List<Cart> cart = new ArrayList<Cart>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cart.class);
        criteria.add(Restrictions.eq("productbrand", "Cart"));
        return cart = (List<Cart>) criteria.list();
    }
}
