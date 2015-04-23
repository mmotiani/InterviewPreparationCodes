import java.util.Arrays;
import java.util.Scanner;


public class insertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements in array");
		int n = in.nextInt();
		int a[] = new int[n];
		System.out.println("Enter the array");
		for(int i=0; i<n;i++)
		{
			a[i]= in.nextInt();
		}
		System.out.println("Before Sort: "+Arrays.toString(a));
		a = sort(a);
		System.out.println("Array Sort: "+Arrays.toString(a));
	

	}

	private static int[] sort(int[] a) {
		// TODO Auto-generated method stub
		for(int i=1; i<a.length; i++)
		{
			int temp = a[i];
			int j;
			for(j=i-1;j>=0 && temp<a[j];j-- )
			{
				a[j+1]=a[j];
			}
			a[j+1]=temp;
		}
		return a;
	}

}
