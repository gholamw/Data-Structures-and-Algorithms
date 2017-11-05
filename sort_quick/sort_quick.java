package sort_quick;

public class sort_quick {
	
	static int[] arr = {10,17,1,5,9,14,18,3,4};
	
	public static void main(String[] args){
		
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " - " );
		}
		
		
		
		
		
		System.out.println(" ");
		quick_sort(0,arr.length-1);
		System.out.println(" ");

		
		
		
		
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " - " );
		}
		
		
		
		
	}
	
	
	public static void partition(int L0 , int R0, int p){
		
		int L = L0;
		int R = R0;
		int pivot = p;
		
		while(L <= R){
			
			while(L < arr.length-1 && arr[L] < arr[pivot])
				L=L+1;
			
			while(R >= 0 && arr[R] > arr[pivot])
				R=R-1;
			
			
			if(L <= R){
				exchange(L,R);
				L=L+1;
				R=R-1;
			}
			
		}
		
	}
	
	
	
	
	public static void exchange(int L, int R){
		
		int temp = arr[L]; 
		arr[L] = arr[R];
		arr[R] = temp;
		
	}
	
	public static void quick_sort(int left, int right){
		int pivot = (left + right) /2;
	//	while(left <= right ){
			
			partition(left,right,pivot);
			pivot = 0;
			partition(left,right,pivot);
			pivot = arr.length-1;
			partition(left,right,pivot);
//			pivot = arr.length-1;
//			partition(left,right,pivot);






			
		//}
	}

}
