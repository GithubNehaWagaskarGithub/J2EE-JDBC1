package DAODTODesignPattern1;

import java.sql.*;
import java.util.ArrayList;

public class DAOClass {
    static Connection con;
    static{
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------
    private static final String addDataQuery="insert into guitarclass values (?,?,?,?)";
    public int addData(DTOClass d1)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(addDataQuery);
            pStmt.setInt(1, d1.getgId());
            pStmt.setString(2,d1.getgName());
            pStmt.setString(3,d1.getgDiv());
            pStmt.setDouble(4,d1.getgFees());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    private static final String updateDataQuery="update guitarclass set Fees=? where Id=?";
    public int updateData(DTOClass d1)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(updateDataQuery);
            pStmt.setDouble(1,d1.getgFees());
            pStmt.setInt(2,d1.getgId());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//-----------------------------------------------------------------------------------------------------
    private static final String deleteDataQuery="delete from guitarclass where Id=?";
    public int deleteData(DTOClass d1){
        PreparedStatement pStmt;
        try {
            pStmt= con.prepareStatement(deleteDataQuery);
            pStmt.setInt(1,d1.getgId());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
//------------------------------------------------------------------------------------------------------
    private static final String displayDataQuery="select * from guitarclass";
    public ArrayList<DTOClass> displayData()
    {
        PreparedStatement pStmt;
        ResultSet rs;
        ArrayList<DTOClass> data = new ArrayList<>();
        try {
            pStmt = con.prepareStatement(displayDataQuery);
            rs = pStmt.executeQuery();

            DTOClass d1 = null;
            while (rs.next()) {
                d1 = new DTOClass();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String div = rs.getString(3);
                double fees = rs.getDouble(4);
                d1.setgId(id);
                d1.setgName(name);
                d1.setgDiv(div);
                d1.setgFees(fees);
                data.add(d1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
}
