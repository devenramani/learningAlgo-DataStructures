
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

	public Vector getAllRooms() {
		Vector allRooms = new Vector(100);

		for (int i = 0; i < doubleRooms.size(); i++) {
			DoubleRoom doubleRoom = (DoubleRoom) doubleRooms.get(i);
			allRooms.addLast(doubleRoom);
		}

		for (int i = 0; i < familyRooms.size(); i++) {
			FamilyRoom familyRoom = (FamilyRoom) familyRooms.get(i);
			allRooms.addLast(familyRoom);
		}

		return allRooms;
	}

	@Override
	public void printRooms() {

		System.out.println("\n-- All Rooms --");

		Vector allRooms = getAllRooms();

		for (int i = 0; i < allRooms.size(); i++) {
			Room room = (Room) allRooms.get(i);
			System.out.println(room.roomNumber + " | " + room.status);
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

	public Room getNextAvailableRoom(Vector rooms) {
		int uniqueId = 0;
		Room nextAvailableRoom = (Room) rooms.get(uniqueId);

		while (nextAvailableRoom.getStatus() != Global.RoomStatus.READY.toString()) {
			uniqueId++;
			nextAvailableRoom = (Room) rooms.get(uniqueId);
		}

		return nextAvailableRoom;

	}

	@Override
	public int checkInDoubleRoom(int client) {
		Room checkInRoom = getNextAvailableRoom(doubleRooms);

		Client c = (Client) clients.get(client);
		c.setClientRoom(checkInRoom);

		checkInRoom.setStatus(Global.RoomStatus.OCCUPIED.toString());

		System.out.println("\nChecked in Double Room : " + checkInRoom.getRoomNumber() + " with Client : " + c.name);

		return checkInRoom.getRoomId();
	}

	@Override
	public int checkInFamilyRoom(int client) {
		Room checkInRoom = getNextAvailableRoom(familyRooms);

		Client c = (Client) clients.get(client);
		c.setClientRoom(checkInRoom);

		checkInRoom.setStatus(Global.RoomStatus.OCCUPIED.toString());

		System.out.println("\nChecked in Double Room : " + checkInRoom.getRoomNumber() + " with Client : " + c.name);

		return checkInRoom.getRoomId();
	}

	@Override
	public boolean checkOutRoom(int client) {
		Client c = (Client) clients.get(client);
		Room room = c.getClientRoom();
		room.setStatus(Global.RoomStatus.READY.toString());
		return c.checkOutClient();
	}

	@Override
	public Vector searchAvailableRooms() {
		Vector allRooms = getAllRooms();
		Vector availableRooms = new Vector(100);

		for (int i = 0; i < allRooms.size(); i++) {
			Room room = (Room) allRooms.get(i);
			if (room.getStatus() == Global.RoomStatus.READY.toString()) {
				availableRooms.addLast(room);
			}
		}
		return availableRooms;
	}

	@Override
	public void printAvailableRooms() {
		Vector availableRooms = searchAvailableRooms();

		System.out.println("\n-- Available Rooms --");

		for (int i = 0; i < availableRooms.size(); i++) {
			Room room = (Room) availableRooms.get(i);
			System.out.println(room.roomNumber + " | " + room.status);
		}
	}

	@Override
	public void printOccupiedRooms() {
		Vector allRooms = getAllRooms();

		System.out.println("\n-- Occupied Rooms --");

		for (int i = 0; i < allRooms.size(); i++) {
			Room room = (Room) allRooms.get(i);
			if (room.getStatus() != Global.RoomStatus.READY.toString()) {
				System.out.println(room.roomNumber + " | " + room.status);
			}
		}
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
