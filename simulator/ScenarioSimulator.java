package simulator;
import java.util.List;
import characters.Citizen;
import interfaces.Resource;
import resources.*;
import jobs.*;
import abstracts.MigrationStrategy;
import exceptions.ResourceDepletionException;

public class ScenarioSimulator {
    List<Citizen> citizens;
    Environment environment;
    MigrationStrategy strategy;
    boolean done = false;
    int day = 1;

    public ScenarioSimulator(List<Citizen> citizens, Environment environment, MigrationStrategy strategy) {
        this.citizens = citizens;
        this.environment = environment;
        this.strategy = strategy;
    }

    public void runSimulation() {
        System.out.println("Simulation starting...");
        strategy.migrate(citizens, environment.resources);
        for (Citizen citizen : citizens) {
            if (citizen.job == null) {
                System.out.println(citizen.name + " is unemployed.");
                continue;
            }
            System.out.println(citizen.name + " is a " + citizen.job.getClass().getSimpleName());
        }

        while (!done) {
            System.out.println("");
            System.out.println("Day " + day + ": Simulation running...");
            environment.simulateChange();
            System.out.println("Climate: " + environment.climate);
            
            for (Citizen citizen : citizens) {
                if (citizen.job == null) {
                    System.out.println(citizen.name + " is unemployed.");
                    continue;
                }
                if (citizen.job instanceof EngineerJob) {
                    citizen.job.performDuties(environment.returnResource(Oxygen.class));
                } else if (citizen.job instanceof BuilderJob) {
                    citizen.job.performDuties(environment.returnResource(Temperature.class));
                } else if (citizen.job instanceof HunterJob) {
                    citizen.job.performDuties(environment.returnResource(Food.class));
                }
            }

            for (Resource resource : environment.resources) {
                try {
                    resource.consume(day, environment.climate);
                } catch (ResourceDepletionException e) {
                    handle(e);
                    System.out.println("Simulation ended.");
                    done = true;
                    break;
                }
            }
            for (Resource resource : environment.resources) {
                System.out.println(resource.getClass().getSimpleName() + " level: " + resource.getLevel());
            }
            day++;
        }
    }

    void handle(ResourceDepletionException e) {
        System.out.println(e.getMessage());
    }
}