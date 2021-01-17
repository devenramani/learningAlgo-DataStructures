import java.util.concurrent.atomic.AtomicLong;

public class ManagementSystem implements IManagementSystem {

	private Vector doubleRooms = new Vector(50);
	private Vector familyRooms = new Vector(50);
	private Vector clients = new Vector(50);

	private Queue roomsToBeCleaned = new Queue(50);

	Graph hotelBuilding = new Graph();

	AtomicLong generateClientUniqueID = new AtomicLong(1);
	AtomicLong generateRoomUniqueID = new AtomicLong(1);

	@Override
	public int addDoubleRoom(String wing, int roomNumber, String status) {
		// assigning a unique number to double room
		int uniqueId = (int) generateRoomUniqueID.getAndIncrement();

		// creating DoubleRoom object
		Graph.Node wingNode = hotelBuilding.findNode(wing);
		DoubleRoom doubleRoom = new DoubleRoom(wingNode, roomNumber, uniqueId, status);

		// adding object to doubleRoom vector
		doubleRooms.addLast(doubleRoom);

		return doubleRoom.getRoomId();
	}

	@Override
	public int addFamilyRoom(String wing, int roomNumber, String status) {
		// assigning a unique number to family room
		int uniqueId = (int) generateRoomUniqueID.getAndIncrement();

		// creating familyRoom object
		Graph.Node wingNode = hotelBuilding.findNode(wing);
		FamilyRoom familyRoom = new FamilyRoom(wingNode, roomNumber, uniqueId, status);

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

			if (nextAvailableRoom.getStatus() == Global.RoomStatus.READY.toString()
					|| nextAvailableRoom.getStatus() == Global.RoomStatus.CHECKED_OUT.toString()) {
				nextRoom = nextAvailableRoom;
				break;
			}
		}
		return nextRoom;

	}

	public Client getClient(int clientId) {

		int clientVectorSize = clients.size();

		Client client = new Client();

		for (int i = 0; i < clientVectorSize; i++) {
			Client c = (Client) clients.get(i);
			if (c.getClientId() == clientId) {
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

			if (client.getClientId() == 0) {
				return 0;
			}

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

			if (client.getClientId() == 0) {
				return 0;
			}

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
			roomsToBeCleaned.push(room);
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
				System.out.println(room.getWing() + "\t" + room.getRoomNumber() + "\t" + room.getStatus() + "\t"
						+ clientInRoom.getClientId() + "\t" + clientInRoom.getName());
			}
		}
	}

	@Override
	public void addWing(String wingName) {
		// TODO Auto-generated method stub
		Graph.Node nodeName = new Graph.Node(wingName);
		hotelBuilding.addNode(nodeName);
	}

	@Override
	public void connectWings(String wing1, String wing2, double distance) {
		// TODO Auto-generated method stub
		hotelBuilding.addEdge(wing1, wing2, distance);
	}

	@Override
	public void organizeCleaning() {
		// TODO Auto-generated method stub

		System.out.println("Cleaning rooms..");
		
		Comparable startWing = "A";

		while(roomsToBeCleaned.size() != 0) {
			Room roomToBeCleaned = (Room) roomsToBeCleaned.top();
			Comparable destinationWing = roomToBeCleaned.getWing();
			
			double shortestPath = getShortestPath(startWing,destinationWing);
			
				try
				{
					System.out.println("Cleaning room - "+ roomToBeCleaned.getRoomNumber());
					//sleeping for n seconds to depict traveling time to other destination wing
				    Thread.sleep((long) (shortestPath * 1000));
				}
				catch(InterruptedException ex)
				{
				    Thread.currentThread().interrupt();
				}
			
			roomToBeCleaned.setStatus(Global.RoomStatus.READY.toString());
			roomsToBeCleaned.pop();
		
		}
		
		System.out.println("Rooms Cleaned");
	}
	
	public double getShortestPath(Comparable startWing, Comparable destinationWing) {
		if(startWing == destinationWing) {
			//returning least amount of time to travel within same wing i.e. 1 min
			return 1;
		}
		else {
			
			Graph.Node destWing = hotelBuilding.findNode(destinationWing);
			Vector allEdges = destWing.getEdges();
			
			double shortestEdgeWeight = ((Graph.Edge) allEdges.get(0)).getDistance();
			
			for(int i=0;i<allEdges.size();i++) {
				Graph.Edge nodeEdge = (Graph.Edge) allEdges.get(i);
				if (nodeEdge.getDistance() < shortestEdgeWeight)
				{
					shortestEdgeWeight = nodeEdge.getDistance();
				}
			}
			
			//[TODO] (Pending) COULD NOT COMPLETE THE LOGIC TO FIND THE SHORTEST DISTANCE BECAUSE OF INFINITE LOOPING ISSUE
			
			return shortestEdgeWeight;
		}
	}

}
