package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.domain.Cart;
import internetshop.niva.il.domain.ProductVAT;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
        ProductVAT productvat = new ProductVAT();
        String id1 = productvat.getProductid();

        Cart cart1 = createCart(1, "Cart test 1", "Test JDBC API", "TEST Nr1", "AVAILABLE TEST", "10.01");
        Cart cart2 = createCart(2, "Cart test 2", "Test JDBC API", "TEST Nr2", "AVAILABLE TEST", "200.01");
        Cart cart3 = createCart(3, "Cart test 3", "Test JDBC API", "TEST Nr3", "AVAILABLE TEST", "20.01");

        cartDAOImpl.create(cart1);
        cartDAOImpl.create(cart2);
        cartDAOImpl.create(cart3);

        List<Cart> cart = cartDAOImpl.getAll();
        assertEquals(3, cart.size());

    }
    @Test
    public void testGetById() throws Exception {
        Cart cart = createCart(4L, "Cart test 4", "Test JDBC API", "TEST Nr4", "AVAILABLE TEST", "40.01");
        ProductVAT productvat = new ProductVAT();
        cartDAOImpl.create(cart);
        assertNotNull(cartDAOImpl.getById(Long.valueOf(productvat.getProductid())));
    }



    @Test
    public void testDelete() throws Exception {
        ProductVAT productvat = new ProductVAT();
        productvat.getProductid();

        Cart cart1 = createCart(Long.parseLong(productvat.getProductid()), "Cart test 5", "Test JDBC API", "TEST Nr5", "AVAILABLE TEST", "500.01");
        Cart cart2 = createCart(Long.parseLong(productvat.getProductid()), "Cart test 7", "Test JDBC API", "TEST Nr7", "AVAILABLE TEST", "700.01");

        cartDAOImpl.create(cart1);
        cartDAOImpl.create(cart2);

        Long cartiddelete = Long.parseLong(productvat.getProductid());
        cartDAOImpl.delete(cartiddelete);
        Long cartidsave =  Long.parseLong(productvat.getProductid());

        assertNull(cartDAOImpl.getById(cartiddelete));
        assertNotNull(cartDAOImpl.getById(cartidsave));
    }




    private Cart createCart( long productid, String productname, String productbrand,
                             String productdescription, String status, String price ) {
        Cart cart= new Cart();
        ProductVAT productvat = new ProductVAT();

       // cart.setProductid(productid);
        productvat.setProductid(String.valueOf(productid));
        cart.setProductname(productname);
        cart.setProductbrand(productbrand);
        cart.setProductdescription(productdescription);
        cart.setProductstatus(status);
        cart.setProductprice(price);
        return cart;

    }
}