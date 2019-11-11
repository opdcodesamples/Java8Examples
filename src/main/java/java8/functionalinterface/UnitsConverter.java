package java8.functionalinterface;

class UnitsConverter {
	
	// KM to Mile
	public double getMile(double km){
		return 0.621371 * km;
	}
	// Mile to KM
	public double getKm(double mile){
		return 1.61 * mile;
	}
	// Litre to Gallon
	public double getGallon(double litre){
		return 0.264172 * litre;
	}
	// Gallon to Litre
	public double getLitre(double gallon){
		return 3.78541 * gallon;
	}
	// Fahrenheit to Celsius
	public double getCelsius(double f){
		return ((f -32) * 5)/9;
	}
	// Celsius to Fahrenheit
	public double getFahrenheit(double c){
		return ((c * 9) / (5)) + 32 ;
	}
	
}
