
public class Queue {
	
	private Vector data;
	
	public Queue(int capacity) {
		this.data = new Vector(capacity);
	}

	public void push(Object o) {
		data.addLast(o);
	}

	public Object pop() {
		Object first = data.get(0);
		data.removeFirst();
		return first;	
	}

	public Object top() {
		return data.get(0);
	}

	public int size() {
		return data.size();
	}

	public boolean empty() {
		data = new Vector(1);
		return true;
	}
}
