package CollableStatement;

import java.sql.*;
import java.util.Scanner;

public class PositiveNegative {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection con=null;
        CallableStatement cs=null;

        System.out.println("Enter a Number");
        int num=sc.nextInt();

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
            cs=con.prepareCall("{?=call NegativePositive(?)}");
            cs.registerOutParameter(1,Types.VARCHAR);
            cs.setInt(2,num);
            cs.execute();
            System.out.println("Number Is :"+cs.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
