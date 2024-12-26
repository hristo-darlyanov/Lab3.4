import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import interfaces.Resource;
import interfaces.SimulationModifier;
import abstracts.MigrationStrategy;
import migrationStrategies.*;
import simulator.*;
import resources.*;
import simulator.simulationModifiers.*;

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

        List<SimulationModifier> simulationModifiers = new ArrayList<>();
        SimulationModifier temperatureEffect = new TemperatureEffect();
        SimulationModifier climateEffect = new ClimateEffect();
        SimulationModifier relicEffect = new RelicEffect();
        simulationModifiers.add(temperatureEffect);
        simulationModifiers.add(climateEffect);
        simulationModifiers.add(relicEffect);
        Environment environment = new Environment(simulationModifiers, resources);

        ScenarioSimulator simulator = new ScenarioSimulator(numCitizens, environment, strategy);
        scanner.close();
        simulator.runSimulation();
    }
}
