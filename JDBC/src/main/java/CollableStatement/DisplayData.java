package CollableStatement;

import java.sql.*;

public class DisplayData {
    public static void main(String[] args) {
        Connection con=null;
        CallableStatement cs=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
            cs=con.prepareCall("{?=call DisplayData()}");
            cs.registerOutParameter(1,Types.VARCHAR);
            cs.execute();
            System.out.println("Fees is : "+cs.getString(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
