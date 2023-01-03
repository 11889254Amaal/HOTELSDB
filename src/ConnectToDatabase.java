
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabase {

public static void conToData1 () throws ClassNotFoundException, SQLException{


Class.forName("com.mysql.jdbc.Driver");
String url = "jdbc:mysql://localhost:3306/HotelDBMS";
String username = "root";
String password = "root";
Connection con = DriverManager.getConnection(url, username, password);
if (con != null) {
System.out.println("Database Connected successfully");

//Entering the data  
         
                 
                 
                   
} else {
System.out.println("Database Connection failed");
}
} 
}
