package java8.functionalinterface;

class LambdaScopes {
	
	private final int num = 1;
	public static void main(String[] args) {
		
		LambdaScopes scopes = new LambdaScopes();
		// lambda can access instance variables as well as static variables
		Converter<String,String> converter = (from) -> String.valueOf(from + scopes.num);
		
		System.out.println("Integer Converted to String: " + converter.convert("34"));
	}

}
