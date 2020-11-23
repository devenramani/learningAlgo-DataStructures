
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Vector v = new Vector(100);
		
		for(int i=1;i<=51;i++) {
			v.addLast(i);
		}
		
		System.out.println("Vector size : " + v.size());
		
		System.out.println("First element : " + v.getFirst());
		
		System.out.println("Last element : " + v.getLast());
		
		System.out.println("Vector to String : " + v);
		
		System.out.println("Adding element at first index..");
		
		v.addFirst(99);
		
		System.out.println("Vector to String : " + v);
		
		System.out.println("First element : " + v.getFirst());
		
		System.out.println("Vector size : " + v.size());
		
		System.out.println("Removing element at last index..");
		
		v.removeLast();
		
		System.out.println("Vector to String : " + v);
		
		System.out.println("Removing element at first index..");
		
		v.removeFirst();
		
		System.out.println("Vector to String : " + v);
		
		System.out.println("Reversing Vector");
		
		v.reverse();
		
		System.out.println("Vector to String : " + v);
		
		
	}

}
