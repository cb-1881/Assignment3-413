import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.*;
//import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver {

    public static void main(String[] args) {
       // Previous window initializations can remain commented out or be used as needed
        //EmployeeManagementWindow();
      // CustomerListingandManagement();
       // customerManagementWindow();
       // LoginWindow();
       createWelcomeWindow();
      //accountListing();
      //initWindow();
       // Other management windows can be initialized here if needed
        //transactionManagementWindow();
    }

    private static void createWelcomeWindow() {
        SwingUtilities.invokeLater(() -> {
            JFrame welcomeFrame = new JFrame("Welcome");
            welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            welcomeFrame.setLayout(new BorderLayout()); // Ensure layout is set to BorderLayout
    
            // Load the original image
            ImageIcon originalIcon = new ImageIcon("images/cat.jpg"); // Adjust path as needed
    
            // Scale the image to the desired size
            Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Set width and height here
    
            // Create a new ImageIcon for JLabel
            ImageIcon imageIcon = new ImageIcon(scaledImage);
    
            // Add the scaled image to a label and add the label to the frame
            JLabel imageLabel = new JLabel(imageIcon);
            welcomeFrame.add(imageLabel, BorderLayout.CENTER);
    
            // Create a "Go" button
            JButton goButton = new JButton("Go");
            goButton.addActionListener(e -> {
                initWindow(); // Open all other windows
                welcomeFrame.dispose(); // Close the welcome window
            });
    
            // Add the button to the SOUTH region of the frame's content pane
            welcomeFrame.getContentPane().add(goButton, BorderLayout.SOUTH);
    
            // Pack the frame or set a fixed size
            welcomeFrame.pack();
            welcomeFrame.setSize(400, 400); // Adjust size as needed to accommodate the image
            welcomeFrame.setLocationRelativeTo(null); // Center the window on the screen
            welcomeFrame.setVisible(true);
        });
    }
    
    public static void initWindow(){
// to show all the windows weve made
CustomerListingandManagement();
accountListing();
LoginWindow();
transactionManagementWindow();

    }

    public static void accountListing() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Account Listing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 800); // Adjust size as needed

            AccountPanel accountPanel = new AccountPanel();
            AccountController accountController = new AccountController(accountPanel);
            frame.add(accountPanel);

            accountController.fetchAndDisplayAccounts(); // This should be called after the AccountPanel is fully initialized

            frame.setLocationRelativeTo(null); // Center the window on the screen
            frame.setVisible(true);
        });
    }


    public static void CustomerListingandManagement() {
        SwingUtilities.invokeLater(() -> {
        JFrame frame = new JFrame("Customer Listing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 800); // Adjust size as needed

        CustomerPanel customerPanel = new CustomerPanel();
        CustomerDAO customerDAO = new CustomerDAO(); // Initialize your CustomerDAO here
        CustomerController customerController = new CustomerController(customerPanel, customerDAO);

        frame.add(customerController.getView());
        customerController.displayAllCustomers();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    });

    }


    public static void EmployeeManagementWindow(){

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Employee Management");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create the view component
            EmployeePanel employeePanel = new EmployeePanel();

            // Create the controller, passing the view to it
            EmployeeController employeeController = new EmployeeController(employeePanel);

            // Add the view component to the JFrame, not the controller
            frame.add(employeeController.getView());

            frame.pack(); // Adjust the window size to fit its content
            frame.setVisible(true);
        });
    }
    public static void customerManagementWindow() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Customer Management");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create the CustomerPanel view component
            CustomerPanel customerPanel = new CustomerPanel();

            // Create the CustomerController, passing the view to it
            CustomerController customerController = new CustomerController(customerPanel);

            // Add the view component to the JFrame
            frame.add(customerController.getView());

            frame.pack(); // Adjust the window size to fit its content
            frame.setVisible(true);
        });
    }

    public static void accountManagementWindow() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("account Management");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create the CustomerPanel view component
            AccountPanel accountPanel = new AccountPanel();

            // Create the CustomerController, passing the view to it
            AccountController accountController = new AccountController(accountPanel);

            // Add the view component to the JFrame
            frame.add(accountController.getView());

            frame.pack(); // Adjust the window size to fit its content
            frame.setVisible(true);
        });
    }

    public static void transactionManagementWindow() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Transaction Management");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create the CustomerPanel view component
            TransactionPanel transactionPanel = new TransactionPanel();

            // Create the CustomerController, passing the view to it
            TransactionController transactionController = new TransactionController(transactionPanel);

            // Add the view component to the JFrame
            frame.add(transactionController.getView());

            frame.pack(); // Adjust the window size to fit its content
            frame.setVisible(true);
        });
    }

    public static void LoginWindow(){

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Customer Login");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);

            CustomerDAO customerDAO = new CustomerDAO();
            LoginPanel loginPanel = new LoginPanel(customerDAO);
            frame.add(loginPanel);

            frame.setLocationRelativeTo(null); // Center the window
            frame.setVisible(true);
        });
    }

}
