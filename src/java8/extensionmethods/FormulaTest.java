package java8.extensionmethods;

class FormulaTest {
	public static void main(String[] a){
		
		Formula formula = new Formula() {

			@Override
			public double calculate(int a) {
				return sqrt(a + 10);
			}
			
		};
		
		System.out.println("sqrt of 32: " + formula.calculate(22));
	}
}
