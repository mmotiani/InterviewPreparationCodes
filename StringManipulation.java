package hardik.code;

import java.util.Arrays;

public class StringManipulation {

	public static void determineUniqueCharacters(String string) {
		
		//Assumption that string is ASCII
		if (string.length() > 256) {
			System.out.println("Not all characters unique");
			return;
		}
		boolean[] charArray = new boolean[256];
		boolean isUnique = true;
		for (int i=0; i < string.length() ; i++) {
			if (charArray[(string.charAt(i))]) {
				isUnique = false;
				break;
			}
			charArray[(string.charAt(i))] = true;
		}
		if (!isUnique) {
			System.out.println("Not unique characters in String");
		} else {
			System.out.println("All characters in string are unique");
		}
	}
	
	public static String stringReverse(String inputString) {
		char[] chaArray = new char[inputString.length()];
		int j =0 ;
		for (int i = (inputString.length()-1); i >=0 ; i-- ){
			chaArray[j++] = inputString.charAt(i); 
		}
		return new String(chaArray);
	}
	
	public static void stringPermutation(String actualString, String permuted) {
		char[] actualCharArray = actualString.toLowerCase().toCharArray();
		char[] permutedCharArray = permuted.toLowerCase().toCharArray();
		Arrays.sort(actualCharArray);
		Arrays.sort(permutedCharArray);
		if (Arrays.equals(actualCharArray, permutedCharArray)) {
			System.out.println("String permutation");
		} else {
			System.out.println("String not permutation");
		}
	}
	
	public static void stringReplace(String actualString, Character charToBeReplaced, Character charToReplace) {
		char[] charArray = actualString.toCharArray();
		int spaceCount = 0;
		for (int i =0 ; i <charArray.length; i++) {
			if (' ' == charArray[i]) {
				spaceCount++;
			}
		}
		int newLength = charArray.length + spaceCount * 2;
		char[] replaceCharArray = new char[newLength];
		for (int i= (actualString.length() - 1); i >= 0 ; i--) {
			if (charArray[i] == ' ') {
				replaceCharArray[--newLength] = '0';
				replaceCharArray[--newLength] = '2';
				replaceCharArray[--newLength] = '%';
			} else {
				replaceCharArray[--newLength] = charArray[i];
			}
		}
		System.out.println("Replcaed String is " + new String(replaceCharArray));
	}
	
	
	public static void countOccurences(String inputString) {
		StringBuffer sb = new StringBuffer();
		char c = inputString.charAt(0);
		int count = 1;
		for (int i = 1 ; i < inputString.length() ; i++) {
			if (c == inputString.charAt(i)) {
				count++;
			} else {
				sb.append(c);
				sb.append(count);
				c = inputString.charAt(i);
				count = 1;
				
			}
		}
		sb.append(c).append(count);
		if(sb.toString().length() > inputString.length()) {
			System.out.println("Returned String is " + inputString);
		} else {
			System.out.println("Returned String is " + sb.toString());
		}
	}
	
	
	public static void main(String[] args) {
		/*determineUniqueCharacters("abcda");
		System.out.println("Reverse string is " + stringReverse("abcdabcd"));
		stringPermutation("&*()", ")(&a");
		stringReplace("Mr Bean Is a Guy ", ' ', ' ');
		countOccurences("abcd");*/
		 
	}
	
	
}
