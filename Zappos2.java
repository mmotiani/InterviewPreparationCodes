package hardik.code;

import java.util.Scanner;

public class Zappos2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int number = sc.nextInt();
			int powerArray[] = new int[number + 1], valueArray[] = new int[number + 1];
			int numValue = 1, powerTen = 1, j = 0, count = 0;
			while (j <= number)
				powerArray[j++] = 0;
			j = 0;
			while (numValue <= number) {
				valueArray[numValue] = powerTen;

				for (j = 0; j <= number; j++) {
					if (powerArray[j] != 0
							&& powerArray[(j + powerTen) % number] == 0
							&& powerArray[j] != numValue)
						powerArray[(j + powerTen) % number] = numValue;
				}
				if (powerArray[powerTen] == 0)
					powerArray[powerTen] = numValue;
				powerTen = (10 * powerTen) % number;
				if (powerArray[0] != 0)
					break;
				numValue++;
			}
			numValue = number;
			if (powerArray[0] == 0 && numValue == 1)
				System.out.print(numValue + "" + powerArray[0]);
			else if(powerArray[0] != 0) {
				while (numValue != 0) {
					while (--count > powerArray[numValue % number] - 1)
						System.out.print("0");
					count = (powerArray[numValue % number] - 1);
					System.out.print("1");
					numValue = ((number + numValue -
							valueArray[powerArray[numValue% number]]) % number);
				}
				while (count != 0) {
					System.out.print("0");
					count--;
				}

			}
		} catch (Exception e) {
			System.out.println("Some Exception Occured" + e.getMessage());
		} finally {
			sc.close();
		}

	}
}
