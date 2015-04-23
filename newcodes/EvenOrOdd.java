import java.util.Scanner;


public class EvenOrOdd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = in.nextInt();
		int m=n;
		if(m%2==0)
		{
			while(m>0)
			{	
				int i = m%10;
				if((i%2)==0)
					System.out.print(m%10+ "  ");		
				m=m/10;
			}
		}
		else
		{
			while(m>0)
			{
				int i = m%10;
				if((i%2)!=0)
					System.out.print(m%10+" ");	
				m=m/10;
			}
		}		
	}
}
