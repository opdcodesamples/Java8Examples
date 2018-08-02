package java8.functionalinterface;

class UnitsConvertorTest {

	public static void main(String[] args) {
		
		UnitsConverter convertor = new UnitsConverter();
		
		Converter<Double, Double> convertKmToMile = convertor::getMile;
		Double mile = convertKmToMile.convert(265D);
		System.out.println("Mile: " + mile);
		
		Converter<Double, Double> convertMileToKm = convertor::getKm;
		Double km = convertMileToKm.convert(164.663315D);
		System.out.println("KM: " + km);

	}

}
