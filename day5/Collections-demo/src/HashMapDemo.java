import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {

        HashMap<Integer,String > sports = new HashMap<>();

        sports.put(1,"Cricket");
        sports.put(2,"Basketball");
        sports.put(3,"volleyball");

        System.out.println("List of Sports: ");

        for(Map.Entry mEntry : sports.entrySet())
        {
            System.out.println(mEntry.getKey()+" "+ mEntry.getValue());
        }
    }
}
