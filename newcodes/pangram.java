import java.util.Hashtable;
import java.util.Scanner;


public class pangram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = in.nextLine();
		str=str.replaceAll(" ","");
		str=str.toLowerCase();
		char [] ch = str.toCharArray();
		Hashtable<Character,Integer> h = new Hashtable<Character, Integer>();
		for (char c : ch) {
			if(h.containsKey(c))
			{
				continue;
			}
			else
			{
				h.put(c, 1);
			}
		}
		if(h.size()==26)
		{
			System.out.println("entered string is pangram");
		}
		else
		{
			System.out.println("entered string is not pangram");
		}

	}

}
