
public class Client {
	
	String name;
	String emailAddress;
	
	int uniqueId;
	
	public Client(String name, String emailAddress, int uniqueId) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.uniqueId = uniqueId;
	}
	
	public int getClientId() {
		return this.uniqueId;
	}
	
}
