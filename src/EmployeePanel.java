import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeePanel extends JPanel {
    private JTextField firstNameField, lastNameField, emailField, phoneField, sexField, birthdayField, salaryField, departmentField;
    private JButton addButton, updateButton, deleteButton;

    public EmployeePanel() {
        setLayout(new GridLayout(0, 2, 10, 10)); // A grid layout with 2 columns

        // Initialize components and add them to the panel
        initializeComponents();
        
        // Buttons (Assuming you need these based on your controller)
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        add(addButton);
        add(updateButton);
        add(deleteButton); // Placeholder, assuming you have or will add action listeners elsewhere
    }
    private void initializeComponents() {
        // First Name
        add(new JLabel("First Name:"));
        firstNameField = new JTextField(20);
        add(firstNameField);
        
        // Last Name
        add(new JLabel("Last Name:"));
        lastNameField = new JTextField(20);
        add(lastNameField);
        
        // Email
        add(new JLabel("Email:"));
        emailField = new JTextField(20);
        add(emailField);
        
        // Phone
        add(new JLabel("Phone:"));
        phoneField = new JTextField(20);
        add(phoneField);
        
        // Sex
        add(new JLabel("Sex:"));
        sexField = new JTextField(20);
        add(sexField);
        
        // Birthday
        add(new JLabel("Birthday:"));
        birthdayField = new JTextField(20);
        add(birthdayField);
        
        // Salary
        add(new JLabel("Salary:"));
        salaryField = new JTextField(20);
        add(salaryField);
        
        // Department
        add(new JLabel("Department:"));
        departmentField = new JTextField(20);
        add(departmentField);
    }

        public Employee getEmployeeDetails() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday = sdf.parse(birthdayField.getText());

            return new Employee(
                    firstNameField.getText(),
                    lastNameField.getText(),
                    emailField.getText(),
                    phoneField.getText(),
                    sexField.getText(),
                    new java.sql.Date(birthday.getTime()),
                    Double.parseDouble(salaryField.getText()),
                    departmentField.getText()
            );
        } catch (Exception e) {
            showMessage("Error parsing employee details: " + e.getMessage());
            return null;
        }
    }

    public String getEmployeeEmail() {
        return emailField.getText();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    // Getter methods for the buttons if not already implemented
    public JButton getAddButton() {
        return addButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
}
