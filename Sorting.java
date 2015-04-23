package hardik.code;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Sorting {
	
	public static void countingSort(int[] arr, int k)
	{
		int[] counts = new int[k];
		
		for(int i =0; i<k;i++)
		{
			counts[i] = 0;
		}
		
		for(int i =0; i < arr.length; i++)
		{
			counts[arr[i]] += 1;
		}
		
		int j =0;
		for(int m=0; m < counts.length;m++)
		{
			for(int n =0; n < counts[m] && j < arr.length; j++, n++)
			{
				arr[j] = m;
			}
		}
		
	}

	public static int[] bubbleSort(int[] A, int n) {
		int temp = 0;
		for (int pass = n - 1; pass >= 0; pass++) {
			for (int i = 0; i < pass; i++) {
				if (A[i] > A[i + 1]) {
					temp = A[i];
					A[i] = A[i + 1];
					A[i + 1] = temp;
				}
			}
		}
		return A;
	}

	public static int[] mergeSort(int[] A, int left, int right) {
		int mid = (left + right) / 2;
		if (left < right) {
			mergeSort(A, left, mid - 1);
			mergeSort(A, mid, right);
			merge(A, left, mid, right);
		}

		return A;
	}

	private static void merge(int[] A, int left, int mid, int right) {
		int temp_pos = left;
		int left_end = mid - 1;
		int size = left + right + 1;
		int[] temp = new int[size];
		while (left <= left_end && mid <= right) {
			if (A[left] <= A[mid]) {
				temp[temp_pos++] = A[left++];
			} else {
				temp[temp_pos++] = A[mid++];
			}
		}
		while (left <= left_end) {
			temp[temp_pos++] = A[left++];
		}
		while (mid <= right) {
			temp[temp_pos++] = A[mid++];
		}
		for (int i = 0; i < size; i++) {
			A[right] = temp[right];
			right--;
		}
	}

	private static int[] mergeSortedArrays(int[] A, int[] B, int[] C) {
		int size = A.length + B.length;
		int[] temp = new int[size];
		int[] result = new int[size + C.length];
		mergeArrays(A, B, temp, 0);
		mergeArrays(temp, C, result, 0);
		return result;
	}

	private static void mergeArrays(int[] A, int[] B, int[] temp,
			int temp_pointer_position) {
		int i = 0, j = 0;
		while (i < A.length && j < B.length) {
			if (A[i] < B[j]) {
				temp[temp_pointer_position++] = A[i++];
			} else {
				temp[temp_pointer_position++] = B[j++];
			}
		}
		if (i == A.length && j != B.length) {
			while (j < B.length) {
				temp[temp_pointer_position++] = B[j++];
			}
		} else if (j == B.length && i != B.length) {
			while (i < A.length) {
				temp[temp_pointer_position++] = A[i++];
			}
		}
	}

	public static void quickSort(int[] A, int low, int high) {
		if (low < high) {
			int pivot = partition(A, low, high);
			if (low < pivot) {
				quickSort(A, low, pivot - 1);
			}
			if (high > pivot) {
				quickSort(A, pivot + 1, high);
			}
		}
	}

	public static int quickSortFindMedian(int[] A, int low, int high) {
		int mid = 0;
		if (low < high) {
			mid = low + (high - low) / 2;
			int pivot = partition(A, low, high);
			while (pivot != mid) {
				if (pivot < mid)
					quickSortFindMedian(A, mid, high);
				else
					quickSortFindMedian(A, low, mid);
			}
		}
		return mid;
	}

	static void findMaxOccurenceInArray(int[] a) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : a) {
			if (!map.containsKey(i))
				map.put(i, 1);
			else {
				int count = map.get(i) + 1;
				map.put(i, count);
			}
		}
		Iterator<Entry<Integer, Integer>> itr = map.entrySet().iterator();
		int maxCount = Integer.MIN_VALUE;
		int maxNumber = Integer.MIN_VALUE;
		while (itr.hasNext()) {
			Entry<Integer, Integer> entry = itr.next();
			if (entry.getValue() > maxCount) {
				maxCount = entry.getValue();
				maxNumber = entry.getKey();
			}
		}
		System.out.println("Number is :" + maxNumber + " count is : " + maxCount);
	}
	private static int partition(int[] a, int low, int high) {
		int left = low, right = high, pivot_item = a[((low + high) / 2)];
		while (left <= right) {
			while (a[left] < pivot_item)
				left++;
			while (a[right] > pivot_item)
				right--;
			if (left <= right) {
				int temp = a[right];
				a[right] = a[left];
				a[left] = temp;
				left++;
				right--;
			}
		}
		return left;// For median return mid = ((low + high)/2)
	}


	public static void main(String[] args) {
		
		int[] arr = new int[] {1,1,1,2,2,2,2,0,0,0,2,0,1,2,0,2,1,0,2,1,0,2,1,0,2,1 };
		countingSort(arr,3);
		
		int[] A = new int[] { 1, 3, 5, 7, 8 };
		int[] B = new int[] { 2, 3, 6, 9 };
		int[] C = new int[] { 3, 6, 8, 9 };
		int[] temp = mergeSortedArrays(A, B, C);
		for (int i : temp) {
			System.out.print(i);
		}
		System.out.println();
		int[] array = new int[] { 1, 9, 6, 4, 7, 2 };
		/*int mid = quickSortFindMedian(array, 0, array.length - 1);
		System.out.println(array[mid]);
*/
		
		 quickSort(array, 0, array.length-1); 
		 for (int i : array) {
			 System.out.print(i + " "); 
		 }
		 C = new int[] { 3, 6, 8, 9 , 9,3,5,6,1,6};
		 findMaxOccurenceInArray(C);
		 
		 	ListNode node6 = new ListNode(5, null);
			ListNode node5 = new ListNode(7, node6);
			ListNode node4 = new ListNode(9, node5);
			ListNode node3 = new ListNode(10, node4);
			ListNode node2 = new ListNode(12, node3);
			ListNode node1 = new ListNode(15, node2);
			ListNode head = new ListNode(2, node1);
			ListNode tempNode = merge_sort(head);
			while (tempNode != null) {
				System.out.print(tempNode.getData() + " ");
				tempNode = tempNode.getNext();
			}

	}
	
	
	public static ListNode merge_sort(ListNode head) {
	    if(head == null || head.getNext() == null) { return head; }
	    ListNode middle = getMiddle(head);      //get the middle of the list
	    ListNode sHalf = middle.next; middle.next = null;   //split the list into two halfs

	    return merge(merge_sort(head),merge_sort(sHalf));  //recurse on that
	}

	//Merge subroutine to merge two sorted lists
	public static ListNode merge(ListNode a, ListNode b) {
	    ListNode dummyHead, curr; dummyHead = new ListNode(); curr = dummyHead;
	    while(a !=null && b!= null) {
	        if(a.data <= b.data)
	        	{ curr.next = a; a = a.next; }
	        else 
	        	{ curr.next = b; b = b.next; }
	        curr = curr.next;
	    }
	    curr.next = (a == null) ? b : a;
	    return dummyHead.next;
	}

	//Finding the middle element of the list for splitting
	public static ListNode getMiddle(ListNode head) {
	    if(head == null) { return head; }
	    ListNode slow, fast; slow = fast = head;
	    while(fast.next != null && fast.next.next != null) {
	        slow = slow.next; fast = fast.next.next;
	    }
	    return slow;
	}
}
