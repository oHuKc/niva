package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.domain.Customer;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;



/**
 * Created by Igor on 2015.10.19..
 */
public class CustDAOImlTest extends TestCase {

    private DbCleaner databaseCleaner = new DbCleaner();
    private CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    @Before
    public void init() throws DBException {
        try {
            databaseCleaner.cleanDatabase();
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreate() throws DBException {
        Customer user = createUser("FirstNametest", "LastNameTest", "+371987654321", "Email@mail.email");

        customerDAO.create(user);

        Customer userFromDB = customerDAO.getById(user.getUserId());
        assertNotNull(userFromDB);
        assertEquals(user.getUserId(), userFromDB.getUserId());
        assertEquals(user.getFirstName(), userFromDB.getFirstName());
        assertEquals(user.getLastName(), userFromDB.getLastName());
        assertEquals(user.getPhoneNr(), userFromDB.getPhoneNr());
        assertEquals(user.getEmail(), userFromDB.getEmail());
    }

    @Test
    public void testMultipleUserCreation() throws DBException, SQLException {

        Customer user1 = createUser("TestFirstName1", "TestLastName1", "+37101234567", "email@mail.mail");
        Customer user2 = createUser("TestFirstName2", "TestLastName2", "+37176543210", "e@mail.email");
        Customer user3 = createUser("TestFirstName3", "TestLastName3", "+37176543211", "mmm@mail.email");
        Customer user4 = createUser("TestFirstName4", "TestLastName4", "+37176500211", "eee@email.email");
        Customer user5 = createUser("TestFirstName5", "TestLastName5", "+37177500211", "ttt@email.email");
        customerDAO.create(user1);
        customerDAO.create(user2);
        customerDAO.create(user3);
        customerDAO.create(user4);
        customerDAO.create(user5);
        List<Customer> users = customerDAO.getAll();
        int rec = customerDAO.recordscount();

        //assertEquals(2, users.size());

        //for (int i = 1 ; i < 0;  i++ ) {
        //    assertEquals(i, users.size());
        //}

        assertEquals(rec, users.size());
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