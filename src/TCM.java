import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Map;
public class TCM {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully.");
        System.out.println("Initial number of bogies: " + trainConsist.size());

        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        System.out.println("Passenger bogies added:");
        System.out.println(passengerBogies);
        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter removing 'AC Chair':");
        System.out.println(passengerBogies);
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("\n'Sleeper' bogie exists in the train.");
        } else {
            System.out.println("\n'Sleeper' bogie does not exist.");
        }
        System.out.println("\nFinal passenger bogie list:");
        System.out.println(passengerBogies);

        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101");
        bogieIds.add("BG102");

        System.out.println("\nBogie IDs added :");
        System.out.println("BG101, BG102, BG103, BG101, BG102");

        System.out.println("\nUnique Bogie IDs :");
        System.out.println(bogieIds);

        LinkedList<String> orderedConsist = new LinkedList<>();

        orderedConsist.add("Engine");
        orderedConsist.add("Sleeper");
        orderedConsist.add("AC");
        orderedConsist.add("Cargo");
        orderedConsist.add("Guard");

        System.out.println("\nInitial Train Consist:");
        System.out.println(orderedConsist);

        orderedConsist.add(2, "Pantry Car");
        System.out.println("\nAfter adding Pantry Car at position 2:");
        System.out.println(orderedConsist);

        orderedConsist.removeFirst();
        orderedConsist.removeLast();

        System.out.println("\nAfter removing first and last bogie:");
        System.out.println(orderedConsist);

        System.out.println("\nFinal ordered train consist:");
        System.out.println(orderedConsist);
        LinkedHashSet<String> trainFormation = new LinkedHashSet<>(orderedConsist);
        trainFormation.add("Pantry Car");
        trainFormation.add("Sleeper");

        System.out.println("\nTrain formation using LinkedHashSet:");
        System.out.println(trainFormation);

        Map<String, Integer> bogieCapacity = new HashMap<>();
        bogieCapacity.put("Sleeper", 72);
        bogieCapacity.put("AC Chair", 78);
        bogieCapacity.put("First Class", 24);
        System.out.println("\nBogie Capacity Mapping:");
        for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
            System.out.println(entry.getKey() + " -> Capacity: " + entry.getValue());
        }
        System.out.println("System ready for further operations...");
    }
}
