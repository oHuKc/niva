package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.database.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilugovecs on 2015.10.19..
 */
public class DbCleaner extends  DAOImplement{

    private List<String> getTableNames(){
        List<String> tableNames = new ArrayList<String>();
        tableNames.add("customers");
        return tableNames;
    }

    public void cleanDatabase() throws DBException {
        for(String tableName : getTableNames()) {
            Connection connection = getConnection();
            try {
                connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(" delete from " + tableName);
                preparedStatement.executeUpdate();
            } catch (Throwable e) {
                System.out.println("Exception while execute cleanDatabase() for table" + tableName);
                e.printStackTrace();
            }finally {
                closeConnection(connection);
            }

        }
    }
}
