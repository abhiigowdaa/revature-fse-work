import java.util.Scanner;

public class InsuranceCalculator
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the driver age: ");
        int driverAge= scan.nextInt();

        System.out.println("Enter the car type: ");
        String carType = scan.nextLine();

        System.out.println("Enter the base premium: ");
        double basePremium = scan.nextDouble();

        System.out.println("Enter the premium: ");
        double finalPremium = scan.nextDouble();

        if(driverAge<25)
        {
            System.out.println("Risk Category: Young Driver (High Risk)");
            finalPremium = basePremium + 100.00;
        }
        else if (driverAge >= 25 && driverAge <= 60)
        {
            System.out.println("Risk Category: Standard(Low Risk)");
            finalPremium = basePremium;
        }
        else {
            System.out.println("Risk Category: Senior Driver(Moderate Risk)");
            finalPremium=basePremium+50.00;

            switch (carType)
            {
                case "LUXARY":
                    System.out.println("Adding luxary vehicle surcharge");
                    finalPremium+=150.00;
                    break;

                case "SEDAN":
                    System.out.println("Adding Standard sedan rates");
                    finalPremium +=10.00;
                    break;

                case "SUV":
                    System.out.println("Adding suv safety fee");
                    finalPremium+=50.00;
                    break;

                default:
                    System.out.println("Unknown car type, Applying Genitic Fee");
                    finalPremium+=25.00;
                    break;
            }

            System.out.println("-----------------------------");
            System.out.println("Final Premium: "+finalPremium);
            System.out.println("-----------------------------");


        }
    }
}
