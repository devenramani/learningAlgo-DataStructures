
public class Client {
	
	private String name;
	private String emailAddress;
	
	private int uniqueId;
	
	Room clientRoom;
	
	public Client(String name, String emailAddress, int uniqueId) {
		this.setName(name);
		this.setEmailAddress(emailAddress);
		this.uniqueId = uniqueId;
	}
	
	public Client() {
		//empty constructor
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
