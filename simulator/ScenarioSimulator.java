package simulator;
import java.util.List;
import characters.Citizen;
import interfaces.Resource;
import resources.*;
import jobs.*;
import abstracts.MigrationStrategy;
import abstracts.Job;
import exceptions.ResourceDepletionException;

public class ScenarioSimulator {
    int amountOfCitizens;
    List<Citizen> citizens;
    Environment environment;
    MigrationStrategy strategy;
    boolean done = false;
    int day = 1;

    public ScenarioSimulator(int amountOfCitizens, Environment environment, MigrationStrategy strategy) {
        this.amountOfCitizens = amountOfCitizens;
        this.environment = environment;
        this.strategy = strategy;
    }

    public void runSimulation() {
        System.out.println("Simulation starting...");
        citizens = strategy.migrate(amountOfCitizens, environment.resources);
        for (Citizen citizen : citizens) {
            if (citizen.getJob() == null) {
                System.out.println(citizen.getName() + " is unemployed.");
                continue;
            }
            System.out.println(citizen.getName() + " is a " + citizen.getJob().getClass().getSimpleName());
        }

        while (!done) {
            System.out.println("");
            System.out.println("Day " + day + ": Simulation running...");
            environment.simulateChange();

            for (Enum<?> effect : environment.effects) {
                System.out.println("Effect: " + effect);
            }
            
            for (Citizen citizen : citizens) {
                Job citizenJob = citizen.getJob();
                if (citizenJob == null) {
                    System.out.println(citizen.getName() + " is unemployed.");
                    continue;
                }
                if (citizenJob instanceof EngineerJob) {
                    citizenJob.performDuties(environment.returnResource(Oxygen.class));
                } else if (citizenJob instanceof BuilderJob) {
                    citizenJob.performDuties(environment.returnResource(Temperature.class));
                } else if (citizenJob instanceof HunterJob) {
                    citizenJob.performDuties(environment.returnResource(Food.class));
                }
            }

            for (Resource resource : environment.resources) {
                try {
                    resource.consume(day, environment.effects);
                } catch (ResourceDepletionException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Simulation ended.");
                    done = true;
                    break;
                }
            }
            for (Resource resource : environment.resources) {
                System.out.println(resource.getClass().getSimpleName() + " level: " + resource.getLevel());
            }
            environment.passDay();
            day++;
        }
    }
}