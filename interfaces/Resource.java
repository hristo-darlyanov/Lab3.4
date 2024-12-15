package interfaces;
import enums.ClimateType;
import exceptions.ResourceDepletionException;

public interface Resource {
    void consume(int day, ClimateType climateType) throws ResourceDepletionException;
    void add(int amount);
    boolean isAvailable();
    int getLevel();
}
