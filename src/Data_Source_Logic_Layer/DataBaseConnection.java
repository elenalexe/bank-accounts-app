package Data_Source_Logic_Layer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/assignment1";
    static final String USER = "root";
    static final String PASS = "Maya16";

    public Connection conn;

    public static DataBaseConnection db;

    private DataBaseConnection()
    {
        try
        {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static synchronized DataBaseConnection getConnection()
    {
        if (db == null)
        {
            db = new DataBaseConnection();
        }
        return db;
    }
}
