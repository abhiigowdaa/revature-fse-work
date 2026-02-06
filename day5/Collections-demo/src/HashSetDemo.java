import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

    public static void main(String[] args) {

        HashSet<String> names = new HashSet<>();

        names.add("Ganesh");
        names.add("Sai Pallavi");
        names.add("sam");
        names.add("Mahesh Babu");
        names.add("Rahul");

        Iterator<String> namesIterator = names.iterator();
        {
            while (namesIterator.hasNext())
            {
                String value = namesIterator.next();
                System.out.println(value);
            }

        }
    }
}
