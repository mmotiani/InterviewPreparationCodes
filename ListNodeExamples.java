package hardik.code;

import java.util.HashMap;
import java.util.Stack;

public class ListNodeExamples {

	static int findLength(ListNode head) {
		int length = 0;
		while (head != null) {
			head = head.getNext();
			length++;
		}
		return length;
	}
	
	static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.getData() + "->");
			head = head.getNext();
		}
	}
	
	public static ListNode mergeLinkedList(ListNode node1, ListNode node2)
	{
		if(node1 == null)
			return node2;
		if(node2 == null)
			return node1;
			
		ListNode head = new ListNode();
		ListNode currNode = head;
		ListNode node = null;
		while(node1 != null && node2 != null)
		{
			ListNode newNode = new ListNode();
			if(node1.getData() <= node2.getData())
			{
				newNode.setData(node1.getData());
				node1 = node1.getNext();
			}
			else
			{
				newNode.setData(node2.getData());
				node2 = node2.getNext();
			}	
			currNode.setNext(newNode);
			currNode =newNode;
		}
		
		if(node1 == null)
			 node = node2;	
		else
			 node = node1;	
		
		while(node!=null)
			{
				ListNode newNode = new ListNode();
				newNode.setData(node.getData());
				node = node.getNext();
				currNode.setNext(newNode);
				currNode =newNode;
			}
		
		node = head;
		head = head.getNext();
		currNode.next = null;
		node = null;
		
		printList(head);
		
		return head;
		
	}
	
	public static ListNode mergeSortUsingRecursion(ListNode node1, ListNode node2){
		
		ListNode result= null;
		if(node1 == null)
			return  node2;
		if(node2 == null)
			return node1;
		
		if(node1.getData() <= node2.getData())
		{
			result = node1;
			result.setNext(mergeSortUsingRecursion(node1.getNext(), node2));
		}
		else
		{
			result = node2;
			result.setNext(mergeSortUsingRecursion(node1, node2.getNext()));
		}
		
		return result;
	}
	
	public static ListNode mergeSortUsingIteration(ListNode a, ListNode b) {
	    ListNode dummyHead, curr; dummyHead = new ListNode(); curr = dummyHead;
	    while(a !=null && b!= null) {
	        if(a.data <= b.data)
	        	{ curr.next = a; a = a.next; }
	        else 
	        	{ curr.next = b; b = b.next; }
	        curr = curr.next;
	    }
	    curr.next = (a == null) ? b : a;
	    return dummyHead.next;
	}
	
	static ListNode insertElement(ListNode head, int position, ListNode newNode) {
		if (head == null) {
			head = newNode;
			return head;
		}
		if (position == 1) {
			newNode.setNext(head);
			return newNode;
		} else {
			ListNode temp = head, nextNode;
			int count = 1;
			while (count < position - 1) {
				temp = temp.getNext();
				count++;
			}
			nextNode = temp.getNext();
			newNode.setNext(nextNode);
			temp.setNext(newNode);
		}
		
		return head;
	}
	
	static void findNthNodeFromEnd(ListNode head, int n) {
		int length = findLength(head);
		if (n > length || n <=0 || head == null)
			return;
		for (int i =0 ; i < length - n ; i++) {
			head = head.getNext();
		}
		System.out.println("nth node is : " + head.getData());
	}
	
	static void findNthNodeFromEndInOneScan(ListNode head, int n) {
		if(head == null || n <0)
				return;
		ListNode intialPtr = head;
		ListNode finalPtr = head;
		
		for(int i=1; i <n; i++)
		{
			if(intialPtr!=null)
				intialPtr = intialPtr.next; 
		}
		
		if(intialPtr == null)
			System.out.println("Out of bounds");
		else
		{
			while(intialPtr.next != null)
			{
				intialPtr = intialPtr.next;
				finalPtr = finalPtr.next;
			}
			System.out.println("nth node is : " + finalPtr.getData());
		}
		
	}
	
	static int findKthNodeFromEndUsingRecursion(ListNode head, int k, Integer i) {
		if (head == null)
			return i;
		i = findKthNodeFromEndUsingRecursion(head.getNext(), k, i);
		i = i + 1;
		if (i == k) {
			System.out.println("Kth Node is :" + head.getData());
			return i;
		}
		return i;
	}
	static void findCycle(ListNode head) {
		if (head == null)
			System.out.println("No Cycle");
		ListNode fastPtr = head, slowPtr = head;
		boolean loopExists = false;
		while (fastPtr != null && fastPtr.getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			if (slowPtr == fastPtr) {
				System.out.println("There is a Cycle");
				loopExists = true;
				break;
			}
		}
		if (!loopExists)
			System.out.println("No Cycle");
	}
	
	static void findStartOfCycle(ListNode head) {
		if (head == null)
			System.out.println("No Cycle");
		ListNode fastPtr = head, slowPtr = head;
		boolean loopExists = false;
		while (fastPtr != null && fastPtr.getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			if (slowPtr == fastPtr) {
				System.out.println("There is a Cycle");
				loopExists = true;
				break;
			}
		}
		if (loopExists) {
			slowPtr = head;
			while (slowPtr != fastPtr) {
				slowPtr = slowPtr.getNext();
				fastPtr = fastPtr.getNext();
			}
			System.out.println("Start of the loop is : " + slowPtr.getData());
		}
			
	}
	static void findNodeCountInCycle(ListNode head) {
		if (head == null)
			System.out.println("No Cycle");
		ListNode fastPtr = head, slowPtr = head;
		boolean loopExists = false;
		while (fastPtr != null && fastPtr.getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			if (slowPtr == fastPtr) {
				System.out.println("There is a Cycle");
				loopExists = true;
				break;
			}
		}
		if (loopExists) {
			int count = 1;
			fastPtr = fastPtr.getNext();
			while (slowPtr != fastPtr) {
				fastPtr = fastPtr.getNext();
				count++;
			}
			System.out.println("Node count in loop is : " + count);
		}
			
	}
	
	static void EvenOddLength(ListNode head) {
		if (head == null)
			System.out.println("No Cycle");
		ListNode fastPtr = head, slowPtr = head;
		while (fastPtr.next != null && fastPtr.getNext().getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
		}
		if (fastPtr.next == null) {
			System.out.println("Odd Length List");
		} else {
			System.out.println("Even Length List");
		}
	}
	
	static ListNode insertInSortedLinkedList(ListNode head, ListNode newNode) {
		if (head == null) {
			head = newNode;
			return head;
		}
		ListNode parent = head ,temp = head , nextNode;
		while (temp != null && temp.getData() < newNode.getData()) {
			parent = temp;
			temp = temp.getNext();
		}
		nextNode = parent.getNext();
		parent.setNext(newNode);
		newNode.setNext(nextNode);
		return head;
			
	}
	
	static ListNode reverseList(ListNode head) {
		ListNode temp = null, nextNode = null, current = head;
		while (current != null) {
			nextNode = current.getNext();
			current.setNext(temp);
			temp = current;
			current = nextNode;
			
		}
		return temp;
	}
	
	static void findMergingPoint(ListNode head1, ListNode head2) {
		if (head1 ==null || head2 == null) {
			System.out.println("No merging point");
			return;
		}
		int length1 = findLength(head1);
		int length2 = findLength(head2);
		int diff = Math.abs(length1 - length2);
		if (length1 > length2) {
			for (int i = 0 ; i < diff; i ++) {
				head1 = head1.getNext();
			}
		} else {
			for (int i = 0 ; i < diff; i ++) {
				head2 = head2.getNext();
			}
		}
		while (head1 != null && head2 != null) {
			if (head1 == head2) {
				System.out.println("Merging point is :" + head1.getData());
				return;
			} 
			head1 = head1.getNext();
			head2 = head2.getNext();
		}
	}
	
	static void findMiddleNode(ListNode head) {
		if (head == null)
			System.out.println("No Cycle");
		ListNode fastPtr = head, slowPtr = head;
		while (fastPtr != null && fastPtr.getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
		}
		if (fastPtr == null) {
			System.out.println("Middle Node- odd Length is : " + slowPtr.getData());
			return;
		}
		if (fastPtr.getNext() == null) {
			System.out.println("Middle Node - even length is : " + slowPtr.getNext().getData());
			return;
		}
			
	}
	
	static ListNode reverseListPair(ListNode head) {
		ListNode temp = null, tmp1 = null; 
		while (head != null && head.getNext() != null) {
			if (temp != null)
				temp.getNext().setNext(head.getNext());
			temp = head.getNext();
			head.setNext(temp.getNext());
			temp.setNext(head);
			if (tmp1 == null)
				tmp1 = temp;
			head = head.getNext();
		}
		return tmp1;
	}
	static void displayLinkedListReverse(ListNode head) {
		if (head == null)
			return;
		else {
			displayLinkedListReverse(head.getNext());
			System.out.print(head.getData() + "->");
		}
	}
	
	static void isListPalindrome(ListNode head) {
		if (head == null) {
			System.out.println("Not palindrom");
			return;
		}
		if (head.getNext() == null) {
			System.out.println("palindrom");
			return;
		}
		ListNode fastPtr = head, slowPtr = head;
		Stack<ListNode> stack = new Stack<ListNode>();
		while (fastPtr != null && fastPtr.getNext() != null) {
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
		}
		if (fastPtr == null) {
			while (slowPtr != null) {
				stack.push(slowPtr);
				slowPtr = slowPtr.getNext();
			}
		} else {
			slowPtr = slowPtr.getNext();
			while (slowPtr != null) {
				stack.push(slowPtr);
				slowPtr = slowPtr.getNext();
			}
		}
		while (!stack.isEmpty()) {
			if (head.getData() != stack.pop().getData()) {
				System.out.println("Not Palindrom");
				return;
			}
			head = head.getNext();
		}
		System.out.println("list is Palindrom");
			
	}
	
	static ListNode removeDuplicates(ListNode head) {
		if (head == null)
			return head;
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		ListNode temp = head, previous = null;
		while (temp != null) {
			if (map.containsKey(temp.getData())) {
				previous.setNext(temp.getNext());
			} else {
				previous = temp;
				map.put(temp.getData(), true);
			}
			temp = temp.getNext();
		}
		return head;
	}
	
	static ListNode partitionList(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode beforeStart = null, afterStart = null, next = null;
		while (head != null) {
			next = head.getNext();
			if (head.getData() < x) {
				head.setNext(beforeStart);
				beforeStart = head;
			} else {
				head.setNext(afterStart);
				afterStart = head;
			}
			head = next;
		}
		if (beforeStart == null)
			return afterStart;
		head = beforeStart;
		while (beforeStart.getNext() != null) {
			beforeStart = beforeStart.getNext();
		}
		beforeStart.setNext(afterStart);
		return head;
	}
	
	static ListNode removeDuplicatesWithoutBuffer(ListNode head) {
		if (head == null)
			return head;
		ListNode temp = null, current = head;
		while (current != null) {
			temp = current;
			while (temp.getNext() != null) {
				if (temp.getNext().getData() == current.getData()) {
					temp.setNext(temp.getNext().getNext());
				} else {
					temp = temp.getNext();
				}
			}
			current = current.getNext();
		}
		return head;
	}
	
	static ListNode addTwoList(ListNode head1, ListNode head2, int carry) {
		if (head1 == null && head2 ==null && carry ==0) {
			return null;
		}
		ListNode result = new ListNode();
		int value = carry;
		if (head2 != null) 
			value += head2.getData();
		if (head1 != null) 
			value += head1.getData();
		result.setData(value%10);
		if (head1 != null || head2 != null) {
			ListNode node = addTwoList(head1 != null ? head1.getNext() : null,
									   head2 != null ? head2.getNext() : null,
									   value > 9 ? 1 :0);
			result.setNext(node);
		}
		return result;
	}
	
	public static void main(String[] args) {
		ListNode node6 = new ListNode(5, null);
		ListNode node5 = new ListNode(7, node6);
		ListNode node4 = new ListNode(9, node5);
		ListNode node3 = new ListNode(10, node4);
		ListNode node2 = new ListNode(12, node3);
		ListNode node1 = new ListNode(15, node2);
		ListNode head = new ListNode(2, node1);
		
		ListNode head2node2 = new ListNode(3, null);
		ListNode head2node1 = new ListNode(2, head2node2);
		ListNode head2 = new ListNode(1, head2node1);
		
		System.out.println("----------------Merged list is ------------------");
		mergeLinkedList(head, head2);
		System.out.println();
		System.out.println("----------------Merged list using recursion ------------------");
		ListNode node = mergeSortUsingRecursion(head, head2);
		printList(node);
		System.out.println("Length is :" + findLength(head));
		EvenOddLength(head);
		printList(head);
		ListNode newNode = new ListNode(8, null);
		head = insertElement(head, 6, newNode);
		System.out.println();
		printList(head);
		ListNode temp = null;
		newNode = new ListNode(8, null);
		temp = insertElement(temp, 1, newNode);
		System.out.println();
		printList(temp);
		temp = insertElement(temp, 2, node6);
		System.out.println();
		printList(temp);
		System.out.println();
		findNthNodeFromEnd(head, 2);
		findNthNodeFromEndInOneScan(head, 15);
		System.out.println("-----------------------Using recursion------------------------------");
		findKthNodeFromEndUsingRecursion(head, 2, 0);
		System.out.println("Length is :" + findLength(head));
		EvenOddLength(head);
		findCycle(head);
		printList(head);
		System.out.println("After this head has cycle");
		node6.setNext(node3);
		newNode = new ListNode(2, node1);
		//printList(newNode);
		findCycle(newNode);
		findStartOfCycle(newNode);
		findNodeCountInCycle(newNode);
		ListNode sortedNode = new ListNode(6, null);
		ListNode sortedNode1 = new ListNode(5, null);
		ListNode sortedNode2 = new ListNode(4, sortedNode1);
		ListNode sortedHead = new ListNode(3, sortedNode2);
		sortedHead = insertInSortedLinkedList(sortedHead, sortedNode);
		printList(sortedHead);
		System.out.println();
		sortedHead = reverseList(sortedHead);
		printList(sortedHead);
		System.out.println();
		node6.setNext(null);
		sortedNode1 = new ListNode(5, node3);
		sortedNode2 = new ListNode(4, sortedNode1);
		sortedHead = new ListNode(3, sortedNode2);
		printList(sortedHead);
		System.out.println();
		printList(head);
		System.out.println();
		findMergingPoint(head, sortedHead);
		/*sortedNode2 = new ListNode(4, node3);
		sortedHead = new ListNode(3, sortedNode2);
		printList(sortedHead);*/
		System.out.println();
		findMiddleNode(head);
		displayLinkedListReverse(head);
		System.out.println("Remove duplicates ");
		sortedHead = removeDuplicatesWithoutBuffer(sortedHead);
		printList(sortedHead);
		System.out.println();
		sortedHead = reverseListPair(head);
		printList(sortedHead);
		System.out.println();
		ListNode d = new ListNode(4, null);
		ListNode a = new ListNode(3, d);
		ListNode b = new ListNode(3, a);
		ListNode c = new ListNode(4, b);
		isListPalindrome(c);
		
		System.out.println("---------------partition list-------------------------------");
		printList(sortedHead);
		System.out.println();
		sortedHead = partitionList(sortedHead, 8);
		printList(sortedHead);
		System.out.println();
		
		ListNode add3 = new ListNode(5, null);
		ListNode add2 = new ListNode(4, add3);
		ListNode add1 = new ListNode(3, add2);
		
		ListNode add6 = new ListNode(5, null);
		ListNode add5 = new ListNode(4, add6);
		ListNode add4 = new ListNode(3, add5);
		
		ListNode sum = addTwoList(add1, add2, 0);
		while(sum != null) {
			System.out.print(sum.getData() + " ");
			sum = sum.getNext();
		}
		
		modularNode(head, 3);
		modularNodeFromEnd(head, 3);
	}
	
	public static void modularNode(ListNode  head, int k)
	{
		printList(head);
		if(head == null)
			System.out.println("Not possible");
		
		if(k<0)
			System.out.println("Not possible");
		
		int i=1;
		ListNode modularNode = null;
		while(head != null)
		{
			if(i%k ==0)
				modularNode = head;
			
			i++;
			head =head.next;
		}
		
		System.out.println("Modular Node is " + modularNode.data);
	}
	
	public static void modularNodeFromEnd(ListNode head, int k)
	{
		if(head == null)
			System.out.println("Not possible");
		
		if(k<0)
			System.out.println("Not possible");
		ListNode fast = head;
		ListNode slow =head;
		for(int i=0; i<k; i++)
		{
			if(fast!=null)
				fast = fast.next;
		}
		
		while(fast.next!=null)
		{
			fast = fast.next;
			slow = slow.next;
		}
		
		System.out.println("Moduluar node from end is " + slow.data);
		
		
	}
}
