package gr.aueb.cf.service.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static BasicDataSource ds = new BasicDataSource();
    private static Connection connection;

    static {
        ds.setUrl("jdbc:mysql://localhost:3306/schooldbpro?serverTimezone=UTC");
        ds.setUsername("schoolpro");
        ds.setPassword(System.getenv("SCHOOLPRO_PASS"));
        ds.setInitialSize(8);
        ds.setMaxTotal(32);
        ds.setMinIdle(8);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);

    }

    /*
    No instances of this class should be available.
     */
    private DBUtil() {

    }

    public static BasicDataSource getDs() {
        return ds;
    }

    public static void setDs(BasicDataSource ds) {
        DBUtil.ds = ds;
    }

    public static Connection getConnection() throws SQLException {
        connection = ds.getConnection();
        System.out.println("Connection established");
        return connection;

    }

    public static void setConnection(Connection connection) {
        DBUtil.connection = connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
