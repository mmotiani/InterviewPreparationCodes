package hardik.code;

public class Searching {

	//need a sorted array
	public static void searchMaxOccurence(int[] A) {
		int   currentElement = A[0], maxElement = 0;
		int currentCount = 0, maxCount = 0;
		for (int i = 0; i < A.length; i++) {
			if(A[i] == currentElement) {
				currentCount++;
			} else {
				currentElement = A[i];
				currentCount = 1;
			}
			if (currentCount > maxCount) {
				maxCount = currentCount;
				maxElement = currentElement;
			}
		}
		System.out.println("Max Element " + maxElement + "Max Count " + maxCount);
	}
	
	public static int indexOfFirstOccurence(int[] A, int left, int right, int data) {
		if(left<=right) {
			int mid = left + (right - left)/2;
			if ((A[mid] == data && mid == left) || (A[mid] == data && A[mid-1] < A[mid])) {
				return mid;
			} else if (A[mid] >= data) {
				return indexOfFirstOccurence(A, left, mid-1, data);
			} else {
				return indexOfFirstOccurence(A, mid+1, right, data);
			} 
		}
		return -1;
	}
	
	public static int singleElementWithAllOtherEven(int[] A) {
		int res = 0;
		for (int i=0; i < A.length ; i++ ) {
			res = res ^ A[i];
		}
		return res;
	}
	public static void main(String[] args) {
		int[] A = new int[] {1,2,2,2,2,3,3,3,4,4,4};
		searchMaxOccurence(A);
		System.out.println("Index of First Occurence" + indexOfFirstOccurence(A, 0, (A.length-1), 2));
		int[] B = new int[] {1,2,2,3,5,3,4,4,1};
		System.out.println("Alone element is :" + singleElementWithAllOtherEven(B));
	}
}
