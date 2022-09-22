package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static Connection connection = null;

    private DbConnection() {
    }

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(Dbconfiq.DB_URL, Dbconfiq.DB_USERNAME, Dbconfiq.DB_PASSWORD);
        }
        return connection;
    }
}
