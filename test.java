interface Vehicle {
    void start();

    // default declares the default implementation of the function
    default void stop() {
        pprint("Vehicle is stopping.");
    }

    // static working as a static
    static int add(int a, int b) {
        return a + b;
    }

    // private used internally
    private void pprint(String a) {
        System.out.println(a);
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting.");
    }
}

public class test {
    public static void main(String[] args) {
        System.out.println(Vehicle.add(0, 0));
        Vehicle car = new Car();
        car.start();
        car.stop();
    }
}

enum Season {
    WINTER("Cold"), SPRING("Warm"), SUMMER("Hot"), AUTUMN("Cool");

    private final String description;

    Season(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

class anotherTest {
    public static void main(String[] args) {
        Season season = Season.SUMMER;
        System.out.println("Season: " + season);
        System.out.println("Description: " + season.getDescription());
    }

    class NestedClass {
        
    }
}


interface Greeting {
    void sayHello();
}

class andAnotherClass {
    public static void main(String[] args) {
        Greeting greet = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello, world!");
            }
        };

        greet.sayHello();
    }
}
