import java.util.ArrayList;

public class Checking extends Account{
    private double balance;

    ArrayList<Transaction> transactions;

    public Checking(String accountNumber, String accountHolderFirstName, String accountHolderLastName, String mailingAddress) {
        super(accountNumber, accountHolderFirstName, accountHolderLastName, mailingAddress);
        this.balance = 0.0;
        this.transactions = new ArrayList<Transaction>();
    }

    public double getBalance() {
        return balance;
    }

    public double getAccountValue() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("deposit", amount));
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) {
        balance -= amount;
        transactions.add(new Transaction("withdraw", amount));
        System.out.println("Withdrew: " + amount);
    }

    public void genTransactionHistory() {
        System.out.println("Transaction history for account: " + getAccountNumber());
        System.out.println("First Name: " + getAccountHolderFirstName());
        System.out.println("Last Name: " + getAccountHolderLastName());
        System.out.println("Mailing Address: " + getMailingAddress());
        for (Transaction t : transactions) {
            System.out.println(t.getType() + ": " + t.getAmount());
        }
        System.out.println("Current Balance: " + getBalance());
    }
    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("Account: ").append(getAccountNumber()).append("\n");
        report.append("First Name: ").append(getAccountHolderFirstName()).append("\n");
        report.append("Last Name: ").append(getAccountHolderLastName()).append("\n");
        report.append("Mailing Address: ").append(getMailingAddress()).append("\n");
        report.append("Current Balance: ").append(getBalance()).append("\n");
        report.append("Transaction History:\n");
        for (Transaction t : transactions) {
            report.append(t.getType()).append(": ").append(t.getAmount()).append("\n");
        }
        return report.toString();
    }
}
