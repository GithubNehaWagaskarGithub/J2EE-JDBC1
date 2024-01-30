package DAODTODesignPattern;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    private static Scanner sc = new Scanner(System.in);
    private static DAOClass d1 = new DAOClass();

    public static void main(String[] args) {
        operation();
    }

    //----------------------------------------------------------------------------
    private static void operation() {
        boolean status = true;
        while (status) {
            System.out.println("Guitar Class Interface");
            System.out.println("1. Add Student :");
            System.out.println("2. Update Student :");
            System.out.println("3. Delete Student :");
            System.out.println("4. Display student :");
            System.out.println("5. Exit :");
            System.out.println("Enter your choice :");
            int ch = sc.nextInt();
            switch (ch) {
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
                    System.out.println("Thanks For Visiting");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You Provide Invalid Choice!!");
                    break;
            }
        }
    }

    //----------------------------------------------------------------------------------------------
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
        DTOClass d=new DTOClass();
        d.setGuitarStudId(id);
        d.setGuitarStudName(name);
        d.setGuitarClassDiv(div);
        d.setGuitarClassFees(fees);
        int result=d1.addData(d);
        if(result>0)
        {
            System.out.println("Data Added");
        }
        else {
            System.out.println("Data Not Added");
        }
    }
    //---------------------------------------------------------------------------------------------
    private static void updateData()
    {
        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        System.out.println("Update a Name :");
        String name=sc.next();
        DTOClass d=new DTOClass();
        d.setGuitarStudId(id);
        d.setGuitarStudName(name);
        int result=d1.updateData(d);
        if(result>0)
        {
            System.out.println("Data Updated");
        }
        else {
            System.out.println("Data Not Updated");
        }
    }
    //------------------------------------------------------------------------------------------------------------
    private static void deleteData()
    {
        System.out.println("Enter a Id :");
        int id=sc.nextInt();
        DTOClass d=new DTOClass();
        d.setGuitarStudId(id);
        int result=d1.deleteData(d);
        if(result>0)
        {
            System.out.println("Data Deleted");
        }
        else {
            System.out.println("Data Not Deleted");
        }
    }
//-----------------------------------------------------------------------------------------------------------------
    private static void displayData()
    {
        ArrayList<DTOClass> result=d1.displayData();
        for(DTOClass data:result)
        {
            System.out.println(data.getGuitarStudId()+"\t"+data.getGuitarStudName()+"\t"+data.
                    getGuitarClassDiv()+"\t"+data.getGuitarClassFees());
        }
    }
}
