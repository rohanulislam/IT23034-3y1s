import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnectionManager {

    protected Connection dbConnection;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;

    public DatabaseConnectionManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public Connection openConnection() {
        String databaseUrl = "jdbc:mysql://localhost:3306/test";
        try {
            dbConnection = DriverManager.getConnection(
                    databaseUrl, "root", "1234");
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return dbConnection;
    }

    public void closeResources() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
