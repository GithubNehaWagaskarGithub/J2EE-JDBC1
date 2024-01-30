package DAODTODesignPattern2;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    private static DAOClass dao=new DAOClass();
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        operation();
    }

    private static void operation() {
        boolean status=true;
        while(status)
        {
            System.out.println("Guitar Class Interface");
            System.out.println("1:InsertData");
            System.out.println("2:UpdateData");
            System.out.println("3:DeleteData");
            System.out.println("4:DisplayData");
            System.out.println("5:Exit");
            int ch=sc.nextInt();
            switch (ch)
            {
                case 1:
                    insertData();
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
                    System.exit(0);
                    System.out.println("Thank you for Visiting !!");
                    break;
                default:
                    System.out.println("You Providing wrong Choice !!");
                break;
            }
        }
    }

    private static void displayData()
    {
        ArrayList<DTOClass> result=dao.displayData();
        for(DTOClass d:result)
        {
            System.out.println(d.getId()+"\t"+d.getName()+"\t"+d.getDiv()+"\t"+d.getFees());
        }
    }

    //--------------------------------------------------------------------------------------------------------------------
    private static void deleteData() {
        System.out.println("Enter a Id :");
        int id= sc.nextInt();
        DTOClass d1=new DTOClass();
        d1.setId(id);
        int result=dao.deleteData(d1);
        if(result>0)
        {
            System.out.println("Data Deleted");
        }
        else {
            System.out.println("Data Not Deleted");
        }
    }

    //--------------------------------------------------------------------------------------------------------------------
    private static void updateData() {
        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        System.out.println("Enter a Fees :");
        double fees=sc.nextDouble();
        DTOClass d1=new DTOClass();
        d1.setId(id);
        d1.setFees(fees);
        int result=dao.updateData(d1);
        if(result>0)
        {
            System.out.println("Data Updated");
        }
        else {
            System.out.println("Data Not Updated");
        }
    }

    //----------------------------------------------------------------------------------------------------------
    private static void insertData() {
        System.out.println("Enter a Id ");
        int id=sc.nextInt();
        System.out.println("Enter a Name");
        String name=sc.next();
        System.out.println("Enter a Div");
        String div=sc.next();
        System.out.println("Enter a Fees");
        double fees=sc.nextDouble();
        DTOClass dto=new DTOClass();
        dto.setId(id);
        dto.setName(name);
        dto.setDiv(div);
        dto.setFees(fees);
        int result=dao.insetData(dto);
        if(result>0)
        {
            System.out.println("Data Inserted");
        }
        else {
            System.out.println("Data Not Inserted");
        }
    }
    //-------------------------------------------------------------------------------------------------------------------
}
