public class AverageFinder {

    private static double findaverage(String[] input)
    {
        double result = 0;

        for(String str : input)
        {
            result += Integer.parseInt(str);
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println("Average Finder v0.1");
        double average = findaverage(args);
        System.out.println("The average is: "+average);
        
    }
}
