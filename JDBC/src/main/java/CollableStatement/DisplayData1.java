package CollableStatement;

import java.sql.*;

public class DisplayData1 {
    public static void main(String[] args) {
        Connection con=null;
        CallableStatement cs=null;
        ResultSet rs=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
            cs=con.prepareCall("{call DisplayData()}");
            //cs.execute();
            while (rs.next())
            {
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDouble(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
