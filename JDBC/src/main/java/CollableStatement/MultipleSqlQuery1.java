package CollableStatement;

import java.sql.*;

public class MultipleSqlQuery1 {
    public static void main(String[] args) {
        Connection con=null;
        CallableStatement cs=null;
        ResultSet rs=null;
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
            cs=con.prepareCall("{call multipleSqlQuery()}");
            cs.execute();
//            while(rs.next())
//            {
//                System.out.println(cs.getInt(1)+"\t"+cs.getString(2));
//            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
