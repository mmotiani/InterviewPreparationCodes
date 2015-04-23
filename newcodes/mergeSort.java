import java.util.Scanner;


public class mergeSort {

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
		a[i] = in.nextInt();
		mergeSort ms = new mergeSort();	
		ms.sort(a);
	}

	private int[] a;
	private int length;
	private int[] temporaryArray;

public void sort(int array[])
{
	this.a = array;
	this.length = array.length;
	this.temporaryArray= new int[length];
	MergeSort(0, length-1);
}

private void MergeSort(int lower, int higher) {
	if(lower<higher)
	{
		int middle = lower + (higher-lower)/2;
		MergeSort(lower, middle);
		MergeSort(middle+1, higher);
		Merger(lower, middle, higher);
	}
	
}

private void Merger(int lower, int middle, int higher) {
	for(int i = lower ; i<higher ; i++)
	{
		temporaryArray[i] = a[i];		
	}
	int i = lower;
	int j= middle+1;
	int k = lower;
	
	while(i<=middle&&j<=higher){
		if(temporaryArray[i]<temporaryArray[j]){
			a[k]=temporaryArray[i];
			i++;
	}
	else
	{
		a[k] = temporaryArray[j];
		j++;
	}
		k++;
}
	while(i<=middle){
		a[k]=temporaryArray[i];
		k++;
		i++;
	}
	
}



}
	

