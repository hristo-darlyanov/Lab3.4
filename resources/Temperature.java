package resources;
import exceptions.ResourceDepletionException;
import interfaces.Resource;
import enums.ClimateType;

public class Temperature implements Resource {
    int resourceLevel;
    public Temperature(int temperatureLevel) {
        this.resourceLevel = temperatureLevel;
    }

    @Override
    public void consume(int day, ClimateType climateType) throws ResourceDepletionException {
        int amountToConsume = 1;
        switch (climateType) {
            case COLD:
                amountToConsume *= 2;
                break;
            case WARM:
                amountToConsume *= 2;
                break;
        }
        resourceLevel -= amountToConsume;
        if (resourceLevel <= 0) {
            throw new ResourceDepletionException("Temperature too low.");
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
