import java.util.ArrayList;
import java.util.List;

public class LoanEngine {

    public static void main(String[] args)
    {
        Integer creditScore = null;

        if(creditScore==null)
        {
            System.out.println("Status pending, Waiting for the Credit bureau responses....");
        }

        String webInput = "75000";

        Integer annualSalary = Integer.parseInt(webInput);

        List<Double> loanOffers = new ArrayList<>();
        loanOffers.add(500000.0);
        loanOffers.add(10000000.050);
        loanOffers.add(8000000.050);

        System.out.println("Processing salary: " + annualSalary);
        System.out.println("Available offers"+ loanOffers.size());

        System.out.println("Max loan ID possible"+Integer.MAX_VALUE);
    }
}
