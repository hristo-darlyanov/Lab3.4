package migrationStrategies;
import java.util.List;
import java.util.Random;
import characters.Citizen;
import interfaces.Resource;
import jobs.*;
import abstracts.MigrationStrategy;

public class UnderwaterSettlement extends MigrationStrategy {
    int depth;
    boolean oxygenSystem;
    List<Resource> resources;

    public UnderwaterSettlement(int depth, boolean oxygenSystem, List<Resource> resources) {
        this.depth = depth;
        this.oxygenSystem = oxygenSystem;
        this.resources = resources;
    }

    @Override
        public void migrate(List<Citizen> citizens, List<Resource> resources) {
            System.out.println("Migrating to underwater settlement.");
            for (Citizen citizen : citizens) {
                Random random = new Random();
                int jobChoice = random.nextInt(3);
                switch (jobChoice) {
                    case 0:
                        citizen.setJob(new BuilderJob());
                        break;
                    case 1:
                        citizen.setJob(new EngineerJob());
                        break;
                    case 2:
                        citizen.setJob(null);
                        break;
                }
            }
        }
}