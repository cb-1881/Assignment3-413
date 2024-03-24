import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.Date;



public class TransactionPanel extends JPanel {

    private JTextField dateAndTimeField, tranTypeField, amountField, descriptionField, refIDField, acctIdField;
    private JButton addButton, updateButton, deleteButton;

    public TransactionPanel() {
        setLayout(new GridLayout(0, 2, 10, 10));
        initializeComponents();
    }

    private void initializeComponents() {
        // Define and add components as shown in EmployeePanel
        // Example:
        add(new JLabel("Date and Time:"));
        dateAndTimeField = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        add(dateAndTimeField);
    
        add(new JLabel("Transaction Type:"));
        tranTypeField = new JTextField(20); // Make sure this line is included
        add(tranTypeField);
    
        add(new JLabel("Amount:"));
        amountField = new JTextField(20);
        add(amountField);
    
        add(new JLabel("Description:"));
        descriptionField = new JTextField(20);
        add(descriptionField);
    
        add(new JLabel("Reference ID:"));
        refIDField = new JTextField(20);
        add(refIDField);
    
        add(new JLabel("Account ID:"));
        acctIdField = new JTextField(20);
        add(acctIdField);
    
        // Initialize buttons
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        add(addButton);
        add(updateButton);
        add(deleteButton);
    }
    

    public Transaction getTransactionDetails() {
        try {
            // Assuming dateAndTimeField's text is in the format "yyyy-MM-dd"
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = sdf.parse(dateAndTimeField.getText());
            java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
    
            return new Transaction(
                sqlDate, // Now correctly using java.sql.Date
                tranTypeField.getText(),
                Double.parseDouble(amountField.getText()),
                descriptionField.getText(),
                refIDField.getText(),
                acctIdField.getText()
            );
        } catch (Exception e) {
            showMessage("Error parsing date: " + e.getMessage());
            System.out.println("Error parsing date: " + e.getMessage());
            return null; // Or handle more gracefully
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public JTextField getDateAndTimeField() {
        return dateAndTimeField;
    }

    public void setDateAndTimeField(JTextField dateAndTimeField) {
        this.dateAndTimeField = dateAndTimeField;
    }

    public JTextField getTranTypeField() {
        return tranTypeField;
    }

    public void setTranTypeField(JTextField tranTypeField) {
        this.tranTypeField = tranTypeField;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public void setAmountField(JTextField amountField) {
        this.amountField = amountField;
    }

    public JTextField getDescriptionField() {
        return descriptionField;
    }

    public void setDescriptionField(JTextField descriptionField) {
        this.descriptionField = descriptionField;
    }

    public JTextField getRefIDField() {
        return refIDField;
    }

    public void setRefIDField(JTextField refIDField) {
        this.refIDField = refIDField;
    }

    public JTextField getAcctIdField() {
        return acctIdField;
    }

    public void setAcctIdField(JTextField acctIdField) {
        this.acctIdField = acctIdField;
    }

    public JButton getAddButton() {
        return addButton;
    }
    
    public JButton getUpdateButton() {
        return updateButton;
    }
    
    public JButton getDeleteButton() {
        return deleteButton;
    }
    
    public String getTransactionRefID() {
        return refIDField.getText();
    }
    


    // Add getters for the buttons
}
