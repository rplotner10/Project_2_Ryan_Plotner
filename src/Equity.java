import java.util.ArrayList;
import java.util.List;

public class Equity extends Account{
    
    private RealTimeFeed realTimeFeed;
    private List<StockPurchase> purchaseStock;

    public Equity(String accountNumber, String accountHolderFirstName, String accountHolderLastName, String mailingAddress) {
        super(accountNumber, accountHolderFirstName, accountHolderLastName, mailingAddress);
        this.purchaseStock = new ArrayList<StockPurchase>();
    }


    public void purchaseStock(String stockName, String tickerSymbol, double purchasePrice, int numberOfShares){
        StockPurchase newPurchase = new StockPurchase(stockName, tickerSymbol, purchasePrice, numberOfShares);
        this.purchaseStock.add(newPurchase);
    }

    @Override
    public void setRealTimeFeed(RealTimeFeed realTimeFeed) {
        this.realTimeFeed = realTimeFeed;
    }

    public double getAccountValue() {
        double totalValue = 0.0;
        for (StockPurchase purchase : purchaseStock) {
            double currentPrice = realTimeFeed.getCurrentValue(purchase.getTickerSymbol());
            totalValue += currentPrice * purchase.getNumberOfShares();
        }
        return totalValue;
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("Account: ").append(getAccountNumber()).append("\n");
        report.append("First Name: ").append(getAccountHolderFirstName()).append("\n");
        report.append("Last Name: ").append(getAccountHolderLastName()).append("\n");
        report.append("Mailing Address: ").append(getMailingAddress()).append("\n");
        report.append("Current Portfolio Value: ").append(getAccountValue()).append("\n");
        report.append("Stock Purchases:\n");
        for (StockPurchase purchase : purchaseStock) {
            report.append(purchase.getStockName()).append(" (").append(purchase.getTickerSymbol()).append(") - ");
            report.append("Purchase Price: ").append(purchase.getPurchasePrice()).append(", ");
            report.append("Number of Shares: ").append(purchase.getNumberOfShares()).append("\n");
        }
        return report.toString();
    }

}
