package internetshop.niva.il.database.jdbc;

import internetshop.niva.il.database.DBException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by ilugovecs on 2015.10.19..
 */
public class DAOImplement {
   // private static final String DB_CONFIG_FILE = "nivadatabase.properties"; //TEST DB
    private static final String DB_CONFIG_FILE = "nivaproductiondb.properties"; //PRODUCTION DB

    private String dbUrl = null;
    private String userName = null;
    private String password = null;

    public DAOImplement() {
        registerJDBCDriver();
        initDatabaseConnectionProperties();
    }

    private void initDatabaseConnectionProperties() {
        Properties properties = new Properties();
        try{
            properties.load(DAOImplement.class.getClassLoader().getResourceAsStream(DB_CONFIG_FILE));
            dbUrl = properties.getProperty("dbUrl");
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
        } catch (IOException e) {
            System.out.println("Exception while reading JDBC configuration from file =" + DB_CONFIG_FILE);
            e.printStackTrace();
        }
    }

    private void registerJDBCDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            System.out.println("Exception while registering JDBC driver !");
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws DBException{
        try {
            return DriverManager.getConnection(dbUrl, userName, password);
        }catch(SQLException e) {
            System.out.println("Exception while getting connection to database");
            e.printStackTrace();
            throw  new DBException(e);
        }

    }
    protected void closeConnection(Connection connection) throws DBException {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Exception while closing connection to database");
            e.printStackTrace();
           throw new DBException(e);
        }
    }
}
