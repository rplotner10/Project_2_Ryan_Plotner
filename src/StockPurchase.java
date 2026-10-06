public class StockPurchase {
    private String stockName;
    private String tickerSymbol;
    private double purchasePrice;
    private int numberOfShares;

    public StockPurchase(String stockName, String tickerSymbol, double purchasePrice, int numberOfShares) {
        this.stockName = stockName;
        this.tickerSymbol = tickerSymbol;
        this.purchasePrice = purchasePrice;
        this.numberOfShares = numberOfShares;
    }
 
    public String getStockName() {
        return stockName;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }
}
