package hardik.code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


//1 Given a list of email list, find all email addresses that are in all the email list
public class AmazonQuestions {

	int findTrailingZeros(int  n)
	{
	    // Initialize result
	    int count = 0;
	 
	    // Keep dividing n by powers of 5 and update count
	    for (int i=5; n/i>=1; i *= 5)
	          count += n/i;
	 
	    return count;
	}
	 
	int maxDiff(int arr[], int arr_size)
	{
	  int max_diff = arr[1] - arr[0];
	  int min_element = arr[0];
	  int i;
	  for(i = 1; i < arr_size; i++)
	  {       
	    if(arr[i] - min_element > max_diff)                               
	      max_diff = arr[i] - min_element;
	    if(arr[i] < min_element)
	         min_element = arr[i];                     
	  }
	  return max_diff;
	} 

	public static void replaceAdjacentIdenticalCharWithoutBuffer(char[] str)
	{
		int j = 0;
		
		for(int i = 1; i <= str.length; i++)
		{
			while(str[i] == str[j] && j > 0)
			{
				i++;
				j--;
			}
			str[++j] = str[i];
		}	
	}

	public void rotateMatrix(int[][] matrix, int n) {
	for (int layer = 0; layer < n / 2; ++layer) {
	 int first = layer;
	 int last = n - 1 - layer;
		for(int i = first; i < last; ++i) {
			int offset = i - first;
			// save top
			int top = matrix[first][i];

			// left -> top
			matrix[first][i] = matrix[last-offset][first];

			// bottom -> left
			matrix[last-offset][first] = matrix[last][last - offset];

			// right -> bottom
			matrix[last][last - offset] = matrix[i][last];
			
			// top -> right
			matrix[i][last] = top;
		}
	  }
	} 
	
	static List<String> findCommonEmailAddresses(List<List<String>> emailList) {
		List<String> smallestList = null;
		for(List<String> list : emailList) {
			if (smallestList == null) {
				smallestList = list;
			} else if(smallestList.size() > list.size()) {
				smallestList = list;
			}
		}
		List<String> result = new ArrayList<String>();
		for (String emailAddress : smallestList) {
			result.add(emailAddress);
			for (List<String> list : emailList) {
				if (!list.contains(emailAddress)) {
					result.remove(emailAddress);
					break;
				}
			}
		}
		return result;
	}
	
