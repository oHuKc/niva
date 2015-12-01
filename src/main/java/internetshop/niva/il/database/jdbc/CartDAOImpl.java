package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.domain.Cart;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilugovecs on 2015.11.17..
 */

@Component(value="CartDAOImpl_JDBC")
public class CartDAOImpl  extends DAOImplement {

    public void create(Cart cart) throws DBException, SQLException {
        if (cart == null ) {
            return;
        }
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO cart VALUES (id, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, cart.getProductid());
            preparedStatement.setString(2, cart.getProductname());
            preparedStatement.setString(3, cart.getProductbrand());
            preparedStatement.setString(4, cart.getProductdescription());
            preparedStatement.setString(5, cart.getProductstatus());
            preparedStatement.setString(6, cart.getProductprice());


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

    public List<Cart> getAll() throws DBException {
        List<Cart> users = new ArrayList<Cart>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from cart");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cart cart = new Cart();
                cart.setProductid(resultSet.getLong("PRODUCT_ID"));
                cart.setProductname(resultSet.getString("PRODUCT_NAME"));
                cart.setProductbrand(resultSet.getString("PRODUCT_BRAND"));
                cart.setProductdescription(resultSet.getString("PRODUCT_DESCRIPTION"));
                cart.setProductstatus(resultSet.getString("STATUS"));
                cart.setProductprice(resultSet.getString("PRICE"));
                users.add(cart);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting cart products list CartDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return users;
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
