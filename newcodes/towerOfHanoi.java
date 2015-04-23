import java.util.Scanner;


public class towerOfHanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter no of disks");
		int n = in.nextInt();
		towerofhanoi(n, 'A', 'B', 'C');
		// TODO Auto-generated method stub

	}

	private static void towerofhanoi(int n, char A, char B, char C) {
		// TODO Auto-generated method stub
		if(n==1)
		{
			System.out.println("Move disk from " +A+ " to "+B );
		}
		else{
		towerofhanoi(n-1,'A', 'C', 'B');
		towerofhanoi(1,'A', 'B', 'C' );
		towerofhanoi(n-1, 'C', 'B', 'A' );
	}
	}

}
