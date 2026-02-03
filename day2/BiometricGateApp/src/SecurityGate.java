public class SecurityGate {

    public static void main(String[] args)
    {
        String passengerName = "Amelia Barner";
        int PassengerAge = 25;
        double passengerbaggageweight = 18.5;
        boolean passengerhasboardingpass = true;
        char gender = 'F';

        System.out.println("Processing Passenger: "+ passengerName);
        System.out.println("Checking baggage weight: "+ passengerbaggageweight);

        System.out.println("passenger: "+ passengerName +"is allowed to board the plane: "+ passengerhasboardingpass);

    }
}
