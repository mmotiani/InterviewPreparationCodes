import java.util.Scanner;

public class fibb2 {

		/**
		 * @param args
		 */
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the number of elements in array");
			int n = in.nextInt();
			if(n==1||n==2)
			{
				System.out.println("Undetermined..at least 3 values");
				System.exit(0);
			}
			int []a = new int[n];
			System.out.println("Enter the array");
			for(int i = 0 ; i<n ; i++)
			{
				a[i] = in.nextInt();
			}
			fib(a, n);	
			
			//initilaize fragment
			int n2=3;
			int[] a2=new int[]{2,3,5};

			int res= checkFragmentFib(n, n2, a, a2);
			if(res==0)
			  System.out.println("No");	
			else 
				 System.out.println("Yes");
			
		}

		private static void fib(int[] a, int n) {
			// TODO Auto-generated method stub
			int j=2;			
			int flag=0;
			int count=0;
			while(j<n)
			{
				if(a[j] !=(a[j-1] +a[j-2] ))
				{
					flag=1;
					System.out.println("Series is not Fibonacii");
					break;
				}
				if(a[0]==0||a[1]==1)
				{
					count=1;
				}
				j++;
			}
			if(count==1)
			{
				System.out.println("Entered fibonacci sequence is from start");
				//System.exit(0);
			}
				if(flag==0)
				{
					System.out.println("Entered fibbonaci is a fragment");
				}
			
				
			
		}

	
	
	private static int checkFragmentFib(int n1, int n2,int arr1[],int arr2[])
	{
		for(int i =0; i<n1; i++)
		{
		   for(int j=0;j<n2;j++)
		   {
		     if(arr1[i]==arr2[j])  
		     break;
		   }

		if (i==n2)
			return 0;
		
		//return 0;
		}
		
	    return 1;
	}

}
