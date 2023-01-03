
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee_Type {
	static final String DB_URL = "jdbc:mysql://localhost:3306/HotelDBMS";

	  static final String USER = "root";
	  static final String PASS = "root";
        
	public boolean CreateTableToDB () {
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        Statement stmt = conn.createStatement();
	     ) {      
	         String sql = "CREATE TABLE employee_type " +
	                  "(id INTEGER not NULL, " +
	                  " employee_type_name    VARCHAR(100) not NULL, " +    
	                  " created_date Date , " +
	                  " updated_date Date not NULL, " +
	                  " is_Active  Boolean  not NULL, " +
	                  " PRIMARY KEY ( id ))";

	        stmt.executeUpdate(sql);
	       
	        System.out.println(true+"===>Created Employe Type Table table in given database...");  
	       
	     } catch (SQLException e) {
	       System.out.println("Table Employe Type Table Already Build");
	       System.out.println("***********************************");
	     }
	return false;
	  }
}
