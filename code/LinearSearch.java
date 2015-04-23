import java.util.Arrays;
import java.util.Scanner;


public class LinearSearch {
 public static void main(String args[]){
	 @SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	 int array[],n,x;
	 int i;
	 System.out.println("Enter number of elements: ");
	 n=sc.nextInt();
	 array=new int[n];
	 System.out.println("Enter elements "+n+" in the array:");
	 for( i=0;i<n;i++){
		 array[i]=sc.nextInt();
	 }
	 System.out.println(Arrays.toString(array));
	 System.out.println("Enter element to be searched");
	 x=sc.nextInt();
	 
	 for( i=0;i<n;i++)
	 {
		// System.out.println("I am here");
		 if(array[i]==x)
			 {System.out.println("It is at position" + i+1);
		 break;}
	 }
	 if(i==n)
		 System.out.println("The element is absent");
 }
}
