
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Guests {

static final String DB_URL = "jdbc:mysql://localhost:3306/HotelDBMS";
  static final String USER = "root";
  static final String PASS = "root";

public boolean CreateTableToDB () {
try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement stmt = conn.createStatement();
     ) {      
         String sql = "CREATE TABLE Guests " +
                  "(id INTEGER not NULL, " +
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

        stmt.executeUpdate(sql);
       
        System.out.println(true+"===>Created Guests Table table in given database...");  
       
     } catch (SQLException e) {
     e.printStackTrace();
       System.out.println(" Guests  Table Already Build");
       System.out.println("***********************************");
     }
return false;
  }
}
