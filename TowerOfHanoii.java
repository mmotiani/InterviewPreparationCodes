package hardik.code;

import java.util.Stack;

public class TowerOfHanoii {

	Stack<Integer> disk;
	int index;
	
	public TowerOfHanoii(int index) {
		this.index = index;
		disk = new Stack<Integer>();
	}
	
	public void moveDisks(int n, TowerOfHanoii destination, TowerOfHanoii buffer) {
		if (n> 0) {
			moveDisks(n-1, buffer, destination);
			moveTop(destination);
			buffer.moveDisks(n-1, destination, this);
		}
	}

	private void moveTop(TowerOfHanoii destination) {
		destination.add(disk.pop());
	}
	public void add(int i) {
		if (disk != null && !disk.isEmpty() && disk.peek() <= i) {
			System.out.println("Can't move");
		} else {
			disk.push(i);
		}
	}
}
