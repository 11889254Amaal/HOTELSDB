
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;

public class Rooms {

	static final String DB_URL = "jdbc:mysql://localhost:3306/HotelDBMS";
	static final String USER = "root";
	static final String PASS = "root";

	public boolean CreateTableToDB() {
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {
			String sql = "CREATE TABLE Rooms " + "(id INTEGER not NULL, " + "room_type_id INTEGER  ,"
					+ "FOREIGN KEY (room_type_id) REFERENCES room_type(id) ON DELETE CASCADE ," + "hotel_id INTEGER  ,"
					+ "FOREIGN KEY (hotel_id) REFERENCES Hotels(id) ON DELETE CASCADE ,"
					+ " created_date Date not NULL, " + " updated_date Date , " + " is_Active  Boolean  not NULL, "
					+ " PRIMARY KEY ( id ))";

			stmt.executeUpdate(sql);

			System.out.println(true + "===>Created Room Table table in given database...");

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(" Room  Table Already Build");
			System.out.println("***********************************");
		}
		return false;
	}
	
	public int InsertintoTableRooms() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			System.out.println("==============================");

			//////////////////////////////////////////////////////////
			 // System.in is a standard input stream
			int count = 20; // reads string

		

			

			int is_Active = 1;
			////////////////////////////////////////////
			Random random = new Random();
			int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
			int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
			long randomDay = minDay + random.nextInt(maxDay - minDay);
			LocalDate created_date = LocalDate.ofEpochDay(randomDay);
			LocalDate updated_date = LocalDate.ofEpochDay(randomDay);
			////////////////////////////////////////////////////

			///////////////////////////////////////////
			for (int id1 = 1; id1 <= count; id1++) {
				// String id2=id1+" "+int_random;
				// long id = Integer.parseInt(id2);
				String employee_type_name[]={"MANAGER", "ATTENDANT", "VALET", "BUTLER","DIRECTOR"};
				// Inserting data using SQL query
				System.out.println(id1);

				
				// Inserting data using SQL query

				String sql = "INSERT INTO employee_type VALUES(" + id1  + ",'" + (employee_type_name[id1-1] ) + "','"
						 + created_date + "','" + updated_date + "','" + is_Active
						+ "')";
				Statement st = con.createStatement();
				//
				// Executing query
				int m = st.executeUpdate(sql);
				if (m >= 1)
					System.out.println("inserted successfully : " + sql);
				else
					System.out.println("insertion failed");

				// Closing the connections

			}

			con.close();
		}
		return 0;
		}


}
