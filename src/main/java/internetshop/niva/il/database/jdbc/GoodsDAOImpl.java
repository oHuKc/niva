package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.domain.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilugovecs on 2015.10.21..
 */
public class GoodsDAOImpl extends DAOImplement {

    public void create(Goods goods) throws DBException {
        if (goods == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into goods values (default, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, goods.getGoodsType());
            preparedStatement.setString(2, goods.getGoodsName());
            preparedStatement.setString(3, goods.getGoodsPrice());
            preparedStatement.setString(4, goods.getGoodsDesription());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                goods.setGoodsId(rs.getLong(1));
            }
        }catch(Throwable e) {
            System.out.println("Exception occured whhile execute GoodsDAOImpl.create()");
            e.printStackTrace();
            throw  new DBException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public Goods getById(Long id) throws DBException {
        Connection connection = null;

        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from goods where GoodsId = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Goods goods = null;
            if (resultSet.next()){
                goods = new Goods();
                goods.setGoodsId(resultSet.getLong("GoodsID"));
                goods.setGoodsType(resultSet.getString("GoodsType"));
                goods.setGoodsName(resultSet.getString("GoodsName"));
                goods.setGoodsPrice(resultSet.getString("GoodsPrice"));
                goods.setGoodsDescription(resultSet.getString("Description"));
            }
            return goods;
        }catch(Throwable e) {
            System.out.println("Exception occured while execute GoodsDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        }finally{
            closeConnection(connection);
        }
    }


    public List<Goods> getAll() throws DBException {
        List<Goods> goods = new ArrayList<Goods>();
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from goods");

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Goods gds = new Goods();
                gds.setGoodsId(resultSet.getLong("GoodsId"));
                gds.setGoodsType(resultSet.getString("GoodsType"));
                gds.setGoodsName(resultSet.getString("GoodsName"));
                gds.setGoodsPrice(resultSet.getString("GoodsPrice"));
                gds.setGoodsDescription(resultSet.getString("Description"));
                goods.add(gds);
            }

        } catch (SQLException e) {
            System.out.println("Exception woccured while getting goods list GoodsDAOImpl.getList()");
            e.printStackTrace();
        }
        return goods;
    }
    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from goods");
            //preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception occured while execute GoodsDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }


    public void update(Goods goods) throws DBException {
        if (goods == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update goods set GoodsType = ?, GoodsName = ? , GoodsPrice = ?, Description = ?" + "where GoodsId = ?");
            preparedStatement.setString(1, goods.getGoodsType());
            preparedStatement.setString(2, goods.getGoodsName());
            preparedStatement.setString(3, goods.getGoodsPrice());
            preparedStatement.setString(4, goods.getGoodsDesription());
            preparedStatement.setLong(1, goods.getGoodsId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception occured while execute GoodsDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

   public int recordscount() throws DBException, SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement st = connection.prepareStatement("select count(1) from goods");
            try {
                ResultSet rs = st.executeQuery();
                try {
                    rs.next();
                    return rs.getInt(1);
                } finally {
                    rs.close();
                }
            } finally {
                st.close();
            }
        } catch (Throwable e) {
            System.out.println("Exception occured while execute GoodsTypeDAOImple.recordscount()");
            e.printStackTrace();
            throw  new DBException(e);
        }
    }

}
