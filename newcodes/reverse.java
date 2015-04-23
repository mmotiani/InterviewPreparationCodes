import java.util.Arrays;
import java.util.Scanner;


public class reverse {

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
		for(int i = 0, j=c.length-1; i<=j;i++,j--)
		{
			int temp = c[i];
			c[i]=c[j];
			c[j]=temp;
		}
		System.out.println("Array After:: "+Arrays.toString(c));
	}

}
