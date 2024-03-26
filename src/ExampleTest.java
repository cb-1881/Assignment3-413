import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ExampleTest {

    public static void main(String[] args) {
        //CustomerDAO customerDAO = new CustomerDAO();
       // AccountDAO accountDAO = new AccountDAO();
        
        // Delete all entries
       // accountDAO.deleteAllAccounts(); // Delete accounts first due to foreign key constraint
        //customerDAO.deleteAllCustomers();

    
        generateRandomCustomers();
       generateRandomAccounts();

    }

    // Helper methods to generate random attributes
    private static String generateRandomString() {
        String[] names = {"Alice", "Bob", "Charlie", "Diana", "Edward"};
        return names[new Random().nextInt(names.length)];
    }

    private static String generateRandomEmail() {
        String[] domains = {"example.com", "test.com", "demo.com"};
        return generateRandomString().toLowerCase() + "@" + domains[new Random().nextInt(domains.length)];
    }

    private static String generateRandomPhoneNumber() {
        Random random = new Random();
        int num = 100000000 + random.nextInt(900000000);
        return String.valueOf(num);
    }

    private static String generateRandomSex() {
        return new Random().nextBoolean() ? "Male" : "Female";
    }

    private static Date generateRandomDate() {
        long millis = -946771200000L + (Math.abs(new Random().nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
        return new Date(millis);
    }

    private static String generateRandomPassword() {
        return "pass" + new Random().nextInt(1000);
    }


  public static void generateRandomCustomers(){


    CustomerDAO customerDAO = new CustomerDAO();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    // Create 5 random customers and add them to the database
    for (int i = 0; i < 5; i++) {
        Customer customer = new Customer(
            generateRandomString(), // First Name
            generateRandomString(), // Last Name
            generateRandomEmail(),  // Email
            generateRandomPhoneNumber(), // Phone
            generateRandomSex(), // Sex
            new java.sql.Date(generateRandomDate().getTime()), // Birthday
            generateRandomPassword(), // Password (plaintext)
            "" // Hashed password placeholder
        );
        
        // Hash the plaintext password before storing it
        // In a real-world scenario, you should hash the password here
        customerDAO.addCustomer(customer);
    }

    System.out.println("5 Random Customers added successfully!");

    // Retrieve and print all customers
    List<Customer> customers = customerDAO.getAllCustomers();
    System.out.println("Listing all customers:");
    for (Customer cust : customers) {
        System.out.println("Name: " + cust.getFirstName() + " " + cust.getLastName() +
                ", Email: " + cust.getEmail() + ", Phone: " + cust.getPhone() +
                ", Sex: " + cust.getSex() + ", Birthday: " + cust.getBirthday());
    }
}

// Helper methods to generate random attributes


  
    public static void generateRandomAccounts() {
        AccountDAO accountDAO = new AccountDAO();
        CustomerDAO customerDAO = new CustomerDAO(); // Assuming you have a method to get all customers
        List<Customer> customers = customerDAO.getAllCustomers();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Random random = new Random();
    
        if (customers.size() > 0) {
            for (int i = 0; i < 5; i++) {
                // Select a random customer
                Customer customer = customers.get(random.nextInt(customers.size()));
                
                // Generate account details
                String acctType = random.nextBoolean() ? "Chk" : "Sav"; // Use abbreviations for account types
                String custNum = customer.getId(); // Use customer ID as cust_num
                double balance = random.nextDouble() * 10000; // Random balance
                double odLimit = "Chk".equals(acctType) ? 500 : 0; // Overdraft, 0 for "Sav"
                double intRate = "Sav".equals(acctType) ? 1.5 : 0.5; // Interest rate
                
                // Use current date for createDate and lastUpdateDate
                Date now = new Date();
                Account account = new Account(null, custNum, balance, now, now, acctType, odLimit, intRate);
                
                // Add account to the database
                accountDAO.addAccount(account);
            }
            System.out.println("5 Random Bank Accounts added successfully!");
        } else {
            System.out.println("No customers found in database to associate with bank accounts.");
        }
    }
    
}
  

