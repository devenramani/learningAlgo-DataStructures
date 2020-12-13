
public class DoubleRoom extends Room {
	
	private static int noOfPeople = 2;
	private static int cleaningTime = 1;

	public DoubleRoom(String wing, int roomNumber, int uniqueId, String status) {
		super(wing, roomNumber, noOfPeople , cleaningTime, uniqueId, status);
	}
}