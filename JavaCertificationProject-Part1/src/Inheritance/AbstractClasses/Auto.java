package Inheritance.AbstractClasses;
/*
    Section 9: Reusing Implementations Through Inheritance
    Topic: 5.Abstract classes
 */
// Auto is a concrete class which extends the abstract class Vehicle.
// should implement abstract methods and constructor matching super.
public class Auto extends Vehicle{

    // Create a constructor that is a pass thru to Vehicle constructor
    public Auto(VehicleType type, String owner, String make) {
        super(type, owner, make);
    }

    @Override
    public void drive() {
        System.out.println("Release Brake, go");
    }

    @Override
    public void park() {
        System.out.println("Parallel or back in ?");
    }

    @Override
    public void makeNoise() {
        System.out.println("Vroom Vroom");
    }

    public static void main(String[] args) {
        Auto car = new Auto(VehicleType.Automobile,"Allen","Ford");
        System.out.println(car);
        car.drive();
        car.park();
        car.makeNoise();

    }
}
