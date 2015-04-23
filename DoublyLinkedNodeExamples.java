package hardik.code;

import java.util.HashSet;
import java.util.Set;

public class DoublyLinkedNodeExamples {

	static DoublyLinkedNode reverse(DoublyLinkedNode head) {
		DoublyLinkedNode tmpNext = null, temp = head, prev = null; 
		while (temp.next!= null) {
			tmpNext = temp.next;
			temp.next = prev;
			prev = temp;
			temp = tmpNext;
		}

		temp.next = temp.previous;
		temp.previous = null;

		return temp;
	}

	
	public static void main(String[] args) {
		DoublyLinkedNode node = new DoublyLinkedNode(3);
		DoublyLinkedNode node1 = new DoublyLinkedNode(4);
		DoublyLinkedNode node2 = new DoublyLinkedNode(5);
		DoublyLinkedNode node3	 = new DoublyLinkedNode(6);
		node.next = node1;node1.next = node2;node2.next = node3;node3.next = null;
		node3.previous = node2;node2.previous = node1;node1.previous = node;node.previous = null;
		node = reverse(node);
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
		
	}
}
