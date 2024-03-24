import javax.swing.*;
import java.awt.*;
//import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;

public class AccountPanel extends JPanel {
    private JTextField acctNumField, custNumField, balanceField, createDateField, lastUpdateDateField, typeField, odLimitField, intRateField;
    private JButton addButton, updateButton, deleteButton;

    public AccountPanel() {
        setLayout(new GridLayout(0, 2, 10, 10)); // Use a grid layout
        initializeComponents();
    }

    private void initializeComponents() {
        // Initialize all the components and fields here
        // For example:
        acctNumField = new JTextField(20);
        custNumField = new JTextField(20);
        balanceField = new JTextField(20);
        
        // Set current date for createDateField and lastUpdateDateField
        createDateField = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        lastUpdateDateField = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        
        typeField = new JTextField(20);
        odLimitField = new JTextField(20);
        intRateField = new JTextField(20);
        
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        
        // Add all the components to the panel
        add(new JLabel("Account Number:"));
        add(acctNumField);
        add(new JLabel("Customer Number:"));
        add(custNumField);
        add(new JLabel("Balance:"));
        add(balanceField);
        add(new JLabel("Create Date:"));
        add(createDateField);
        add(new JLabel("Last Update Date:"));
        add(lastUpdateDateField);
        add(new JLabel("Type:"));
        add(typeField);
        add(new JLabel("OD Limit:"));
        add(odLimitField);
        add(new JLabel("Interest Rate:"));
        add(intRateField);
        
        add(addButton);
        add(updateButton);
        add(deleteButton);
    }
    public Account getAccountDetails() {
        try {
           // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //java.util.Date parsedCreateDate = sdf.parse(createDateField.getText());
            //java.util.Date parsedLastUpdateDate = sdf.parse(lastUpdateDateField.getText());

            java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

            return new Account(
                    acctNumField.getText(),
                    custNumField.getText(),
                    Double.parseDouble(balanceField.getText()),
                    currentDate, // Set current date as creation date
                    // For lastUpdateDateField, decide if you want to use the current date
                    // or handle it in a different manner
                    currentDate, // This can be set the same way if you wish
                    typeField.getText(),
                    Double.parseDouble(odLimitField.getText()),
                    Double.parseDouble(intRateField.getText())
            );
        } catch (Exception e) {
            showMessage("Error parsing date or number format: " + e.getMessage());
            System.out.println("Error parsing date or number format: " + e.getMessage());
            return null; // Or handle more gracefully
        }
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    // Getters for buttons
    public JButton getAddButton() {
        return addButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

  
    public String getAccountNumber() {
        return acctNumField.getText(); // Retrieves the account number as a String
    }


    public void setAcctNumField(JTextField acctNumField) {
        this.acctNumField = acctNumField;
    }

    public JTextField getCustNumField() {
        return custNumField;
    }

    public void setCustNumField(JTextField custNumField) {
        this.custNumField = custNumField;
    }

    public JTextField getBalanceField() {
        return balanceField;
    }

    public void setBalanceField(JTextField balanceField) {
        this.balanceField = balanceField;
    }

    public JTextField getCreateDateField() {
        return createDateField;
    }

    public void setCreateDateField(JTextField createDateField) {
        this.createDateField = createDateField;
    }

    public JTextField getLastUpdateDateField() {
        return lastUpdateDateField;
    }

    public void setLastUpdateDateField(JTextField lastUpdateDateField) {
        this.lastUpdateDateField = lastUpdateDateField;
    }

    public JTextField getTypeField() {
        return typeField;
    }

    public void setTypeField(JTextField typeField) {
        this.typeField = typeField;
    }

    public JTextField getOdLimitField() {
        return odLimitField;
    }

    public void setOdLimitField(JTextField odLimitField) {
        this.odLimitField = odLimitField;
    }

    public JTextField getIntRateField() {
        return intRateField;
    }

    public void setIntRateField(JTextField intRateField) {
        this.intRateField = intRateField;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public void setUpdateButton(JButton updateButton) {
        this.updateButton = updateButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }


}
