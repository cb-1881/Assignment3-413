import java.util.List;

public interface EmployeeDAOInterface {
    void addEmployee(Employee employee);
    Employee getEmployee(String email); // Assuming email is unique identifier
    void updateEmployee(Employee employee);
    void deleteEmployee(String email);
    List<Employee> getAllEmployees();
}
