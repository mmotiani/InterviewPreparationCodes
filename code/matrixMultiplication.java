import java.util.Scanner;


public class matrixMultiplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value=0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of rows of first Matrix");
		int m = in.nextInt();
		
		System.out.println("Enter the number of columns of first Matrix");
		int n = in.nextInt();
		
		int [][]arr1 = new int[m][n];
		System.out.println("enter the elements of first Matrix");
		for(int i =0 ; i<m; i++)
			for(int j=0; j<n;j++)
				arr1[i][j]=in.nextInt();
		
		System.out.println("Enter the number of rows of second Matrix");
		int p = in.nextInt();
		
		System.out.println("Enter the number of columns of second Matrix");
		int q = in.nextInt();
		if(n!=p)
		{
			System.out.println("matrix with entered order can't be multiplied");
			System.exit(0);
		}
		
		int [][]arr2 = new int[m][n];
		System.out.println("enter the elements of second Matrix");
		for(int i =0 ; i<m; i++)
			for(int j=0; j<n;j++)
				arr2[i][j]=in.nextInt();
		
		int [][]multiply = new int [m][q];
		
		for (int i=0; i<m; i++)
		{
			for (int j=0; j<q; j++)
			{
				for (int k=0; k<p; k++)
				{
					value = value + arr1[i][k] * arr2[k][j];
				}
				multiply[i][j]=value;
				value=0;
			}
		}
		
		System.out.println("Product of Matrix:");
		System.out.println("__________________");
		for(int i=0;i<m;i++)
		{
			for(int j=0 ; j<q ; j++)
				System.out.println(multiply[i][j]+"\t");
			
			System.out.println("\n");
		}
		
		
	}

}
