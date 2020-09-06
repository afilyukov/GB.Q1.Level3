import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DBAuthService implements AuthService{
    private final Set<Record> records;

    public DBAuthService() {
        records = new HashSet<>();
        ResultSet results;
        Connection connection = DBConnector.getConnection("jdbc:mysql://localhost:8889/GB.TestDB1?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CLIENTS");
            results = preparedStatement.executeQuery();
            while (results.next()) {
                records.add(new Record(
                                results.getInt("id"),
                                results.getString("name"),
                                results.getString("login"),
                                results.getString("password")
                        )
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Cannot get sql records");
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                throw new RuntimeException("Cannot close connection");
            }
        }



    }

    @Override
    public Record findRecord(String login, String password) {
        for (Record record : records) {
            if (record.getLogin().equals(login) && record.getPassword().equals(password)) {
                return record;
            }
        }
        return null;
    }
}
