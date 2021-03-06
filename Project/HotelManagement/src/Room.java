
 public class Room {

	private Graph.Node wing;
	private String status;

	private int roomNumber;
	private int uniqueId;	
	private int noOfPeople;
	private int cleaningTime;
	
	Client clientInRoom;
	
	public Room() {
		//empty constructor
	}

	public Room(Graph.Node wing, int roomNumber, int noOfPeople, int cleaningTime, int uniqueId, String status) {
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

	public Comparable getWing() {
		return wing.getLabel();
	}

	public void setWing(Graph.Node wing) {
		this.wing = wing;
	}
	
	public void setClientInRoom(Client clientInRoom) {
		this.clientInRoom = clientInRoom;
	}
	
	public Client getClientInRoom() {
		return this.clientInRoom;
	}
		
}
