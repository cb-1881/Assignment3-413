import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO implements TransactionDAOInterface {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/CS413";
        String user = "root";
        String password = "Rootroot123!";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        String sql = "INSERT INTO transaction (dateandtime, tran_type, amount, description, ref_id, acct_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(transaction.getDateAndTime().getTime()));
            stmt.setString(2, transaction.getTranType());
            stmt.setDouble(3, transaction.getAmount());
            stmt.setString(4, transaction.getDescription());
            stmt.setString(5, transaction.getRefID());
            stmt.setString(6, transaction.getAcctId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
public Transaction getTransaction(String id) {
    String sql = "SELECT * FROM transaction WHERE id = ?";
    Transaction transaction = null;
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            transaction = new Transaction(null, sql, 0, sql, sql, sql);
            transaction.setDateAndTime(rs.getDate("dateandtime"));
            transaction.setTranType(rs.getString("tran_type"));
            transaction.setAmount(rs.getDouble("amount"));
            transaction.setDescription(rs.getString("description"));
            transaction.setRefID(rs.getString("ref_id"));
            transaction.setAcctId(rs.getString("acct_id"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return transaction;
}

@Override
public void updateTransaction(Transaction transaction) {
    String sql = "UPDATE transaction SET dateandtime = ?, tran_type = ?, amount = ?, description = ?, ref_id = ?, acct_id = ? WHERE id = ?";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setDate(1, new java.sql.Date(transaction.getDateAndTime().getTime()));
        stmt.setString(2, transaction.getTranType());
        stmt.setDouble(3, transaction.getAmount());
        stmt.setString(4, transaction.getDescription());
        stmt.setString(5, transaction.getRefID());
        stmt.setString(6, transaction.getAcctId());
        stmt.setString(7, transaction.getRefID()); // Assuming refID is used as a unique identifier
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public void deleteTransaction(String id) {
    String sql = "DELETE FROM transaction WHERE id = ?";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, id);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public List<Transaction> getAllTransactions() {
    List<Transaction> transactions = new ArrayList<>();
    String sql = "SELECT * FROM transaction";
    try (Connection conn = getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Transaction transaction = new Transaction(null, sql, 0, sql, sql, sql);
            transaction.setDateAndTime(rs.getDate("dateandtime"));
            transaction.setTranType(rs.getString("tran_type"));
            transaction.setAmount(rs.getDouble("amount"));
            transaction.setDescription(rs.getString("description"));
            transaction.setRefID(rs.getString("ref_id"));
            transaction.setAcctId(rs.getString("acct_id"));
            transactions.add(transaction);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return transactions;
}

    // Implement other methods (getTransaction, updateTransaction, deleteTransaction, getAllTransactions) similarly
}
