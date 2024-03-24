
import java.util.Date;

public class Account {
    private String acctNum;
    private String custNum;
    private double balance;
    private Date createDate;
    private Date lastUpdateDate;
    private String type;
    private double odLimit;
    private double intRate;



    public Account(String acctNum, String custNum, double balance, Date createDate, Date lastUpdateDate, String type,
            double odLimit, double intRate) {
        this.acctNum = acctNum;
        this.custNum = custNum;
        this.balance = balance;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.type = type;
        this.odLimit = odLimit;
        this.intRate = intRate;
    }
    public String getAcctNum() {
        return acctNum;
    }
    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }
    public String getCustNum() {
        return custNum;
    }
    public void setCustNum(String custNum) {
        this.custNum = custNum;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getOdLimit() {
        return odLimit;
    }
    public void setOdLimit(double odLimit) {
        this.odLimit = odLimit;
    }
    public double getIntRate() {
        return intRate;
    }
    public void setIntRate(double intRate) {
        this.intRate = intRate;
    }

    // Constructors, getters, and setters
}
