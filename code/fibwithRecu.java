import java.util.Scanner;


public class fibwithRecu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements you want to generate in fibonacci series");
		int n = in.nextInt();
		int c;
		for(int i=0;i<=n;i++)
		System.out.print(fib(i) + " ");
		
	}

	public static int fib(int n) {
		// TODO Auto-generated method stub
		if(n==0)
		{
			return 0;
		}
		else if(n==1)
		{
			return 1;
		}
		else
		{
			return fib(n-1)+fib(n-2);
		}
		
	}

	

}
