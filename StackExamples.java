package hardik.code;

import java.util.Stack;

public class StackExamples {
	
	static void reverseStack(Stack<Integer> s) {
		if (s.isEmpty())
			return;
		int temp = s.pop();
		reverseStack(s);
		insertAtBottom(s, temp);
	}

	private static void insertAtBottom(Stack<Integer> s, int data) {
		if (s.isEmpty()) {
			s.push(data);
			return;
		}
		int temp = s.pop();
		insertAtBottom(s, data);
		s.push(temp);
	}
	
	//working (descending order) For ascending order, reverse the sign
	static Stack<Integer> sortStackTest(Stack<Integer> s) {
		if (s.isEmpty())
			return null;
		Stack<Integer> reverseStack = new Stack<Integer>();
		while (!s.isEmpty()) {
			int temp = s.pop();
			while(!reverseStack.isEmpty() && reverseStack.peek() > temp) {
				s.push(reverseStack.pop());
			}
			reverseStack.push(temp);
		}
		return reverseStack;
	}
	
	static void sortStack(Stack<Integer> s) {
		if (s.isEmpty())
			return;
		int temp = s.pop();
		sortStack(s);
		insert(s, temp);
	}
	
	private static void insert(Stack<Integer> s, int data) {
		if(!s.isEmpty() && s.peek() < data) {
			int temp = s.pop();
			insert(s, data);
			s.push(temp);
		} else {
			s.push(data);
		}
	}
	
	public static int[] getSpanByMe(int[] arr)
	{
		if(arr.length < 0)
			return null;
		
		int[] result = new int[arr.length];
		
		result[0] =1;
		int currMax = arr[0];
		
		for(int i =1; i< arr.length; i++)
		{
			if(arr[i] < currMax)
			{
				result[i] = 1;
			}
			else
				result[i] = result[i-1] +1;
			
			currMax = arr[i];
		}
		for (int i : result) {
			System.out.print(i + " ");
		}
		return result;
	}

	static int[] findSpan(int[] array) {
		int[] spanArray = new int[array.length]; 
		for (int i = 0; i < array.length ; i++) {
			int span = 1;
			int j = i-1;
			while (j>=0 && array[j] <= array[j+1]) {
				span++;
				j--;
			}
			spanArray[i] = span;
		}
		for (int i : spanArray) {
			System.out.print(i + " ");
		}
		return spanArray;
	}
	
	public static void removeAdjacentDuplicateUsingStack(int[] arr)
	{
		if(arr == null)
			System.out.println("Array is null");
		else{

			Stack<Integer> st = new Stack<Integer>();
			st.push(arr[0]);
			boolean isDuplicate;

			for (int i = 1; i < arr.length; i++) {
				isDuplicate = false;

				while (!st.isEmpty() && arr[i] == st.peek()) {
					i++;
					isDuplicate = true;
				}

				if (isDuplicate) {
					st.pop();
					i--;
				} else
					st.push(arr[i]);
			}

			while (!st.isEmpty()) {
				System.out.print(st.pop() + "\t");
			}
		}
		
	}
	
	static void removeAdjacentDuplicates(int[] array) {
		int stackPointer = -1;
		for (int i =0; i < array.length;) {
			if (stackPointer == - 1 || array[stackPointer] != array[i]) {
				stackPointer++;
				array[stackPointer] = array[i];
				i++;
			} else {
				while(i < array.length && array[i] ==array[stackPointer]) {
					i++;
				}
				stackPointer--;
			}
		}
		for (int i = 0 ; i <=stackPointer; i ++) {
			System.out.print(array[i] + " ");
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1,3,2,2,0,0,3,1,0};
		removeAdjacentDuplicates(array);
		System.out.println();
		array = new int[] {1,3,2,2,0,0,3,1,0};
		removeAdjacentDuplicateUsingStack(array);
		System.out.println();
		System.out.println("-----------------Find span of stock market price------------------");
		int[] newArray = new int[] {6,3,4,5,1,2,3,6,7};
		findSpan(newArray);
		System.out.println();
		getSpanByMe(newArray);
		System.out.println();
		Stack<Integer> s = new Stack<Integer>();
		s.push(2);s.push(7);s.push(6);s.push(4);s.push(1);s.push(3);s.push(9);
		reverseStack(s);
		while (!s.isEmpty())
			System.out.print(s.pop() + " ");
		System.out.println("Reverse end");
		s = new Stack<Integer>();
		s.push(2);s.push(7);s.push(6);s.push(4);s.push(1);s.push(3);s.push(9);
		Stack<Integer> stack=new Stack<Integer>();
		stack.push(3);stack.push(4);stack.push(1);stack.push(2);stack.push(2);stack.push(3);stack.push(4);stack.push(1);
		//sortStack(stack);
		stack = sortStackTest(stack);
		System.out.println("Stack sorting");
		while (!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		System.out.println();
		sortStack(s);
		while (!s.isEmpty())
			System.out.print(s.pop() + " ");
		System.out.println();
	}

}

class AdvancedStack {
	Stack<Integer> elementStack;
	Stack<Integer> minStack;
	
	public AdvancedStack() {
		elementStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	public void push(int data) {
		elementStack.push(data);
		if (minStack.isEmpty() || minStack.peek() >= data) {
			minStack.push(data);
		}
	}
	
	public int pop() {
		if (elementStack.isEmpty()) {
			return -1;
		}
		int minTop = minStack.peek();
		int elementTop = elementStack.peek();
		if (minTop == elementTop)
			minStack.pop();
		return elementStack.pop();
	}
	
	public int min() {
		return minStack.peek();
	}
	
	public boolean isEmpty() {
		return elementStack.isEmpty();
	}
	
	public int peek() {
		if (elementStack.isEmpty())
			return -1;
		return elementStack.peek();
	}
}
