import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.awt.*;
import java.text.SimpleDateFormat;

public class CustomerPanel extends JPanel {
    private JTextField idField, firstNameField, lastNameField, emailField, phoneField, sexField, birthdayField;
    private JButton addButton, updateButton, deleteButton;
    private JPasswordField passwordField;
     private JTable customersTable;
    private DefaultTableModel customersTableModel;

    public CustomerPanel() {
        setLayout(new GridLayout(0, 2, 10, 20)); // Use a grid layout
        initializeComponents();
       // initializeCustomersTable();
    }

    private void initializeComponents() {
        // Define preferred size for text fields
        Dimension textFieldDimension = new Dimension(100, 20); // Smaller width and height
        // Define font for text fields
        Font textFieldFont = new Font("Arial", Font.PLAIN, 10);
        
        // Define preferred size for buttons
        Dimension buttonSize = new Dimension(80, 25);
        // Define margin for buttons
        Insets buttonMargin = new Insets(2, 5, 2, 5);
    
     
    
        // First Name Field
        add(new JLabel("First Name:"));
        firstNameField = new JTextField(20);
        firstNameField.setPreferredSize(textFieldDimension);
        firstNameField.setFont(textFieldFont);
        add(firstNameField);
    
        // Last Name Field
        add(new JLabel("Last Name:"));
        lastNameField = new JTextField(20);
        lastNameField.setPreferredSize(textFieldDimension);
        lastNameField.setFont(textFieldFont);
        add(lastNameField);
    
        // Email Field
        add(new JLabel("Email:"));
        emailField = new JTextField(20);
        emailField.setPreferredSize(textFieldDimension);
        emailField.setFont(textFieldFont);
        add(emailField);
    
        // Phone Field
        add(new JLabel("Phone:"));
        phoneField = new JTextField(20);
        phoneField.setPreferredSize(textFieldDimension);
        phoneField.setFont(textFieldFont);
        add(phoneField);
    
        // Sex Field
        add(new JLabel("Sex:"));
        sexField = new JTextField(20);
        sexField.setPreferredSize(textFieldDimension);
        sexField.setFont(textFieldFont);
        add(sexField);
    
        // Birthday Field
        add(new JLabel("Birthday:"));
        birthdayField = new JTextField(20);
        birthdayField.setPreferredSize(textFieldDimension);
        birthdayField.setFont(textFieldFont);
        add(birthdayField);
    
        // Password Field
        add(new JLabel("Password:"));
        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(textFieldDimension);
        passwordField.setFont(textFieldFont);
        add(passwordField);
    
        // Adding buttons with adjusted sizes and margins
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
    
        addButton.setPreferredSize(buttonSize);
        addButton.setMargin(buttonMargin);
    
        updateButton.setPreferredSize(buttonSize);
        updateButton.setMargin(buttonMargin);
    
        deleteButton.setPreferredSize(buttonSize);
        deleteButton.setMargin(buttonMargin);
    
        // Assuming there's a panel or a method to add these buttons
        add(addButton);
        add(updateButton);
        add(deleteButton);
    
        initializeCustomersTable(); // Assuming this method sets up the customers table
    }
    

    public Customer getCustomerDetails() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedBirthday = sdf.parse(birthdayField.getText());
            java.sql.Date sqlBirthday = new java.sql.Date(parsedBirthday.getTime());
            
            // Pass a placeholder for the hashed password since it's not relevant at this stage.
            // The actual hashing and storage of the hashed password will be handled in CustomerDAO when adding/updating the customer.
            return new Customer(
                firstNameField.getText(),
                lastNameField.getText(),
                emailField.getText(),
                phoneField.getText(),
                sexField.getText(),
                sqlBirthday,
                new String(passwordField.getPassword()), // This is the plaintext password.
                "" // Placeholder for the hashed password
            );
        } catch (Exception e) {
            showMessage("Error: " + e.getMessage());
            return null;
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


    private void initializeCustomersTable() {
        String[] columnNames = {"ID", "First Name", "Last Name", "Email", "Phone", "Sex", "Birthday"};
        customersTableModel = new DefaultTableModel(columnNames, 0);
        customersTable = new JTable(customersTableModel);
        JScrollPane scrollPane = new JScrollPane(customersTable);
        this.add(scrollPane, BorderLayout.CENTER);
    }

/* 
    public void displayAccounts(List<Account> accounts) {
        accountsTableModel.setRowCount(0); // Clear existing rows
        
        for (Account account : accounts) {
            Object[] row = new Object[] {
                account.getAcctNum(),
                account.getCustNum(),
                account.getBalance(),
                account.getType(),
                account.getIntRate()
            };
            accountsTableModel.addRow(row);
        }
    }

    */
    public void displayCustomers(List<Customer> customers) {
        // Make sure the customersTableModel is not null before attempting to set row count
        //if(customersTableModel != null) {
            customersTableModel.setRowCount(0); // Clear the table before adding new data
            for (Customer customer : customers) {
                Object[] row = new Object[] {
                        customer.getId(),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getEmail(),
                        customer.getPhone(),
                        customer.getSex(),
                        new SimpleDateFormat("yyyy-MM-dd").format(customer.getBirthday())
                };
                customersTableModel.addRow(row);
            }
        //}
    }
}
