import java.util.HashSet;
import java.util.Scanner;
import java.util.Arrays;

public class removeDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements in array");
		int n = in.nextInt();
		int []c = new int[n];
		System.out.println("Enter the arrray::");
		for(int i=0; i<n;i++)
		{
			c[i]=in.nextInt();
		}
		System.out.println("Array Before:: " +Arrays.toString(c));
		HashSet h = new HashSet();
		for(int i=0; i<n; i++)
		{
			h.add(c[i]);
		}
		System.out.println("Array After:: "+h);
		
	}

}
