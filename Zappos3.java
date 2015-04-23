package hardik.code;

public class Zappos3 {

	public static void main(String[] args) {
		System.out.	println(superPower(15));
	}
	static int superPower(int z) {
        int result;
        // checks whether the number is even, if yes then it is a power of even number
		if (z%2 == 0)
			result =isSuperPower(z,2,2);
        // checks whether the number is multiple of 5, if yes then it is a power of multiple of 5 only
		else if (z%5 == 0)
			result =isSuperPower(z,5,10);
        // checks whether the number is odd, if yes then it is a power of odd number
		else
			result =isSuperPower(z,3,2);
		
		return result;
    }
    static int isSuperPower(int number, int power, int increment) {
		while (true) {
            //Loop untill the power is greater than the numebr
			int i = 2;
			if (Math.pow(power, i)<=number) {
				i++;
				continue;
			}
			//for(i=2;Math.pow(power, i)<=number;i++);
			
            //check whether the previous power equals the number
			if(Math.pow(power, i-1) == number)
				return 1;
            //If the power is grater than the number for i=2 itself then return 0
			if (i == 2)
				return 0;
			power=power+increment;
		}
	}

}
