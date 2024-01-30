package PrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement pStmt;

        String str="delete from guitarclass where Id=?";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
            pStmt=con.prepareStatement(str);
            pStmt.setInt(1,102);
            int count=pStmt.executeUpdate();
            if(count>0)
            {
                System.out.println("Data Deleted");
            }
            else {
                System.out.println("Data Not Deleted");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
