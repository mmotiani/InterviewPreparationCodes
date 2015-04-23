package hardik.code;


public class HeapExamples {

	public static int heapSize;
	public static int getLeft(int i) {
		return 2*i + 1;
	}
	
	public static int getRight(int i) {
		return 2*i + 2;
	}
	
	public static int getMin(int[] A) {
		return A[0];
	}
	
	public static int getMax(int[] A) {
		return A[0];
	}
	
	public static void replaceMax(int[] A, int i) {
		A[0] = i;
		maxHeapify(A, 0);
	}
	
	public static void replaceMin(int[] A, int i) {
		A[0] = i;
		minHeapify(A, 0);
	}
	public static void buildMinHeap(int[] A) {
		heapSize = A.length;
		for (int i=(A.length-1)/2; i>=0; i--) {
			minHeapify(A, i);
		}
	}
	private static void minHeapify(int[] A, int i) {
		int left = getLeft(i);
		int right = getRight(i);
		int temp, min = Integer.MIN_VALUE;
		if (left < heapSize && A[left] < A[i]) 
			min = left;
		else
			min = i;
		if (right < heapSize && A[right] < A[min])
			min = right;
		if (min != i) {
			temp = A[i];
			A[i] = A[min];
			A[min] = temp;
			minHeapify(A, min);			
		}
	}

	public static void buildMaxHeap(int[] A) {
		heapSize = A.length;
		for (int i = (A.length-1)/2; i>=0; i--) {
			maxHeapify(A, i);
		}
	}
	public static void maxHeapify(int[] A, int i) {
		int left, right, max = -1, temp;
		left = getLeft(i);
		right = getRight(i);
		if (left < heapSize && A[left] > A[i])
			max = left;
		else 
			max = i;
		if (right < heapSize && A[right] > A[max])
			max = right;
		if (max != i) {
			temp = A[i];
			A[i] = A[max];
			A[max] = temp;
			maxHeapify(A, max);
		}
 	}
	
	
	public static void heapSort(int[] A, int n) {
		int temp;
		buildMaxHeap(A);
		for (int i=A.length-1; i>=0; i--) {
			temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			heapSize--;
			maxHeapify(A, 0);
			
		}
	}
	
	public static void findKthLargestElement(int[] A, int k) {
		int[] B = new int[k];
		System.arraycopy(A, 0, B, 0, k);
		buildMinHeap(B);
		for (int i =k; i < A.length ; i++) {
			if (A[i] > getMin(B))
				replaceMin(B, A[i]);
		}
		System.out.println("Kth max is " + getMin(B));
	}
	
	public static void findKthSmallestElement(int[] A, int k) {
		int[] B = new int[k];
		System.arraycopy(A, 0, B, 0, k);
		buildMaxHeap(B);
		for (int i =k; i < A.length ; i++) {
			if (A[i] < getMax(B))
				replaceMax(B, A[i]);
		}
		System.out.println("Kth min is " + getMax(B));
	}
	
	
	public static void main(String[] args) {
		int A[] = new int[]{4,1,3,2,16,9,10,14,8,7};
		/*heapSort(A, A.length);
		System.out.println(Arrays.toString(A));*/
		findKthLargestElement(A, 3);
		findKthSmallestElement(A, 3);
		
	}
}
