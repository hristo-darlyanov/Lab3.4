package simulator.simulationModifiers;
import java.util.Random;
import interfaces.SimulationModifier;
import enums.TemperatureEffectType;

public class TemperatureEffect implements SimulationModifier{
    public TemperatureEffectType getEffectType() {
        Random random = new Random();
        return random.nextBoolean() ? TemperatureEffectType.COLD : TemperatureEffectType.WARM;
    }    
}
