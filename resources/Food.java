package resources;
import java.util.ArrayList;
import enums.TemperatureEffectType;
import enums.RelicEffectType;
import exceptions.ResourceDepletionException;
import interfaces.Resource;

public class Food implements Resource {
    int resourceLevel;

    public Food(int foodSupply) {
        this.resourceLevel = foodSupply;
    }

    @Override
    public void consume(int day, ArrayList<Enum<?>> effects) throws ResourceDepletionException {
        int amountToConsume = 0;
        for (Enum<?> effect : effects) {
            if (effect.equals(TemperatureEffectType.COLD)) {
                amountToConsume = day * 2;
            } else if (effect.equals(TemperatureEffectType.WARM)) {
                try {
                    amountToConsume = day / 2;
                } catch (ArithmeticException e) {
                    amountToConsume = 1;
                }
            } else if (effect.equals(RelicEffectType.RESOURCE_DECREASE)) {
                amountToConsume += 5;
            } else if (effect.equals(RelicEffectType.RESOURCE_INCREASE)) {
                amountToConsume -= 5;
            }
        }

        resourceLevel -= amountToConsume;
        if (resourceLevel <= 0) {
            throw new ResourceDepletionException(this.getClass());
        }
    }

    @Override
    public void add(int amount) {
        resourceLevel += amount;
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