package DAODTODesignPattern1;

import DAODTODesignPattern1.DAOClass;
import DAODTODesignPattern1.DTOClass;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    private static Scanner sc=new Scanner(System.in);
    private static DAOClass dd=new DAOClass();
    public static void main(String[] args) {
        operation();
    }
//-----------------------------------------------------------------------------------------
    private static void operation()
    {
        boolean status=true;
        while (status)
        {
            System.out.println("Welcome Guitar Class Interface !!");
            System.out.println("1. Add Data :");
            System.out.println("2. Update Data :");
            System.out.println("3. Delete Data :");
            System.out.println("4. Display Data :");
            System.out.println("5. Exit :");
            System.out.println("Enter Your Choice :");
            int ch=sc.nextInt();
            switch (ch)
            {
                case 1:
                    addData();
                    break;
                case 2:
                    updateData();
                    break;
                case 3:
                    deleteData();
                    break;
                case 4:
                    displayData();
                    break;
                case 5:
                    System.out.println("Thanks for watching !!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You are Entering Invalid Choice !!");
                    break;
            }
        }
    }
    //-------------------------------------------------------------------------------------------------
    private static void addData()
    {
        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        System.out.println("Enter a Name :");
        String name=sc.next();
        System.out.println("Enter a Div :");
        String div=sc.next();
        System.out.println("Enter a Fees :");
        double fees=sc.nextDouble();
        DTOClass d1=new DTOClass();
        d1.setgId(id);
        d1.setgName(name);
        d1.setgDiv(div);
        d1.setgFees(fees);
        int result=dd.addData(d1);
        if(result>0)
        {
            System.out.println("Data Added");
        }
        else {
            System.out.println("Data Not Added");
        }
    }
    //--------------------------------------------------------------------------------
    private static void updateData()
    {
        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        System.out.println("Enter a Fees :");
        double fees=sc.nextDouble();
        DTOClass d1=new DTOClass();
        d1.setgId(id);
        d1.setgFees(fees);
        int result=dd.updateData(d1);
        if(result>0)
        {
            System.out.println("Data Updated");
        }
        else {
            System.out.println("Data Not Updated");
        }
    }
    //---------------------------------------------------------------------------------------------------------
    private static void deleteData()
    {
        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        DTOClass d1=new DTOClass();
        d1.setgId(id);
        int result=dd.deleteData(d1);
        if(result>0)
        {
            System.out.println("Data Deleted");
        }
        else {
            System.out.println("Data Not Deleted");
        }
    }
    //----------------------------------------------------------------------------------------------
    private static void displayData()
    {
        ArrayList<DTOClass> result=dd.displayData();
        for(DTOClass data:result)
        {
            System.out.println(data.getgId()+"\t"+data.getgName()+"\t"+data.getgDiv()+"\t"+data.getgFees());
        }
    }

}
