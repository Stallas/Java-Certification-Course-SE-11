package Inheritance.AbstractClasses;

/*
    Section 9: Reusing Implementations Through Inheritance
    Topic: 9.Polymorphism
 */
// We create a new Vehicle, Motorcycle, which implements the abstract methods on Vehicle
class MotorCycle extends Vehicle{
    public MotorCycle(VehicleType type, String owner, String make) {
        super(type, owner, make);
    }
    @Override
    public void drive() {
        System.out.println("Kick up stand. Go");
    }
    @Override
    public void park() {
        System.out.println("Put up stand.");
    }
    @Override
    public void makeNoise() {
        System.out.println("Zoom");
    }
}
// TestVehicles demonstrates polymorphism
public class TestVehicles{
    public static void main(String[] args) {

        // We create 3 types of Vehicle classes.
        Auto car = new Auto(Vehicle.VehicleType.Automobile,"Allen","Ford");
        MotorCycle harley = new MotorCycle(Vehicle.VehicleType.Motorcycle,"Buzz","Harley-davidson");
        AutomatedAuto automatedCar =  new AutomatedAuto(Vehicle.VehicleType.Automobile,"Maartha","Tesla");

        // We execute this class's drive method the same regardless of the type pf object passed..
        drive(car);
        drive(automatedCar);
        drive(harley);

        // We execute this class's park method the same regardless of the type pf object passed..
        park(car);
        park(automatedCar);
        park(harley);


    }
    /* We create a generic drive method that makes no assumptions about
    What the object's drive method will do, it just knows from the abstract class
    that drive() is a valid method on Vehicle.
    */
    public static void drive(Vehicle v){
        System.out.println(v.getClass().getName() + " drive() : ");
        v.drive();
    }
    /* We create a generic park method that makes no assumptions about
    What the object's park method will do, it just knows from the abstract class
    that park() is a valid method on Vehicle.
    */
    public static void park(Vehicle v){
        System.out.println(v.getClass().getName() + " park() : ");
        v.park();
    }
}
