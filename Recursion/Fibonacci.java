package Recursion;

public class Fibonacci {
	public static void main(String[] args){
		System.out.println(fibonacci(5));
	}
	
	
	public static int fibonacci(int k){
		if(k == 0 )
			return 0;
		if(k == 1)
			return 1;
		
		return fibonacci(k-1) + fibonacci(k-2);
	}

}
