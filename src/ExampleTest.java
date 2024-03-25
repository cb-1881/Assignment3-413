import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ExampleTest {

    public static void main(String[] args) {
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
}
