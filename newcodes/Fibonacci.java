public class Fibonacci {

	    public static void main(String[] args) {
	       // int N = Integer.parseInt(args[0]);
	    	int N=10;
	    	
	    	int i=0;
	    	if(i==0)
	    		System.out.print(0);
	        for ( i = 1; i <= N; i++)
	            System.out.print(" " + fibRecursion(i));
	        
	        
	        //fibNoRecursion(10);
	    }
	    
	    
	    public static int fibRecursion(int n) {
	        if (n <= 1) return n;
	        else return fibRecursion(n-1) + fibRecursion(n-2);
	    }
	    
	   /* 
	    public static void fibNoRecursion(int n)
	    {
	    	
	    	
	    	for(int i=2;i<=n;i++)
	    	{
	    		//i=(i-1)+(i-2);
	    		System.out.print(i);
	    	}
	    }*/
	
}