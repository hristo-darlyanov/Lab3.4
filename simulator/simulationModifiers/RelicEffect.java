package simulator.simulationModifiers;
import interfaces.SimulationModifier;
import enums.RelicEffectType;
import java.util.Random;

public class RelicEffect implements SimulationModifier {
    public RelicEffectType getEffectType() {
        Random random = new Random();
        return RelicEffectType.values()[random.nextInt(RelicEffectType.values().length)];
    }
}
