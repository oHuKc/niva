package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.database.DBException;
import internetshop.niva.il.domain.TV;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilugovecs on 2015.11.05..
 */
public class TVDAOImpl extends DAOImplement {

    public void create(TV tv) throws DBException{
        if(tv == null ) {
            return;
        }
        Connection connection = null;

        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tv_hometheater VALUES (id, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, tv.getTvtype());
            preparedStatement.setString(2, tv.getTvscreensize());
            preparedStatement.setString(3 ,tv.getTvebrand());
            preparedStatement.setString(4, tv.getTvprice());
            preparedStatement.setString(5, tv.getTvresolution());
            preparedStatement.setString(5, tv.getTvdescription());
            preparedStatement.setInt(6, tv.getTvscreentypeid());


            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()) {
                tv.setTvid(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception occured while execute TVDAOIML.create()");
            e.printStackTrace();
            throw  new DBException(e);
        }finally {
            closeConnection(connection);
        }
    }

    public TV getById(Long id) throws DBException {

            Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_hometheater where id = ? ");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            TV tv = null;
            if (resultSet.next()) {
                tv = new TV();
                tv.setTvid(resultSet.getLong("id"));
                tv.setTvtype(resultSet.getString("TV_TYPE"));
                tv.setTvscreensize(resultSet.getString("TV_SCREEN_SIZE"));
                tv.setTvebrand(resultSet.getString("BRAND"));
                tv.setTvprice(resultSet.getString("PRICE"));
                tv.setTvresolution(resultSet.getString("RESOLUTION"));
                tv.setTvdescription(resultSet.getString("DESCRIPTION"));
                tv.setTvscreentypeid(resultSet.getInt("SCREEN_TYPE_ID"));
            }
            return tv;
        } catch (Throwable e) {
            System.out.println("Exception occured while execute TVDAOIml.getById()");
            e.printStackTrace();
            throw  new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<TV> getAll() throws DBException {
        List<TV> tv = new ArrayList<TV>();
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_hometheater");

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                TV tvs = new TV();
              tvs.setTvid(resultSet.getLong("id"));
              tvs.setTvtype(resultSet.getString("TV_TYPE"));
                tvs.setTvscreensize(resultSet.getString("TV_SCREEN_SIZE"));
              tvs.setTvebrand(resultSet.getString("BRAND"));
              tvs.setTvprice(resultSet.getString("PRICE"));
              tvs.setTvresolution(resultSet.getString("RESOLUTION"));
              tvs.setTvdescription(resultSet.getString("DESCRIPTION"));
                tvs.setTvscreentypeid(resultSet.getInt("SCREEN_TYPE_ID"));
                tv.add(tvs);
            }

        } catch (SQLException e) {
            System.out.println("Exception woccured while getting goods list TVDAOImpl.getAll()");
            e.printStackTrace();
        }
        return tv;
    }

    public List<TV> get4KUHD(int id) throws DBException {
        List<TV> tv = new ArrayList<TV>();
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tv_hometheater where SCREEN_TYPE_ID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                TV tvs = new TV();
                tvs.setTvid(resultSet.getLong("id"));
                tvs.setTvtype(resultSet.getString("TV_TYPE"));
                tvs.setTvscreensize(resultSet.getString("TV_SCREEN_SIZE"));
                tvs.setTvebrand(resultSet.getString("BRAND"));
                tvs.setTvprice(resultSet.getString("PRICE"));
                tvs.setTvresolution(resultSet.getString("RESOLUTION"));
                tvs.setTvdescription(resultSet.getString("DESCRIPTION"));
                tvs.setTvscreentypeid(resultSet.getInt("SCREEN_TYPE_ID"));
                tv.add(tvs);
            }
        } catch (SQLException e) {
            System.out.println("Exception occured while getting goods list TVDAOImpl.get4KUHD4045()");
            e.printStackTrace();
        }
        return tv;
    }


    public TV getByScreenSize(String id) throws DBException {

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select TV_SCREEN_SIZE FROM tv_hometheater  where SCREEN_TYPE_ID = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            TV tv = null;
            if (resultSet.next()) {
                tv = new TV();
               //tv.setTvid(resultSet.getLong("id"));
              // tv.setTvtype(resultSet.getString("TV_TYPE"));
                tv.setTvscreensize(resultSet.getString("TV_SCREEN_SIZE"));
               //tv.setTvebrand(resultSet.getString("BRAND"));
              // tv.setTvprice(resultSet.getString("PRICE"));
               // tv.setTvresolution(resultSet.getString("RESOLUTION"));
              //  tv.setTvdescription(resultSet.getString("DESCRIPTION"));
            }
            return tv;
        } catch (Throwable e) {
            System.out.println("Exception occured while execute TVDAOImpl.getByScreenSize()");
            e.printStackTrace();
            throw  new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }


}
