import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class binarySearch {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements in array");
		int n = in.nextInt();
		
		int []a = new int[n];
		
		System.out.println("Enter the array in sorted order");
		for(int i = 0 ; i<n ; i++)
		{
			
			a[i] = in.nextInt();
		}
		
		System.out.println("Enter the element to be searched in array");
		int search = in.nextInt();
		int f=0;
		int first = 0;
		int  last = n-1;
		int middle = (first+last)/2;
		
		while(first<=last)
		{
			if(a[middle]<search)
			{
				first= middle+1;
			}
			else if(a[middle]==search)
			{
				System.out.println(search + " found at location " + (middle+1));
				f=1;
				break;
			}
			else
			{
				last = middle-1;
			}
			middle = (first+last)/2;
		}
		if(f==0)
		{
			System.out.println(search + " is not present in array ");
		}
	}

}
