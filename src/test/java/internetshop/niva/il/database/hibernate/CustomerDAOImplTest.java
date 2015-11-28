package internetshop.niva.il.database.hibernate;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.database.jdbc.DbCleaner;


import internetshop.niva.il.domain.Customer;
import internetshop.niva.il.servlet.spring.SpringConfig;

import org.junit.Before;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 * Created by voyager on 2015.11.27..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CustomerDAOImplTest  {

    @Autowired
    private DbCleaner dbCleaner ;
    @Autowired
    private CustomerDAOImpl customerDAO ;

    @Before
    public void init() throws DBException {
        dbCleaner.cleanDatabase();
    }
    @Test
    public void testMultipleUserCreation() throws DBException, SQLException {
        Customer user1 = createUser("Hibernate1", "ORM1", "+37101234567", "email@mail.mail");
        Customer user2 = createUser("Hibernate2", "ORM2", "+37176543210", "e@mail.email");
        Customer user3 = createUser("Hibernate3", "ORM3", "+37176543211", "mmm@mail.email");
        Customer user4 = createUser("Hibernate4", "ORM4", "+37176500211", "eee@email.email");
        Customer user5 = createUser("Hibernate5", "ORM5", "+37177500211", "ttt@email.email");

        customerDAO.create(user1);
        customerDAO.create(user2);
        customerDAO.create(user3);
        customerDAO.create(user4);
        customerDAO.create(user5);

        List<Customer> users = customerDAO.getAll();

        assertEquals(5, users.size());
    }
    private  Customer createUser (String firstname, String lastname, String phonenr, String email) {
        Customer user = new Customer();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setPhoneNr(phonenr);
        user.setEmail(email);
        return user;
    }
}