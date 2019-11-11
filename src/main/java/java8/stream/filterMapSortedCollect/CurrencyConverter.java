package java8.stream.filterMapSortedCollect;

class CurrencyConverter {
	
	// to USD
	public Transaction getUSD(Transaction transaction){
		
		String currency = transaction.getCurrency();
		double usdValue;
		
		switch(currency){
		case "USD":
			usdValue = transaction.getValue();
			break;
		case "INR":
			usdValue = transaction.getValue() * 0.015;
			break;
		case "GBP":
			usdValue = transaction.getValue() * 1.25;
			break;
		case "YEN":
			usdValue = transaction.getValue() * 0.0090;
			break;
		default:
			usdValue = 0.00000000001;
		}
		
		transaction.setUsdValue(usdValue);
		return transaction;
	}
	
	
}
