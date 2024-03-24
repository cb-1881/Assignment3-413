import java.util.List;

public interface AccountDAOInterface {
    void addAccount(Account account);
    Account getAccount(String acctNum);
    void updateAccount(Account account);
    void deleteAccount(String acctNum);
    List<Account> getAllAccounts();
}
