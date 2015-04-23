package hardik.code;

public class JavaPattern {

	public static void main(String[] args) {
		for (int i = 1 ; i <=5; i++) {
			for (int j=1; j <= i; j++) {
				if(i%2 != 0)
					System.out.print(1);
			}
			if(i%2 != 0)
			System.out.println();
		}
		
		for (int i = 1 ; i <=5; i++) {
			for (int j = 1; j <=i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		for (int i = 'A' ; i <='E'; i++) {
			for (int j = 'A'; j <=i; j++) {
				System.out.print("" + (char)j);
			}
			System.out.println();
		}
	}
}
