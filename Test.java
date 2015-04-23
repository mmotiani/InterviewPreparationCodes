package hardik.code;

import java.util.HashMap;

class HashPractice {
	public int i=0; 
	@Override 
	public int hashCode() { 
	return i; 
	} 
} 

	class Test{ 
	public static void main(String[] args){ 
	HashMap <HashPractice, String> hm = new HashMap<HashPractice, String>(); 

	HashPractice t1 = new HashPractice(); 

	hm.put(t1,"success"); 

	System.out.println(hm.get(t1)); //print success 

	t1.i = 10; 

	System.out.println(hm.get(t1)); //NULL 


	} 
	}
