import java.util.Scanner;


public class stringRotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter First String::");
		String first = in.nextLine();
		System.out.println("Enter Second String");
		String second = in.nextLine();
		
		if(rotate(first, second))
		{
			System.out.println("Second string is rotation of first");
		}
		else
			System.out.println("Second string is not rotation of first");
	}

	private static boolean rotate(String first, String second) {
		// TODO Auto-generated method stub
		if(first.length()!=second.length())
		{
			return false;
		}
		if(first.equals(second))
		{
			System.out.println("Entered Strings are equal. Rotation will give the same result.");
			System.exit(0);
		}
		String str = first + first;
		int n = str.indexOf(second);
		if(n>0)
		{	
			return true;
		}
		else
			return false;
	}

}
