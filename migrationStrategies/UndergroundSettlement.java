package migrationStrategies;
import java.util.List;
import java.util.Random;
import characters.Citizen;
import interfaces.Resource;
import jobs.*;
import abstracts.MigrationStrategy;

public class UndergroundSettlement extends MigrationStrategy {
    int resourcesLevel;
    int safety;
    List<Resource> resources;

    public UndergroundSettlement(int resourcesLevel, int safety, List<Resource> resources) {
        this.resourcesLevel = resourcesLevel;
        this.safety = safety;
        this.resources = resources;
    }

    @Override
    public void migrate(List<Citizen> citizens, List<Resource> resources) {
        System.out.println("Migrating to underground settlement.");
        for (Citizen citizen : citizens) {
            Random random = new Random();
            int jobChoice = random.nextInt(3);
            switch (jobChoice) {
                case 0:
                    citizen.setJob(new BuilderJob());
                    break;
                case 1:
                    citizen.setJob(new HunterJob());
                    break;
                case 2:
                    citizen.setJob(null);
                    break;
            }
        }
    }
}
