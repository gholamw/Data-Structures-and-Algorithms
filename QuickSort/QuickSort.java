package QuickSort;

public class QuickSort {
	
	static int[] arr = {2,10,1,3,5,7};
	
	public static void main(String[] args){
		System.out.println("Array before sorting");
		
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] +  " - " );
		}
		
		
		qsort(0,arr.length-1);
		
		System.out.println(" ");
		System.out.println("Array after sorting");
		System.out.println(" ");


		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] +  " - " );
		}
			
	}
	
	
	public static void qsort(int L, int R){
		int pivot;
		int i,j;
		if(L < R){
			pivot = (L+R) / 2;
			partition(L,R,pivot);
			
		}
		
	}
	
	
	public static void partition(int L0, int R0, int p){
		int L = L0; 
		int R = R0; 
		
		while(L <= R){
			
			// scan left-side
			while(L < arr.length-1 && arr[L] < arr[p])
				L = L + 1;
			
			while(R >0 && arr[R] > arr[p])
				R = R - 1;
			
			if(L <= R){
				swapItems(L,R);
				L = L + 1;
				R = R - 1;
			}
			
			
			
		}
		
	}
	
	
	public static void swapItems(int L , int R){
		
		int temp = arr[L];
		arr[L] = arr[R];
		arr[R] = temp;
	}
	

}
