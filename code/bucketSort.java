import java.util.Arrays;
import java.util.Scanner;


public class bucketSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements in array");
		int n = in.nextInt();
		int []a = new int[n];
		System.out.println("Enter the array");
		for(int i = 0 ; i<n ; i++)
		{
			
			a[i] = in.nextInt();
		}
		
		 int max = a[0];
	      for(int i=0;i<a.length;i++)
	      {
	    	 if(a[i]>max)
	    	 {
	    		 max=a[i];
	    	 }
	      }
	      int maxVal=max;
	 
	      System.out.println("Before: " + Arrays.toString(a));
	      sort(a,maxVal);
	      System.out.println("After:  " + Arrays.toString(a));
	}
	public static void sort(int[] a, int maxVal) {
	      int [] bucket=new int[maxVal+1];
	 
	      for (int i=0; i<bucket.length; i++) {
	         bucket[i]=0;
	      }
	 
	      for (int i=0; i<a.length; i++) {
	         bucket[a[i]]++;
	      }
	 
	      int outPos=0;
	      for (int i=0; i<bucket.length; i++) {
	         for (int j=0; j<bucket[i]; j++) {
	            a[outPos++]=i;
	         }
	      }
	   }
	 
}
