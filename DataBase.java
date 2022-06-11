package AtmMachine;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
public class DataBase {
    static String name;
    static String coose = "Choose what you want: ";
    static int Pin;
    static String Username;
    int choose;
    Scanner input = new Scanner(System.in);

    static Account account = new Account(null,0,0);

    public void signUp(){
        boolean end = true;
        name = "\nWait to save your account...";
        while(end) {
            try {
                System.out.print("Set ur Username: ");
                account.setUsername(input.next());
                System.out.print("Set ur Pin: ");
                account.setPassword(input.nextInt());
            } catch (NumberFormatException ex) {
                System.out.println("\nsorry for \"PIN\" you should use number");
                mainPage();
            }
            try {
                for (int i = 0; i < name.length(); i++) {
                    Thread.sleep(150);
                    System.out.print(name.charAt(i));
                    end = false;
                }
            } catch (InterruptedException ex) {
                System.exit(0);
            } finally {
                System.out.println("\nDone");
            }
        }
    }
    public void signIn() {
        boolean end = true;
        if (DataBase.Username == null && DataBase.Pin == 0) {
            System.out.println("\nsorry sir you don't have an account");
        }else
            while (end) {
                try {
                    System.out.print("put your Username: ");
                    String Username = input.next();
                    System.out.print("put your PIN: ");
                    int Pin = input.nextInt();
                    checkAccount(Username, Pin);
                    end = false;
                } catch (Exception e) {
                    checkAccount(null,0);
                }
            }

    }
    public void checkAccount(String Username, int Pin){
        name = "\nWait for checking...";
        try {
            for (int i = 0; i < name.length(); i++){
                Thread.sleep(200);
                System.out.print(name.charAt(i));
            }
        }catch (InterruptedException ex){
            System.exit(0);
        }finally{
            System.out.println("\nDone");
        }
        if (Objects.equals(Username, DataBase.Username) && Objects.equals(Pin, DataBase.Pin)){
            bankMoney();
        }else {
            System.out.println("\nYour Username or PIN is wrong");
        }
    }
    public void bankMoney(){
        boolean end = true;
        while (end) {
            try {
            System.out.println("""
                    \n1.Check Your account
                    2.Log out account
                    """);
                System.out.print(coose);
            choose = input.nextInt();
                switch (choose) {
                    case 1 -> accountPage();
                    case 2 -> end = false;

                    default -> System.out.println("just number 1 and 2 brooh");
                }
            } catch (InputMismatchException e){
                System.out.println("Try again");
                input.next();
            }
        }
    }

    private void accountPage() {
        boolean end = true;
        while (end){
            try {
                System.out.println("""
                        \n1.Check ur money
                        2.Withdraw money
                        3.Saving money
                        4.Change PIN
                        5.Exit
                        """);
                System.out.print(coose);
                choose = input.nextInt();
                switch (choose){
                    case 1 -> System.out.println("\nYour balance is: "+account.getbalance());
                    case 2 -> {
                        System.out.print("\nEnter amount of money: ");
                        account.tranferbalance(input.nextInt());
                    }
                    case 3 -> {
                        System.out.print("\nEnter amount of money: ");
                        account.setbalance(input.nextInt());
                    }
                    case 4 -> {
                        System.out.print("\nSet your new pin: ");
                        account.setPin(input.nextInt());
                    }
                    case 5 -> end = false;
                }
            }catch (InputMismatchException e){
                System.out.println();
            }
        }
    }

    public void mainPage() {
        boolean end = true;
        while (end) {
            try {
                System.out.println("""
                        \n1.Create ur account:
                        2.Login  ur account:
                        3.Close:
                        """);
                System.out.print(coose);
                choose = input.nextInt();
                switch (choose) {
                    case 1:
                        signUp();
                        break;
                    case 2:
                        signIn();
//                        end = false;
                        break;
                    case 3:
                        end = false;
                        break;
                    case 4:
                        account.setPin(input.nextInt());
                    case 5:
                        System.out.println(account.getPin());
                    default:
                        System.out.println("\nape luu");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nsWrong input");
                input.next();
            }
        }
        System.out.println("\nThanks for using Atm ");
        input.close();
        System.exit(0);
    }
}
