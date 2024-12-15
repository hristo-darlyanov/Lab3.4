package abstracts;
import java.util.List;
import characters.Citizen;
import interfaces.Resource;

public abstract class MigrationStrategy {
    public abstract void migrate(List<Citizen> citizens, List<Resource> resources);
}
