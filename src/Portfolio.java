import java.util.ArrayList;
import java.util.List;

public class Portfolio {

    private List<Account> accounts;
    private RealTimeFeed realTimeFeed;

    public Portfolio(RealTimeFeed realTimeFeed) {

        this.realTimeFeed = realTimeFeed;
        this.accounts = new ArrayList<>();
    }


    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public double getTotalValue() {
        double total = 0.0;
        for (Account account : accounts) {
            total += account.getAccountValue();
        }
     
        return total;

    }

    public void generateReport(String fileName) {
        for (Account account : accounts) {
            System.out.println("Account: " + account.getAccountHolderFirstName() + " " + account.getAccountHolderLastName() + ", Value: " + account.getAccountValue());
        }
        System.out.println("Total Portfolio Value: " + getTotalValue());
    }

}
