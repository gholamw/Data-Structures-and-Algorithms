package linear_exp;

public class linear_exp {
	public static void main(String[] args){
		System.out.println(linear_exponent(2.0 , 2));
		
	}
	
	
	public static double linear_exponent(double a, int b){
		double x = a;
		double result =1;
		
		for(int k = 1; k<= b ; k++){
			result = result*x;
		}
		
		return result;
	}

}
