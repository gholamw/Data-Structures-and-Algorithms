package Hashtables;

import java.util.HashSet;
import java.util.Hashtable;

public class Hashtables {
	// Total worse running time Θ(N+M)
	// Will need memory allocation for hashtable Θ(N) , where N is number of elements
	// of b (wanted array to hash). 
	public static void main(String[] args) {
		int[] a = { 1, 5, 2,2, 4, 0,0,0,0, 3 }; //m
		int[] b = { 3, 6, 2, 8, 4, 6, 0, 22, 63, 99, 1, 5,5,5,5,5 }; // n
		boolean aInb = true;

		HashSet<Integer> hash = new HashSet<Integer>();
		// Hashing all elements of b, Θ(N), where N is number of
		// elements in b.
		for (int i = 0; i < b.length; i++) {
			hash.add(b[i]);
		}
		
		
		// Iterate through all elements of a to check if it contained in b Θ(M),
		// where M is number of elements of a.
		// Total Θ(M)*Θ(1) (each elements will take Θ(1) to hash in the table.
		for (int i = 0; i < a.length && aInb == true; i++) {

			aInb = hash.contains(a[i]); // O(1)
		}

		if (aInb) {
			System.out.println("a is a subset of b ");
		} else {
			System.out.println("a is NOT a subset of b ");

		}

	}

}
