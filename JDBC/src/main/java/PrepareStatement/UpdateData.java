package PrepareStatement;

import java.sql.*;

public class UpdateData {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pStmt=null;

        String st1="update guitarclass set Fees=? where Id=?";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
            pStmt=con.prepareStatement(st1);
            pStmt.setDouble(1,45999.99);
            pStmt.setInt(2,102);
            int count=pStmt.executeUpdate();
            if(count>0)
            {
                System.out.println("Data Updated");
            }
            else {
                System.out.println("Data Not Added");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
