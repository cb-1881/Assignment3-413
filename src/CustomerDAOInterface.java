
import java.util.List;
//import java.sql.*;


    public interface CustomerDAOInterface {
    void addCustomer(Customer customer);
    Customer getCustomer(String id);
    void updateCustomer(Customer customer);
    void deleteCustomer(String id);
    List<Customer> getAllCustomers();
}
