
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//add elements
		Vector v = new Vector(10);
		
		for(int i=1;i<=50;i++) {
			v.addLast(i);
		}
		
		//get Size
		System.out.println("Vector size : " + v.size());
		
		// get First and Last element
		System.out.println("First element : " + v.getFirst());
		System.out.println("Last element : " + v.getLast());
		
		//Vector to String
		System.out.println("Vector to String : " + v);

		//adding element at first index
		System.out.println("Adding element at first index..");
		v.addFirst(99);
		System.out.println("Vector to String : " + v);
		System.out.println("First element : " + v.getFirst());
		
		//removing element at last index
		System.out.println("Removing element at last index..");
		v.removeLast();
		System.out.println("Vector to String : " + v);
		
		//removing element at first index
		System.out.println("Removing element at first index..");
		v.removeFirst();
		System.out.println("Vector to String : " + v);
		
		//reverse Vector
		System.out.println("Reversing Vector");
		v.reverse();
		System.out.println("Vector to String : " + v);
		
		//repeating Vector
		System.out.println("Repeating Vector");
		Vector repeatedVector = v.repeat();
		System.out.println("Repeated Vector : " + repeatedVector);
		
		//interleave Vector
		System.out.println("Interleaving Vector");
		
		Vector v1 = new Vector(3);
		Vector v2 = new Vector(3);
		
		v1.addLast(1);
		v1.addLast(2);
		v1.addLast(3);
		
		v2.addLast(4);
		v2.addLast(5);
		v2.addLast(6);

		System.out.println("Interleaved Vector" + v1.interleave(v2));

	}

}
