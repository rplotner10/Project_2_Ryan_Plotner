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

    public String getMailingAddress() {
        return mailingAddress;
    }

    abstract double getAccountValue();
}
