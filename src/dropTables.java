import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dropTables {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/CS413";
        String user = "root";
        String password = "Rootroot123!";

        // SQL statements to drop tables
        String[] sqlStatements = {
            "DROP TABLE IF EXISTS bank_account",
            "DROP TABLE IF EXISTS Customer",
            "DROP TABLE IF EXISTS Employees",
            "DROP TABLE IF EXISTS transaction", 
            "DROP TABLE IF EXISTS admin"
           
        };

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            
            // Execute each SQL statement to drop tables
            for (String sql : sqlStatements) {
                stmt.execute(sql);
                System.out.println("Dropped table with command: " + sql);
            }
            System.out.println("All specified tables dropped successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

