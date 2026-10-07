import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
public class MockRealTimeFeed implements RealTimeFeed{
   
    private ArrayList<String> tickerSymbols = new ArrayList<>();
    private ArrayList<Double> currentValues = new ArrayList<>();

    //Created a constructor that reads in both file paths
    public MockRealTimeFeed(String filePath){
        try {
            FileReader fr = new FileReader(filePath);
            //read the file
            BufferedReader br = new BufferedReader(fr);
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                int commaIndex = line.indexOf(' ');
                if (commaIndex != -1) {
                    String ticker = line.substring(0, commaIndex);
                    String valueStr = line.substring(commaIndex + 1);
                    tickerSymbols.add(ticker);
                    currentValues.add(Double.parseDouble(valueStr));
                }
            }
            br.close();
            

             
            
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
 