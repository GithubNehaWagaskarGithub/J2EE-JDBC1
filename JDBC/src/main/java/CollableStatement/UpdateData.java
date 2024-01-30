package CollableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UpdateData {
    public static void main(String[] args) {
        Connection con=null;
        CallableStatement cs=null;

        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
            cs= con.prepareCall("{call UpdateData()}");
            cs.execute();
            System.out.println("Data Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
