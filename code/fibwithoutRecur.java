import java.util.Scanner;


public class fibwithoutRecur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements you want to generate in fibonacci series");
		int n = in.nextInt();
		int a=0;
		int b=1;
		int c;
		if(n==1)
		{
			System.out.println(a + " ");
		}
		else if(n==2)
		{
			System.out.println(a + " " + b + "  ");
		}
		else{
			System.out.print(a + " " + b + "  ");
		for(int i=2 ; i<n; i++)
		{
			c=a+b;
			a=b;
			b=c;
			System.out.print(c + "  ");
		}
		}
		
		
		
		
	}

}
