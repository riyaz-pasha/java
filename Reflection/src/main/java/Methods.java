import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class Vehicle {

    private final String name;

    Vehicle(String name) {
        this.name = name;
    }

    protected void start() {
        System.out.println("Vehicle Started!!...");
    }

    protected void stop() {
        System.out.println("Vehicle Stopped!!...");
    }

    private void serviceVehicle() {
        System.out.println("Vehicle serviced!!");
    }

    @Override
    public String toString() {
        return "I'm a Vehicle";
    }

    public String getName() {
        return name;
    }
}

public class Methods {
    public static void main(String[] args) {
        Vehicle pulsar150 = new Vehicle("Bajaj Pulsar 150");
        Class vehicleClassObj = pulsar150.getClass();

        System.out.println("-------------------------------------------------------------------");
        for (Method method : vehicleClassObj.getMethods()) {
            System.out.println("\nMethod Name " + method.getName());
            System.out.println("Method Return Type " + method.getReturnType());
            System.out.println("Method Modifier " + Modifier.toString(method.getModifiers()));
        }
        System.out.println("-------------------------------------------------------------------");
        for (Method method : vehicleClassObj.getDeclaredMethods()) {
            System.out.println("\nMethod Name " + method.getName());
            System.out.println("Method Return Type " + method.getReturnType());
            System.out.println("Method Modifier " + Modifier.toString(method.getModifiers()));
        }
    }
}
