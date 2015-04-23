import java.util.Scanner;


public class sumofDigits {

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
		for(int i=0; i<n; i++)
		{
			a[i]=in.nextInt();
		}
		System.out.println("Enter the elements whose sum you want::");
		int m = in.nextInt();
		
		int i=0;
		int j=n-1;
		int flag=0;
		while(i<j)
		{
			if((a[i]+a[j])>m)
			{
				j--;
			}
			else if((a[i]+a[j])<m)
			{
				i++;
			}
			else
			{
				flag=1;
				System.out.println(a[i] + " + " + a[j] + " = " + (a[i]+a[j]));
				i++;
				j--;
			}
		}
		if(flag==0)
		{
			System.out.println("There is not two values whose sum is equal to "+m);
		}
	}

}
