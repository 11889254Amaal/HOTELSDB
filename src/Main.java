import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	static void choicesFunction() {

		System.out.println("***************************");
		System.out.println("Welcome...Please Select one of the following options:");
		System.out.println("1. connect to database");
		System.out.println("2. create All Table Student databse");
		System.out.println("3. Insert 10,000 hotels ");
		System.out.println("4.  Insert 1 hotels");
		System.out.println("5.  Print 10 hotels ");
		System.out.println("6. Make first 10 hotels 'is_Active' = false ");
		System.out.println("7. Print hotel information by user input");
		System.out.println("8. updateById");
		System.out.println("9. Delete by id");
		System.out.println("10. Sub Menu");
		System.out.println("11. Insert to Employe Type Table");
		System.out.println("12. Insert to Rooms Type Table");
		System.out.println("13. Insert to Guest Tables");
		System.out.println("14. Insert to Rooms Tables");
		System.out.println("15. Insert to Employes Tables");
		System.out.println("16. Existe from System");
	}

	static void choicesFunctionForSubMenu() {
		System.out.println("***************************");
		System.out.println("Welcome...Please Select one of the following options:");
		System.out.println("1. Guests who's name end with 'E'");
		System.out.println("2. Rooms where guests are paying more than 1000");
		System.out.println("3.Count of guests who are staing in 'DELUXE' rooms");
		System.out.println("4.Guests who are staing in rooms and served by employee who have 'A' in their name");
		System.out.println("5.All rooms which are not active but room type is 'Deluxe'");
		System.out.println("6.All room type in hotels who's name have 'H' or are active but have more than 5 rooms.");
		System.out.println("7.Existe from Program");
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		choicesFunction();

		do {
			/// hibkjbjkjguj
			int userInput = sc.nextInt();
			switch (userInput) {
			case 1:
				// this class to connect eclipes with my database
				ConnectToDatabase connectToDatabse1 = new ConnectToDatabase();
				ConnectToDatabase.conToData1();
				choicesFunction();
				//
				break;

			case 2:
				CreateHotelsTable CreateHotelsTable = new CreateHotelsTable();
				CreateHotelsTable.CreateTableToDB();

				CreateRoom_TypeTable CreateRoomTypeTable = new CreateRoom_TypeTable();
				CreateRoomTypeTable.CreateTableToDB();

				Rooms CreateRoomTable = new Rooms();
				CreateRoomTable.CreateTableToDB();
				choicesFunction();

				Guests CreateRoomTable1 = new Guests();
				CreateRoomTable1.CreateTableToDB();
				choicesFunction();

				Employee_Type CreateRoomTable2 = new Employee_Type();
				CreateRoomTable2.CreateTableToDB();
				choicesFunction();

				Employees CreateRoomTable3 = new Employees();
				CreateRoomTable3.CreateTableToDB();
				choicesFunction();
				break;

			case 3:

				CreateHotelsTable InsertHotels = new CreateHotelsTable();
				InsertHotels.insertIntoTable();

				choicesFunction();
				break;

			case 4:
				CreateHotelsTable InsertHotels1 = new CreateHotelsTable();
				InsertHotels1.insertIntoTableHotels();
				choicesFunction();

				break;

			case 5:

				CreateHotelsTable Load10hotel = new CreateHotelsTable();
				Load10hotel.ShowTop();
				choicesFunction();

				break;

			case 6:
				CreateHotelsTable LoadChangehotel = new CreateHotelsTable();
				LoadChangehotel.ChangeActive();
				choicesFunction();

				break;
			case 7:
				CreateHotelsTable LoadChangehote2 = new CreateHotelsTable();
				LoadChangehote2.ShowHostelInformation();
				choicesFunction();

				break;
			case 8:
				CreateHotelsTable UpdateByID1 = new CreateHotelsTable();
				UpdateByID1.updateById();
				;
				choicesFunction();

				break;

			case 9:
				CreateHotelsTable DelteByID1 = new CreateHotelsTable();
				DelteByID1.DeleteById();
				choicesFunction();

				break;

			

			case 10:
				
				System.out.println("New TASK SUB Menu");
				Scanner sc1 = new Scanner(System.in);
				choicesFunctionForSubMenu();

				do {
					/// hibkjbjkjguj
					int userInput1 = sc.nextInt();
					switch (userInput1) {
					case 1:
						// this class to insert to table with IDENTITY(1,1)

						choicesFunctionForSubMenu();
						//
						break;

					case 2:
						// this class to insert to table with IDENTITY(1,1)

						choicesFunctionForSubMenu();
						//
						break;
					case 3:
						// this class to insert to table with IDENTITY(1,1)

						choicesFunctionForSubMenu();
						//
						break;
						
					case 4:
						// this class to insert to table with IDENTITY(1,1)

						choicesFunctionForSubMenu();
						//
					break;
					
					case 5:
						// this class to insert to table with IDENTITY(1,1)

						choicesFunctionForSubMenu();
						//
					break;
					
					case 6:
						// this class to insert to table with IDENTITY(1,1)

						choicesFunctionForSubMenu();
						//
					break;
					
					case 7:
						// this class to insert to table with IDENTITY(1,1)

						System.out.println("Exiting The System Bye See you Again :)!....");
						System.exit(0);
						//
					break;
					
					}
				} while (true);
			case 11:
				System.out.println("Insert to Employe Type Table");
				Employee_Type empType=new Employee_Type();
				empType.InsertintoTableEmploye_type();
				///done
				break;
				
			case 12:
				System.out.println("Insert to Rooms Type Table");
				CreateRoom_TypeTable RoomsType=new CreateRoom_TypeTable();
				RoomsType.InsertintoTableRooms_type();
				//done
				break;
			case 13:
				System.out.println("Insert to Guest  Table");
				Guests GuestsInsert=new Guests();
				GuestsInsert.InsertIntoTable();
				break;
			case 14:
				System.out.println("Insert to Rooms  Table");
				Rooms RommInsert=new Rooms();
				RommInsert.InsertintoTableRooms();
				break;
			
			case 15:
				System.out.println("Insert to Employe  Table");
				Employees emp1=new Employees();
				emp1.InsertintoTableEmploye();
				break;
			case 16:
				System.out.println("Exiting The System Bye See you Again :)!....");
				System.exit(0);

				break;

			}
			

		} while (true);

	}

}
