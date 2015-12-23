package internetshop.niva.il.database.hibernate;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.ProductVATDAO;
import internetshop.niva.il.database.jdbc.DAOImplement;
import internetshop.niva.il.domain.Cart;
import internetshop.niva.il.domain.ProductVAT;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Igor on 2015.12.21..
 */
@Component(value="ProductVatDAOImpl_Hibernate")
@Transactional
public class ProductVatDAOImpl extends DAOImplement implements ProductVATDAO {

    @Autowired
    private SessionFactory sessionFactory;


    public void create(ProductVAT productVAT) throws DBException {
        sessionFactory.getCurrentSession().save(productVAT);
    }


    public ProductVAT getById(String productid) throws DBException {
        ProductVAT productVAT;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ProductVAT.class);
        criteria.add(Restrictions.eq("productid", productid));
        return productVAT = (ProductVAT) criteria.uniqueResult();
    }


    public void delete(String id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        ProductVAT productvat = (ProductVAT) session.get(ProductVAT.class, id);
        if (productvat != null) {
            session.delete(productvat);
        }
        session.flush();
    }

}


