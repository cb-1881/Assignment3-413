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

        String[] sqlStatements = {
            "CREATE TABLE Customer (id INT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(45), last_name VARCHAR(45), email VARCHAR(40) UNIQUE, phone VARCHAR(20), sex VARCHAR(10), birthday DATE, hashed_password VARCHAR(60))",
            "CREATE TABLE Employees (id INT PRIMARY KEY AUTO_INCREMENT, first_name VARCHAR(45), last_name VARCHAR(45), email VARCHAR(40), phone VARCHAR(20), sex VARCHAR(10), birthday DATE, salary DECIMAL(10,2), department VARCHAR(40))",
            "CREATE TABLE bank_account (acct_num INT PRIMARY KEY AUTO_INCREMENT, cust_num INT, balance DECIMAL(10,2), create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, acct_type VARCHAR(5), od_limit DECIMAL(10,2), int_rate DECIMAL(5,2), FOREIGN KEY (cust_num) REFERENCES Customer(id))",
            "CREATE TABLE transaction (id INT PRIMARY KEY AUTO_INCREMENT, dateandtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP, tran_type VARCHAR(15), amount DECIMAL(10,2), description VARCHAR(40), ref_id INT, acct_id INT, FOREIGN KEY (acct_id) REFERENCES bank_account(acct_num))",
            "CREATE TABLE admin (userid VARCHAR(45) PRIMARY KEY, pwd VARCHAR(45))"
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
