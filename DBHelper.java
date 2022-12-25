import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private String userName = "root";
    private String password = "";
    private String dbUrl = "'jdbc:mysql://localhost:3306/StockManagement?useSSL=false&serverTimezone=UTC'";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);

    }

    public SQLException showErrorMessage(SQLException exception) {
        System.out.println("eror :" + exception.getMessage());
        System.out.println("error kodu :" + exception.getErrorCode());
        return exception;
    }
}
