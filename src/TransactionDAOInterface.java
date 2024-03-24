import java.util.List;

public interface TransactionDAOInterface {
    void addTransaction(Transaction transaction);
    Transaction getTransaction(String id);
    void updateTransaction(Transaction transaction);
    void deleteTransaction(String id);
    List<Transaction> getAllTransactions();
}
