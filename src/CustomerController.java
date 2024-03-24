
import org.mindrot.jbcrypt.BCrypt;

public class CustomerController {
    private CustomerPanel view;
    private CustomerDAO customerDAO;

    public CustomerController(CustomerPanel view) {
        this.view = view;
        this.customerDAO = new CustomerDAO();
        initController();
    }

    private void initController() {
        view.getAddButton().addActionListener(e -> addCustomer());
        view.getUpdateButton().addActionListener(e -> updateCustomer());
        view.getDeleteButton().addActionListener(e -> deleteCustomer());
    }


    public CustomerPanel getView() {
        return view;
    }

    public void setView(CustomerPanel view) {
        this.view = view;
    }

    
    private void addCustomer() {
        Customer customer = view.getCustomerDetails();
        if (customer != null) {
            // Hash the password before adding the customer
            String hashedPassword = BCrypt.hashpw(customer.getPassword(), BCrypt.gensalt());
            customer.setHashedPassword(hashedPassword); // Ensure Customer class has this setter
    
            customerDAO.addCustomer(customer);
            view.showMessage("Customer signed up successfully");
        }
    }
    

    private void updateCustomer() {
        Customer customer = view.getCustomerDetails();
        if (customer != null) {
            customerDAO.updateCustomer(customer);
            view.showMessage("Customer updated successfully");
        }
    }

    private void deleteCustomer() {
        String email = view.getCustomerEmail();
        customerDAO.deleteCustomer(email);
        view.showMessage("Customer deleted successfully");
    }



    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }




    
}
