import java.util.Arrays;
import java.util.Scanner;


public class dutchFlag {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("Enter the no of balls");
		int n = in.nextInt();
		String []str = new String [n+1];
		System.out.println("Enter " + n + " balls: red, white or blue");
		
		for(int i=0; i<str.length; i++)
		{
			str[i] = in.nextLine();
		}
		for(int i=0; i<str.length ; i++)
		{
			System.out.print(str[i]+ " ");
		}
		int[] b = new int[3];
		for (int i=0;i<3;i++)
		{
			b[i]=0;
		}
		for(int i=0;i<str.length;i++)
		{
			if(str[i].equalsIgnoreCase("blue"))
				b[0]++;
			if(str[i].equalsIgnoreCase("white"))
				b[1]++;
			if(str[i].equalsIgnoreCase("red"))
				b[2]++;
		}
		
		int number =0;
		for(int i=0;i <b.length ; i++)
		{
			for(int j = 0; j<b[i];j++)
			{
				if(i==0)
				{
					str[number]="blue";
					number++;
				}
				if(i==1)
				{
					str[number]="white";
					number++;
				}
				if(i==2)
				{
					str[number]="red";
					number++;
				}
			}
		}
		System.out.println();
		for(int i=0; i<str.length ; i++)
		{
			System.out.print(str[i]+ " ");
		}
		
		
	}

}
