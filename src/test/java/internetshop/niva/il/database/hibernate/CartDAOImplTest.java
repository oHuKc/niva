package internetshop.niva.il.database.hibernate;

import internetshop.niva.il.database.CartDAO;
import internetshop.niva.il.database.jdbc.*;
import internetshop.niva.il.domain.Cart;
import internetshop.niva.il.servlet.spring.SpringConfig;
import org.hibernate.annotations.NaturalId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ilugovecs on 2015.12.01..
 */

public class CartDAOImplTest {

   /* @Autowired
    private DbCleaner databaseCleaner;

    @Autowired @Qualifier("CartDAOImpl_Hibernate")
    private CartDAOImpl cartDAOImpl;
    */
    private DbCleaner databaseCleaner = new DbCleaner();
    private CartDAOImpl cartDAOImpl = new CartDAOImpl();

    @Before
    public void setUp() throws Exception {
       databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws Exception {
        Cart cart1 = createCart(1L, "Cart test 1", "Test Hibernate", "TEST Nr1", "AVAILABLE TEST", "$1000.01");
        Cart cart2 = createCart(2L, "Cart test 2", "Test Hibernate ORM", "TEST Nr2", "AVAILABLE TEST", "$2000.01");

        cartDAOImpl.create(cart1);
        cartDAOImpl.create(cart2);

        List<Cart> cart = cartDAOImpl.gateAll();
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