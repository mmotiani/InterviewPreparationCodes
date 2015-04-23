package hardik.code;

public class StringAlgorithms {

	public static String identifyCommonSubStrOfNStr(String [] strArr){

	    String commonStr="";
	    String smallStr ="";        

	    //identify smallest String      
	    for (String s :strArr) {
	    	if (smallStr.isEmpty()) {
	    		smallStr=s;
	    	} else if(smallStr.length()> s.length()){
	            smallStr=s;
	        }
	    }
	    System.out.println("Smallest string is " + smallStr);
	    String tempCom="";
	    char [] smallStrChars=smallStr.toCharArray();               
	    for (char c: smallStrChars){
	        tempCom+= c;

	        for (String s :strArr){
	            if(! s.contains(tempCom)){
	            tempCom="";
	                break;
	            }               
	        }

	        if(!tempCom.isEmpty() && tempCom.length()>commonStr.length()){
	            commonStr=tempCom;  
	        }                       
	    }   

	    return commonStr;
	}
	
	public static String  longestCommonSubsequence(String  a, String  b) {
	    int[][] lengths = new int[a.length()+1][b.length()+1];
	 
	    // row 0 and column 0 are initialized to 0 already
	 
	    for (int i = 0; i < a.length(); i++)
	        for (int j = 0; j < b.length(); j++)
	            if (a.charAt(i) == b.charAt(j))
	                lengths[i+1][j+1] = lengths[i][j] + 1;
	            else
	                lengths[i+1][j+1] =
	                    Math .max(lengths[i+1][j], lengths[i][j+1]);
	 
	    for (int i = 0; i < a.length(); i++) {
	    	for (int j = 0; j < b.length(); j++)
	        	System.out.print(lengths[i][j] + " ");
	    	System.out.println();
	    }
	    
	    // read the substring out from the matrix
	    StringBuffer  sb = new StringBuffer ();
	    for (int x = a.length(), y = b.length();
	         x != 0 && y != 0; ) {
	        if (lengths[x][y] == lengths[x-1][y])
	            x--;
	        else if (lengths[x][y] == lengths[x][y-1])
	            y--;
	        else {
	            if(a.charAt(x-1) == b.charAt(y-1))
	            	sb.append(a.charAt(x-1));
	            x--;
	            y--;
	        }
	    }
	 
	    return sb.reverse().toString();
	}
	public static void main(String[] args) {
		String[] s = new String[] {"abcdefg", "qbcdefp", "lkjhbcdef", "mnbcdef"};
		s = new String[] {"abcd", "ababc", "abcd", "alkbc"};
		System.out.println("Common substring is :" + identifyCommonSubStrOfNStr(s));
		System.out.println("Common subsequense is :" + longestCommonSubsequence("ABCBDAB", "BDCABA"));
	}
}
