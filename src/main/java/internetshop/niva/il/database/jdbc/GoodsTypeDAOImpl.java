package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.domain.GoodsType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;

/**
 * Created by ilugovecs on 2015.10.23..
 */
public class GoodsTypeDAOImpl extends DAOImplement {

    public void create(GoodsType goodstype) throws DBException, SQLException {
        if(goodstype == null) {
            return;
        }
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into goods_type values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, goodstype.getItemModel());
            preparedStatement.setString(2, goodstype.getItemDescripton());
            preparedStatement.setString(3, goodstype.getItemType());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()) {
                goodstype.setItemId(rs.getLong(1));
            }
        }catch (Throwable e) {
            System.out.println("Exception occured while execute GoodsTypeDAOImpl.create()");
            e.printStackTrace();
            throw  new DBException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public GoodsType getById(Long id) throws DBException, SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from goods_type where ItemId = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            GoodsType goodstype = null;
            if(resultSet.next()) {
                goodstype = new GoodsType();
                goodstype.setItemId(resultSet.getLong("ItemId"));
                goodstype.setItemModel(resultSet.getString("ItemModel"));
                goodstype.setItemDescription(resultSet.getString("ItemDescription"));
                goodstype.setItemType(resultSet.getString("ItemType"));
            }
            return  goodstype;
        }catch (Throwable e) {
            System.out.println("Exception occured while execute GoodsTypeDAOImpl.getById()");
            e.printStackTrace();
            throw  new DBException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public  List<GoodsType>  getAll() throws DBException, SQLException {
        List<GoodsType> goodstype = new ArrayList<GoodsType>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from goods_type");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                GoodsType gdstype = new GoodsType();
                gdstype.setItemId(resultSet.getLong("ItemId"));
                gdstype.setItemModel(resultSet.getString("ItemModel"));
                gdstype.setItemDescription(resultSet.getString("ItemDescription"));
                gdstype.setItemType(resultSet.getString("ItemType"));
                goodstype.add(gdstype);
            }
        }catch(SQLException e) {
            System.out.println("Exception occure while execute GoodsTypeDAOImpl.getAll()");
            e.printStackTrace();
        }
        return goodstype;

    }

    public void delete(Long id) throws  DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE  FROM goods_type");
            preparedStatement.executeUpdate();
        }catch (Throwable e) {
            System.out.println("Exception occure while execute GoodsTypeDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public  void update(GoodsType goodstype) throws DBException, SQLException {
        if (goodstype == null ) {
            return;
        }
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE goods_type set ItemModel = ?, ItemDescription = ?, ItemType = ?" + "where ItemId = ? ");
            preparedStatement.setString(1, goodstype.getItemModel());
            preparedStatement.setString(2, goodstype.getItemDescripton());
            preparedStatement.setString(3, goodstype.getItemType());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception occured while execute GoodsDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        }finally {
            closeConnection(connection);
        }
    }

    int recordscount() throws DBException, SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement st = connection.prepareStatement("select count(1) from goods_type");
            try{
                ResultSet rs = st.executeQuery();
                try {
                    rs.next();
                    return  rs.getInt(1);
                } finally {
                    rs.close();
                }
            } finally {
                st.close();
            }
        }catch (Throwable e) {
            System.out.println("Exception occured while execute GoodsTypeDAOImple.recordscount()");
            e.printStackTrace();
            throw  new DBException(e);
        }
    }
}
