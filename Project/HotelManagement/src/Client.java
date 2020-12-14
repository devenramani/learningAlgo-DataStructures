
public class Client {
	
	String name;
	String emailAddress;
	
	int uniqueId;
	
	Room clientRoom;
	
	public Client(String name, String emailAddress, int uniqueId) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.uniqueId = uniqueId;
	}
	
	public int getClientId() {
		return this.uniqueId;
	}
	
	public void setClientRoom(Room clientRoom) {
		this.clientRoom = clientRoom;
	}
	
	public Room getClientRoom() {
		return this.clientRoom;
	}
	
	public boolean checkOutClient() {
		this.clientRoom = null;
		return true;
	}
}
