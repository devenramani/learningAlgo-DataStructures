
public class FamilyRoom extends Room {
	
	private static int noOfPeople = 4;
	private static int cleaningTime = 2;
	
	public FamilyRoom(String wing, int roomNumber, int uniqueId, String status) {
		super(wing, roomNumber, noOfPeople, cleaningTime, uniqueId, status);
	}
}