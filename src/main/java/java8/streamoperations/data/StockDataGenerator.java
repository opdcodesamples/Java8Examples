package java8.streamoperations.data;

import java.text.DecimalFormat;
import java.util.Calendar;

import java8.streamoperations.models.Stock;

public class StockDataGenerator {
	
	private static double MAX_TICKER_PRICE = 200;
	private static double MIN_TICKER_PRICE = 60;
	
	private static int MAX_NUM_OF_DAYS = 365;
	
	private static DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("#.##");
	
	public static Stock[] getStockFeed () {
		
		String[] tickernames = new String[] {"APPL","T","CITI","AIZ","IBM","GOOGLE"};
		Stock[] stocks = new Stock[MAX_NUM_OF_DAYS * tickernames.length];
		
		for(int count = 0; count < tickernames.length; ++count) {
			
			String ticker = tickernames[count];
			System.out.println("setting data for: " + ticker);
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -MAX_NUM_OF_DAYS);
			
			for(int i=0;i<MAX_NUM_OF_DAYS; ++i) {
				Stock stock = new Stock();
				
				double tickerPrice = (Math.random() * ((MAX_TICKER_PRICE - MIN_TICKER_PRICE) + 1)) + MIN_TICKER_PRICE;
				double formattedPrice  = Double.valueOf(DECIMAL_FORMATTER.format(tickerPrice));
				
				cal.add(Calendar.DATE, 1);
				System.out.println("" + cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH) +1) + "/" + cal.get(Calendar.DATE));
			
				
				stock.setTicker(ticker);
				stock.setTickerprice(formattedPrice);
				stock.setTickerDate(cal.getTime());
				
				stocks[(count*MAX_NUM_OF_DAYS) + i] = stock;
				
			}
			
		}
		
		return stocks;
		
	}

}
