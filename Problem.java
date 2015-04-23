package hardik.code;

import java.util.Arrays;
import java.util.Iterator;

public class Problem<E> implements Iterator<E> {
	Iterator<Iterator<E>> iter;
	Iterator<E> iter2;

	Problem(Iterator<Iterator<E>> iter) {
		this.iter = iter;
		if (iter.hasNext())
			this.iter2 = iter.next();
	}

	@Override
	public boolean hasNext() {
		if (iter2 != null) {
			if (iter2.hasNext())
				return true;
		}
		while (iter.hasNext()) {
			iter2 = iter.next();
			if (iter2.hasNext())
				return true;
		}
		return false;
	}

	@Override
	public E next() {
		if (iter2 != null) {
			if (iter2.hasNext())
				return iter2.next();
		}
		if (iter.hasNext()) {
			iter2 = iter.next();
			return this.next();
		}
		return null;
	}

	@Override
	public void remove() {
		while(iter.hasNext()) {
			iter.next().remove();
		}
		iter.remove();
	}

	public static void main(String[] args) {
		Iterator<Integer> a = Arrays.asList(1, 2, 3).iterator();
		Iterator<Double> b = Arrays.asList(4.0, 5.0, 6.0).iterator();
		Iterator<Long> c = Arrays.asList(7L, 8L, 9L).iterator();
		Iterator<? extends Iterator<? extends Number>> list = Arrays.asList(a, b, c).iterator();
		// Now I pass the iterator of iterator to the class problem. Problem is
		// actually an iterator since I implement Iterator<Integer>
		@SuppressWarnings({ "rawtypes", "unchecked" })
		Problem p = new Problem(list);
		while (p.hasNext()) {
			System.out.println(p.next());
		}
	}

}