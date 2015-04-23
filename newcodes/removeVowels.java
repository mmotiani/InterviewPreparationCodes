import java.util.Scanner;


public class removeVowels {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = in.nextLine();
		System.out.println("Before Removal::" + str.toString());
		str = str.replaceAll("[aeiouAEIOU]", "");
		System.out.println("After Removal::" + str.toString());
		
	}

}
