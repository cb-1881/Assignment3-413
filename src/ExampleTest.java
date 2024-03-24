import java.text.SimpleDateFormat;
import java.util.List;

public class ExampleTest {

    public static void main(String[] args) {
        // Create an instance of EmployeeDAO
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Create an instance of Employee
        Employee employee = new Employee(null, null, null, null, null, null, 0, null);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("john.doe@example.com");
        employee.setPhone("1234567890");
        employee.setSex("Male");

        try {
            // Set the birthday using SimpleDateFormat
            String strDate = "1990-01-01"; // Example date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            employee.setBirthday(new java.sql.Date(sdf.parse(strDate).getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        employee.setSalary(50000.00);
        employee.setDepartment("Engineering");

        // Use EmployeeDAO to add the Employee to the database
        employeeDAO.addEmployee(employee);

        System.out.println("Employee added successfully!");

             // Retrieve and print all employees
        List<Employee> employees = employeeDAO.getAllEmployees();
        System.out.println("Listing all employees:");
        for (Employee emp : employees) {
            System.out.println(", Name: " + emp.getFirstName() + " " + emp.getLastName() +
                    ", Email: " + emp.getEmail() + ", Phone: " + emp.getPhone() +
                    ", Sex: " + emp.getSex() + ", Birthday: " + emp.getBirthday() +
                    ", Salary: " + emp.getSalary() + ", Department: " + emp.getDepartment());
        }
        //employeeDAO.deleteEmployee("john.doe@example.com");  
    }
}
