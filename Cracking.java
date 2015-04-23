package hardik.code;

import java.util.ArrayList;

public class Cracking {

	
	static void stringCompression(String s) {
		char c = s.charAt(0);
		int count = 0;
		StringBuffer sb = new StringBuffer();
		sb.append(c);
		for (int i =0 ; i < s.length() ; i ++) {
			if (s.charAt(i) == c) {
				count++;
			} else {
				sb.append(count);
				c = s.charAt(i);
				sb.append(c);
				count = 1;
			}
		}
		sb.append(count);
		System.out.println("Compressed String is : "+sb.toString());
	}

	public void addParen(ArrayList<String> list, int leftRem, int rightRem,
			char[] str, int count) {
		if (leftRem < 0 || rightRem < leftRem)
			return; // invalid state

		if (leftRem == 0 && rightRem == 0) { /* no more parens left */
			String s = String.copyValueOf(str);
			list.add(s);
		} else {
			/* Add left paren, if there are any left parens remaining. */
			if (leftRem > 0) {
				str[count] = '(';
				addParen(list, leftRem - 1, rightRem, str, count + 1);
			}

			/* Add right paren., if expression is valid */
			if (rightRem > leftRem) {
				str[count] = ')';
				addParen(list, leftRem, rightRem - 1, str, count + 1);
			}
		}
	}

	public ArrayList<String> generateParens(int count) {
		char[] str = new char[count * 2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, count, count, str, 0);
		return list;
	}

	public static void main(String[] args) {
		stringCompression("aabbccdd");
	}
}
