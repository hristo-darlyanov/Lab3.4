package simulator.simulationModifiers;
import java.util.Random;
import interfaces.SimulationModifier;
import enums.ClimateEffectType;

public class ClimateEffect implements SimulationModifier {
    public ClimateEffectType getEffectType() {
        Random random = new Random();
        return ClimateEffectType.values()[random.nextInt(ClimateEffectType.values().length)];
    }
}
