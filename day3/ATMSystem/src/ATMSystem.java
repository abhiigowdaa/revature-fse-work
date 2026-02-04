public class ATMSystem {

    public static boolean canWithdraw(double balance, double amount)
    {
        System.out.println("Checking: Is ₹" + amount+"available?");
        return balance>=amount;
    }

    public static void printRecipt(String name, double remainingBalance)
    {
        System.out.println("-------------------------------------");
        System.out.println("Customer: "+name);
        System.out.println("Remaining Balance: "+remainingBalance);
        System.out.println("-------------------------------------");

    }

    public static void main(String[] args)
    {
        double mybalance=5000.00;
        double withdrawalRequest = 3000.00;

        if(canWithdraw(mybalance,withdrawalRequest))
        {
            mybalance -= withdrawalRequest;
            printRecipt("Abhishek",mybalance);
        }
        else {
            System.err.println("Error: Insufficient Balance");
            System.out.println("Available Balance: "+mybalance);
        }
    }
}
