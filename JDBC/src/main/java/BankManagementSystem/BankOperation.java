package BankManagementSystem;

import java.sql.*;

public class BankOperation {
    static Connection con=null;
    static String UserName=null;
    static int accNumber=0;
    static double accBalance=0.0;
    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/operation","root","Neha@123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //-------------------------------------------------------------------------------------

    public static boolean LoginValidation(String userName, String pass)
    {
        String loginValidationQuery="select * from userlogin where Username=? and Password=?";
        PreparedStatement pStmt;
        ResultSet rs;
        try {
            pStmt=con.prepareStatement(loginValidationQuery);
            pStmt.setString(1,userName);
            pStmt.setString(2,pass);
            rs= pStmt.executeQuery();
            if(rs.next())
            {
                accNumber=rs.getInt(1);
                UserName=rs.getString(2);
                String Password=rs.getString(3);
                if(userName.equals(UserName) && pass.equals(Password))
                {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    public static void depositAmount(double amt)
    {
        String depositAmountQuery="insert into bankpassbook values (?,?,?,?,?,?)";

        accBalance=checkBalance();
        PreparedStatement pStmt;
        try {
            pStmt=con.prepareStatement(depositAmountQuery);
            pStmt.setInt(1,0);
            pStmt.setDouble(2,accBalance+amt);
            pStmt.setDouble(3,amt);
            pStmt.setDouble(4,0);
            pStmt.setInt(5,accNumber);
            pStmt.setString(6,null);
            int count=pStmt.executeUpdate();
            if(count>0)
            {
                System.out.println(amt+" Amount Deposit Successfully !!");
            }
            else {
                System.out.println("Amount Is Not Deposit");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public static void withdrawAmount(double amt1)
    {
        accBalance=checkBalance();
        if(checkBalance()>=amt1)
        {
            String withdrawAmountQuery="insert into bankpassbook values (?,?,?,?,?,?)";
            PreparedStatement pStmt;
            ResultSet rs;
            try {
                pStmt=con.prepareStatement(withdrawAmountQuery);
                pStmt.setInt(1,0);
                pStmt.setDouble(2,(accBalance-amt1));
                pStmt.setDouble(3,0);
                pStmt.setDouble(4,amt1);
                pStmt.setInt(5,accNumber);
                pStmt.setString(6,null);
                int count=pStmt.executeUpdate();
                if(count>0)
                {
                    System.out.println(amt1+" Amount Withdraw Successfully");
                }
                else
                {
                    System.out.println("Amount is Insufficient");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //---------------------------------------------------------------------------------------------------------------------
    public static double checkBalance()
    {
        String checkBalanceQuery="select TotalAmount from userlogin full join bankpassbook on ANo=AccNo where ANo=? order by TransId desc limit 1";
        PreparedStatement pStmt;
        ResultSet rs;
        try {
            pStmt=con.prepareStatement(checkBalanceQuery);
            pStmt.setInt(1,accNumber);
            rs=pStmt.executeQuery();
            if(rs.next())
            {
                return rs.getInt(1);
            }
            else {
                System.out.println("Something Went Wrong!!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
//------------------------------------------------------------------------------------------------------------------
    public static void accountStatement()
    {
        String accountStmtQuery="select * from bankpassbook where AccNo=?";
        PreparedStatement pStmt;
        ResultSet rs;
        try {
            pStmt=con.prepareStatement(accountStmtQuery);
            pStmt.setInt(1,accNumber);
            rs= pStmt.executeQuery();
            System.out.println("TranId\tTotalAmount\tDepositAmount\tWithdrawAmount\tAccNo\tRefAccNo");
            while(rs.next())
            {
                System.out.println(rs.getInt(1)+"\t\t"+rs.getDouble(2)+"\t\t"+rs.getDouble(3)+"\t\t\t\t"+rs.getDouble(4)+"\t\t\t"+rs.getInt(5)+"\t\t\t"+rs.getInt(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //------------------------------------------------------------------------------------------------------------------------
}
