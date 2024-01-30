package DAODTODesignPattern;

import java.sql.*;
import java.util.ArrayList;

public class DAOClass {
    static Connection con;
    static
    {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------
    private static final String addData="insert into guitarclass values(?,?,?,?)";
    public int addData(DTOClass d)
    {
        PreparedStatement pStmt;
        try {
            pStmt= con.prepareStatement(addData);
            pStmt.setInt(1,d.getGuitarStudId());
            pStmt.setString(2,d.getGuitarStudName());
            pStmt.setString(3,d.getGuitarClassDiv());
            pStmt.setDouble(4,d.getGuitarClassFees());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//------------------------------------------------------------------------------------------------------------------
    private static final String updateData="update guitarclass set Name=? where Id=?";
    public int updateData(DTOClass d)
    {
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(updateData);
            pStmt.setString(1,d.getGuitarStudName());
            pStmt.setInt(2,d.getGuitarStudId());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//-------------------------------------------------------------------------------------------------------------------
    private static final String deleteData="delete from guitarclass where Id=?";
    public int deleteData(DTOClass d)
    {
        PreparedStatement pStmt;
        try {
            pStmt= con.prepareStatement(deleteData);
            pStmt.setInt(1,d.getGuitarStudId());
            int count=pStmt.executeUpdate();
            return count;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//-----------------------------------------------------------------------------------------------------------------
    private static final String displayData="select * from guitarclass";
    public ArrayList<DTOClass> displayData()
    {
        PreparedStatement pStmt;
        ResultSet rs;
        ArrayList<DTOClass> data=new ArrayList<>();
        try {
            pStmt= con.prepareStatement(displayData);
            rs=pStmt.executeQuery();
            DTOClass d1=null;
            while (rs.next())
            {
                d1=new DTOClass();
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String div=rs.getString(3);
                double fees=rs.getDouble(4);
                d1.setGuitarStudId(id);
                d1.setGuitarStudName(name);
                d1.setGuitarClassDiv(div);
                d1.setGuitarClassFees(fees);
                data.add(d1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
//-------------------------------------------------------------------------------------------------------------------

}
