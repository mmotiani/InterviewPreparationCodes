package hardik.code;

public class Heap {

	int capacity;
	int count;
	int[] array;
	
	public Heap() {};
	public Heap(int capacity) {
		this.capacity = capacity;
		this.count = 0;
		this.array = new int[capacity];
	}
	
	public int getParent(int index) {
		if (index <=0 || index >= this.count)
			return -1;
		else
			return (index-1)/2;
	}
	
	public int getLeftChild(int i) {
		int left = 2*i+1;
		if (left >= this.count)
			return -1;
		else 
			return left;
	}
	
	public int getRightChild(int i) {
		int right = 2*i+2;
		if (right >= this.count)
			return -1;
		else 
			return right;
	}
	
	public int getMax() {
		if (this.count == 0)
			return -1;
		else 
			return this.array[0];
	}
	
	public void heapify(int i) {
		int left,right,temp ,max = i;
		if(i<=0 || i>= this.count)
			return;
		left = getLeftChild(i);
		right = getRightChild(i);
		if (left != -1 && this.array[left] > this.array[max]) {
			max = left;
		}
		if (right != -1 && this.array[right] > this.array[max]) {
			max = right;
		}
		if (max != i) {
			temp = this.array [i];
			this.array[i] = this.array[max];
			this.array[max] = temp;
			heapify(max);
		}
		
	}
	
	public void insert(Heap h, int data) {
		if(this.count == this.capacity) {
			resizeArray();
		}
		this.count++;
		int i = this.count -1;
		while (i>=0 && data > array[(i-1)/2]) {
			array[i] = array[(i-1)/2];
			i = (i-1)/2;
		}
		array[i] = data;
	}

	public void resizeArray() {
		int[] old_array = new int[this.capacity];
		System.arraycopy(this.array, 0, old_array, 0, this.count);
		this.array = new int[this.capacity*2];
		for (int i=0; i< this.capacity; i++) {
			this.array[i] = old_array[i];
		}
		this.capacity = this.capacity *2;
		old_array = null;
		
	}
	
	public int deleteMax() {
		if (this.count == 0)
			return -1;
		int data = this.array[0];
		this.array[0] = this.array[this.count - 1];
		heapify(0);
		return data;
	}
	
	public void buildHeap(Heap h , int[] A, int n) {
		if(h==null) return;
		if(n > h.capacity) {
			resizeArray();
		}
		for (int i=0; i <n ; i++) {
			h.array[i] = A[i];
		}
		this.count = n;
		h.count = n;
		for (int i =(n-1)/2; i >=0; i--) {
			h.heapify(i);
		}
		
	}
	
	public void heapSort(int[] A, int n) {
		Heap h = new Heap(n);
		int temp;
		buildHeap(h, A, n);
		for (int i= n-1; i>=0; i--) {
			temp = h.array[0];
			h.array[0] = h.array[this.count-1];
			h.array[this.count-1] = temp;
			h.count--;
			h.heapify(0);
		}
		h.count = n;
		for (int i=0; i < h.array.length; i++) {
			System.out.println(h.array[i]);
			A[i] = h.array[i];
		}
	}
	
	
}
