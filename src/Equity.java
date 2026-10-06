import java.util.ArrayList;
import java.util.List;

public class Equity extends Account{
    
    private List<StockPurchase> purchaseStock;

    public Equity(String accountNumber, String accountHolderFirstName, String accountHolderLastName, String mailingAddress) {
        super(accountNumber, accountHolderFirstName, accountHolderLastName, mailingAddress);
        this.purchaseStock = new ArrayList<StockPurchase>();
    }


    public void purchaseStock(String stockName, String tickerSymbol, double purchasePrice, int numberOfShares){
        StockPurchase newPurchase = new StockPurchase(stockName, tickerSymbol, purchasePrice, numberOfShares);
        this.purchaseStock.add(newPurchase);
    }
}
