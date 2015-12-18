package internetshop.niva.il.database;

import internetshop.niva.il.domain.Cart;
import org.hibernate.HibernateException;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ilugovecs on 2015.11.17..
 */
public interface CartDAO {

    void create(Cart cart) throws DBException, SQLException;

    Cart getById(Long id) throws DBException, SQLException;

    void delete(String id) throws  DBException;

    List<Cart> getAll() throws  DBException;

    List<Cart> CartSelectHQL() throws HibernateException;
}
