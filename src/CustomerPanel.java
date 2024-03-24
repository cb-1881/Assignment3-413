import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class CustomerPanel extends JPanel {
    private JTextField idField, firstNameField, lastNameField, emailField, phoneField, sexField, birthdayField;
    private JButton addButton, updateButton, deleteButton;

    public CustomerPanel() {
        setLayout(new GridLayout(0, 2, 10, 10)); // Use a grid layout
        initializeComponents();
    }

    private void initializeComponents() {
        // ID - Assuming you're using it for something, otherwise you might not need this field
        add(new JLabel("ID:"));
        idField = new JTextField(20);
        add(idField);

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

        // Buttons for operations
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        add(addButton);
        add(updateButton);
        add(deleteButton);
    }

public Customer getCustomerDetails() {
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parsedBirthday = sdf.parse(birthdayField.getText());
        java.sql.Date sqlBirthday = new java.sql.Date(parsedBirthday.getTime());

        return new Customer(
            idField.getText(), // Assuming an ID field is used for something; you might not need this for creation
            firstNameField.getText(),
            lastNameField.getText(),
            emailField.getText(),
            phoneField.getText(),
            sexField.getText(),
            sqlBirthday // Now correctly using java.sql.Date
          
        );
    } catch (Exception e) {
        showMessage("Error parsing date or number format: " + e.getMessage());
        return null; // Or handle more gracefully
    }
}


    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    // Getters for the buttons and other input fields if necessary
    public JButton getAddButton() {
        return addButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
    
    public String getCustomerEmail() {
        return emailField.getText();
    }
}
