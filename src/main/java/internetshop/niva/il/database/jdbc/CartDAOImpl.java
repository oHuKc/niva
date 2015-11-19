package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.domain.Cart;
import lv.javaguru.java2.database.jdbc.DAOImpl;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ilugovecs on 2015.11.17..
 */
@Component
public class CartDAOImpl  extends DAOImpl{

    public void create (Cart cart) throws DBException, SQLException {
        if (cart == null ) {
            return;
        }
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO cart VALUES (id, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cart.getProductname());
            preparedStatement.setString(2, cart.getProductbrand());
            preparedStatement.setString(3, cart.getProductdescription());
            preparedStatement.setString(4, cart.getProductstatus());
            preparedStatement.setString(5, cart.getProductprice());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()) {
                cart.setProductid(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception occured while execute CartDAOImpl.create()");
            e.printStackTrace();
            throw  new DBException(e);
        } finally {
            if (connection != null) {
                //closeConnection(connection);
                connection.close();
            }
        }
    }


}
