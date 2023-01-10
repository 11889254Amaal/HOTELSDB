
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;

import com.mysql.cj.jdbc.Driver;

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
	
	public int InsertintoTableRooms()  {
		
		String sql = "INSERT INTO Rooms (id,room_type_id ,hotel_id,created_date,updated_date,is_Active) \r\n"
				+ "VALUES (101, 1,84,'2022-02-02', '2022-02-02', 1),\r\n"
				+ "       (201, 2,107,'2022-02-02', '2022-02-02', 1),\r\n"
				+ "      (301, 2,157,'2022-02-02', '2022-02-02', 1),\r\n"
				+ "       (401, 3,204,'2022-02-02', '2022-02-02', 1),\r\n"
				+ "      (501, 3,226,'2022-02-02', '2022-02-02', 1),\r\n"
				+ "       (601, 2,230,'2022-02-02', '2022-02-02', 1),\r\n"
				+ "      (701, 3,242,'2022-02-02', '2022-02-02', 1),\r\n"
				+ "      (801, 1,385,'2022-02-02', '2022-02-02', 1)\r\n";
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement st = con.createStatement();
			// Executing query
			int n = st.executeUpdate(sql);
			if (n >1)
				System.out.println("Inserted successfully : " + sql);
			else
				System.out.println("Inserting failed");
			// Closing the connections
			con.close();
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
		return 0;}


}
