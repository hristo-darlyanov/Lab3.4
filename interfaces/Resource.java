package interfaces;
import java.util.ArrayList;
import exceptions.ResourceDepletionException;

public interface Resource {
    void consume(int day, ArrayList<Enum<?>> effects) throws ResourceDepletionException;
    void add(int amount);
    boolean isAvailable();
    int getLevel();
}
