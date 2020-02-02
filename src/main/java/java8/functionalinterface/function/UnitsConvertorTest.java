package java8.functionalinterface.function;

import java.util.function.Function;

class UnitsConvertorTest {

	public static void main(String[] args) {
		
		UnitsConverter convertor = new UnitsConverter();
		
		Function<Double, Double> convertKmToMile = convertor::getMile;
		Double mile = convertKmToMile.apply(20D);
		System.out.println("Mile: " + mile);
		
		Function<Double, Double> convertMileToKm = convertor::getKm;
		Double km = convertMileToKm.apply(12.43D);
		System.out.println("KM: " + km);

	}

}
