package resources;
import exceptions.ResourceDepletionException;
import interfaces.Resource;
import java.util.ArrayList;
import enums.ClimateEffectType;
import enums.TemperatureEffectType;

public class Temperature implements Resource {
    int resourceLevel;
    public Temperature(int temperatureLevel) {
        this.resourceLevel = temperatureLevel;
    }

    @Override
    public void consume(int day, ArrayList<Enum<?>> effects) throws ResourceDepletionException {
        int amountToConsume = 1;
        for (Enum<?> effect : effects) {
            if (effect.equals(TemperatureEffectType.COLD)) {
                amountToConsume = day * 2;
            } else if (effect.equals(TemperatureEffectType.WARM)) {
                try {
                    amountToConsume = day / 2;
                } catch (ArithmeticException e) {
                    amountToConsume = 1;
                }
            } else if (effect.equals(ClimateEffectType.TEMPERATURE_DECREASE)) {
                amountToConsume += 5;
            } else if (effect.equals(ClimateEffectType.TEMPERATURE_INCREASE)) {
                amountToConsume -= 5;
            }
        }
        resourceLevel -= amountToConsume;
        if (resourceLevel <= -30) {
            throw new ResourceDepletionException(this.getClass());
        }
    }

    @Override
    public void add(int amount) {
        resourceLevel = Math.min(37, resourceLevel + amount);
    }

    @Override
    public boolean isAvailable() {
        return resourceLevel > 0;
    }

    @Override
    public int getLevel() {
        return resourceLevel;
    }
}
