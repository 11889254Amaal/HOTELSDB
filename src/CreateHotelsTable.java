
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.sql.DataSource;

import java.sql.Connection;

public class CreateHotelsTable {
	private final DataSource dataSource = null;
	static final String DB_URL = "jdbc:mysql://localhost:3306/HotelDBMS";

	static final String USER = "root";
	static final String PASS = "root";

	public boolean CreateTableToDB() {

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {
			String sql = "CREATE TABLE Hotels " + "(id INTEGER not NULL, " + " hotel_name  VARCHAR(100) not NULL, "
					+ " hotel_location  VARCHAR(100), " + " created_date Date not NULL, " + " updated_date Date , "
					+ " is_Active  Boolean  not NULL, " + " PRIMARY KEY ( id ))";

			stmt.executeUpdate(sql);

			System.out.println(true + "===>Created Hotels table in given database...");

		} catch (SQLException e) {
			System.out.println("Table Hotels Already Build");
		}
		return false;
	}

	public long insertIntoTable() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			System.out.println("==============================");

			//////////////////////////////////////////////////////////
			System.out.println("PlZ enter number of student");
			Scanner sc = new Scanner(System.in); // System.in is a standard input stream
			int count = sc.nextInt(); // reads string

			int int_random = ThreadLocalRandom.current().nextInt();
			///////////////////////////////////////////////////

			String hotel_name = "Muscat Hotel";

			String hotel_location = "Muscat";

			String is_Active = "true";
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

				// Inserting data using SQL query
				System.out.println(id1);

				Random rd = new Random();
				System.out.println(rd);
				Integer numberToAdd = rd.nextInt(100);
				System.out.println(numberToAdd);
				// Inserting data using SQL query

				String sql = "INSERT INTO Hotels VALUES(" + id1 + numberToAdd + ",'" + (hotel_name + id1) + "','"
						+ (hotel_location + id1) + "','" + created_date + "','" + updated_date + "','" + is_Active
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

	public long insertIntoTableHotels() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			System.out.println("==============================");

			//////////////////////////////////////////////////////////
			// System.in is a standard input stream
			int count = 1; // reads string

			int int_random = ThreadLocalRandom.current().nextInt();
			///////////////////////////////////////////////////

			String hotel_name = "Muscat Hotel";

			String hotel_location = "Muscat";

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
				// System.out.println(id);
				// Inserting data using SQL query

				// Inserting data using SQL query
				System.out.println(id1);

				Random rd = new Random();
				System.out.println(rd);
				Integer numberToAdd = rd.nextInt(100);
				System.out.println(numberToAdd);
				String sql = "INSERT INTO Hotels VALUES(" + id1 + numberToAdd + ",'" + (hotel_name + id1) + "','"
						+ (hotel_location + id1) + "','" + created_date + "','" + updated_date + "','" + is_Active
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

	public long ShowTop() throws ClassNotFoundException {
		String sqlDB = " SELECT * FROM Hotels LIMIT 10";

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		try {

			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet m = st.executeQuery(sqlDB);
			if (m.next()) {
				do {
					System.out.println("id : " + m.getInt(1));
					System.out.println("hotel_name :" + m.getString(2));
					System.out.println("hotel_location :" + m.getString(3));
					System.out.println("created_date :" + m.getDate(4));
					System.out.println("updated_date :" + m.getDate(5));
					if (m.getInt(6) == 1) {
						System.out.println("is_Active : true");
					} else {
						System.out.println("is_Active : fulse");
					}
					System.out.println("*********************************");
				} while (m.next());
			} else {
				System.out.println("No such user id is already registered");
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

		return 0;

	}

	public long insertIntoTableHotels1() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			System.out.println("==============================");

			//////////////////////////////////////////////////////////
			// System.in is a standard input stream
			int count = 1; // reads string

			int int_random = ThreadLocalRandom.current().nextInt();
			///////////////////////////////////////////////////

			String hotel_name = "Muscat Hotel";

			String hotel_location = "Muscat";

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
			for (int id = 0; id < count; id++) {
				// String id2=id1+" "+int_random;
				// long id = Integer.parseInt(id2);
				// System.out.println(id);
				// Inserting data using SQL query
				System.out.println(id);

				// Inserting data using SQL query
				String sql = "INSERT INTO Hotels VALUES(" + id + ",'" + (hotel_name + id) + "','"
						+ (hotel_location + id) + "','" + created_date + "','" + updated_date + "','" + is_Active
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
			// closed
			con.close();

		}
		return 0;

	}

	public long ChangeActive() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			String query = "update Hotels set is_Active=0 where Id<=10 ";
			ps = (PreparedStatement) conn.prepareStatement(query);

			ps.executeUpdate();
			System.out.println("Record is updated successfully......");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public long ShowHostelInformation() throws ClassNotFoundException {

		System.out.println("plz enter how many rows want to show");

		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		int id = sc.nextInt();
		String sqlDB = " SELECT * FROM Hotels WHERE id<= '" + id + "'";

		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		String username = "root";
		String password = "root";
		try {

			Connection conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet m = st.executeQuery(sqlDB);
			if (m.next()) {
				do {
					System.out.println("id : " + m.getInt(1));
					System.out.println("hotel_name :" + m.getString(2));
					System.out.println("hotel_location :" + m.getString(3));
					System.out.println("created_date :" + m.getDate(4));
					System.out.println("updated_date :" + m.getDate(5));
					if (m.getInt(6) == 1) {
						System.out.println("is_Active : true");
					} else {
						System.out.println("is_Active : fulse");
					}
					System.out.println("*********************************");
				} while (m.next());
			} else {
				System.out.println("No such user id is already registered");
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

		return 0;

	}

	public static void updateById() throws ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception e) {
				System.out.println(e);
			}
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connection is created successfully:");
			stmt = (Statement) conn.createStatement();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please Enter any id to Update hotel data :");
	         int userinput =scanner.nextInt();
	         System.out.println("Please Enter the new Hotel name:");
	         String hotelname=scanner.next();
	         System.out.println("Please Enter the new Hotel location:");
	         String hotellocatin=scanner.next();
	
	         Statement st = conn.createStatement();
	         String sql="UPDATE Hotels SET hotel_name='"+hotelname+"',hotel_location='"+hotellocatin+"' WHERE id='"+userinput+"'";
		     int result=st.executeUpdate(sql);
			System.out.println("Record has been updated in the table successfully..................");
		} catch (SQLException excep) {
			excep.printStackTrace();
		} catch (Exception excep) {
			excep.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Please check it in the MySQL Table. Record is now updated.......");
	}

}
