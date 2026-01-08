import java.util.HashMap;
import java.util.Map;

public class Finditernary {

    public static void findItinerary(Map<String, String> tickets) {

        // Step 1: Build reverse map (to -> from)
        Map<String, String> reverseMap = new HashMap<>();
        for (String from : tickets.keySet()) {
            String to = tickets.get(from);
            reverseMap.put(to, from);
        }

        // Step 2: Find starting city
        String start = null;
        for (String from : tickets.keySet()) {
            if (!reverseMap.containsKey(from)) {
                start = from;
                break;
            }
        }

        // Step 3: Print the itinerary
        while (tickets.containsKey(start)) {
            System.out.print(start + " -> ");
            start = tickets.get(start);
        }
        System.out.println(start);
    }

    // MAIN METHOD (Program entry point)
    public static void main(String[] args) {

        Map<String, String> tickets = new HashMap<>();

        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        findItinerary(tickets);
    }
}
