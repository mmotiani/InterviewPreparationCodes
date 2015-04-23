import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
 
public class zeroone {
       public static void main(String args[])
       {
              Scanner in = new Scanner(System.in);
              System.out.println("Enter the number::");
              int n = in.nextInt();
              switch(n)
              {
                     case 0:{
                           System.out.println("Everything is multiple of 0");
                           break;
                     }
                     case 1:
                     {
                           System.out.println("the no is:: "+n);
                           break;
                     }
                     default:
                     {
                           long z = getZeroOne(n);          
                           System.out.println("the no is:: "+z );
                           break;
                     }
              }
                          
       }
 
       private static long getZeroOne(int ip) {
              // TODO Auto-generated method stub
              ArrayList<Long> array = new ArrayList<Long>();
              ArrayList<Long> array1 = new ArrayList<Long>();
             
              long min = Long.MAX_VALUE;
              boolean flag = false;
              long mul_val = 10;
              long a = 0;
              long b = 1;
             
              array.add(a);
              array.add(b);
              while(!flag){       
                     for(long c : array)
                     {
                           long num = mul_val+c;
                           if((num%ip) == 0){
                                  if(num<min){
                                         min = num;
                                         flag = true;
                                         break ;
                                  }
                           }
                           array1.add(c);
                           array1.add(num);
                     }
                     array.clear();
                     array.addAll(array1);
                     mul_val*=10;
              }
              return min;
       }
             
}