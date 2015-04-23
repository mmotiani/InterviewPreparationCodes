import java.util.Hashtable;
import java.util.Scanner;


public class stringtoken {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = in.nextLine();
		String [] tokens = str.split(" ");
		int tokencount = tokens.length;
		Hashtable<String, Integer> h = new Hashtable<String, Integer>();
		for(int i = 0;i<tokencount;i++)
		{
			if(h.containsKey(tokens[i]))
			{
				System.out.println(tokens[i]);
				break;
			}
			else
			{
				h.put(tokens[i], 1);
			}
		}
		
	}

}
