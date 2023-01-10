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
	
	public void hotelswhnamehavEH() {


	

		String sql = "SELECT COUNT(Rooms.room_type_id), Room_Type.room_type_name FROM Rooms INNER JOIN Room_Type ON Rooms.room_type_id = Room_Type.id GROUP BY room_type_name HAVING COUNT(Rooms.room_type_id) > 5 ORDER BY COUNT(Rooms.room_type_id) DESC ;";
		
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			while (resultSet.next() ) {
				 
				if(resultSet.next()==true) {
				int CountOfRooms=resultSet.getInt(1);
				String   room_type_name=resultSet.getString(2);
				System.out.println( CountOfRooms+" "+room_type_name);
			
				}
				else
				{
					System.out.println( "No Rooms Avaliable");
				}
			}
			

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
	
	public void GuestStaingInRooms() {


		

		String sql = "SELECT * FROM Guests INNER JOIN Rooms ON Guests.room_id = Rooms.id INNER JOIN Employee ON Rooms.id = Employee.room_id INNER JOIN Employee_Type  ON Employee.employee_type_id = Employee_Type.id WHERE Employee_Type.employee_type_name LIKE '%A%'";
		
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement st = conn.createStatement();
			ResultSet resultSet = st.executeQuery(sql);
			
			while (resultSet.next() ) {
				 
				
				int id=resultSet.getInt(1);
				String   guest_name=resultSet.getString(2);
				int   guest_phone=resultSet.getInt(3);
				int   guest_accompanying_members=resultSet.getInt(4);
				System.out.println( id+" "+guest_name+""+guest_phone+guest_accompanying_members);
			
				
				
			}
			

			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

}
