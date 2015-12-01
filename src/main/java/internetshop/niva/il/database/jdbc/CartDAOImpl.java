package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.domain.Cart;
import internetshop.niva.il.database.jdbc.DAOImplement;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ilugovecs on 2015.11.17..
 */
@Component("CartDAOImpl_JDBC")
@Transactional
public class CartDAOImpl  extends DAOImplement {

    public void create(Cart cart) throws DBException, SQLException {
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

    public Cart getById(Long id) throws DBException, SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from cart where id = ? ");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Cart cart = null;
            if (resultSet.next()) {
                cart = new Cart();
                cart.setProductid(resultSet.getLong("PRODUCT_ID"));
                cart.setProductname(resultSet.getString("PRODUCT_NAME"));
                cart.setProductbrand(resultSet.getString("PRODUCT_BRAND"));
                cart.setProductdescription(resultSet.getString("PRODUCT_DESCRIPTION"));
                cart.setProductstatus(resultSet.getString("STATUS"));
                cart.setProductprice(resultSet.getString("PRICE"));
            }
            return cart;
        } catch (Throwable e) {
            System.out.println("Exception occured while execute CartDAOIml.getById()");
            e.printStackTrace();
            throw  new DBException(e);
        } finally {
            if ( connection != null ) {
                //closeConnection(connection);
                try {
                    connection.close();
                }catch (SQLException ignore) {}
            }
        }
    }

}
