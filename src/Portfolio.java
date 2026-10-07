import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.io.FileWriter;

public class Portfolio {

    private List<Account> accounts;
    private RealTimeFeed realTimeFeed;

    public Portfolio(RealTimeFeed realTimeFeed) {

        this.realTimeFeed = realTimeFeed;
        this.accounts = new ArrayList<>();
    }


    public void addAccount(Account account) {
        account.setRealTimeFeed(realTimeFeed);
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
        accounts.sort(Comparator.comparingDouble(Account::getAccountValue).reversed());
        try {
        FileWriter writer = new FileWriter(fileName);
        for (Account account : accounts) {
            writer.write(account.generateReport());
        }
        writer.write("Total Portfolio Value: " + getTotalValue() + "\n");

        writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


}

