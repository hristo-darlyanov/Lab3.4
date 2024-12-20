package migrationStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import characters.Citizen;
import interfaces.Resource;
import jobs.*;
import abstracts.MigrationStrategy;

public class UnderwaterSettlement extends MigrationStrategy {
    List<Resource> resources;

    public UnderwaterSettlement(List<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public List<Citizen> migrate(int amountOfCitizens, List<Resource> resources) {
        System.out.println("Migrating to underground settlement.");
        List<Citizen> citizens = new ArrayList<>();
        for (int i = 0; i < amountOfCitizens; i++) {
            String name = "Citizen " + (i + 1);
            Random random = new Random();
            int jobChoice = random.nextInt(3);
            switch (jobChoice) {
                case 0:
                    citizens.add(new Citizen(name, new BuilderJob()));
                    break;
                case 1:
                    citizens.add(new Citizen(name, new EngineerJob()));
                    break;
                case 2:
                    citizens.add(new Citizen(name, null));
                    break;
            }
        }

        return citizens;
    }
}