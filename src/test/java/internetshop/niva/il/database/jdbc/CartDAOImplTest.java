package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.domain.Cart;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Igor on 2015.12.01..
 */
@Component
public class CartDAOImplTest {


    private DbCleaner dbCleaner = new DbCleaner();
    private CartDAOImpl cartDAOImpl = new CartDAOImpl();


    @Before
    public void init() throws Exception {
        dbCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws Exception {
        Cart cart1 = createCart(1L, "Cart test 1", "Test JDBC API", "TEST Nr1", "AVAILABLE TEST", "$1000.01");
        Cart cart2 = createCart(2L, "Cart test 2", "Test JDBC API", "TEST Nr2", "AVAILABLE TEST", "$2000.01");

        cartDAOImpl.create(cart1);
        cartDAOImpl.create(cart2);

        List<Cart> cart = cartDAOImpl.getAll();
        assertEquals(2, cart.size());

    }


    /*

    @Test
    public void testGetById() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
*/


    private Cart createCart( long productid, String productname, String productbrand,
                             String productdescription, String status, String price ) {
        Cart cart= new Cart();
        cart.setProductid(productid);
        cart.setProductname(productname);
        cart.setProductbrand(productbrand);
        cart.setProductdescription(productdescription);
        cart.setProductstatus(status);
        cart.setProductprice(price);
        return cart;

    }
}