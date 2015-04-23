import java.util.Arrays;
import java.util.Scanner;


public class selectionSort {

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
		for(int i=0; i<a.length; i++)
		{
			int index = i; 
			for(int j=i+1; j<a.length;j++)
			{
				if(a[j]<a[i])
				{
					index=j;
				}
				int small = a[index];
				a[index]=a[i];
				a[i]=small ;
			}
		}
		return a;
	}

}
