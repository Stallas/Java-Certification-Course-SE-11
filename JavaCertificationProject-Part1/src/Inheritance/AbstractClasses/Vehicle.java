package Inheritance.AbstractClasses;
/*
    Section 9: Reusing Implementations Through Inheritance
    Topic: 4.Abstract classes
 */
// Vehicle is our most general entity and will never be an actual instance.
public abstract class Vehicle {

    // We create an enum which describes possible subclasses
    protected enum VehicleType{
        Automobile,Motorcycle,Moped,Bicycle,Scooter
    }
    // define some attributes all vehicles would have in common
    private VehicleType type;
    private String owner;
    private String make;

    // constructor will be the method we use to set data
    public Vehicle(VehicleType type,String owner, String make){
        this.type = type;
        this.owner = owner;
        this.make = make;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type=" + type +
                ", owner='" + owner + '\'' +
                ", make='" + make + '\'' +
                '}';
    }

    // We create methods we want concrete subclasses to be forced to implement
    public abstract void drive();
    public abstract void park();
    public abstract void makeNoise();
}
