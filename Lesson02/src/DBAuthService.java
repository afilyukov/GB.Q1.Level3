import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DBAuthService implements AuthService{
    private final Set<AuthService.Record> records;

    public DBAuthService() {
        records = new HashSet<>();
        try {
        ResultSet results = new DBConnector().getAll("SELECT * FROM CLIENTS");

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
            throw new RuntimeException("Statement error");
        }
    }

    @Override
    public AuthService.Record findRecord(String login, String password) {
        for (AuthService.Record record : records) {
            if (record.getLogin().equals(login) && record.getPassword().equals(password)) {
                return record;
            }
        }
        return null;
    }
}
