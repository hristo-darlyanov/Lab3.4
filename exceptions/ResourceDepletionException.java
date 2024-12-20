package exceptions;

import interfaces.Resource;
import resources.*;;

public class ResourceDepletionException extends Exception {
    public ResourceDepletionException(Class<? extends Resource> resourceType) {
            super(getMessage(resourceType));
        }
    
        private static String getMessage(Class<? extends Resource> resource) {
            if (resource.equals(Oxygen.class)) {
                return "Oxygen has been depleted.";
            } else if (resource.equals(Temperature.class)) {
                return "Temperature is too low.";
            } else if (resource.equals(Food.class)) {
                return "Food has been eaten.";
            } else {
                return "Resource has been depleted.";
            }
    }
}