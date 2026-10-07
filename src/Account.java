abstract class Account {
    private String accountNumber;
    private String accountHolderFirstName;
    private String accountHolderLastName;
    private String mailingAddress;

    public Account(String accountNumber, String accountHolderFirstName, String accountHolderLastName, String mailingAddress) {
        this.accountNumber = accountNumber;
        this.accountHolderFirstName = accountHolderFirstName;
        this.accountHolderLastName = accountHolderLastName;
        this.mailingAddress = mailingAddress;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderFirstName(){
        return accountHolderFirstName;
    }

    public String getAccountHolderLastName(){
        return accountHolderLastName;
    }

    public String getMailingAddress(){
        return mailingAddress;
    }
    public void setRealTimeFeed(RealTimeFeed realTimeFeed){
        //This is empty now but will be filled in later.
    }
    abstract double getAccountValue();
    abstract String generateReport();
}
