package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class DividedBy7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection con=null;
        CallableStatement cs=null;

        System.out.println("Enter a Num :");
        int num=sc.nextInt();
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
            cs= con.prepareCall("{?=call DivideBy7OrNot(?)}");
            cs.setInt(2,num);
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.execute();
            System.out.println("Number is "+cs.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
