package java8.stream.collect.transactionexample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class TransactionTest {

	public static void main(String[] args) {
		List<Transaction> transactionList = new ArrayList<>();
		
		transactionList.add(new Transaction(30000, "INR"));
		transactionList.add(new Transaction(30021, "INR"));
		transactionList.add(new Transaction(30021, "INR"));
		transactionList.add(new Transaction(40021, "INR"));
		transactionList.add(new Transaction(65421, "INR"));
		transactionList.add(new Transaction(55021, "INR"));
		
		transactionList.add(new Transaction(30000, "USD"));
		transactionList.add(new Transaction(30021, "USD"));
		transactionList.add(new Transaction(30021, "USD"));
		transactionList.add(new Transaction(40021, "USD"));
		transactionList.add(new Transaction(65421, "USD"));
		transactionList.add(new Transaction(55021, "USD"));
		
		transactionList.add(new Transaction(30000, "GBP"));
		transactionList.add(new Transaction(30021, "GBP"));
		transactionList.add(new Transaction(30021, "GBP"));
		transactionList.add(new Transaction(40021, "GBP"));
		transactionList.add(new Transaction(65421, "GBP"));
		transactionList.add(new Transaction(55021, "GBP"));
		
		transactionList.add(new Transaction(30000, "YEN"));
		transactionList.add(new Transaction(30021, "YEN"));
		transactionList.add(new Transaction(30021, "YEN"));
		transactionList.add(new Transaction(40021, "YEN"));
		transactionList.add(new Transaction(65421, "YEN"));
		transactionList.add(new Transaction(55021, "YEN"));
		
		try{
			System.out.println("\n simply printing USD transactions	");
			transactionList.stream().filter((t) -> "USD".equals(t.getCurrency()) ).forEach(System.out::println);
			
			List<Transaction> usdTransactions = transactionList.stream().filter((t) -> "USD".equals(t.getCurrency()) ).collect(Collectors.toList());
			System.out.println("All USD Transactions: " + usdTransactions);
			
			EquivalentUSDValue equivalentUSDValue = new EquivalentUSDValue();
			Function<Transaction, Transaction> convertToUSD = equivalentUSDValue::getUSDValue;
			
			System.out.println("\n sorting by USD value");
			transactionList.stream().map(convertToUSD::apply).sorted(Comparator.comparingDouble(Transaction::getUsdValue)).forEach(System.out::println);
			
			System.out.println("\n sorting by currency name"); 
			transactionList.stream().map(convertToUSD::apply).sorted(Comparator.comparing(Transaction::getCurrency)).forEach(System.out::println);
			
			System.out.println("\n counting ");
			long bigTransactions = 
					transactionList.stream().filter((t) -> t.getUsdValue() > 40000).count();
			
			System.out.println("Big Transactions count: " + bigTransactions);
			
			System.out.println("\n grouping by currency");
			Map<String, List<Transaction>> bigTransactionsByCurrency = 
					transactionList.stream().filter((Transaction t) -> t.getValue() > 50000).
					collect(Collectors.groupingBy(Transaction::getCurrency));
			
			System.out.println("Big Transactions By Currency: " + bigTransactionsByCurrency);
			
			//map((t) -> Math.round(t.getUsdValue())).
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		

	}

}
