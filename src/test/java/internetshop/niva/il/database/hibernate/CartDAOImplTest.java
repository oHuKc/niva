package internetshop.niva.il.database.hibernate;

import internetshop.niva.il.database.CartDAO;
import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.ProductVATDAO;
import internetshop.niva.il.database.jdbc.DbCleaner;
import internetshop.niva.il.domain.Cart;
import internetshop.niva.il.domain.ProductVAT;
import internetshop.niva.il.servlet.spring.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by ilugovecs on 2015.12.01..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CartDAOImplTest {

    @Autowired
    private DbCleaner databaseCleaner;

    @Autowired
    @Qualifier(value = "CartDAOImpl_Hibernate")
    private CartDAO cartDAO;

    @Autowired
    @Qualifier(value = "ProductVatDAOImpl_Hibernate")
    private ProductVATDAO productVATDAO;


    @Before
    public void setUp() throws Exception {
       databaseCleaner.cleanDatabase();
    }
/*
    @Test
    public void testCreate() throws Exception {

        ProductVAT productvat1 = productVATDAO.getById("1");
        ProductVAT productvat2 = productVATDAO.getById("2");

        Cart cart1 = createCart(productvat1, "Cart test 1", "Test Hibernate", "TEST Nr1", "AVAILABLE TEST", "$1000.01");
        Cart cart2 = createCart(productvat2, "Cart test 2", "Test Hibernate", "TEST Nr2", "AVAILABLE TEST", "$2000.01");

        cartDAO.create(cart1);
        cartDAO.create(cart2);

        List<Cart> cart = cartDAO.getAll();
        assertEquals(2, cart.size());

    }

    private Cart createCart( ProductVAT productid, String productname, String productbrand,
                            String productdescription, String status, String price )
            throws DBException, SQLException {
        Cart cart = new Cart();
        cart.setProductid(productid);
        cart.setProductname(productname);
        cart.setProductbrand(productbrand);
        cart.setProductdescription(productdescription);
        cart.setProductstatus(status);
        cart.setProductprice(price);
        return cart;

    }
*/
}