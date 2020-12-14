
 public class Room {

	String wing;
	String status;

	int roomNumber;
	int uniqueId;
	int noOfPeople;
	int cleaningTime;

	public Room(String wing, int roomNumber, int noOfPeople, int cleaningTime, int uniqueId, String status) {
		this.wing = wing;
		this.roomNumber = roomNumber;
		this.noOfPeople = noOfPeople;
		this.cleaningTime = cleaningTime;
		this.uniqueId = uniqueId;
		this.status = status;
	}

	public int getRoomId() {
		return this.uniqueId;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public int getRoomNumber() {
		return this.roomNumber;
	}
		
}