	/*
	 * You are given a series like this: (1,2) (2,3) (5,6) (2,9)
	 * 
	 * Every element in this series is a pair(u,v) which means that there is a
	 * connection between (u,v).
	 * 
	 * Output group of elements: For instance, if you look at the above series,
	 * the output will be: [1,2,9], [5,6]
	 */
	
	
	static void findRelation(Points[] p) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Points point : p) {
			if (!map.containsKey(point.x)) {
				map.put(point.x, point.y);
			} else {
				if (map.get(point.x) < point.y) {
					map.put(point.x, point.y);
				} 
			}
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		Set<Integer> traversedSet = new HashSet<Integer>();
		for (Map.Entry<Integer, Integer> entry : set) {
			if (!traversedSet.contains(entry.getKey())) {
				int key = entry.getKey();
				int value = entry.getValue();
				traversedSet.add(key);
				List<Integer> list = new ArrayList<Integer>();
				list.add(key);list.add(value);
				while(map.containsKey(value)) {
					int newKey =  map.get(value);
					list.add(map.get(value));
					traversedSet.add(value);
					value = newKey;
				}
				result.add(list);
			}
		}
		for(List<Integer> list : result) {
			Iterator<Integer> it = list.iterator();
			while (it.hasNext()) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
		}
	} 
	
	
	/**
	 * Given n array return true if there exist a element from each array whose sum is zero
	 */
	
	/**
	 * amazon-interview-questions4 of 4 votes 65 Answers You are given a large
	 * set of integers, which are not sorted. Figure out a method to retrieve
	 * the largest 1000 elements, in O(n) run time
	 * Use Min-heap to do this. O(n)
	 */

	
	/**
	 * == Question == Given a list of TestResult, where each result contains a
	 * test score, a student ID and a date, figure out the students' final
	 * scores. A final score is the average of a student's top 5 scores.
	 * 
	 * Here is a sample of the list of TestResult: 50 JACK 5/14/2013 89 ALICE
	 * 3/25/2012 70 BOBBY 12/7/2010 60 JACK 8/9/2013 99 MIKE 9/11/2011 100 JOHN
	 * 7/4/2011 38 JACK 1/28/2014 46 JACK 11/15/2012 <... more ...>
	 * 
	 * struct TestResult { score, student_id, date, }
	 * 
	 * 
	 * Iterate the list. create a map with key as student id and value as list of students score.
	 * Iterate List until all records are exhausted.
	 * Now iterate the map to calculate the average value for each student's test score.
	 * At the end, Map contains student id and a list with all average scores.
	 */
	
	/**
	 * Take a list of integers (left to right order) and return an integer of
	 * the number of identical binary trees that can be created from the same
	 * list.
	 * 
	 * Input: [10, 8, 15, 6, 9, 4, 5] Output: 24
	 * 
	 * Input: [12, 6, 19, 15, 5] Output: 6
	 * 
	 * Input: [44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64] Output: 1
	 */

	/**
	 * How will you Serialize and Deserialize the binary tree?
	 */
	
	static void serializeBinaryTree(BinaryTreeNode root, StringBuffer sb) {
		if (root == null) {
			sb.append("# ");
		}else {
			sb.append(root.getData() + " ");
			serializeBinaryTree(root.getLeft(), sb);
			serializeBinaryTree(root.getRight(), sb);
		}
	}
	
	static BinaryTreeNode deserializeBinaryTree(String s) {
		if (s==null || s.isEmpty())
			return null;
		StringTokenizer st = new StringTokenizer(s, " ");
		return deserializeBinaryTree(st);
	}
	
	
	private static BinaryTreeNode deserializeBinaryTree(StringTokenizer st) {
		if (!st.hasMoreTokens())
			return null;
		String s = st.nextToken();
		if (s.equals("#")) {
			return null;
		}
		BinaryTreeNode root = new BinaryTreeNode();
		root.setData(Integer.parseInt(s));
		root.setLeft(deserializeBinaryTree(st));
		root.setRight(deserializeBinaryTree(st));
		return root;
	}
	
	public static void convertBSTToArray(BinaryTreeNode root, List<Integer> list) {
		if (root == null) {
			list.add(null);
		} else {
			convertBSTToArray(root.getLeft(), list);
			list.add(root.getData());
			convertBSTToArray(root.getRight(), list);
		}
			
    }
	
