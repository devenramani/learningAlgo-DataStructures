
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagementSystem mSystem = new ManagementSystem();

		//adding doubleRooms
		mSystem.addDoubleRoom("A-Wing", 101, Global.RoomStatus.READY.toString());
		mSystem.addDoubleRoom("A-Wing", 102, Global.RoomStatus.OCCUPIED.toString());
		mSystem.addDoubleRoom("A-Wing", 103, Global.RoomStatus.READY.toString());
		mSystem.addDoubleRoom("A-Wing", 104, Global.RoomStatus.READY.toString());
		mSystem.addDoubleRoom("A-Wing", 105, Global.RoomStatus.READY.toString());
		mSystem.addDoubleRoom("A-Wing", 106, Global.RoomStatus.CHECKED_OUT.toString());
		
		//adding familyRooms
		mSystem.addFamilyRoom("B-Wing", 201, Global.RoomStatus.READY.toString());
		mSystem.addFamilyRoom("B-Wing", 202, Global.RoomStatus.CHECKED_OUT.toString());
		mSystem.addFamilyRoom("B-Wing", 203, Global.RoomStatus.OCCUPIED.toString());
		mSystem.addFamilyRoom("B-Wing", 204, Global.RoomStatus.OCCUPIED.toString());
		mSystem.addFamilyRoom("B-Wing", 205, Global.RoomStatus.READY.toString());
		
		//adding Clients
		mSystem.addClient("John", "John@vub.be");
		mSystem.addClient("Sam", "Sam@vub.be");
		mSystem.addClient("Sara", "Sara@vub.be");
		mSystem.addClient("Emily", "Emily@vub.be");
		mSystem.addClient("Theo", "Theo@vub.be");
		
		//print all rooms and clients
		mSystem.printRooms();
		mSystem.printClients();
		
		mSystem.printAvailableRooms();
		mSystem.printOccupiedRooms();
		
		mSystem.checkInDoubleRoom(0);
		mSystem.checkInDoubleRoom(1);
		
		mSystem.checkInFamilyRoom(2);
		mSystem.checkInFamilyRoom(3);
		
		mSystem.printAvailableRooms();
		mSystem.printOccupiedRooms();
		
		mSystem.checkOutRoom(3);
		
		mSystem.printAvailableRooms();
		
	}

}
