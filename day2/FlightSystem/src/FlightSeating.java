public class FlightSeating {

    public static void main(String[] args)
    {
        String[][] seatingChart =new String [3][2];

        seatingChart[0][0] = "VIP: Mr. Smith";
        seatingChart[0][1] = "VIP: Mrs. Smith";
        seatingChart[1][0] = "Empty";
        seatingChart[1][1] = "Capt. Rogers";
        seatingChart[2][0] = "Dr. Strange";
        seatingChart[2][1] = "Empty";

        System.out.println("Passenger in Row 3, seat A is: "+ seatingChart[2][0]);


        for(int i=0;i<seatingChart.length;i++)
        {
            for(int j=0;j<seatingChart.length-1;j++)
            {
                System.out.println(seatingChart[i][j]);
            }
        }
    }
}
