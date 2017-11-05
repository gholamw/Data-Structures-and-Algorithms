package HeapSort;

import java.util.Arrays;

public class HeapSort <Key extends Comparable<Key>> {
	public static void main(String[] args){
		//Comparable[] arr = {1,8,54,10,4,85,9};
		//Comparable[] arr = {100,70,11,1000,2,99,1};
		Comparable[] arr = {100,90,70,80,50,40,20};


		CreateHeap heap = new CreateHeap(arr);
//		System.out.println("Before shrink" + Arrays.toString(arr));
//		int N = arr.length;
//		arr[0] = arr[--N];
//		for(int i=arr.length-1; i>=0; i--){
//			System.out.println(" ");
//			for(int j = 0; j < i; j++)
//				System.out.print(arr[j] + ",");
//		}
		heap.sort(arr.length);
		Comparable[] result = heap.applyHeapSort();
		for(int i=0; i<result.length; i++){
			System.out.print(result[i] + ",");
		}
	}


}
