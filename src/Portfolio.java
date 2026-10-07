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
        writer.write("<html>");
        writer.write("<head><title>Portfolio Report</title></head>");
        writer.write("<body>");
        writer.write("<h1>Portfolio Report</h1>");

        for (Account account : accounts) {
            writer.write("<h2>Account: " + account.getAccountHolderFirstName() + " " + account.getAccountHolderLastName() + "</h2>");
            writer.write("<pre>" + account.generateReport() + "</pre>");
        }

        writer.write("<h2>Total Portfolio Value: " + getTotalValue() + "</h2>");
        writer.write("</body>");
        writer.write("</html>");
        writer.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

}

