package hardik.code;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {50,5, 20, 30, 45};
		int data = 45; 
		
		int pivot = getPivot(arr, 0, arr.length -1);
		
		if(pivot == -1)
			System.out.println("not found");
		else if(arr[pivot] == data)
			System.out.println(pivot);
		else if(data <= arr[arr.length-1])
		{
			System.out.println(Binarysearch(arr, pivot+1, arr.length -1, data));
		}
		else
			System.out.println(Binarysearch(arr,0, pivot-1, data));

		
	}
	
	private static int Binarysearch(int[] arr, int low, int high, int data) {
		// TODO Auto-generated method stub
		int mid;
		while(high>=low)
		{
			mid = (high + low ) /2;
			if(arr[mid] == data)
				return mid;
			else if(arr[mid] < data)
				low = mid +1;
			else if(arr[mid] > data)
				high = mid -1;
		}
		return -1;

	}

	public static int getPivot(int[] arr, int low, int high)
	{
		int mid;
		while(high>=low)
		{		
			if(high == low)
				return high;
			else if(high - low ==1)
				return arr[high]>arr[low]?high:low;
			else {
				mid = low + (high - low ) /2;
				if(arr[low] >= arr[mid])
					high = mid;
				else 
					low = mid;
			}
		}
		return -1;
	}

}
