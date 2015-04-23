package hardik.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackOfStacks<E> extends Stack<E>{

	private static final long serialVersionUID = 1L;
	List<Stack<E>> list;
	private int capacity;
	
	public StackOfStacks(int capacity) {
		this.capacity = capacity;
		list = new ArrayList<Stack<E>>(capacity);
	}
	
	private Stack<E> getLastStack() {
		if (list.size() ==0)
			return null;
		return (list.get(list.size() - 1));
	}
	
	public E push(E data) {
		Stack<E> lastStack = getLastStack();
		if (lastStack != null && lastStack.size() != capacity) {
			lastStack.push(data);
		} else {
			Stack<E> stack = new Stack<E>();
			stack.push(data);
			list.add(stack);
		}
		return data;
	}
	
	public E pop() {
		Stack<E> lastStack = getLastStack();
		if (lastStack == null) {
			return null;
		}
		E data = lastStack.pop();
		if (lastStack.size() == 0) 
			list.remove(lastStack);
		return data;
	}
	
	public boolean isEmpty() {
		return (list.size() == 0);
	}
}
