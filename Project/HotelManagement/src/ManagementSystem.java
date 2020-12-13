
public class ManagementSystem implements IManagementSystem {

	private Vector doubleRooms = new Vector(50);
	private Vector familyRooms = new Vector(50);
	private Vector clients = new Vector(50);

	@Override
	public int addDoubleRoom(String wing, int roomNumber, String status) {
		// assigning a unique number to double room
		int uniqueId = doubleRooms.size();

		// creating DoubleRoom object
		DoubleRoom doubleRoom = new DoubleRoom(wing, roomNumber, uniqueId, status);

		// adding object to doubleRoom vector
		doubleRooms.addLast(doubleRoom);

		return doubleRoom.getRoomId();
	}

	@Override
	public int addFamilyRoom(String wing, int roomNumber, String status) {
		// assigning a unique number to family room
		int uniqueId = familyRooms.size();

		// creating familyRoom object
		FamilyRoom familyRoom = new FamilyRoom(wing, roomNumber, uniqueId, status);

		// adding object to familyRooms vector
		familyRooms.addLast(familyRoom);

		return familyRoom.getRoomId();
	}

	@Override
	public int addClient(String name, String emailAddress) {
		// assigning a unique number to client
		int clientId = clients.size();

		// creating client object
		Client client = new Client(name, emailAddress, clientId);

		// adding object to clients vector
		clients.addLast(client);
		return client.getClientId();
	}

	@Override
	public void printRooms() {
		System.out.println("\n-- Double Rooms --");
		// printing all the doubleRooms
		for (int i = 0; i < doubleRooms.size(); i++) {
			DoubleRoom doubleRoom = (DoubleRoom) doubleRooms.get(i);
			System.out.println(doubleRoom.roomNumber + " | " + doubleRoom.status);
		}

		System.out.println("\n-- Family Rooms --");
		// printing all the familyRooms
		for (int i = 0; i < familyRooms.size(); i++) {
			FamilyRoom familyRoom = (FamilyRoom) familyRooms.get(i);
			System.out.println(familyRoom.roomNumber + " | " + familyRoom.status);
		}

	}

	@Override
	public void printClients() {
		System.out.println("\n-- Clients --");
		// printing all the clients.
		for (int i = 0; i < clients.size(); i++) {
			Client client = (Client) clients.get(i);
			System.out.println(client.name + " | " + client.emailAddress);
		}
	}

	@Override
	public int checkInDoubleRoom(int client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkInFamilyRoom(int client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean checkOutRoom(int client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector searchAvailableRooms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printAvailableRooms() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printOccupiedRooms() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addWing(String wingName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void connectWings(String wing1, String wing2, double distance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void organizeCleaning() {
		// TODO Auto-generated method stub

	}

}
