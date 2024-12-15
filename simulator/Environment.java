package simulator;
import java.util.List;
import java.util.Random;
import enums.ClimateType;
import interfaces.Resource;

public class Environment {
    ClimateType climate;
    List<Resource> resources;

    public Environment(ClimateType climate, List<Resource> resources) {
        this.climate = climate;
        this.resources = resources;
    }

    void simulateChange() {
        System.out.println("Simulating climate change.");
        Random random = new Random();
        this.climate = ClimateType.values()[random.nextInt(ClimateType.values().length)];
    }

    Resource returnResource(Class<? extends Resource> resourceType) {
        for (Resource resource : resources) {
            if (resource.getClass().equals(resourceType)) {
                return resource;
            }
        }
        return null;
    }
}
