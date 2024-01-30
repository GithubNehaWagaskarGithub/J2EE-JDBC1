package Statement;

import java.sql.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UpdateData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;

//        System.out.println("Enter a Id :");
//        int id=sc.nextInt();
//        System.out.println("Enter a Name");
//        String name=sc.next();
        String Query="select * from guitarclass";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
            stmt=con.createStatement();
            rs=stmt.executeQuery(Query);
            while (rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
