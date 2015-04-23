import java.util.Scanner;


public class palindromeNo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number you want to reverse");
		long n = in.nextLong();
		long a=n;
		long reverse = 0;
		long digit=0;
		while(n>0)
		{
			digit = n%10;
			reverse = reverse * 10 +digit;
			n=n/10;
		}
		if(reverse==a)
		{
			System.out.println("No is  palindrome");
		}
		else
		{
			System.out.println("No is not palindrome");
		}

	}

}
