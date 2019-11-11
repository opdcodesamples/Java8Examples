package java8.general;

class TestExceptions {

	public static void main(String[] args) {
		try {
			
			int a = Integer.MAX_VALUE;
			int b = Integer.MIN_VALUE;
			
			int c = a + b;
			
			System.out.println(c);
			
			//int d = Integer.parseInt(a) + Integer.parseInt(b);
			//System.out.println(d);
			
			int e = Math.addExact(a, b);
			System.out.println(e);
			
			//int f = Math.sum(a, b);			
			//System.out.println(f);
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
