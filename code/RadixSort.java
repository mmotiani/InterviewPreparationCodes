import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
 
public class RadixSort {
 
  // Define the length of the array.
  private static final int LENGTH = 10;
 
  // Define the queues.
  @SuppressWarnings("rawtypes")
private static LinkedList[] q = {
      new LinkedList(), // 0
      new LinkedList(), // 1
      new LinkedList(), // 2
      new LinkedList(), // 3
      new LinkedList(), // 4
      new LinkedList(), // 5
      new LinkedList(), // 6
      new LinkedList(), // 7
      new LinkedList(), // 8
      new LinkedList() // 9
  };
 
  /**
   * Main method.
   * @param args
   */
  public static void main(String[] args)
  {
    // Random List.
    int[] list = new int[LENGTH];
 
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter numbers to be sorted:");
    for(int r=0; r < LENGTH; r++){
      list[r] = sc.nextInt();
    }
 
    // Sort the list.
    int[] sortedList = sort(list);
 
    // Print the sorted list.
    for(int i=0; i < sortedList.length; i++){
      System.out.println(sortedList[i]);
    }
 
  }
 
  /**
   * Sorts an array of objects (integers) using radix sort.
   * @param list  The unsorted list.
   * @return    The sorted list.
   */
  public static int[] sort(int[] list)
  {
    // Get the maximum number of digits.
    int maxDigits = getMaxDigits(list);
 
    // Iterate through the radix depending on max digits.
    for(int r=1; r <= maxDigits; r++){
 
      // Iterate through every number.
      int radix;
      for(int n=0; n < list.length; n++){
        // Figure out what queue to put it into.
        radix = getDigitAt((list[n]), r);
        // Put it into it's queue accordinmaxDigits = getMaxDigits(list);g to the radix.
        q[radix].offer(list[n]);
      }
 
      // Go through the queues and put the numbers back into the list.
      int a=0;
      for(int k=0; k < q.length; k++){
        // Go through every element in the queue.
        while(q[k].peek() != null){
          list[a++] = (int) q[k].poll();
        }
      }
 
    }
 
    // Return the list, it is now sorted.
    return list;
 
  }
 
  /**
   * Gets the maximum digits of a list of integers.
   * @param list
   * @return
   */
  public static int getMaxDigits(int[] list)
  {
    // Define the max digits.
    int maxDigits = 0;
 
    // Iterate through the list.
    int digits;
    for(int i=0; i < list.length; i++){
 
      // Cast the number to a string.
      digits = getDigits((list[i]));
 
      // Compare the lengths.
      if(digits > maxDigits){
        maxDigits = digits;
      }
 
    }
 
    // Return the max digits.
    return maxDigits;
  }
 
  /**
   * Gets the number of digits the specified number has.
   * @param i
   * @return
   */
  public static int getDigits(int i)
  {
    if(i < 10){
      return 1;
    }
    return 1 + getDigits(i / 10);
  }
 
  /**
   * Gets the digit at the specified radix of the specified number.
   * @param number
   * @param radix
   * @return
   */
  public static int getDigitAt(int number, int radix)
  {
    return (int)(number / Math.pow(10,radix-1)) % 10;
  }
 
}
