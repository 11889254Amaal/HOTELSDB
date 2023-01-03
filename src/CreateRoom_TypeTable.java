
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateRoom_TypeTable {

		static final String DB_URL = "jdbc:mysql://localhost:3306/HotelDBMS";
		  static final String USER = "root";
		  static final String PASS = "root";

		public boolean CreateTableToDB () {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		        Statement stmt = conn.createStatement();
		     ) {      
		         String sql = "CREATE TABLE room_type " +
		                  "(id INTEGER not NULL, " +
		                  " room_type_name   VARCHAR(100) not NULL, " +    
		                  " created_date Date , " +
		                  " updated_date Date , " +
		                  " is_Active  Boolean  not NULL, " +
		                  " PRIMARY KEY ( id ))";

		        stmt.executeUpdate(sql);
		       
		        System.out.println(true+"===>Created Room Type Table table in given database...");  
		       
		     } catch (SQLException e) {
		       System.out.println("Table Room Type Table Already Build");
		       System.out.println("***********************************");
		     }
		return false;
		  }
}
