import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicLong;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagementSystem mSystem = new ManagementSystem();

		AtomicLong uniqueRoomNumber = new AtomicLong(101);

		// adding A wing rooms
		mSystem.addDoubleRoom("A-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addDoubleRoom("A-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.CHECKED_OUT.toString());
		mSystem.addFamilyRoom("A-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.OCCUPIED.toString());
		mSystem.addFamilyRoom("A-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.OCCUPIED.toString());

		// adding B wing rooms
		mSystem.addFamilyRoom("B-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addFamilyRoom("B-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.CHECKED_OUT.toString());
		mSystem.addDoubleRoom("B-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.OCCUPIED.toString());
		mSystem.addDoubleRoom("B-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());

		// adding C wing rooms
		mSystem.addDoubleRoom("C-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addDoubleRoom("C-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.OCCUPIED.toString());
		mSystem.addFamilyRoom("C-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addFamilyRoom("C-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());

		// adding D wing rooms
		mSystem.addDoubleRoom("D-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addDoubleRoom("D-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());
		mSystem.addFamilyRoom("D-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.OCCUPIED.toString());
		mSystem.addFamilyRoom("D-Wing", (int) uniqueRoomNumber.getAndIncrement(), Global.RoomStatus.READY.toString());

		// adding Clients
		mSystem.addClient("John", "John@vub.be");
		mSystem.addClient("Sam", "Sam@vub.be");
		mSystem.addClient("Sara", "Sara@vub.be");
		mSystem.addClient("Emily", "Emily@vub.be");
		mSystem.addClient("Theo", "Theo@vub.be");

		while (true) {

			System.out.println("\n \n ***Hotel Management***");
			System.out.println("1. Display Rooms");
			System.out.println("2. Display Clients");
			System.out.println("3. Check-In Room");
			System.out.println("4. Check-Out Room");

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

					System.out.println("1. Double Room.");
					System.out.println("2. Family Room.");

					BufferedReader checkinOptions = new BufferedReader(new InputStreamReader(System.in));

					int checkinOption = Integer.parseInt(checkinOptions.readLine());

					switch (checkinOption) {
					case 1:
						System.out.println("Check-In Double Room.");
						mSystem.checkInDoubleRoom(1);
						break;
					case 2:
						System.out.println("Check-In Family Room.");
						break;
					default:
						System.out.println("Incorrect Option.");
					}

					break;
				case 4:
					System.out.println("Check-Out Room.");
					break;
				case 5:
					System.out.println("Case 5");
					break;
				default:
					System.out.println("Incorrect Option.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
//		mSystem.checkInDoubleRoom(0);
//		mSystem.checkInDoubleRoom(1);
//		
//		mSystem.checkInFamilyRoom(2);
//		mSystem.checkInFamilyRoom(3);

//		mSystem.checkOutRoom(3);

	}

}
