package CollableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection con=null;
        CallableStatement cs=null;

        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
            cs= con.prepareCall("{call DeleteData(?)}");
            cs.setInt(1,id);
            cs.execute();
            System.out.println("Data Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
