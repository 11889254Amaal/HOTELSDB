
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Guests {

static final String DB_URL = "jdbc:mysql://localhost:3306/HotelDBMS";
  static final String USER = "root";
  static final String PASS = "root";

public boolean CreateTableToDB () {
try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
     ) {      
         String sql = "CREATE TABLE Guests " +
                  "(id int NOT NULL AUTO_INCREMENT, " +
                  " guest_name   VARCHAR(100) not NULL, " +
                  " guest_phone  VARCHAR(100) not NULL, " +
                  " guest_accompanying_members   INTEGER not NULL, " +
                  " guest_payment_amount INTEGER not NULL, " +
                  "room_id INTEGER  ,"+
                           "FOREIGN KEY (room_id) REFERENCES Rooms(id) ON DELETE CASCADE ,"+
                           "hotel_id INTEGER  ,"+
                           "FOREIGN KEY (hotel_id) REFERENCES Hotels(id) ON DELETE CASCADE ,"+
                  " created_date Date not NULL, " +
                  " updated_date Date , " +
                  " is_Active  Boolean  not NULL, " +
                  " PRIMARY KEY ( id ))";
         String sql1="ALTER TABLE Guests AUTO_INCREMENT=100";
        stmt.executeUpdate(sql);
        stmt.executeUpdate(sql1);
        System.out.println(true+"===>Created Guests Table table in given database...");  
       
     } catch (SQLException e) {
     e.printStackTrace();
       System.out.println(" Guests  Table Already Build");
       System.out.println("***********************************");
     }
return false;
  }

public static void InsertIntoTable() {
	
	
	String sql = "INSERT INTO guests (guest_name,guest_phone ,guest_accompanying_members,guest_payment_amount,room_id,hotel_id,created_date,updated_date,is_Active) \r\n"
			+ "VALUES ('MUNA', '9677456',5,200,101,79,'2022-01-01', '2022-01-01', 1),\r\n"
			+ "       ('NORA', '9677452',2,1000,101,79,'2022-02-02', '2022-02-02', 1),\r\n"
			+ "      ('EMEE', '9675432',3,400,101,79,'2022-03-03', '2022-03-03', 1),\r\n"
			+ "       ('SALE', '9577452',4,1200,101,79,'2022-04-04', '2022-04-04', 1),\r\n"
			+ "      ('LAMA', '9377432',9,700,101,79,'2022-05-05', '2022-05-05', 1),\r\n"
			+ "       ('SUHA', '9277452',19,2000,101,79,'2022-02-06', '2022-02-06', 1),\r\n"
			+ "      ('MARIYA', '9677432',23,800,101,79,'2022-03-07', '2022-03-07', 1),\r\n"
			+ "      ('AHMED', '9977432',4,700,101,79,'2022-04-08', '2022-04-08', 1)\r\n";
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
	}}





}
