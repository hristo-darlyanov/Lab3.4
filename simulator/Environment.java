package simulator;
import java.util.List;
import interfaces.Resource;
import interfaces.SimulationModifier;
import java.util.ArrayList;

public class Environment {
    ArrayList<Enum<?>> effects = new ArrayList<>();
    List<SimulationModifier> simulationModifiers;
    List<Resource> resources;

    public Environment(List<SimulationModifier> simulationModifiers, List<Resource> resources) {
        this.simulationModifiers = simulationModifiers;
        this.resources = resources;
    }

    void simulateChange() {
        System.out.println("Simulating climate change.");
        for (SimulationModifier simulationModifier : simulationModifiers) {
            effects.add(simulationModifier.getEffectType());
        }
    }

    void passDay() {
        effects.clear();
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
