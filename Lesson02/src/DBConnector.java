import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnector {
    public ResultSet getAll (String query) {
        //ToDO сделать getOneClint

        //Deprecated
        //try {
        //    Class.forName("com.mysql.jdbc.Driver");
        //} catch (ClassNotFoundException e) {
        //    throw new RuntimeException("Driver not found");
        //}

        Connection connection;
        ResultSet results;
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/GB.TestDB1?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Driver Registration error");
        }

        try {
            Statement statement = connection.createStatement();
            results = statement.executeQuery(query);
            return results;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Statement error");
        }



    }
}
