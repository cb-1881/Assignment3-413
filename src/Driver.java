import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Driver {
    public static void main(String[] args) {
        EmployeeManagementWindow();
        customerManagementWindow();
        accountManagementWindow();
        transactionManagementWindow();
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

}
