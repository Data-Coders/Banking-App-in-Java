import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.lang.*;

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
            case 4 -> displayAllBankAccounts();
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

    public static void header(){
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Name                          Amount    PIN Number");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String space(int number, int length){
        System.out.println(" Space ");
        String space = "";
        int numberOfSpace = number - length;
        for (int i = 0; i < numberOfSpace; i++){
            space = space.concat(" ");
        }
        return space;
    }

    public static void openBankAccount() {
        Scanner input = new Scanner(System.in);
        int numberOfCustomers =0 ;
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
                header();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int i = 0; i < numberOfCustomers; i++){
            try{
                if (i > 0){
                    int valueOfI = i + 1;
                    System.out.println("\n\nEnter the Details for "+ valueOfI + " Customer");
                }
                System.out.print("Enter Your First Name : ");
                String firstName = input.next();
                System.out.print("Enter You Last Name : ");
                String LastName = input.next();
                System.out.print("Enter Amount to be Deposited : ");
                String amount = input.next();
                System.out.print("Enter Your Pin Number : ");
                String pin = input.next();
//                System.out.println(firstName + " " + LastName +  " " + amount + " " + pin);
                File file = new File("filename.txt");
                FileWriter myFileWriter = new FileWriter(file, true);
                String name = firstName + " " + LastName;
                System.out.println(name.length());
                String space = space(30,name.length());
                String space2 = space(10,amount.length());
                String data = "\n" + name + space + amount + space2 + pin;
                myFileWriter.write(data);
                myFileWriter.close();
            } catch(InputMismatchException | IOException e){
                System.out.print("Please Enter Correct Value");
            }
        }
        try{
            System.out.println("All of Your Records Have Been Successfully Entered in the DataBase");
            Thread.sleep(4000);
            main(null);
        }catch (InterruptedException e){
            System.out.println("SomeThing Wrong Happened");
        }
    }

    public static void displayAllBankAccounts(){
        File data = new File("filename.txt");
        try{
            Scanner sc = new Scanner(data);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Please Create the File First.");
        }
        try{
        Thread.sleep(4000);
        }catch (InterruptedException e){
            System.out.println("SomeThing Wrong Happened");
        }
    }







}
