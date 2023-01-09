import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class HotelsManagment {
	static final String DB_URL = "jdbc:mysql://localhost:3306/HotelDBMS";
	static final String USER = "root";
	static final String PASS = "root";

	public static void GuestEndWithE() {

		String sql = "SELECT guest_name FROM guests WHERE guest_name LIKE '__e%'";
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement st = con.createStatement();
			// Executing query
			ResultSet n = st.executeQuery(sql);
			if (n.next())
				System.out.println("THE Name:" + n.getString(1) + " end with E");
			else
				System.out.println("NO Name End with E");
			// Closing the connections
			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public void guestsPayingMoreThan1001() {


		int user = 8;

		String sql = "SELECT * FROM Rooms INNER JOIN Guests ON Rooms.id = Guests.room_id WHERE Guests.guest_payment_amount > 100";
		
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 0;
			while (resultSet.next() && count < user) {
				String room_type_id=resultSet.getString(2);
				String   hotel_id=resultSet.getString(3);
				String   created_date=resultSet.getString(4);
				String   updated_date= resultSet.getString(5);
				String   Guest_Name= resultSet.getString(8);
				int   guest_accompanying_members= resultSet.getInt(10);
				int   guest_payment_amount= resultSet.getInt(10);
			
				System.out.println( room_type_id+" "+hotel_id+" "+created_date+" "+updated_date+" "+Guest_Name+" "+guest_accompanying_members+" "+guest_payment_amount);
				
				count++;
			}

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		
	}

	public void guestsStartWithDeluxe() {


		int user = 8;

		String sql = "SELECT  COUNT(*) FROM Guests INNER JOIN rooms ON Rooms.id = Guests.room_id WHERE Guests.guest_name like 'DELUXE';";
		
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			while (resultSet.next() ) {
				String room_type_id=resultSet.getString(1);
				
			
				System.out.println( "Count of guests who are staing in 'DELUXE' rooms "+room_type_id);
				
				
			}

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		
	}
	
	public void guestsNotActiveWithDeluxe() {


		int user = 8;

		String sql = "SELECT  *  FROM Rooms INNER JOIN room_type ON Rooms.room_type_id = room_type.id WHERE Rooms.room_type_id=2 and Rooms.is_Active=1;";
		
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			int count = 0;
			int user1=3;
			while (resultSet.next()&& (count< user1) ) {
				String id=resultSet.getString(1);
				String   room_type_id=resultSet.getString(2);
				String   hotel_id=resultSet.getString(3);
				String   created_date= resultSet.getString(4);
				String   updated_date= resultSet.getString(5);
				int   is_Active= resultSet.getInt(6);
				int   id1= resultSet.getInt(7);
				String   room_type_name= resultSet.getString(8);
			
				System.out.println( id+" "+room_type_id+" "+hotel_id+" "+created_date+" "+updated_date+" "+is_Active+" "+id1+""+room_type_name);
				
				count++;
			
			
				
				
			}
			

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		
	}
}
