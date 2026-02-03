import java.util.Scanner;

public class SecurityGate {

    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);

        System.out.println("Enter the passenger name:");
        String passengerName = scan.next();

        System.out.println("Enter the passenger Age: ");
        int PassengerAge = scan.nextInt();

        System.out.println("Enter the passenger baggage weight: ");
        double passengerbaggageweight = scan.nextDouble();

        System.out.println("Enter if the passenger has the baggage or not: ");
        boolean passengerhasboardingpass = scan.nextBoolean();

        System.out.println("Enter the Gender F or M: ");
        char gender = scan.next().charAt(0);

        System.out.println("Processing Passenger: "+ passengerName);
        System.out.println("Checking baggage weight: "+ passengerbaggageweight);

        System.out.println("passenger: "+ passengerName +"is allowed to board the plane: "+ passengerhasboardingpass);

    }
}
