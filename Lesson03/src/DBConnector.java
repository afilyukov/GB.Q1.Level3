import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException throwable) {
          //  throwable.printStackTrace();
            throw new RuntimeException("Driver not found");
        }
    }

    public static Connection getConnection(String connectionString) {
        try {
            return DriverManager.getConnection(connectionString, "root", "root");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            throw new RuntimeException("Connection error");
        }
    }
}
