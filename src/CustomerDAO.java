import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements CustomerDAOInterface {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/CS413";
        String user = "root";
        String password = "Rootroot123!";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (id, first_name, last_name, email, phone, sex, birthday) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getId());
            stmt.setString(2, customer.getFirstName());
            stmt.setString(3, customer.getLastName());
            stmt.setString(4, customer.getEmail());
            stmt.setString(5, customer.getPhone());
            stmt.setString(6, customer.getSex());
            stmt.setDate(7, new Date(customer.getBirthday().getTime()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomer(String id) {
        String sql = "SELECT * FROM Customer WHERE id = ?";
        Customer customer = null;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                customer = new Customer(sql, sql, sql, sql, sql, sql, null);
                customer.setId(rs.getString("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setSex(rs.getString("sex"));
                customer.setBirthday(rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        String sql = "UPDATE Customer SET first_name = ?, last_name = ?, email = ?, phone = ?, sex = ?, birthday = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhone());
            stmt.setString(5, customer.getSex());
            stmt.setDate(6, new Date(customer.getBirthday().getTime()));
            stmt.setString(7, customer.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(String id) {
        String sql = "DELETE FROM Customer WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM Customer";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Customer customer = new Customer(sql, sql, sql, sql, sql, sql, null);
                customer.setId(rs.getString("id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));
                customer.setPhone(rs.getString("phone"));
                customer.setSex(rs.getString("sex"));
                customer.setBirthday(rs.getDate("birthday"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