public static BinaryTreeNode convertListToBST(Iterator<Integer> it, int start, int end) {
    	
    	if (start > end)
    		return null;
    	int mid = start + (end-start)/2;
    	BinaryTreeNode node = new BinaryTreeNode();
    	node.setLeft(convertListToBST(it, start, mid-1));
    	Integer i = it.next();
    	if (i == null) {
    		return null;
    	}
    	node.setData(i);
    	node.setRight(convertListToBST(it, mid + 1, end));
    	return node;
    	
    }
	
	static int[] findPosition(int[] a, int n) {
		int result[];
		if (a.length < n) {
			result = new int[1];
		} else {
			result = new int[(a.length/n)];
		}
		for (int i=0, j=0; i < a.length ; i++) {
			if (i%n ==0) {
				result[j++] = a[i];
			}
		}
		return result;
	}
	
	

	static void findAnagrams(String string1, String string2) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i=0; i < string1.length(); i++) {
			if (!map.containsKey(string1.charAt(i))) {
				map.put(string1.charAt(i), 1);
			} else {
				int value = map.get(string1.charAt(i)) + 1;
				map.put(string1.charAt(i), value);
			}
		}
		HashMap<Character, Integer> tempMap = new HashMap<Character, Integer>();
		List<Integer> list = new ArrayList<Integer>(); 
		int count = 0;
		for (int i=0; i < string2.length(); i++){
			char ch = string2.charAt(i);
			if (!map.containsKey(ch)) {
				count = 0;
				tempMap.clear();
			} else {
				if (count == string1.length()) {
					char ch1 = string2.charAt(i - string1.length());
					int value = tempMap.get(ch1) -1;
					tempMap.put(ch1, value);
					count--;
				}
				if (!tempMap.containsKey(ch)) {
					tempMap.put(ch, 1);
				} else {
					tempMap.put(ch, tempMap.get(ch) + 1);
				}
				if(tempMap.get(ch) <= map.get(ch)) {
					count++;
					if (count == string1.length()) {
						list.add(i-string1.length()+1);
					}
				} else {
					count = 0;
					tempMap.clear();
				}
			}
		}
		System.out.println("Such indexes are :");
		for (int i : list) {
			System.out.print( i + " ");
		}
	}
	
	static void isNumberPowerOfTwo(int number) {
		if(number <= 0) {
			System.out.println("Not a power");
		}
		if ((number & -number) == number) {
			System.out.println("Power of 2");
		} else {
			System.out.println("Not a power of two");
		}
	}
	
	static void multiply(int[] a) {
		List<Integer> list = new ArrayList<Integer>();
		int multiplication = 0;
		for (int i = 0 ; i < a.length; i++) {
			multiplication *= a[i]; 
		}
		if (multiplication ==0) {
			for (int i = 0 ; i < a.length ; i++) {
				if (a[i] ==0)
					list.add(i);
			}
		} 
		if (list.size() > 1) {
			for (int i = 0 ; i < a.length; i++) {
				a[i] = 0;
			}
		} else if(list.size() == 1) {
			for (int i = 0 ; i < a.length; i++) {
				if (!list.contains(i)) {
					multiplication *= a[i]; 
				}
				a[i] = 0;
			}
			a[list.get(0)] = multiplication;
		} else {
			for (int i = 0 ; i < a.length; i++) {
				a[i] = multiplication/a[i];
			}
		}
	}
	
	
	static int findNumberOfZerosRecursive(int[] a, int start, int end, int data) {
		if (start <= end) {
			int mid = start + (end - start)/2;
			if ((end == mid && a[mid] == data) || (a[mid] == data && a[mid+1] > data)) {
				return mid;
			} else if(a[mid] >= data) {
				return findNumberOfZerosRecursive(a, start, mid-1, data);
			} else if (a[mid] < data) {
				return findNumberOfZerosRecursive(a, mid+1, end, data);
			} else {
				return -1;
			}
		}
		return -1;
	}
	
	static void findAverageInSlidingWindow(int[] a, int w) {
		Queue<Integer> queue = new LinkedList<Integer>();
		double sum = 0;
		for (int i = 0 ; i < w; i ++) {
			queue.add(a[i]);
			sum += a[i];
		}
		System.out.println("Sum is :" + sum);
		List<Double> result = new ArrayList<Double>();
		for (int i = w; i < a.length; i++) {
			result.add(sum/w);
			sum = sum - queue.poll(); 
			queue.add(a[i]);
			sum =sum + a[i];
		}
		result.add(sum/w);
		System.out.println("Sliding window probem :");
		for (Double i : result) {
			System.out.print(i + " ");
		}
	}
	
	public static void maxSlidingWindow(int A[], int n, int w, int B[]) {
		Deque<Integer> Q = new ArrayDeque<Integer>();

		// Initialize deque Q for first window
		for (int i = 0; i < w; i++) {
			while (!Q.isEmpty() && A[i] >= A[Q.getLast()])
				Q.pollLast();
			Q.offerLast(i);
		}

		for (int i = w; i < n; i++) {
			B[i - w] = A[Q.getFirst()];

			// update Q for new window
			while (!Q.isEmpty() && A[i] >= A[Q.getLast()])
				Q.pollLast();

			// Pop older element outside window from Q
			while (!Q.isEmpty() && Q.getFirst() <= i - w)
				Q.pollFirst();

			// Insert current element in Q
			Q.offerLast(i);
		}
		B[n - w] = A[Q.getFirst()];
	}
	
	

	static int findNumberOfZerosRecursive(int[] a, int data) {
		int start = 0, end = a.length-1;
		while(start <= end) {
			int mid = start + (end - start)/2;
			if ((mid == end && a[mid] == data) || (a[mid] == data && a[mid+1] > data)) {
				return mid;
			} else if (a[mid] >= data) {
				end = mid - 1;
			} else if (a[mid] > data) {
				start = mid + 1;
			} else {
				return -1;
			}
		}
		return -1;
	}
	static void findRange(int[][] arrays) {
		Queue<NewEntry> queue = new PriorityQueue<NewEntry>();
		for (int i=0; i<arrays.length ;i++) {
			queue.add(new NewEntry(arrays[i][0],arrays[i],0));
		}
		int diff = Integer.MAX_VALUE;
		int finalRange1=0, finalRange2=0;
		while(!queue.isEmpty()) {
			Queue<NewEntry> newQueue = new PriorityQueue<NewEntry>();
			NewEntry range1 = queue.poll();
			int i = queue.size();
			while(i > 1) {
				newQueue.add(queue.poll());
				i--;
			}
			NewEntry range2 = queue.poll();
			newQueue.add(range2);
			System.out.println("Ranges :" + range1.value + " " + range2.value);
			if (Math.abs(range1.value - range2.value) < diff) {
				diff = Math.abs(range1.value - range2.value);
				finalRange1 = range1.value;
				finalRange2 = range2.value;
			}
			if (range1.getNext()) {
				newQueue.add(range1);
			} else {
				break;
			}
			queue = newQueue;
			
		}
		System.out.println("Smallest range is :" + finalRange1 + " - " + finalRange2);
		
	}
	
	//O(n) if all characters are same to O(n!) if all characters are distinct
	public static void permutate(String head, String tail) {
        if (tail.isEmpty()) {
            System.out.println(head);
        } else {
            Set<Character> seen = new HashSet<Character>();
            for (int i = 0; i < tail.length(); i++) {
                if (!seen.contains(tail.charAt(i))) {
                    seen.add(tail.charAt(i));
                    permutate(head + tail.charAt(i), tail.substring(0, i) + tail.substring(i + 1, tail.length()));
                }
            }
        }
    }

	static void findSumInList(Iterator<Integer> it, int sum) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		while (it.hasNext()) {
			int number1 = it.next();
			int number2 = sum - number1;
			if(map.containsKey(number2)) {
				System.out.println("Such numbers are :" + number1 + " and " + number2);
				break;
			}
			map.put(number1, true);
		}
	}
	private static String decrypt(String string, boolean[] isAfterK, Map<Character, Integer> map) {
		String decrypted = "";
		for (int i=0, j=0; i <string.length() ;j++) {
			if(isAfterK[j]) {
				decrypted += getKey(map, Integer.parseInt(string.substring(i, i+2)));
				i+=2;
			} else {
				decrypted += getKey(map, Integer.parseInt(string.substring(i, i+1)));
				i++;
			}
		}
		return decrypted;
	}

	private static String getKey(Map<Character, Integer> map, int parseInt) {
		Set<Map.Entry<Character, Integer>> set = map.entrySet();
		String key = "";
		for (Map.Entry<Character, Integer> entry : set) {
			if (entry.getValue() == parseInt) {
				key = String.valueOf(entry.getKey());
			} 
		}
		return key;
	}

	private static String encrypt(String str, boolean[] isAfterK, Map<Character, Integer> map) {
		char[] array = str.toCharArray();
		String encrypted = "";
		for (int i=0; i < array.length;i++) {
			if (map.get(array[i]) > 9) {
				isAfterK[i] = true;
			}
			encrypted += map.get(array[i]);
		}
		return encrypted;
	}
	
	static void findMax(int[] a) {
		int pass = a.length-1;
		for (int j = pass; j>= pass-1;j--){
			for (int i=0; i<pass; i++) {
				if (a[i] > a[i+1]) {
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}
		System.out.println("largest element is :" + a[pass-1]);
	}
	
	
	public static DoublyLinkedNode convertToLL(BinaryTreeNode root, DoublyLinkedNode currentNode)
	   {
		   if(root == null)
			   return currentNode;
		   else
		   {
			   currentNode = convertToLL(root.getLeft(), currentNode);
			   
			   DoublyLinkedNode newNode = new DoublyLinkedNode();
			   newNode.data = (root.getData());
			   currentNode.next = newNode;
			   newNode.previous = currentNode;
			   currentNode = newNode;
			   
			   return convertToLL(root.getRight(), currentNode);
		   }
	   }
	static void findLatestVersion(String version1, String version2) {
		StringTokenizer st1 = new StringTokenizer(version1, ".");
		StringTokenizer st2 = new StringTokenizer(version2, ".");
		boolean found = false;
		while(st1.hasMoreTokens() && st2.hasMoreTokens()) {
			Integer ver1 = Integer.parseInt(st1.nextToken());
			Integer ver2 = Integer.parseInt(st2.nextToken());
			if (ver1.compareTo(ver2) == -1) {
				System.out.println("Version 2 is latest");
				found = true;
				break;
			} else if (ver1.compareTo(ver2) == 1) {
				System.out.println("Version 1 is latest");
				found = true;
				break;
			} 
		}
		if (!found) {
			if (st1.hasMoreTokens())
				System.out.println("Version 1 is latest");
			else if(st2.hasMoreTokens())
				System.out.println("version 2 is latest");
			else
				System.out.println("Same version");
		}
		
	}
	
	static void removeDuplicatesFromString(String str) {
		char[] charArray = str.toCharArray();
		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
		int j=0;
		for (int i=0;i<charArray.length;i++) {
			if(!map.containsKey(charArray[i])) {
				charArray[j++] = charArray[i];
				map.put(charArray[i], true);
			} 
 		}
		System.out.println(new String(charArray,0,j));
	}
	
	static void removeDuplicatesFromStringBooleanArray(String str) {
		char[] charArray = str.toCharArray();
		boolean[] array = new boolean[(int) Math.pow(2, 8)];
		int j=0;
		for (int i=0;i<charArray.length;i++) {
			if(!array[charArray[i]]) {
				charArray[j++] = charArray[i];
				array[charArray[i]] = true;
			}
 		}
		System.out.println(new String(charArray,0,j));
	}
	
	
	static void countNumberOfZeros(int number) {
		int count = 0;
		int num = number;
		while(number > 0) {
			count = count + (number%10 > 0 ?0:1);
			number = number/10;
		}
		System.out.println("The count of zero is :" + count);
		count = 0;
		while(num > 0) {
			if ((num & 1) == 0)
				count = count + 1;
			num = num>>1;
		}
		System.out.println("The count of zero is :" + count);
	}
	
	static void findfactors_rec(int n, int m)
	{
	    m = m - 1;

	    if(m == 0)
	        return;
	    if(n % m == 0)
	        System.out.print(m + " ");

	    findfactors_rec(n,m);
	}

	static void findfactors_rec_wrapper(int n)
	{
	    findfactors_rec(n,n);
	    System.out.println();
	}
	
	public static int integerfrmbinary(String str){
	    double j=0;
	    for(int i=0;i<str.length();i++){
	        if(str.charAt(i)== '1'){
	         j=j+ Math.pow(2,str.length()-1-i);
	     }

	    }
	    return (int) j;
	}
	
	public static void findSquareRoot(int number)
	{
		//Proceeding to find out square root of the number
		double g1;
		double squareRoot = number / 2;
		do {
			g1 = squareRoot;
			squareRoot = (g1 + (number / g1)) / 2;
		} while ((g1 - squareRoot) != 0);
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> emailList1 = new ArrayList<String>();
		emailList1.add("abc@xyz");emailList1.add("abc1@xyz");emailList1.add("abc2@xyz");emailList1.add("abc31@xyz");
		List<String> emailList2 = new ArrayList<String>();
		emailList2.add("abc@xyz");emailList2.add("abc11@xyz");emailList2.add("abc12@xyz");emailList2.add("abc3@xyz");
		List<String> emailList3 = new ArrayList<String>();
		emailList3.add("abc@xyz");emailList3.add("abc1@xyz");emailList3.add("abc21@xyz");emailList3.add("abc3@xyz");
		List<String> emailList4 = new ArrayList<String>();
		emailList4.add("abc1@xyz");emailList4.add("abc@xyz");emailList4.add("abc12@xyz");emailList4.add("abc3@xyz");
		List<List<String>> emailAddressList = new ArrayList<List<String>>();
		emailAddressList.add(emailList1);
		emailAddressList.add(emailList2);
		emailAddressList.add(emailList3);
		emailAddressList.add(emailList4);
		List<String> result = findCommonEmailAddresses(emailAddressList);
		System.out.println(result.size());
		for (String s : result) 
			System.out.println(s);
		
		
		BinaryTreeNode root1 = new BinaryTreeNode();
		root1.setData(18);
		BinaryTreeNode root2 = new BinaryTreeNode();
		root2.setData(22);
		BinaryTreeNode root3 = new BinaryTreeNode();
		root3.setData(16);
		BinaryTreeNode root4 = new BinaryTreeNode();
		root4.setData(19);
		BinaryTreeNode root5 = new BinaryTreeNode();
		root5.setData(21);
		BinaryTreeNode root6 = new BinaryTreeNode();
		root6.setData(23);
		BinaryTreeNode root7 = new BinaryTreeNode();
		root7.setData(15);
		BinaryTreeNode root8 = new BinaryTreeNode();
		root8.setData(25);
		BinaryTreeNode root9 = new BinaryTreeNode();
		root9.setData(17);
		BinaryTreeNode root = new BinaryTreeNode();
		root.setData(20);
		root.setLeft(root1);
		root.setRight(root2);
		root1.setLeft(root3);
		root1.setRight(root4);
		root2.setLeft(root5);
		root2.setRight(root6);
		root3.setLeft(root7);
		root3.setRight(root9);
		root6.setRight(root8);
		StringBuffer sb = new StringBuffer(); 
		serializeBinaryTree(root, sb);
		BinaryTreeNode temp = deserializeBinaryTree(sb.toString());
		System.out.println();
		TreeExamples.inOrder(temp);
		System.out.println();
		TreeExamples.levelOrder(temp);
		System.out.println();
		List<Integer> li = new ArrayList<Integer>();
		convertBSTToArray(temp, li);
		System.out.println("BST to an array");
		for (Integer i : li) {
			System.out.print(i);
		}
		System.out.println();
		BinaryTreeNode t = convertListToBST(li.iterator(), 0, li.size() -1);
		TreeExamples.inOrder(t);
		System.out.println();
		/*temp = TreeExamples.convertListToBST(list.iterator(), 0, list.size() - 1);//deserializeBinaryTree(list, 0, list.size() - 1);
		System.out.println();
		TreeExamples.inOrder(temp);
		System.out.println();
		TreeExamples.levelOrder(temp);
		System.out.println();
		TreeExamples.levelOrder(root);*/
		
		int[] a = new int[1000];
		for (int i = 0 ; i < 1000; i++) {
			a[i] = i+1;
		}
		int[] b = new int[] {2,3};
		for (int i :findPosition(b, 20)) {
			System.out.print(i + " ");
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 1);
	    map.put('B', 2);
	    map.put('C', 3);
	    map.put('D', 4);
	    map.put('E', 5);
	    map.put('F', 6);
	    map.put('G', 7);
	    map.put('H', 8);
	    map.put('I', 9);
	    map.put('J', 10);
	    map.put('K', 11);
	    map.put('L', 12);
	    map.put('M', 13);
	    map.put('N', 14);
	    map.put('O', 15);
	    map.put('P', 16);
	    map.put('Q', 17);
	    map.put('R', 18);
	    map.put('S', 19);
	    map.put('T', 20);
	    map.put('U', 21);
	    map.put('V', 22);
	    map.put('W', 23);
	    map.put('X', 24);
	    map.put('Y', 25);
	    map.put('Z', 26);
	    String str = "ABCEZYAR";
	    boolean[] isAfterK = new boolean[str.length()];
	    System.out.println(encrypt(str, isAfterK, map));
	    System.out.println(decrypt("12352625118", isAfterK,map));
	    int[] max = new int[] {10,8,6,2,3}; 
	    findMax(max);
	    Points p1 = new Points(1, 2);
	    Points p2 = new Points(2, 3);
	    Points p3 = new Points(5, 6);
	    Points p4 = new Points(2, 9);
	    Points p5 = new Points(0, 3);
	    Points p6 = new Points(0, 2);
	    Points[] p = new Points[6];
	    p[0] = p1; p[1] = p2;p[2] = p3;p[3] = p4;p[4] = p5;p[5] = p6;
	    Queue<Points> queue = new PriorityQueue<Points>(p.length);
	    
	    for (int i = 0 ; i < 3; i++) {
	    	queue.add(p[i]);
	    }
	    for (int i = 3; i < p.length ; i++) {
	    	Points pt = queue.peek();
	    	if (pt.distance > p[i].distance) {
	    		queue.poll();
	    		queue.add(p[i]);
	    	}
	    }
	    for (int i =0 ; i < 3; i++) {
	    	Points pt = queue.poll();
	    	System.out.println("Point -" +(i+1) +" x value :" + pt.x + " Y value :" + pt.y);
	    }
		Points pts = new Points();
		Arrays.sort(p);
		Arrays.sort(p, pts.comparator);
	    findRelation(p);
	    
	    findLatestVersion("10.3.4" , "10.3");
	    
	    List<Integer> list = Arrays.asList(new Integer[] {3,4,5,5,2,1});
	    //Collections.sort(list);
	    findSumInList(list.iterator(), 10);
	    permutate("", "abc");
	    
	    int[][] array = new int[][] {{0,10,255},{2,11,257},{4,12,258}};
	    findRange(array);
	    
	    int zeroArray[] = new int[] {1,1,1};
	    System.out.println("Number of zeros recursive:" + findNumberOfZerosRecursive(zeroArray, 0, zeroArray.length-1, 0));
	    System.out.println("Number of zeros iterative:" + findNumberOfZerosRecursive(zeroArray, 0));
	    int slidingWindow[] = { 1, 3, -1, -3, 5, 3, 6, 7 };

	    findAverageInSlidingWindow(slidingWindow, 3);
	    int[] resultArray = new int[slidingWindow.length - 3 + 1];
	    maxSlidingWindow(slidingWindow, slidingWindow.length, 3, resultArray);
	    System.out.println();
	    for (int i : resultArray) {
	    	System.out.print(i + " ");
	    }
	    System.out.println();
	    findAnagrams("aa", "aaaa");
	    System.out.println();
	    isNumberPowerOfTwo(-128);
	    removeDuplicatesFromString("aabbcddabc");
	    removeDuplicatesFromStringBooleanArray("aabbcddabc");
	    countNumberOfZeros(10);
	    findfactors_rec_wrapper(15);
	    
	}
	
	
}

class NewEntry implements Comparable<NewEntry> {

	int value;
	int[] array;
	int index;
	
	public NewEntry() {
		super();
	}
	
	public NewEntry(int value,int[] array,int index) {
		this.value = value;
		this.array = array;
		this.index = index;
	}
	public boolean getNext() {
		this.index++;
		if(index < array.length) {
			this.value = array[this.index];
			return true;
		} else {
			return false;
		}
	}
	@Override
	public int compareTo(NewEntry o) {
		return this.value - o.value;
	}
	
}
class Points implements Comparable<Points>{
	int x;
	int y;
	double distance;
	
	
	public Points() {
		super();
	}

	public Points(int x, int y) {
		this.x = x;
		this.y = y;
		this.distance =(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))); 
	}

	/*@Override
	public int compareTo(Points o) {
		return this.x - o.x;
	}
	*/
	public Comparator<Points> comparator = new Comparator<Points>() {
		
		@Override
		public int compare(Points o1, Points o2) {
			return new Integer(o1.y).compareTo(o2.y);
		}
	}; 

	@Override
	public int compareTo(Points o) {
		return Double.compare(o.distance, this.distance);
	}
}