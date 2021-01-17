import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicLong;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AtomicLong uniqueRoomNumber = new AtomicLong(101);
					
		ManagementSystem mSystem = new ManagementSystem();
		
		mSystem.addWing("A");
		mSystem.addWing("B");
		mSystem.addWing("C");
		mSystem.addWing("D");
		
		mSystem.connectWings("A", "B", 5);
		mSystem.connectWings("B", "D", 4);
		mSystem.connectWings("D", "C", 3);
		mSystem.connectWings("C", "A", 8);
		mSystem.connectWings("B", "C", 2);
		
		// adding Clients
		mSystem.addClient("John", "John@vub.be");
		mSystem.addClient("Sam", "Sam@vub.be");
		mSystem.addClient("Sara", "Sara@vub.be");
		mSystem.addClient("Emily", "Emily@vub.be");
		mSystem.addClient("Theo", "Theo@vub.be");

		// adding A wing rooms
		mSystem.addDoubleRoom("A", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addDoubleRoom("A", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addFamilyRoom("A", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addFamilyRoom("A", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());

		// adding B wing rooms
		mSystem.addFamilyRoom("B", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addFamilyRoom("B", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addDoubleRoom("B", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addDoubleRoom("B", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());

		// adding C wing rooms
		mSystem.addDoubleRoom("C", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addDoubleRoom("C", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addFamilyRoom("C", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addFamilyRoom("C", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());

		// adding D wing rooms
		mSystem.addDoubleRoom("D", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addDoubleRoom("D", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addFamilyRoom("D", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addFamilyRoom("D", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());


		while (true) {

			System.out.println("\n \n ***Hotel Management***");
			System.out.println("1. Display Rooms");
			System.out.println("2. Display Clients");
			System.out.println("3. Check-In Room");
			System.out.println("4. Check-Out Room");
			System.out.println("5. Organize Cleaning");

			System.out.println("0. Exit");

			System.out.println("\n Enter your choice: ");

			try {
				BufferedReader inputMenuOptions = new BufferedReader(new InputStreamReader(System.in));

				int option = Integer.parseInt(inputMenuOptions.readLine());

				switch (option) {
				
				case 0:
					
					System.out.println("Exiting Application..");
					System.exit(0);
					
				case 1:
					
					System.out.println("Displaying Rooms.");
					mSystem.printRooms();
					mSystem.printAvailableRooms();
					mSystem.printOccupiedRooms();
					break;
					
				case 2:
					
					System.out.println("Displaying Clients.");
					mSystem.printClients();
					break;
					
				case 3:
					
					System.out.println("Check-In Room.");
					System.out.println("Select ClientID :");
					
					mSystem.printClients();
					
					BufferedReader checkinClientInput= new BufferedReader(new InputStreamReader(System.in));
					int checkinClientID= Integer.parseInt(checkinClientInput.readLine());

					System.out.println("1. Double Room.");
					System.out.println("2. Family Room.");
					
					BufferedReader checkinOptions = new BufferedReader(new InputStreamReader(System.in));
					int checkinOption = Integer.parseInt(checkinOptions.readLine());

						switch (checkinOption) {
						
						case 1:
							
							System.out.println("Check-In Double Room:");
							mSystem.checkInDoubleRoom(checkinClientID);
							break;
							
						case 2:
							
							System.out.println("Check-In Family Room:");
							mSystem.checkInFamilyRoom(checkinClientID);
							break;
							
						default:
							
							System.out.println("Incorrect Option.");
							
						}
						break;
						
				case 4:
					
					System.out.println("\nCheck-Out Room:");
					mSystem.printOccupiedRooms();
					System.out.println("\n Enter ClientId to Check-Out :");
					
					BufferedReader clientIdToCheckOut = new BufferedReader(new InputStreamReader(System.in));
					int clientID = Integer.parseInt(clientIdToCheckOut.readLine());
					
					mSystem.checkOutRoom(clientID);
					
					break;
					
				case 5:
					
					System.out.println("\n Organize Cleaning..");
					mSystem.organizeCleaning();
					
					break;
					
				default:
					
					System.out.println("Incorrect Option.");
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
