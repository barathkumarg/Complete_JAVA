
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBConnection {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/test";

        // Database credentials
        String username = "barath";
        String password = "Barathg@1516";

        Connection connection = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Perform database operations
            // ...

            // Close the connection
            connection.close();
            System.out.println("Connection closed.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}