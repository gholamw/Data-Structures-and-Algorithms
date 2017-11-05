package Recursion;

public class Factorial {
	static int result=0;

	
	public static void main(String[] args){
		System.out.println(factorial(5));
	}
	
	
	public static int factorial(int m){
		if(m == 0)
			return 1;
		
		return  factorial(m-1) * m;
		
	}

}
