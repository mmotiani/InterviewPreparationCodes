package hardik.code;

public class LongestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String S= "abcdcba";
	printLongestPalindrome(S);
	}
	
	
	public static void printLongestPalindrome(String S)
	{
		int maxBack=-1;
		int maxFront = -1;
		int maxLength=0;
		for (int potentialCenter = 0 ; potentialCenter < S.length();potentialCenter ++ )
		{	
			int back = potentialCenter-1;
			int front = potentialCenter + 1;
			int longestPalindrome = 0;
			while(back >=0 && front<S.length() && S.charAt(back)==S.charAt(front))
			{
				back--;
				front++;
				longestPalindrome++;
				
			}
			if (longestPalindrome > maxLength)
			{
				maxLength = longestPalindrome+1;
				maxBack = back + 1;
				maxFront = front;
			}
			back = potentialCenter;
			front = potentialCenter + 1;
			longestPalindrome=0;
			while(back >=0 && front<S.length() && S.charAt(back)==S.charAt(front))
			{
				back--;
				front++;
				longestPalindrome++;
			}
			if (longestPalindrome > maxLength)
			{
				maxLength = longestPalindrome;
				maxBack = back + 1;
				maxFront = front;
			}
			
		}
		
		
		if (maxLength == 0) System.out.println("There is no Palindrome in the given String");
		else{
			System.out.println("The Longest Palindrome is " + S.substring(maxBack,maxFront) + "of " + maxLength);
		}
	}

}
