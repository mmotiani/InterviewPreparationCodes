package hardik.code;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ZapposAssessent {

	static int palindrome(String str, int i) {
        int count = 0;
        if (str == null || str.isEmpty())
			return 0;
        HashSet<String> set = findDistinctSubStrings(str);
        Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			if (isPalindrome(it.next()))
				count++;
		}
		return count;
    }
    static HashSet<String> findDistinctSubStrings(String str) {
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = 1; j <= str.length() - i ; j++) {
				set.add(str.substring(i, i + j));
			}
		}
        return set;
	}
    
    public static boolean isPalindrome(String str) {
		StringBuffer sb =  new StringBuffer();
		for (int i = str.length()-1; i >=0; i--) {
			sb.append(str.charAt(i));
		}
		return (sb.toString().equals(str));
		
	}
    
    public static void test() {
    	Set<String> stringSet = new HashSet<>();
		 String str = "abcacbbbca";
		 int back;
		 int front;
	     for (int center = 0; center < str.length(); center++) {
	         
	         
	         back = center;
	         front = center+1;
	         while (back >= 0 && front < str.length() && str.charAt(back) == str.charAt(front)) {
		    	  stringSet.add(str.substring(back,front+1));
		    	  back--;
		    	  front++;
		      }
	         
	         
	         
	         back = center;
	         front = center;
	         while (back >= 0 && front < str.length() && str.charAt(back) == str.charAt(front)) {
		    	  stringSet.add(str.substring(back,front+1));
		    	  back--;
		    	  front++;
		      }
	     } 
	     
	     for(String str1:stringSet)
	     {
	    	 System.out.println(str1);
	     }
    }
    
    
    static int palindrome(String str) {
        if (str == null || str.isEmpty())
			return 0;
        HashSet<String> set = findSubStrings(str);
		return set.size();
    }
    
    static HashSet<String> findSubStrings(String str) {
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < str.length(); i++) {
            //To check whether this substring of even length is palindrom or not
			isPalindrome(set, str, i , i+1);
            //To check whether this substring of odd length is palindrom or not
			isPalindrome(set, str, i , i);
		}
        return set;
	}
    
    public static void isPalindrome(Set<String> result, final String str, int i, int j) {
        while (i >=0 && j < str.length() && str.charAt(i) == str.charAt(j)) {
            result.add(str.substring(i, j+1));
            i--;
            j++;
        }
	}
 	public static void main(String[] args) {
		System.out.println("String is " + palindrome("aabaa"));
		longestPalindrome("abcabaaabc");
	}

 	public static  String longestPalindrome(String s) {
 		if (s.isEmpty()) {
 			return null;
 		}
 	 
 		if (s.length() == 1) {
 			return s;
 		}
 	 
 		String longest = s.substring(0, 1);
 		for (int i = 0; i < s.length(); i++) {
 			// get longest palindrome with center of i
 			String tmp = helper(s, i, i);
 			if (tmp.length() > longest.length()) {
 				longest = tmp;
 			}
 	 
 			// get longest palindrome with center of i, i+1
 			tmp = helper(s, i, i + 1);
 			if (tmp.length() > longest.length()) {
 				longest = tmp;
 			}
 		}
 	 System.out.println("Longest Palindrome is :" + longest);
 		return longest;
 	}
 	 
 	// Given a center, either one letter or two letter, 
 	// Find longest palindrome
 	public static String helper(String s, int begin, int end) {
 		while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
 			begin--;
 			end++;
 		}
 		return s.substring(begin + 1, end);
 	}
 	
 
}



 	
