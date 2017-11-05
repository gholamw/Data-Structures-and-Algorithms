package HeapSort;

import java.util.Arrays;

public class CreateHeap<Key extends Comparable<Key>> {

	Key[] array;
	int lastParent;
	int numberOfNoSorts;

	public CreateHeap(Key[] inputArray) {
		array = inputArray;
		lastParent = (int) Math.floor((array.length - 2) / 2);
		numberOfNoSorts = 0;

	}

	public Key[] sort(int sizeArray) {
		boolean keepSorting = true;
		while (keepSorting) {
			keepSorting = performSorting(sizeArray);
		}
		return array;

	}

	public void swap(int index1, int index2) {
		Key element1 = array[index1];
		Key element2 = array[index2];
		System.out.println("Before swapping " + Arrays.toString(array));

		array[index1] = element2;
		array[index2] = element1;
		System.out.println("After swapping " + Arrays.toString(array));
	}

	public boolean performSorting(int sizeArray) {
		int size = array.length - 1;
		boolean sorted = false;
		int currentParent = lastParent;
		int child1 = 0;
		int child2 = 0;
		boolean withinRange1 = false;
		boolean withinRange2 = false;

		// swap(5, 4);

		while (currentParent >= 0
				&& numberOfNoSorts != Math.floor(array.length / 2)) {
			
			child1 = (2 * currentParent) + 1;
			if(child1<=sizeArray){
				withinRange1 = true;
			}else{
				withinRange1 = false;
			}
			child2 = (2 * currentParent) + 2;
			
			if(child2<=sizeArray){
				withinRange2 = true;
			}else{
				withinRange2 = false;
			}
			if (currentParent < 0) {
				currentParent = (int) Math.floor((array.length - 2) / 2);
			}
			Key element1 = array[child1];
			Key element2 = array[child2];
			Key parent = array[currentParent];
			Key biggerChild = null;
			int bigChildIndex = 0;

			if (element1.compareTo(element2) > 0 && withinRange1 == true) {
				biggerChild = element1;
				bigChildIndex = child1;
			} else if(element2.compareTo(element1) > 0 && withinRange2 == true) {
				biggerChild = element2;
				bigChildIndex = child2;
			}
			
			
		  if(biggerChild == null){	
			  lastParent = lastParent - 1;
			  return true;
		  }else{
			if (biggerChild.compareTo(parent) > 0) {
				swap(bigChildIndex, currentParent);
			} else {
				numberOfNoSorts++;
			}
			if (currentParent == 0) {
				lastParent = (int) Math.floor((array.length - 2) / 2);
			} else {
				lastParent = lastParent - 1;
			}
		  }
			return true;
		}

		return false;
	}
	
	
	
	public Key[] applyHeapSort(){
		lastParent = (int) Math.floor((array.length - 2) / 2);
		numberOfNoSorts = 0;
		boolean keepSorting = true;

		for(int i=array.length-1; i>=0; i--){
			swap(0,i);
			//while (keepSorting) {
				//keepSorting = 
			sort(i-1);
			numberOfNoSorts = 0;
			//}
			
		}
		
		return array;
		
	}

}
