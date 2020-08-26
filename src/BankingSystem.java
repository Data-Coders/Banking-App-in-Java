import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class BankingSystem {
    public static void main(String[] args){
        view();
        Scanner input = new Scanner(System.in);
        int inputNumber = 0;
        try {
            inputNumber = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please Enter the Correct Option Please");
            main(null);
        }
        switch (inputNumber) {
            case 1 -> openBankAccount();
            case 2 -> System.out.println("Deposit Amount");
            case 3 -> System.out.println("Withdraw Amount");
            case 4 -> System.out.println("Display All the Customers");
            case 5 -> System.out.println("Exit");
        }
    }

    public static void view(){
        System.out.println("|______________________________________________________|");
        System.out.println("|-----------------Welcome The Times Bank---------------|");
        System.out.println("|======================================================|");
        System.out.println("<<= 1. Open Bank Account                             =>>");
        System.out.println("<<= 2. Deposit Amount                                =>>");
        System.out.println("<<= 3. WithDraw Amount                               =>>");
        System.out.println("<<= 4. Display all The Customers                     =>>");
        System.out.println("<<= 5. Exit                                          =>>");
        System.out.print("\nEnter Your Choice (1 to 5) : ");
    }

    public static void headerr(){
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Name                          Account Number    Amount");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void openBankAccount() {
        Scanner input = new Scanner(System.in);
        int numberOfCustomers =0 ;
        int accountNumber = 0 ;
        int amount ;
        int pin ;
        System.out.print("Enter The Number of Customers : ");
        try {
            numberOfCustomers = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Enter the Correct Integer as Integers are only Readable in our Servers.");
            main(null);
        }
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                headerr();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int i = 0; i < numberOfCustomers; i++){
            try{
                if (i > 0){
                    System.out.println("\n\nEnter the Details for "+ i+1 + "Customer");
                }
                System.out.print("Enter Your First Name : ");
                String firstName = input.next();
                System.out.print("Enter You Last Name : ");
                String LastName = input.next();
                System.out.print("Enter Amount to be Deposited : ");
                amount = input.nextInt();
                System.out.print("Enter Your Pin Number : ");
                pin = input.nextInt();
//                System.out.println(firstName + " " + LastName +  " " + amount + " " + pin);
                FileWriter myFileWriter = new FileWriter("filename.txt");
                String data = firstName + " " + LastName + " " + amount + " " + pin;
                myFileWriter.write(data);
                myFileWriter.close();
            } catch(InputMismatchException | IOException e){
                System.out.print("Please Enter Correct Value");
            }
        }
        main(null);
    }
}
