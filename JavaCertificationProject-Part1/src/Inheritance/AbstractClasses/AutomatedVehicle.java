package Inheritance.AbstractClasses;
/*
    Section 9: Reusing Implementations Through Inheritance
    Topic: 6.Abstract classes
 */
/*  Thus abstract class extends the abstract Vehicle.
    It is not required that an abstract class implements any or all of Vehicle's abstract methods.
    In this ex, we implement 2 of Vehicle's abstract methods, but do not implement makeNoise method.
    But has to implement constructor.
 */
public abstract class AutomatedVehicle extends Vehicle{
    // constructor is pass thru to Vehicle constructor
    public AutomatedVehicle(VehicleType type, String owner, String make) {
        super(type, owner, make);
    }
    // This class implements park(),but calls an abstract method defined on this class.
    // Any class that extends the automatedVehicle, no longer has to implement park(),
    // but has to implement autoPark()
    public void drive() {
        autoDrive();
    }
// This class implements park(),but calls an abstract method defined on this drive.
    public void park() {
        autoPark();
    }
    // Any concrete class that extends AutomatedVehicle, has to implement autoPark()
    abstract void autoPark();
    // Any concrete class that extends AutomatedVehicle, has to implement autoDrive()
    abstract void autoDrive();
}
