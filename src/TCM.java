import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        bogieCapacity.forEach((k, v) -> System.out.println(k + " -> Capacity: " + v));

        class Bogie {
            String name;
            int capacity;

            Bogie(String name, int capacity) {
                this.name = name;
                this.capacity = capacity;
            }

            @Override
            public String toString() {
                return name + " -> Capacity: " + capacity;
            }
        }

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 72));

        System.out.println("\nBefore Sorting:");
        bogies.forEach(System.out::println);

        bogies.sort(Comparator.comparingInt(b -> b.capacity));
        System.out.println("\nAfter Sorting (Ascending Order):");
        bogies.forEach(System.out::println);

        bogies.sort(Comparator.comparingInt((Bogie b) -> b.capacity).reversed());
        System.out.println("\nAfter Sorting (Descending Order):");
        bogies.forEach(System.out::println);

        List<Bogie> highCapacityBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();
        System.out.println("\nFiltered bogies with capacity > 60:");
        highCapacityBogies.forEach(System.out::println);

        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        System.out.println("\nGrouped bogies by type:");
        groupedBogies.forEach((k, v) -> System.out.println(k + ": " + v));

        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        System.out.println("\nTotal seating capacity of the train: " + totalSeats);

        String trainID = "TRN-1234";
        String cargoCode = "PET-AB";

        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        Matcher trainMatcher = trainPattern.matcher(trainID);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        System.out.println("\nTrain ID Validation:");
        if (trainMatcher.matches()) {
            System.out.println(trainID + " is valid.");
        } else {
            System.out.println(trainID + " is invalid.");
        }

        System.out.println("\nCargo Code Validation:");
        if (cargoMatcher.matches()) {
            System.out.println(cargoCode + " is valid.");
        } else {
            System.out.println(cargoCode + " is invalid.");
        }

        System.out.println("\nSystem ready for further operations...");
    }
}