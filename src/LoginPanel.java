import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private CustomerDAO customerDAO;

    public LoginPanel(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridLayout(3, 2, 10, 10));
        
        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);
        
        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);
        
        loginButton = new JButton("Login");
        loginButton.addActionListener(e -> authenticateCustomer());
        add(loginButton);
    }
    
    private void authenticateCustomer() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        
        if (customerDAO.authenticateCustomer(email, password)) {
            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Proceed to the next part of your application
        } else {
            JOptionPane.showMessageDialog(this, "Invalid email or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
