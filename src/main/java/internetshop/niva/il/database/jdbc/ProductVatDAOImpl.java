package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.domain.ProductVAT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ilugovecs on 2015.12.22..
 */
public class ProductVatDAOImpl extends DAOImplement{

    public void create(ProductVAT productvat) throws DBException {

        if( productvat == null ) {
            return;
        }
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT  INTO product_vat VALUES (id, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, productvat.getOrderid());
            preparedStatement.setString(2, productvat.getVatname());
            preparedStatement.setString(3, productvat.getVat());
            preparedStatement.setString(4, productvat.getPrice());
            preparedStatement.setString(5, productvat.getPricetotal());

            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                productvat.setProductid(rs.getString(1));
            }
        }catch (Throwable e) {
            System.out.println("Exception occured while execute ProductVATDAOImpl.create()");
            e.printStackTrace();
            throw  new DBException(e);
        }
    }

    public ProductVAT getById(Long id) throws DBException, SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product_vat where id = ? ");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ProductVAT productvat = null;
            if (resultSet.next()) {
                productvat = new ProductVAT();
                productvat.setProductid("PRODUCT_ID");
                productvat.setVatname(resultSet.getString("VAT_NAME"));
                productvat.setVat(resultSet.getString("VAT"));
                productvat.setPrice(resultSet.getString("PRICE"));
                productvat.setPricetotal(resultSet.getString("PRICE_TOTAL"));
            }
            return productvat;
        } catch (Throwable e) {
            System.out.println("Exception occured while execute ProductVATDAOImpl.getById()");
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
