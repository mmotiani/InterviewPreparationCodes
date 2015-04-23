import java.util.Scanner;


public class regex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = in.nextLine();
		System.out.println(str);
		str=str.replaceAll("[^a-zA-Z ]", "");
		System.out.println();
		System.out.println(str);

	}

}
