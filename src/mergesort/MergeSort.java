package mergesort;
import static java.lang.System.currentTimeMillis;

/* Java program for Merge Sort */
class MergeSort 

{ 
	// Merges two subarrays of arr[]. 
	// First subarray is arr[l..m] 
	// Second subarray is arr[m+1..r] 
	public static void merge(int arr[], int l, int m, int r) 
	{ 
		// Find sizes of two subarrays to be merged 
		int array1 = m - l + 1; 
		int array2 = r - m; 

		/* Create temp arrays */
		int L[] = new int [array1]; 
		int R[] = new int [array2]; 

		/*Copy data to temp arrays*/
		for (int i=0; i<array1; ++i) 
			L[i] = arr[l + i]; 
		for (int j=0; j<array2; ++j) 
			R[j] = arr[m + 1+ j]; 


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = l; 
		while (i < array1 && j < array2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				arr[k] = L[i]; 
				i++; 
			} 
			else
			{ 
				arr[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < array1) 
		{ 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < array2) 
		{ 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	public static void sort(int arr[], int l, int r) 
	{ 
		if (l < r) 
		{ 
			// Find the middle point 
			int m = (l+r)/2; 

			// Sort first and second halves 
			sort(arr, l, m); 
			sort(arr , m+1, r); 

			// Merge the sorted halves 
			merge(arr, l, m, r); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	// Driver method 
	public static void main(String args[]) 
	{
            int elements= 100;
      int arr[] = new int[elements];
     //= {22, 30, 15, 1, 7, 87, 65, 24, 22, 0}
    for (int i=0; i<elements; i++){
        arr[i]=(int)(Math.random()*101);
    }
		System.out.println("Given Array"); 
		printArray(arr); 

		MergeSort ob = new MergeSort(); 
		ob.sort(arr, 0, arr.length-1); 

		System.out.println("\nSorted array"); 
		printArray(arr); 
	} 
} 
/* This code is contributed by Rajat Mishra */
