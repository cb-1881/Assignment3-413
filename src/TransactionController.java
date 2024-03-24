public class TransactionController {
    private TransactionPanel view;
    private TransactionDAO transactionDAO;

    public TransactionController(TransactionPanel view) {
        this.view = view;
        this.transactionDAO = new TransactionDAO();
        initController();
    }

    private void initController() {
        view.getAddButton().addActionListener(e -> addTransaction());
        view.getUpdateButton().addActionListener(e -> updateTransaction());
        view.getDeleteButton().addActionListener(e -> deleteTransaction());
    }

    

    private void addTransaction() {
        Transaction transaction = view.getTransactionDetails();
        transactionDAO.addTransaction(transaction);
        view.showMessage("Transaction added successfully");
    }

    private void updateTransaction() {
        Transaction transaction = view.getTransactionDetails();
        transactionDAO.updateTransaction(transaction);
        view.showMessage("Transaction updated successfully");
    }

    private void deleteTransaction() {
        String refID = view.getTransactionRefID();
        transactionDAO.deleteTransaction(refID);
        view.showMessage("Transaction deleted successfully");
    }

    public TransactionPanel getView() {
        return view;
    }

    public void setView(TransactionPanel view) {
        this.view = view;
    }

    public TransactionDAO getTransactionDAO() {
        return transactionDAO;
    }

    public void setTransactionDAO(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }
}
