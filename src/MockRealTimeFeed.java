import java.util.ArrayList;
import java.io.FileInputStream;
public class MockRealTimeFeed implements RealTimeFeed{
   
    private ArrayList<String> tickerSymbols = new ArrayList<>();
    private ArrayList<Double> currentValues = new ArrayList<>();

    //Created a constructor that reads in both file paths
    public MockRealTimeFeed(String filePath){
        try {
            FileInputStream fis = new FileInputStream(filePath);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public double getCurrentValue(String tickerSymbol){
        for(int i = 0; i < tickerSymbols.size(); i++){
            if(tickerSymbols.get(i).equals(tickerSymbol)){
                return currentValues.get(i);
            }
        }
        System.out.println("Ticker symbol not found.");
        return 0.0;
    }



}
 