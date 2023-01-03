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
			System.out.println("8. Exit from Program");
			}
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
		
				// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
				choicesFunction();

				do {
				           ///hibkjbjkjguj
				int userInput = sc.nextInt();
				switch (userInput) {
				case 1:
				//this class to connect eclipes with my database
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
				System.out.println("Exiting The System Bye See you Again :)!....");
				System.exit(0);

				break;


				}

				} while (true);


				

		}

	}
