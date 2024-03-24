import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements EmployeeDAOInterface {

    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/CS413";
        String user = "root";
        String password = "Rootroot123!";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO Employees (first_name, last_name, email, phone, sex, birthday, salary, department) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getPhone());
            stmt.setString(5, employee.getSex());
            stmt.setDate(6, new java.sql.Date(employee.getBirthday().getTime()));
            stmt.setDouble(7, employee.getSalary());
            stmt.setString(8, employee.getDepartment());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployee(String email) {
        String sql = "SELECT * FROM Employees WHERE email = ?";
        Employee employee = null;
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                employee = new Employee(sql, sql, sql, sql, sql, null, 0, sql);
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhone(rs.getString("phone"));
                employee.setSex(rs.getString("sex"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDepartment(rs.getString("department"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        String sql = "UPDATE Employees SET first_name = ?, last_name = ?, phone = ?, sex = ?, birthday = ?, salary = ?, department = ? WHERE email = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setString(3, employee.getPhone());
            stmt.setString(4, employee.getSex());
            stmt.setDate(5, new java.sql.Date(employee.getBirthday().getTime()));
            stmt.setDouble(6, employee.getSalary());
            stmt.setString(7, employee.getDepartment());
            stmt.setString(8, employee.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(String email) {
        String sql = "DELETE FROM Employees WHERE email = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employees";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Employee employee = new Employee(sql, sql, sql, sql, sql, null, 0, sql);
                employee.setFirstName(rs.getString("first_name"));
                employee.setLastName(rs.getString("last_name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhone(rs.getString("phone"));
                employee.setSex(rs.getString("sex"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setDepartment(rs.getString("department"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
