
public class Stack {
	
	private Vector data;

	public Stack(int capacity) {
		this.data = new Vector(capacity);
	}

	public void push(Object o) {
		data.addLast(o);
	}

	public Object pop() {
		Object last = data.get(data.size()-1);
		data.removeLast();
		return last;
	}

	public Object top() {
		return data.getLast();
	}

	public int size() {
		return data.size();
	}

	public boolean empty() {
		data = new Vector(1);
		return true;
	}
}
