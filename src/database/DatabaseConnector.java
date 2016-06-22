package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Sushant on 6/22/2016.
 */
public class DatabaseConnector {
    private Connection conn;
    private static final String DB_URL = "jdbc:mysql://localhost/exam";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "";
    public DatabaseConnector() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn(){
        return conn;
    }
}
