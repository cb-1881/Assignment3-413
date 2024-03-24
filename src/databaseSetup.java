import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseSetup {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/CS413";
        String user = "root";
        String password = "Rootroot123!";

        // SQL statements for table creation
        String[] sqlStatements = {
            "CREATE TABLE bank_account (acct_num INT PRIMARY KEY AUTO_INCREMENT, cust_num INT, balance FLOAT, create_date VARCHAR(40), last_update_date VARCHAR(40), acct_type VARCHAR(5), od_limit FLOAT, int_rate FLOAT)",
            "CREATE TABLE Customer (id INT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(45), last_name VARCHAR(45), email VARCHAR(40), phone VARCHAR(20), sex VARCHAR(10), birthday VARCHAR(20))",
            "CREATE TABLE Employees (id INT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(45), last_name VARCHAR(45), email VARCHAR(40), phone VARCHAR(20), sex VARCHAR(10), birthday VARCHAR(20), salary DOUBLE, department VARCHAR(40))",
            "CREATE TABLE transaction (id INT PRIMARY KEY AUTO_INCREMENT, dateandtime VARCHAR(20), tran_type VARCHAR(15), amount FLOAT, description VARCHAR(40), ref_id INT, acct_id INT)",
            "CREATE TABLE admin (userid VARCHAR(45),pwd VARCHAR(45))"
        };

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            
            // Execute each SQL statement to create tables
            for (String sql : sqlStatements) {
                stmt.execute(sql);
                System.out.println("Executed: " + sql);
            }
            System.out.println("All tables created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
