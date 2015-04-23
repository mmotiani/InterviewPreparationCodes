import java.util.Scanner;


public class binaryTodecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Binary Number");
		long n = in.nextLong();
		int m = binarytodecimal(n);
		
		System.out.println("Equvalent Decimal Number is:: "+m);
		
	}

	private static int binarytodecimal(long n) {
		// TODO Auto-generated method stub
		String str = Long.toString(n);
		int a=0;
		int m=0;
		for(int i = str.length()-1; i>=0; i--)
		{
			if(str.charAt(i)=='0'){
				m=m+1;			
			}
			else{
				a = (int) (a + Math.pow(2, m));
			m=m+1; 
		}
				
		}
		return a;
	}

}
