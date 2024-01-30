package DAODTODesignPattern2;

import java.sql.*;
import java.util.ArrayList;

public class DAOClass {

    static Connection con;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //--------------------------------------------------------------------------------------------------------------------
    private static final String insertQuery="insert into guitarclass values(?,?,?,?)";
    public int insetData(DTOClass dto)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(insertQuery);
            pStmt.setInt(1,dto.getId());
            pStmt.setString(2,dto.getName());
            pStmt.setString(3,dto.getDiv());
            pStmt.setDouble(4,dto.getFees());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//------------------------------------------------------------------------------------------------------------------
    private static final String updateQuery="update guitarclass set Fees=? where Id=?";
    public int updateData(DTOClass d1)
    {
        PreparedStatement pStmt;
        try {
            pStmt= con.prepareStatement(updateQuery);
            pStmt.setDouble(1,d1.getFees());
            pStmt.setInt(2,d1.getId());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    private static final String deleteQuery="delete from guitarclass where Id=?";
    public int deleteData(DTOClass d1)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(deleteQuery);
            pStmt.setInt(1,d1.getId());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    private static final String displayData="select * from guitarclass";
    public ArrayList<DTOClass> displayData()
    {
        PreparedStatement pStmt;
        ResultSet rs;
        ArrayList<DTOClass> data=new ArrayList<>();
        try {

            pStmt=con.prepareStatement(displayData);
            rs=pStmt.executeQuery();
            DTOClass d1=null;
            while (rs.next())
            {
                d1=new DTOClass();
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String div=rs.getString(3);
                double fees=rs.getDouble(4);
                d1.setId(id);
                d1.setName(name);
                d1.setDiv(div);
                d1.setFees(fees);
                data.add(d1);
            }
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    //-----------------------------------------------------------------------------------------------------------------
}
