import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements AccountDAOInterface {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/CS413";
        String user = "root";
        String password = "Rootroot123!";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void addAccount(Account account) {
        String sql = "INSERT INTO bank_account (acct_num, cust_num, balance, create_date, last_update_date, acct_type, od_limit, int_rate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, account.getAcctNum());
            stmt.setString(2, account.getCustNum());
            stmt.setDouble(3, account.getBalance());
            stmt.setDate(4, new java.sql.Date(account.getCreateDate().getTime()));
            stmt.setDate(5, new java.sql.Date(account.getLastUpdateDate().getTime()));
            stmt.setString(6, account.getType());
            stmt.setDouble(7, account.getOdLimit());
            stmt.setDouble(8, account.getIntRate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account getAccount(String acctNum) {
        String sql = "SELECT * FROM bank_account WHERE acct_num = ?";
        Account account = null;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, acctNum);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                account = new Account(sql, sql, 0, null, null, sql, 0, 0);
                account.setAcctNum(rs.getString("acct_num"));
                account.setCustNum(rs.getString("cust_num"));
                account.setBalance(rs.getDouble("balance"));
                account.setCreateDate(rs.getDate("create_date"));
                account.setLastUpdateDate(rs.getDate("last_update_date"));
                account.setType(rs.getString("acct_type"));
                account.setOdLimit(rs.getDouble("od_limit"));
                account.setIntRate(rs.getDouble("int_rate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "UPDATE bank_account SET cust_num = ?, balance = ?, create_date = ?, last_update_date = ?, acct_type = ?, od_limit = ?, int_rate = ? WHERE acct_num = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, account.getCustNum());
            stmt.setDouble(2, account.getBalance());
            stmt.setDate(3, new java.sql.Date(account.getCreateDate().getTime()));
            stmt.setDate(4, new java.sql.Date(account.getLastUpdateDate().getTime()));
            stmt.setString(5, account.getType());
            stmt.setDouble(6, account.getOdLimit());
            stmt.setDouble(7, account.getIntRate());
            stmt.setString(8, account.getAcctNum());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(String acctNum) {
        String sql = "DELETE FROM bank_account WHERE acct_num = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, acctNum);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM bank_account";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Account account = new Account(sql, sql, 0, null, null, sql, 0, 0);
                account.setAcctNum(rs.getString("acct_num"));
                account.setCustNum(rs.getString("cust_num"));
                account.setBalance(rs.getDouble("balance"));
                account.setCreateDate(rs.getDate("create_date"));
                account.setLastUpdateDate(rs.getDate("last_update_date"));
                account.setType(rs.getString("acct_type"));
                account.setOdLimit(rs.getDouble("od_limit"));
                account.setIntRate(rs.getDouble("int_rate"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    
}
