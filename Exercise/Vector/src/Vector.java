public class Vector {
	private Object data[];
	private int count;

	public Vector(int capacity) {
		data = new Object[capacity];
		count = 0;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Object get(int index) {
		return data[index];
	}

	public void set(int index, Object obj) {
		data[index] = obj;
	}

	public boolean contains(Object obj) {
		for (int i = 0; i < count; i++) {
			if (data[i] == obj)
				return true;
		}
		return false;
	}

	public void addFirst(Object item) {
		for (int i = count - 1; i >= 0; i--) {
			data[i + 1] = data[i];
		}
		data[0] = item;
		count++;
	}

	public void addLast(Object o) {
		if (count >= data.length) {
			this.extendCapacity();
		}
		data[count] = o;
		count++;
	}

	/*
	 * public boolean binarySearch(Object key) { int start = 0; int end = count - 1;
	 * while(start <= end) { int middle = (start + end + 1) / 2; if(key <
	 * data[middle]) end = middle -1; else if(key > data[middle]) start = middle +
	 * 1; else return true; } return false; }
	 */

	public Object getFirst() {
		return data[0];
	}

	public Object getLast() {
		return (data[count - 1]);

	}

	public void removeLast() {
		data[count - 1] = null;
		count--;
	}

	public void removeFirst() {
		for (int i = 0; i < count - 1; i++) {
			data[i] = data[i + 1];
		}
		data[count] = null;
		count--;
	}

	public String toString() {
		String str = "";

		for (int i = 0; i < count; i++) {
			str += " " + data[i];
		}
		return str;
	}

	public void reverse() {

		Object temp;

		for (int i = 0; i < this.count / 2; i++) {
			temp = data[i];
			data[i] = data[count - i - 1];
			data[count - i - 1] = temp;
		}
	}

	public Vector repeat() {
		Vector tempVector = new Vector(2 * count);

		for (int i = 0; i < count; i++) {
			tempVector.addLast(data[i]);
			tempVector.addLast(data[i]);
		}
		return tempVector;
	}

	public Vector interleave(Vector interleaveVector) {
		Vector tempVector = new Vector(2 * count);

		for (int i = 0; i < count; i++) {
			tempVector.addLast(data[i]);
			tempVector.addLast(interleaveVector.data[i]);
		}
		return tempVector;
	}

	public void extendCapacity() {
		Vector extendedVector = new Vector(2 * count);
		for (int i = 0; i < count; i++) {
			extendedVector.addLast(data[i]);
		}
		this.data = extendedVector.data;
	}
}