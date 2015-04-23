import java.util.Scanner;
import java.util.StringTokenizer;


public class reverseSentenceWithoutWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = in.nextLine();
		System.out.println("Before Reverse:: "+str.toString());
		StringTokenizer st = new StringTokenizer(str);
		System.out.println("After Reverse::");
		while(st.hasMoreTokens())
			System.out.print(reverse(st.nextToken())+ " ");
	}

	private static StringBuilder reverse(String nextToken) {
		// TODO Auto-generated method stub
		StringBuilder dest = new StringBuilder(nextToken.length());
		for(int i = nextToken.length()-1; i>=0;i--)
				dest.append(nextToken.charAt(i));
		return dest;
		
	}

}
