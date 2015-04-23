import java.util.Scanner;


public class EvenOdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int j, k=0;
		System.out.println("Enter the number of elements in array");
		int n = in.nextInt();
		int []a = new int[n];
		
		System.out.println("Enter the array");
		try{
		for(int i = 0 ; i<n ; i++)
		{
				a[i] = in.nextInt();
				if(a[i]<0)
				{
					System.out.println("array should be of positive numbers");
					System.exit(0);
				}
		}
		}
		catch(Exception ex)
		{
			System.out.println("Unexpected Result");
		}
		for(int i = 0 ; i<n ; i++)
		{
				System.out.print(a[i]+ " ");
		}
		for(j=0;j<a.length;j++)
		{
			if(a[j]%2==0)
			{
				int temp = a[j];
				a[j]=a[k];
				a[k]=temp;
				k++;
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("_____________________");
		System.out.println("After making Changes");
		System.out.println("_____________________");
		System.out.println();
		for(int i = 0 ; i<n ; i++)
		{
				System.out.print(a[i]+ " ");
		}

	}

}
