import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class square {
	private static final String Q = null;
	private static final String P = null;

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number::");
		int n = in.nextInt();
		 primeFactor(n);
		
	}

	private static int primeFactor(int n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		int count=0;
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		while(n%2==0)
		{
			a.add(2);
			n=n/2;
		}
		for(int i=3 ; i<Math.sqrt(n);i=i+2)
		{
			while(n%i==0)
			{
				a.add(i);
				n=n/i;
			}
		}

		if(n>2)
		{
			a.add(n);
		}
		for(int m : a)
		{
			if(h.containsKey(m))
			{
				h.put(m,h.get(m)+1);
			}
			else
			{
				h.put(m, 1);
			}
		}
		
		
		
		Set<Integer> set = h.keySet();
		Iterator it = set.iterator();
		while(it.hasNext())
		{
			Integer key  = (Integer)it.next();
			Integer value=(Integer)h.get(key);
			System.out.println("Key: "+key+", Value "+value);
		}
		
		Set<Integer> set1 = h.keySet();
		Iterator it1 = set1.iterator();
		boolean flag=true;
		int k = h.get(a.get(0));
		while(it1.hasNext())
		{
			Integer key  = (Integer)it1.next();
			if(k==((Integer)h.get(key)))
					{
						continue;
					}
			else
			{
				flag=false;
				break;
			}
		}
		if(flag)
		{
			return 1;
		}
		else
		{
			return 0;
		}
		
	}
}
