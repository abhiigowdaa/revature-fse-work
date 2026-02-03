public class FlightSystem {

    public static void main(String[] args) {

        String[] passengers = {"Abhi","sharath","Rayan","Diwa"};

        System.out.println("Total seats: "+ passengers.length);

        for(int i=0; i< passengers.length;i++)
        {
            System.out.println("seat "+ (i+1)+ " : "+passengers[i]);
        }

        System.out.println("\nUpdate: Nikhil Cancelled. Adding Nawaz");
        passengers[3]="Nawaz";
        System.out.println("New passenger at seat 4 is: "+passengers[3]);


    }
}
