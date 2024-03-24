

public class EmployeeController {
    private EmployeePanel view;
    private EmployeeDAO employeeDAO;

    public EmployeeController(EmployeePanel view) {
        this.view = view;
        this.employeeDAO = new EmployeeDAO();
        initController();
    }

    private void initController() {
        view.getAddButton().addActionListener(e -> addEmployee());
        view.getUpdateButton().addActionListener(e -> updateEmployee());
        view.getDeleteButton().addActionListener(e -> deleteEmployee());
    }

    
    
        // Method to get the view component for adding to a JFrame
        public EmployeePanel getView() {
            return view;
        }

    private void addEmployee() {
        Employee employee = view.getEmployeeDetails();
        employeeDAO.addEmployee(employee);
        view.showMessage("Employee added successfully");
    }

    private void updateEmployee() {
        Employee employee = view.getEmployeeDetails();
        employeeDAO.updateEmployee(employee);
        view.showMessage("Employee updated successfully");
    }

    private void deleteEmployee() {
        String email = view.getEmployeeEmail();
        employeeDAO.deleteEmployee(email);
        view.showMessage("Employee deleted successfully");
    }
}
