
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagementSystem mSystem = new ManagementSystem();
		
		//adding doubleRooms
		mSystem.addDoubleRoom("A-Wing", 101,"Ready");
		mSystem.addDoubleRoom("A-Wing", 102,"Ready");
		mSystem.addDoubleRoom("A-Wing", 103,"Ready");
		
		//adding familyRooms
		mSystem.addFamilyRoom("B-Wing", 201, "Ready");
		mSystem.addFamilyRoom("B-Wing", 202, "Ready");
		
		//adding Clients
		mSystem.addClient("John", "John@vub.be");
		mSystem.addClient("Sam", "Sam@vub.be");
		
		//print all rooms and clients
		mSystem.printRooms();
		mSystem.printClients();
		
	}

}
