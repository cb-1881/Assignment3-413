
import java.util.Date;

public class Transaction {
    private Date dateAndTime;
    private String tranType;
    private double amount;
    private String description;
    private String refID;
    private String acctId;


    
    public Transaction(Date dateAndTime, String tranType, double amount, String description, String refID,
            String acctId) {
        this.dateAndTime = dateAndTime;
        this.tranType = tranType;
        this.amount = amount;
        this.description = description;
        this.refID = refID;
        this.acctId = acctId;
    }
    public Date getDateAndTime() {
        return dateAndTime;
    }
    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
    public String getTranType() {
        return tranType;
    }
    public void setTranType(String tranType) {
        this.tranType = tranType;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getRefID() {
        return refID;
    }
    public void setRefID(String refID) {
        this.refID = refID;
    }
    public String getAcctId() {
        return acctId;
    }
    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    // Constructors, getters, and setters
}

