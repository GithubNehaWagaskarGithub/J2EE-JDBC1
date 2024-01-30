package PrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            System.out.println("Driver Is Loded");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection con;
        PreparedStatement pStmt;

        String insertQuery="insert into guitarclass values(?,?,?,?)";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Operation","root","Neha@123");
            pStmt=con.prepareStatement(insertQuery);
            pStmt.setInt(1,102);
            pStmt.setString(2,"Piu");
            pStmt.setString(3,"B");
            pStmt.setDouble(4,23999.99);
            int count=pStmt.executeUpdate();
            if(count>0)
            {
                System.out.println("Data Added");
            }
            else {
                System.out.println("Data Not Added");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
