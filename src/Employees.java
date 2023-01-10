
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.mysql.cj.jdbc.Driver;

public class Employees {

	static final String DB_URL = "jdbc:mysql://localhost:3306/HotelDBMS";
	static final String USER = "root";
	static final String PASS = "root";

	public boolean CreateTableToDB() {
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {
			String sql = "CREATE TABLE employee " + "(id INTEGER not NULL, "
					+ " employee_type_name    VARCHAR(100) not NULL, " + "employee_type_id  INTEGER  ,"
					+ "FOREIGN KEY (employee_type_id) REFERENCES Employee_Type(id) ON DELETE CASCADE ,"
					+ "room_id  INTEGER  ," + "FOREIGN KEY (room_id ) REFERENCES Rooms(id) ON DELETE CASCADE ,"
					+ " created_date Date , " + " updated_date Date not NULL, " + " is_Active  Boolean  not NULL, "
					+ " PRIMARY KEY ( id ))";

			stmt.executeUpdate(sql);

			System.out.println(true + "===>Created Employe Type Table table in given database...");

		} catch (SQLException e) {
			System.out.println("Table Employe Type Table Already Build");
			System.out.println("***********************************");
		}
		return false;
	}

	public int InsertintoTableEmploye() {
		String sql = "INSERT INTO employee (id,employee_type_name,employee_type_id,room_id,created_date,updated_date,is_Active) \r\n"
				+ "VALUES (201,'VALET',2,101,'2022-01-01', '2022-01-01', 1),\r\n"
				+ "       (301,'VALET',2,201,'2022-02-02', '2022-02-02', 1),\r\n"
				+ "      (401,'VALET', 1,301,'2022-03-03', '2022-03-03', 1),\r\n"
				+ "       (501,'VALET', 3,401,'2022-04-04', '2022-04-04', 1),\r\n"
				+ "      (601,'VALET', 3,501,'2022-05-05', '2022-05-05', 1),\r\n"
				+ "       (701,'BUTLER', 4,601,'2022-02-06', '2022-02-06', 1),\r\n"
				+ "      (801,'BUTLER',4,701,'2022-03-07', '2022-03-07', 1),\r\n"
				+ "      (901,'BUTLER', 4,801,'2022-04-08', '2022-04-08', 1)\r\n";
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

		return 0;
}
}