import java.text.BreakIterator;
import java.util.Scanner;

public class BankingApp {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        Double balance = 8469.49;

        System.out.println("Enter the Name of the Customer: ");
        String name = scan.nextLine();

        System.out.println("Enter the 5 Digit Account Number: ");
        int accNum = scan.nextInt();

        if(accNum<=99999 && accNum>9999)
        {
            System.out.println("Valid Account Number. Name: "+name);
        }
        else {
            System.out.println("Invalid Account Number.");
            return;
        }

        System.out.println("Enter the IFSC code: ");
        String ifscCode = scan.next();

        System.out.println("Enter the PIN: ");
        int pin = scan.nextInt();

        if(pin==8585)
        {
            System.out.println("Corrent PIN you are now loggined!");
        }
        else {
            System.out.println("Wrong Pin..");
            return;
        }

        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your Current Balance: ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ₹");
                    double deposit = scan.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.println("Deposit successful!");
                        System.out.println("Updated Balance: ₹" + balance);
                    } else {
                        System.out.println("Invalid deposit amount!");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdraw = scan.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("Withdrawal successful!");
                        System.out.println("Updated Balance: ₹" + balance);
                    } else {
                        System.out.println("Invalid withdrawal or insufficient balance!");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the Banking App.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }
}
