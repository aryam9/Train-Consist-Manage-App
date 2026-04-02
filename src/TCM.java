import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TCM {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Train initialized successfully.");
        System.out.println("Initial number of bogies: " + trainConsist.size());

        List<String> passengerBogiesNames = new ArrayList<>();
        passengerBogiesNames.add("Sleeper");
        passengerBogiesNames.add("AC Chair");
        passengerBogiesNames.add("First Class");
        System.out.println("Passenger bogies added:");
        System.out.println(passengerBogiesNames);

        passengerBogiesNames.remove("AC Chair");
        System.out.println("\nAfter removing 'AC Chair':");
        System.out.println(passengerBogiesNames);

        if (passengerBogiesNames.contains("Sleeper")) {
            System.out.println("\n'Sleeper' bogie exists in the train.");
        } else {
            System.out.println("\n'Sleeper' bogie does not exist.");
        }
        System.out.println("\nFinal passenger bogie list:");
        System.out.println(passengerBogiesNames);

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

        Map<String, Integer> bogieCapacityMap = new HashMap<>();
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 78);
        bogieCapacityMap.put("First Class", 24);
        System.out.println("\nBogie Capacity Mapping:");
        bogieCapacityMap.forEach((k, v) -> System.out.println(k + " -> Capacity: " + v));

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
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 24));
        }

        long startLoop = System.nanoTime();
        List<Bogie> filteredLoop = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) filteredLoop.add(b);
        }
        long endLoop = System.nanoTime();
        System.out.println("\nLoop-based filtering found " + filteredLoop.size() + " bogies.");
        System.out.println("Loop filtering time: " + (endLoop - startLoop) + " ns");

        long startStream = System.nanoTime();
        List<Bogie> filteredStream = bogies.stream()
                .filter(b -> b.capacity > 60)
                .toList();
        long endStream = System.nanoTime();
        System.out.println("\nStream-based filtering found " + filteredStream.size() + " bogies.");
        System.out.println("Stream filtering time: " + (endStream - startStream) + " ns");

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

        class GoodsBogie {
            String type;
            String cargo;
            GoodsBogie(String type, String cargo) {
                this.type = type;
                this.cargo = cargo;
            }
            @Override
            public String toString() {
                return type + " -> Cargo: " + cargo;
            }
        }

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("Open", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        System.out.println("\nGoods bogies in the train:");
        goodsBogies.forEach(System.out::println);

        boolean safetyCompliant = goodsBogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        System.out.println("\nSafety Compliance Check:");
        if (safetyCompliant) {
            System.out.println("All goods bogies are safe. Train is safety compliant.");
        } else {
            System.out.println("Unsafe cargo detected in cylindrical bogie(s)! Train is NOT safety compliant.");
        }
        class InvalidCapacityException extends Exception {
            InvalidCapacityException(String message) {
                super(message);
            }
        }

        class PassengerBogie {
            String type;
            int capacity;
            PassengerBogie(String type, int capacity) throws InvalidCapacityException {
                if (capacity <= 0) {
                    throw new InvalidCapacityException("Capacity must be greater than zero");
                }
                this.type = type;
                this.capacity = capacity;
            }
            @Override
            public String toString() {
                return type + " -> Capacity: " + capacity;
            }
        }

        List<PassengerBogie> validPassengerBogies = new ArrayList<>();
        try {
            validPassengerBogies.add(new PassengerBogie("Sleeper", 72));
            validPassengerBogies.add(new PassengerBogie("AC Chair", 56));
            validPassengerBogies.add(new PassengerBogie("First Class", 24));
        } catch (InvalidCapacityException e) {
            System.out.println("\nError creating bogie: " + e.getMessage());
        }

        System.out.println("\nPassenger bogies after capacity validation:");
        validPassengerBogies.forEach(System.out::println);

        System.out.println("\nTrain Consist including valid passenger bogies:");
        LinkedList<String> finalConsist = new LinkedList<>();
        finalConsist.add("Engine");
        validPassengerBogies.forEach(b -> finalConsist.add(b.type));
        finalConsist.add("Cargo");
        finalConsist.add("Guard");
        System.out.println(finalConsist);
    }
}