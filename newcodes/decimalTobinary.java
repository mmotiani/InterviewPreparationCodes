import java.util.Scanner;


public class decimalTobinary {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = in.nextInt();
		String m = decimaltobinary(n);
		System.out.println("Equvalent Binary Number is:: "+m);
	}

	private static String decimaltobinary(int n) {
		// TODO Auto-generated method stub
		String str = "";
		if(n==0)
		return "0";
		else
		{
			while(n>0)
			{
				int rem = n % 2;
				str = rem + str;
				n=n/2;
			}
			return str;
		}
	}

}
