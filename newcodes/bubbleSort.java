import java.util.Scanner;


public class bubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements in array");
		int n = in.nextInt();
		int []a = new int[n];
		System.out.println("Enter the array");
		for(int i = 0 ; i<n ; i++)
		{
			
			a[i] = in.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			for(int j=1;j<n-i;j++)
			{
				if(a[j-1]>a[j])
				{
					int temp = a[j-1];
					a[j-1]= a[j];
					a[j]=temp;
					
				}
			}
		}
		System.out.println("_____________________________________");
		System.out.println("sorted array is:");
		for(int i = 0 ; i<n ; i++)
		{
			
			System.out.println(a[i]);
		}
		
	}

}
