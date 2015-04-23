import java.util.Arrays;
import java.util.Scanner;


public class stringCompress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = in.nextLine();
		System.out.println("String:: "+str.toString());
		compress(str);

	}

	private static void compress(String str) {
		// TODO Auto-generated method stub
		char []c=new char[2*str.length()];
		int i;
		for(i=0; i<str.length()-2;i=i+2)
		{
			c[i]=c[i+1]=str.charAt(i);
		}
		System.out.println("Array at step "+(i+1)+" = " + Arrays.toString(c));
		String s1 = new String(c);
		compress(s1);
	}

}
