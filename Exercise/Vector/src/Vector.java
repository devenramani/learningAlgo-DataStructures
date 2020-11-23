public class Vector
{
	private Object data[];
	private int count;
	
	public Vector(int capacity)
	{
		data = new Object[capacity];
		count = 0;
	}

	public int size()
	{
		return count;
	}
 
	public boolean isEmpty()
	{
		return size() == 0;
	}

	public Object get(int index)
	{
		return data[index];
	}

	public void set(int index, Object obj)
	{
		data[index] = obj;
	}

	public boolean contains(Object obj)
	{
		for(int i=0;i<count;i++)
		{
			if(data[i] == obj) return true;
		}
		return false;
	}
	
	public void addFirst(Object item)
	{
		// add your code
	}

	public void addLast(Object o)
	{
		data[count] = o;
		count++;
	}
	
	/*
	public boolean binarySearch(Object key)
	{
	int start = 0;
	int end = count - 1;
	while(start <= end)
	{
		int middle = (start + end + 1) / 2;
		if(key < data[middle]) end = middle -1;
		else if(key > data[middle]) start = middle + 1;
		else return true;
	}
	return false;
	}
	*/

//	public Object getFirst()
//	{
//		// add your code
//	}

//	public Object getLast()
//	{
//		// add your code
//	}

	public void removeLast()
	{
		// add your code
	} 

	public void removeFirst()
	{
		// add your code
	}
	
}