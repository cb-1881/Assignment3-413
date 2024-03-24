public class AccountController {
    private AccountPanel view;
    private AccountDAO accountDAO;

    public AccountController(AccountPanel view) {
        this.view = view;
        this.accountDAO = new AccountDAO();
        initController();
    }

    private void initController() {
        view.getAddButton().addActionListener(e -> addAccount());
        view.getUpdateButton().addActionListener(e -> updateAccount());
        view.getDeleteButton().addActionListener(e -> deleteAccount());
    }

    

    private void addAccount() {
        Account account = view.getAccountDetails();
        if (account != null) {
            accountDAO.addAccount(account);
            view.showMessage("Account added successfully");
        }
    }

    private void updateAccount() {
        Account account = view.getAccountDetails();
        if (account != null) {
            accountDAO.updateAccount(account);
            view.showMessage("Account updated successfully");
        }
    }

    private void deleteAccount() {
        String acctNum = view.getAccountNumber(); // This method needs to be implemented in AccountPanel
        accountDAO.deleteAccount(acctNum);
        view.showMessage("Account deleted successfully");
    }

    public AccountPanel getView() {
        return view;
    }

    public void setView(AccountPanel view) {
        this.view = view;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
