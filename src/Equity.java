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

}
