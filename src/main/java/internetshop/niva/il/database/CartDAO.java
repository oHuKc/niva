package internetshop.niva.il.database;

import internetshop.niva.il.domain.Cart;

/**
 * Created by ilugovecs on 2015.11.17..
 */
public interface CartDAO {

    void create(Cart cart) throws DBException;
}
