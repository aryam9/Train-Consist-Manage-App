import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
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
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        System.out.println("\nBogie IDs added :");
        System.out.println("BG101, BG102, BG103, BG101, BG102");

        System.out.println("\nUnique Bogie IDs :");
        System.out.println(bogieIds);

        System.out.println("System ready for further operations...");
    }
}
