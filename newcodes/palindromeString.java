import java.util.Scanner;


public class palindromeString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string::");
		String str = in.nextLine();
		String reverse="";
		int length = str.length();
		for (int i =length-1;i>=0;i-- )
			reverse = reverse + str.charAt(i);
		
		if(str.equals(reverse))
		{
			System.out.println("String is palindrome");
		}
		else
		{
			System.out.println("String is not palindrome");
		}
	}

}
