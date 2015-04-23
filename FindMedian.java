package hardik.code;

public class FindMedian {

    public static void main(String[] args){ 
        int[] a = {1,9,-4,7,6,11,3,2,10}; 
        int median; 

        median = new FindMedian().findMedian(a,0,a.length-1); 
        if(a.length%2 != 0) 
            System.out.print("the median is : "+a[median]); 
        else 
            System.out.print("the median is : "+(a[median] + a[median + 1])/2 ); 
    } 
    public int findMedian(int[] a,int left,int right){ 
        int index = 0; 
        int mid = (left+right)/2; 
        index = partition(a,left,right); 
        while( index != mid){ 
            if(index < mid) 
                index = partition(a,mid,right); 
            else index = partition(a,left,mid); 
        } 
        return index; 
    } 
    public int partition(int[] a,int i,int j ){ 
        int pivot = (i+j)/2; 
        int temp; 
        while(i <= j){ 
            while(a[i] < a[pivot]) 
                i++; 
            while(a[j] > a[pivot]) 
                j--; 
            if(i <= j){ 
                temp = a[i]; 
                a[i]=a[j]; 
                a[j] = temp; 
                i++;j--; 
            } 
        } 
        return pivot; 
    } 

    //O(n) median of 2 sorted array
    int getMedian(int ar1[], int ar2[], int n)
    {
        int i = 0;  /* Current index of i/p array ar1[] */
        int j = 0; /* Current index of i/p array ar2[] */
        int count;
        int m1 = -1, m2 = -1;
     
        /* Since there are 2n elements, median will be average
         of elements at index n-1 and n in the array obtained after
         merging ar1 and ar2 */
        for (count = 0; count <= n; count++)
        {
            /*Below is to handle case where all elements of ar1[] are
              smaller than smallest(or first) element of ar2[]*/
            if (i == n)
            {
                m1 = m2;
                m2 = ar2[0];
                break;
            }
     
            /*Below is to handle case where all elements of ar2[] are
              smaller than smallest(or first) element of ar1[]*/
            else if (j == n)
            {
                m1 = m2;
                m2 = ar1[0];
                break;
            }
     
            if (ar1[i] < ar2[j])
            {
                m1 = m2;  /* Store the prev median */
                m2 = ar1[i];
                i++;
            }
            else
            {
                m1 = m2;  /* Store the prev median */
                m2 = ar2[j];
                j++;
            }
        }
     
        return (m1 + m2)/2;
    }
}
