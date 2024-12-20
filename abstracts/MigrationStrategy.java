package abstracts;
import java.util.List;
import interfaces.Resource;
import characters.Citizen;

public abstract class MigrationStrategy {
    public abstract List<Citizen> migrate(int amountOfCitizens, List<Resource> resources);
}
