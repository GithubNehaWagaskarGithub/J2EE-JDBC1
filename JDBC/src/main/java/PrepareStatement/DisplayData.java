package PrepareStatement;

import java.sql.*;

public class DisplayData {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement pStmt;
        ResultSet rs;
        String str="select * from guitarclass";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
            pStmt=con.prepareStatement(str);
            rs=pStmt.executeQuery();
            while (rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
