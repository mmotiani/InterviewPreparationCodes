package hardik.code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DynamicProgramingAndStringAlgorithms {

	static String findLongestCommonSubString(String[] stringArray) {
		String smallestString = "";
		for (String string : stringArray) {
			if (string != null && smallestString.isEmpty())
				smallestString = string;
			else if (string != null && smallestString.length() > string.length())
				smallestString = string;
		}
		String longestCommonSubString = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0 ; i < smallestString.length() ; i++) {
			char c = smallestString.charAt(i);
			sb.append(c);
			for (String string : stringArray) {
				if (string != null && !string.contains(sb.toString())) {
					sb = sb.deleteCharAt(0);
					break;
				}
			}
			if (sb.length() != 0 && sb.length() > longestCommonSubString.length()) {
				longestCommonSubString = sb.toString();
			}
		}
		System.out.println("longest common substring is :" + longestCommonSubString);
		return longestCommonSubString;
	}
	
	
	static String findLongestCommonSubSequence(String string1, String string2) {
		int[][] lengthArray = new int[string1.length()+1][string2.length()+1];
		
		for (int i = 0 ; i < string1.length() ; i++) {
			for (int j =0 ; j < string2.length() ; j++) {
				if (string1.charAt(i) == string2.charAt(j)) {
					lengthArray[i+1][j+1] = 1 + lengthArray[i][j];
				} else {
					lengthArray[i+1][j+1] = Math.max(lengthArray[i][j+1], lengthArray[i+1][j]);
				}
			}
		}
		StringBuffer longestCommonSubSequence = new StringBuffer();
		for (int x=string1.length(), y =  string2.length(); x !=0 && y!=0;)
		{
			if (lengthArray[x][y] == lengthArray[x][y-1]) {
				y--;
			} else if (lengthArray[x][y] == lengthArray[x-1][y]) {
				x--;
			} else if (string1.charAt(x-1) == string2.charAt(y -1)) {
				longestCommonSubSequence.append(string1.charAt(x-1));
				x--;
				y--;
			}
		}
		System.out.println(longestCommonSubSequence.reverse().toString());
		return longestCommonSubSequence.reverse().toString();
	}
	
	
	//O(2^n)
	static ArrayList<ArrayList<Integer>> findSubSets(ArrayList<Integer> list, int index) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
		if (list.size() == index) {
			result.add(new ArrayList<Integer>());
		} else {
			int set = list.get(index);
			result = findSubSets(list, index + 1);
			ArrayList<ArrayList<Integer>> subResult1 = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> temp : result) {
				ArrayList<Integer> subResult2 = new ArrayList<Integer>();
				subResult2.addAll(temp);
				subResult2.add(set);
				subResult1.add(subResult2);
				
			}
			result.addAll(subResult1);
		}
		return result;
	}
	
	static ArrayList<String> findAllPermutation(String string) {
		if (string == null)
			return null;
		ArrayList<String> array = new ArrayList<String>();
		if (string.length() == 0) {
			array.add("");
			return array;
		} 
		char c = string.charAt(0);
		ArrayList<String> words = findAllPermutation(string.substring(1));
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String start = word.substring(0, j);
				start += (c + word.substring(j));
				array.add(start);
			}
		}
		return array;
	}
	
	
	static void printAllParenthesisPattern(ArrayList<String> list, char[] s, int leftRem, int righRem, int count) {
		if (leftRem < 0 || righRem < leftRem) {
			return;
		}
		if (leftRem ==0 && righRem ==0) {
			String string = String.copyValueOf(s);
			list.add(string);
		} else {
			if (leftRem > 0) {
				s[count] = '(';
				printAllParenthesisPattern(list, s, leftRem -1, righRem, count+1);
			}
			
			if (righRem > leftRem) {
				s[count] = ')';
				printAllParenthesisPattern(list, s, leftRem, righRem - 1, count+1);
			}
		}
	}
	
	public static int countWaysDP(int n, int[] map) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (map[n] > -1) {
			return map[n];
		} else {
			map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map)
					+ countWaysDP(n - 3, map);
			return map[n];
		}
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
		
		static int lis( int arr[], int n )
		{
		   int  i, j, max = 0;
		   int[] lis = new int[n];
		 
		   /* Initialize LIS values for all indexes */
		   for ( i = 0; i < n; i++ )
		      lis[i] = 1;
		    
		   /* Compute optimized LIS values in bottom up manner */
		   for ( i = 1; i < n; i++ )
		      for ( j = 0; j < i; j++ )
		         if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
		            lis[i] = lis[j] + 1;
		    
		   /* Pick maximum of all LIS values */
		   for ( i = 0; i < n; i++ )
		      if ( max < lis[i] )
		         max = lis[i];
		 
		   /* Free memory to avoid memory leak */
		   lis = null;
		 
		   return max;
		}
	public static void main(String[] args) {
		String[] string = new String[] {"abcdab", "abcdababc", "abcdab", "ablcdabkacd"};
		findLongestCommonSubString(string);
		findLongestCommonSubSequence("ABCBDABC", "BDCABAC");
		findLongestCommonSubSequence("abcdababc", "ablcdabkacd");
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);list.add(4);list.add(5);
		System.out.println(findSubSets(list, 0).toString());
		System.out.println(findAllPermutation("ab").toString());
		int count = 2;
		ArrayList<String> list1 = new ArrayList<String>();
		char[] chArray = new char[count*2];
		printAllParenthesisPattern(list1, chArray, count, count, 0);
		for (String s : list1) {
			System.out.print(s + " ");
		}System.out.println();
		
		int n = 3;
		int[] map = new int[] {-1,-1,-1,-1};
		System.out.println(countWaysDP(n, map));
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		System.out.println(lis(arr,arr.length-1));
			
	}
}
