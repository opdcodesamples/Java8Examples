package java8.functionalinterface;

class ConverterTest {
	
	public static void main(String[] a) {
		
		/*Converter<String, Integer> convert = new Converter<String, Integer>() {
			public Integer convert(String s) {
				return Integer.parseInt(s);
			}			
		};*/
		
		// lambda creates a functional interface
		Converter<String, Integer> converter = Integer::parseInt;
		Integer convertedInteger = converter.convert("123");
		System.out.println("converted integer: " + convertedInteger);
		
		// more simplified version
		Converter<String, Integer> converter2 = Integer::valueOf;
		Integer convertedInteger2 = converter2.convert("1233");
		System.out.println("converted integer: " + convertedInteger2);
		
		// lambda with instance methods
		MyStringUtil myStringUtil = new MyStringUtil();
		//Converter<String,Character> strConverter = (from) -> myStringUtil.firstChar(from);
		Converter<String,Character> strConverter = myStringUtil::firstChar;
		System.out.println("first char: " + strConverter.convert("Prashant"));
		
		
	}
}

class MyStringUtil {
	public Character firstChar(String string){
		return string.charAt(0);
	}
}
