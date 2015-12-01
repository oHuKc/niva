package internetshop.niva.il.database;

import internetshop.niva.il.domain.Cart;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ilugovecs on 2015.11.17..
 */
public interface CartDAO {

    void create(Cart cart) throws DBException, SQLException;

    Cart getById(Long id) throws DBException, SQLException;

    void delete(Long id) throws  DBException;

    List<Cart> gateAll() throws  DBException;
}
