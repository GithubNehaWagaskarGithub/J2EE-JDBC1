package BankManagementSystem;

import java.util.Scanner;

public class MainApp
{
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        operation();
    }
//----------------------------------------------------
    private static void operation()
    {
        boolean status=true;
        System.out.println("Enter a Username :");
        String userName=sc.next();
        System.out.println("Enter a Password :");
        String pass=sc.next();

        boolean result=BankOperation.LoginValidation(userName,pass);
        if(result==true)
        {
            System.out.println("Welcome "+BankOperation.UserName);
            System.out.println("You are Successfully Login !!");

            while (status)
            {
                System.out.println("1. Deposit Amount :");
                System.out.println("2. Withdraw amount :");
                System.out.println("3. Check Balance :");
                System.out.println("4. Account Statement :");
                System.out.println("5. Logout :");
                System.out.println("6. Exit :");
                System.out.println("Enter a Choice !!");
                int ch=sc.nextInt();
                switch (ch)
                {
                    case 1:
                        System.out.println("Enter a amount which you want to Deposit :");
                        double amt=sc.nextDouble();
                        BankOperation.depositAmount(amt);
                        break;
                    case 2:
                        System.out.println("Enter a Amount which you want to Withdraw :");
                        double amt1=sc.nextDouble();
                        BankOperation.withdrawAmount(amt1);
                        break;
                    case 3:
                        System.out.println("Account Balance is :" + BankOperation.checkBalance());
                        break;
                    case 4:
                        BankOperation.accountStatement();
                        break;
                    case 5:
                        System.out.println("Logout Successfully !!");
                        System.out.println("Thanks for Transaction !!");
                        BankOperation.UserName=null;
                        BankOperation.accNumber=0;
                        operation();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    case 7:
                        System.out.println("Invalid Choice !!");
                        break;
                }
            }
        }
    }
}
