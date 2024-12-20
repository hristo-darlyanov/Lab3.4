import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import enums.ClimateType;
import interfaces.Resource;
import abstracts.MigrationStrategy;
import migrationStrategies.*;
import simulator.*;
import resources.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of citizens:");
        int numCitizens = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Choose a migration strategy (1: Underwater, 2: Underground):");
        int strategyChoice = scanner.nextInt();
        scanner.nextLine();
        
        List<Resource> resources = new ArrayList<>();
        resources.add(new Temperature(20));
        if (strategyChoice == 1) {
            System.out.println("Underwater settlement selected.");
            resources.add(new Oxygen(100));
        } else {
            System.out.println("Underground settlement selected.");
            resources.add(new Food(100));
        }

        MigrationStrategy strategy;
        if (strategyChoice == 1) {
            strategy = new UnderwaterSettlement(resources);
        } else {
            strategy = new UndergroundSettlement(resources);
        }
        Environment environment = new Environment(ClimateType.COLD, resources);

        ScenarioSimulator simulator = new ScenarioSimulator(numCitizens, environment, strategy);
        scanner.close();
        simulator.runSimulation();
    }
}
