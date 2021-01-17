import java.util.concurrent.atomic.AtomicLong;

public class ManagementSystem implements IManagementSystem {

	private Vector doubleRooms = new Vector(50);
	private Vector familyRooms = new Vector(50);
	private Vector clients = new Vector(50);

	AtomicLong generateClientUniqueID = new AtomicLong(1);
	AtomicLong generateRoomUniqueID = new AtomicLong(1);

	@Override
	public int addDoubleRoom(String wing, int roomNumber, String status) {
		// assigning a unique number to double room
		int uniqueId = (int) generateRoomUniqueID.getAndIncrement();

		// creating DoubleRoom object
		DoubleRoom doubleRoom = new DoubleRoom(wing, roomNumber, uniqueId, status);

		// adding object to doubleRoom vector
		doubleRooms.addLast(doubleRoom);

		return doubleRoom.getRoomId();
	}

	@Override
	public int addFamilyRoom(String wing, int roomNumber, String status) {
		// assigning a unique number to family room
		int uniqueId = (int) generateRoomUniqueID.getAndIncrement();

		// creating familyRoom object
		FamilyRoom familyRoom = new FamilyRoom(wing, roomNumber, uniqueId, status);

		// adding object to familyRooms vector
		familyRooms.addLast(familyRoom);

		return familyRoom.getRoomId();
	}

	@Override
	public int addClient(String name, String emailAddress) {
		// assigning a unique number to client
		int clientId = (int) generateClientUniqueID.getAndIncrement();

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
			System.out.println(room.getWing() + "\t" + room.getRoomNumber() + "\t" + room.getStatus());
		}
	}

	@Override
	public void printClients() {
		System.out.println("\n-- Clients --");
		System.out.println("ID \tName \tEmail \n");
		// printing all the clients.
		for (int i = 0; i < clients.size(); i++) {
			Client client = (Client) clients.get(i);
			System.out.println(client.getClientId() + "\t" + client.getName() + "\t" + client.getEmailAddress());
		}
	}

	public Room getNextAvailableRoom(Vector rooms) {
		int roomsSize = rooms.size();

		Room nextRoom = new Room();

		for (int i = 0; i < roomsSize; i++) {
			Room nextAvailableRoom = (Room) rooms.get(i);

			if (nextAvailableRoom.getStatus() == Global.RoomStatus.READY.toString() || nextAvailableRoom.getStatus() == Global.RoomStatus.CHECKED_OUT.toString()) {
				nextRoom = nextAvailableRoom;
				break;
			}
		}
		return nextRoom;

	}
	
	public Client getClient(int clientId) {
		
		int clientVectorSize = clients.size();
		
		Client client = new Client();
		
		for (int i = 0;i< clientVectorSize; i++) {
			Client c = (Client) clients.get(i);
			if(c.getClientId() == clientId) {
				client = c;
				break;
			}
		}
		return client;
	}

	@Override
	public int checkInDoubleRoom(int clientId) {
		Room checkInRoom = getNextAvailableRoom(doubleRooms);
		if (checkInRoom.getRoomNumber() != 0) {
			Client client = getClient(clientId);
			
			if(client.getClientId() == 0) {return 0;}
			
			client.setClientRoom(checkInRoom);

			checkInRoom.setStatus(Global.RoomStatus.OCCUPIED.toString());
			checkInRoom.setClientInRoom(client);

			System.out.println(
					"\nChecked in Double Room : " + checkInRoom.getRoomNumber() + " with Client : " + client.getName());

			return checkInRoom.getRoomId();
		} else {
			return 0;
		}
	}

	@Override
	public int checkInFamilyRoom(int clientId) {
		Room checkInRoom = getNextAvailableRoom(familyRooms);
		if (checkInRoom.getRoomNumber() != 0) {
			Client client = getClient(clientId);
			
			if(client.getClientId() == 0) {return 0;}
			
			client.setClientRoom(checkInRoom);

			checkInRoom.setStatus(Global.RoomStatus.OCCUPIED.toString());
			checkInRoom.setClientInRoom(client);

			System.out.println(
					"\nChecked in Family Room : " + checkInRoom.getRoomNumber() + " with Client : " + client.getName());

			return checkInRoom.getRoomId();
		} else {
			return 0;
		}
	}

	@Override
	public boolean checkOutRoom(int clientId) {
		
		Client client = getClient(clientId);

		if (client != null && client.getClientRoom() != null) {
			Room room = client.getClientRoom();
			room.setStatus(Global.RoomStatus.CHECKED_OUT.toString());
			System.out.println("\nCheckout Successfull.");
			return client.checkOutClient();
		} else {
			System.out.println("\nError while Checking out room.");
			return false;
		}
	}

	@Override
	public Vector searchAvailableRooms() {
		Vector allRooms = getAllRooms();
		Vector availableRooms = new Vector(100);

		for (int i = 0; i < allRooms.size(); i++) {
			Room room = (Room) allRooms.get(i);
			if (room.getStatus() == Global.RoomStatus.READY.toString()
					|| room.getStatus() == Global.RoomStatus.CHECKED_OUT.toString()) {
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
			System.out.println(room.getWing() + "\t" + room.getRoomNumber() + "\t" + room.getStatus());
		}
	}

	@Override
	public void printOccupiedRooms() {
		Vector allRooms = getAllRooms();

		System.out.println("\n-- Occupied Rooms --");
		
		System.out.println("Wing \tRoom \tStatus \tClientId \tClientName\n");

		for (int i = 0; i < allRooms.size(); i++) {
			Room room = (Room) allRooms.get(i);
			if (room.getStatus() != Global.RoomStatus.READY.toString()
					&& room.getStatus() != Global.RoomStatus.CHECKED_OUT.toString()) {
				Client clientInRoom = room.getClientInRoom();
				System.out.println(room.getWing() + "\t" + room.getRoomNumber() + "\t" + room.getStatus() + "\t" + clientInRoom.getClientId() +"\t" + clientInRoom.getName());
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
