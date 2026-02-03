public class BaggageCounter
{
    public static void main(String[] args)
    {
        double baggageWeight = 25.13;
        double baggageWeightLimit= 23.0;
        double baggageFeeperKG = 1000;

        boolean hasPriorityStatus = false;
        boolean isSecurityCleared = true;

        double excessweight= baggageWeight-baggageWeightLimit;

        boolean isOverweight = baggageWeight>baggageWeightLimit;

        double totalExtraFee = 0.0;

        if(isOverweight)
        {
            totalExtraFee = excessweight*baggageFeeperKG;
        }

        boolean canFly = (!isOverweight || hasPriorityStatus) && isSecurityCleared;

        System.out.println("Excess weight: "+excessweight+ "KG");
        System.out.println("Baggage Fee: "+ totalExtraFee);
        System.out.println("Boarding Status: "+ canFly);
    }
}
