package CollableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection con=null;
        CallableStatement cs=null;

        //System.out.println("Enter a Id :");
        int id=sc.nextInt();
        String name=sc.next();
        String div=sc.next();
        //System.out.println("Enter a Fees :");
        double fees=sc.nextDouble();
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
            cs=con.prepareCall("{call InsertData(?,?,?,?)}");
            cs.setInt(1,id);
            cs.setString(2,name);
            cs.setString(3,div);
            cs.setDouble(4,fees);
            cs.execute();
            System.out.println("Data Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
