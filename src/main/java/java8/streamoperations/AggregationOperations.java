package java8.streamoperations;

import java.util.Arrays;
import java.util.stream.Stream;

import java8.models.Stock;
import java8.streamoperations.data.StockDataGenerator;

public class AggregationOperations {

	public static void main(String[] args) {
		Stock[] stocks = StockDataGenerator.getStockFeed();
		Stream<Stock> stream = Arrays.stream(stocks);
		
		stream.forEach(System.out::println);

	}

}
