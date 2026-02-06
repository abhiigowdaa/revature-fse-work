import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {

    public static void main(String[] args)
    {
        ArrayList<String> sports = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of games");
        int NoOfgames = scan.nextInt();

        System.out.println("Enter the sport played: ");

        for(int i=0;i<NoOfgames;i++)
        {
            String Sportsplayed = scan.next();
            sports.add(Sportsplayed);
        }
        
        System.out.println("List of sports played are: \n");
        for(String sport:sports)
        {
            System.out.println(sport);
        }

    }




}
