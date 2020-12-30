
 public class Room {

	private String wing;
	private String status;

	private int roomNumber;
	private int uniqueId;	
	private int noOfPeople;
	private int cleaningTime;
	
	public Room() {
		//empty constructor
	}

	public Room(String wing, int roomNumber, int noOfPeople, int cleaningTime, int uniqueId, String status) {
		this.setWing(wing);
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

	public String getWing() {
		return wing;
	}

	public void setWing(String wing) {
		this.wing = wing;
	}
		
}
