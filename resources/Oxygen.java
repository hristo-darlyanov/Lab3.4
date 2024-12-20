package resources;

import exceptions.ResourceDepletionException;
import interfaces.Resource;
import enums.ClimateType;

public class Oxygen implements Resource {
    int resourceLevel;

    public Oxygen(int oxygenLevel) {
        this.resourceLevel = oxygenLevel;
    }

    @Override
    public void consume(int day, ClimateType climateType) throws ResourceDepletionException {
        int amountToConsume = 0;
        switch (climateType) {
            case COLD:
                amountToConsume = day * 2;
                break;
            case WARM:
                try {
                    amountToConsume = day / 2;
                } catch (ArithmeticException e) {
                    amountToConsume = 1;
                }
                break;
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