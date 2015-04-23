package hardik.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

public class SearchingSortingExamples {

	public static void mergeSortedArrays(int[] A, int[] B) {
		int j = A.length-1, k = A.length + B.length -1, i = B.length-1;
		int[] C = new int[k+1];
		for (;k>=0;k--) {
			if(i >=0 && (B[i] > A[j] || j<0)) {
				C[k] = B[i];
				i--;
			} else {
					C[k] = A[j];
					j--;
			}
		}
		System.out.println(Arrays.toString(C));
		
	}
	
	public static void sortArrayWithAnagrams(String[] s) {
		if(s.length == 0) {
			return;
		}
		HashMap<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		for (String s1 : s) {
			String s2 = sortString(s1);
			if (!map.containsKey(s2)){
				map.put(s2, new LinkedList<String>());
			}
			LinkedList<String> list = map.get(s2);
			list.add(s1);
			map.put(s2, list);
		}
		int i = 0;
		for (String s1 : map.keySet()) {
			LinkedList<String> list = map.get(s1);
			while(!list.isEmpty()) {
				s[i++] = list.poll();
			}
		}
		System.out.println(Arrays.toString(s));
	}
	
	static void findFirstRepeatedElement(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i =0 ; i < A.length ; i ++) {
			if (!map.containsKey(A[i])) {
				map.put(A[i], i+1);
			} else {
				int value = map.get(A[i]);
				if (value > 0) {
					value = -value;
					map.put(A[i], value);
				}
			}
		}
		int maxValue = Integer.MIN_VALUE;
		int maxNum = 0;
		Iterator<Entry<Integer, Integer>> itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<Integer, Integer> entry = itr.next();
			if (entry.getValue() < 0 && entry.getValue() > maxValue) {
				maxValue = entry.getValue();
				maxNum = entry.getKey();
			}
		}
		System.out.println("First repeated number :" + maxNum);
		
	}
	public static String sortString(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	
	public static int findElementInShiftedSortedArray(int[] A, int data) {
		int pivot = findPivot(A, 0, A.length - 1);
		if (A[pivot] == data)
			return 1;
		else {
			if (A[pivot] <= data)
				return binarySearch(A, 0, pivot-1, data);
			else 
				return binarySearch(A, pivot+1, A.length-1, data);
				
		}
	}
	
	public static int findPivot(int[] A, int left, int right) {
		if (left == right) {
			return left;
		}
		if (left == right-1) {
			if (A[left] >= A[right]) {
				return left;
			} else {
				return right;
			}
		}
		else {
			int mid = left + (right-left)/2;
			if (A[left] >= A[mid])
				return findPivot(A, left, mid);
			else
				return findPivot(A, mid, right);
		}
	}
	
	public static int binarySearch(int[] A, int left, int right, int data) {
		if (left <= right) {
			int mid = left + (right-left)/2;
			if (A[mid] == data) {
				return 1;
			} else if (A[mid] > data) {
				return binarySearch(A, left, mid-1, data);
			} else 
				return binarySearch(A, mid+1, right, data);
		}
		return 0;
	}
	
	public static void convertStringToIntByMe(String str)
	{	
		int power =1;
		int sum =0;
		for(int i =str.length() -1 ; i>=0; i--)
		{
			if(str.charAt(i) == '-')
				sum = -sum;
			else
			{
			//int currNum = str.charAt(i) - '0';
			sum = sum + power * (str.charAt(i) - '0');
			power = power * 10;
			}
		} 
		
		System.out.println(sum);
	}
	
	static void convertStringToInteger(String string) {
		char[] array = string.toCharArray();
		int value = 0;
		for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
			int powerTen = (int) Math.pow(10, j);
			int digit = Character.getNumericValue(array[i]);
			if (digit == -1 && array[i] == '-') {
				value = -value;
			} else {
				value = (int) (value + (digit * powerTen));
			}
		}
		System.out.println("Int value is :" + value);
	}
	
	static void findSumInArray(int[] A, int k) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		boolean found = false;
		for (int i: A) {
			map.put(i, true);
		}
		for (int numIndex : A) {
			int number =  k - numIndex;
			if (map.containsKey(number)) {
				System.out.println("Such numbers are :" + numIndex + " + " + number + " = " + k);
				found = true;
				break;
			}
		}
		if (!found) 
			System.out.println("No such numbers");
	}
	
	// no need of map.. calculate square of full array. 2 loops. outer loop from m =2 to m = n-1
	//inner loop with 2 variables. i=0; j = m-1.Condition i <j.
	//Add i+j. If result > m, decrement j, if result < m , increment i.
	static void findSquareSumInArray(int[] A, int k) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		boolean found = false;
		for (int i = 0; i < A.length ; i++) {
			A[i] = A[i] * A[i]; 
		}
		for (int i: A) {
			map.put(i, true);
		}
		for (int i = A.length-1 ; i >=0 ; i--) {
			for (int j=0 ; j < i ; j++) {
				int number2 = A[i] - A[j]; 
				if (map.containsKey(number2)) {
					System.out.println("Such Numbers are : number1 " + Math.sqrt(number2) + "number2 " + Math.sqrt(A[j]) + "and sum is :" + Math.sqrt(A[i]));
					found = true;
					break;
				}
			}
		}
		if (!found) 
			System.out.println("No such numbers");
	}
	
	static int findFirstPositive(int[] a) {
		int start = 0, end = a.length-1;
		while (start <= end) {
			if (end == start)
				return a[start];
			if (start == (end-1))
				return Math.max(a[start], a[end]);
			
			int mid = start + (end -start)/2;
			if (a[mid] > a[mid - 1] && a[mid] >=0 && a[mid-1] < 0) {
				return a[mid];
			} else if (a[mid-1] < a[mid] && a[mid] < 0) {
				start = mid + 1;
			} else if (a[mid-1] < a[mid] && a[mid] > 0) {
				end = mid- 1;
			} else {
				return -1;
			}
		}
		return -1;
	}
	
	static int findPivot(int[] a) {
		int first = 0;
		int last = a.length-1;
		while (first <= last) {
			if (first == last) {
				return a[first];
			} else if (first == last-1) {
				return Math.max(a[first], a[last]);
			} else {
				int mid = first + (last- first)/2;
				if (a[mid-1] < a[mid] && a[mid] > a[mid + 1]) {
					return a[mid];
				} else if ((a[mid-1] < a[mid] && a[mid] < a[mid + 1])) {
					first = mid + 1; 
				} else if ((a[mid-1] > a[mid] && a[mid] > a[mid + 1])){
					last = mid - 1;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}
	
	static int findFirstOccurence(int[] a, int start, int end, int data) {
		if(start <= end) {
			int mid=start + (end-start)/2;
			if ((start == mid && a[mid] == data) || (a[mid-1] < a[mid] && a[mid] == data )) {
				return mid;
			} else if (a[mid] < data) {
				return findFirstOccurence(a, mid+1, end, data);
			} else {
				return findFirstOccurence(a, start, mid-1, data);
			}
		}
		return -1;
	}
	
	static int findStringInArrayContainingEmptyElements(String[] stringArray, String str, int start, int end) {
		if (start <= end) {
			int mid = start + (end - start)/2;
			if(stringArray[mid].isEmpty()) {
				int left = mid-1;
				int right = mid+1;
				while (true) {
					if (left < start && right > end) {
						return -1;
					} else if (left >= start && !stringArray[left].isEmpty()) {
						mid = left;
						break;
					} else if (right <= end && !stringArray[right].isEmpty()) {
						mid = right;
						break;
					}
					left--;right++;
				}
			}
			if (stringArray[mid].equals(str)) {
				return mid;
			}
			else if(str.compareTo(stringArray[mid]) < 0) {
				return findStringInArrayContainingEmptyElements(stringArray, str, 0, mid-1);
			} else if(str.compareTo(stringArray[mid]) > 0) {
				return findStringInArrayContainingEmptyElements(stringArray, str, mid+1, end);
			}
		}
		return -1;
	}
	
	static void findRowWithMaxZeros(int[][] array) {
		int row = 0, column = array[0].length -1;
		int count = 0;
		int maxRow = 0;
		while (row < array.length && column >=0) {
			if (array[row][column] == 0)
			{
				count++;column--;
				maxRow = row;
			} else {
				row++;
			}
		}
		System.out.println("Row with Max zero is :" + (maxRow+1) +" and the count is :" + count);
	}
	
	public static int binarySearchOnCircularArray(int arr[], int arrSize, int key)
	{
	    int mid, start=0, end1=arrSize-1;
	    int index=-1;
	    if(arr[start] == key)
	        index = start;
	    else if(arr[end1] == key)
	        index = end1;

	    while(index == -1 && start != end1 -1)
	    {
	        mid = (start+end1)/2;
	        if(arr[mid] == key)     //If found the element
	            index = mid;
	        else if (arr[mid] < arr[start]) //Right part of mid is sorted array...
	        {
	            if(key > arr[mid] && key < arr[end1])
	                start = mid;
	            else
	                end1 = mid;
	        }
	        else    //Left part of mid is sorted array....
	        {
	            if(key > arr[start] && key < arr[mid])
	                end1 = mid;
	            else
	                start = mid;
	        }
	    }

	    return index;
	}
	
	public static void main(String[] args) {
		int[] A = new int[4];
		A[0] = 1; A[1] = 3; A[2] = 5; A[3] = 7;
		int[] B = new int[] {2,4,6};
		mergeSortedArrays(A, B);
		
		String[] s = new String[] {"abc","bc","acb","cb","bca","cab","a"};
		sortArrayWithAnagrams(s);
		
		int[] C = new int[] {13,14,15,16,17,1,2,3,4};
		if(1 == findElementInShiftedSortedArray(C, 7)) {
			System.out.println("Element found");
		} else {
			System.out.println("Element  not found");
		}
		
		int[] temp = new int[] {2,4,6,6,7, 2, 6,9,2};
		findFirstRepeatedElement(temp);
		convertStringToInteger("-1234");
		convertStringToIntByMe("-1234");
		
		findSumInArray(temp, 6);
		
		int[] sum = new int[] {3, 4,5, 6,9,10, 12, 13, 15};
		findSquareSumInArray(sum, 0);
		
		int[] pivot = new int[] {1,2,3,4,5,4,3,2,1};
		System.out.println("Pivot is :" + findPivot(pivot));
		
		int[] firstOccurence = new int[] {1,2,3,4,5,5,6,6};
		System.out.println("First occured at " + findFirstOccurence(firstOccurence, 0, firstOccurence.length-1, 5));
		
		String[] stringArray = new String[] {"abc","bcd","","","","","cef"};
		int index = findStringInArrayContainingEmptyElements(stringArray, "cef", 0, stringArray.length - 1);
		System.out.println("String found is :" + stringArray[index]);
		
		int[][] array = new int[][]{{1,1,1,1,0,0},{1,1,0,0,0,0},{1,1,1,1,1,0},{1,1,1,0,0,0},{1,1,1,1,1,1}};
		findRowWithMaxZeros(array);
		
		int in = findFirstPositive(new int[]{-5,-4,-3,-1,1,3,4,5});
		System.out.println("Index is "+ in);
	}
	
}
