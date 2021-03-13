package java8.functionalinterface;

import java.util.function.Function;

class LambdaScopes {
	
	int instanceVar = 1;
	static int classVar = 1;
	
	public static void main(String[] args) {
		int localVar = 2;
		LambdaScopes scopes = new LambdaScopes();
		// lambda can read and write to instance and static variables
		// though lambda can read local variables but it cannot write / alter local variables
		Function<Integer,Integer> add = (x) -> { 
												scopes.instanceVar++; 
												classVar++; 
												//localVar++; // can't do this
												return x + scopes.instanceVar + classVar + localVar;
												};
		
		System.out.println("Integer Converted to String: " + add.apply(60));
	}

}
