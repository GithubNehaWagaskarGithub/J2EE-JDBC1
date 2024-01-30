package Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
    public static void main(String[] args) {
        Connection con=null;
        Statement stmt=null;

        String query="insert into guitarclass values(106,'Lokesh','H',2400)";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
            stmt=con.createStatement();
            int count=stmt.executeUpdate(query);
            if(count>0)
            {
                System.out.println("Data Added");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
