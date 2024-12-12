package Inheritance.AbstractClasses;
/*
    Section 9: Reusing Implementations Through Inheritance
    Topic: 7.Abstract classes
 */
/* This a concrete class extending AutomatedVehicle.
You will note that this class does not implement drive() or park()
Concrete class extends abstract so implement const,abstract methods on all parent levels
 */
public class AutomatedAuto extends AutomatedVehicle{
    // constructor is pass thru to AutomatedVehicle constructor
    public AutomatedAuto(VehicleType type, String owner, String make) {
        super(type, owner, make);
    }
    // Implements autoPark(), required by AutomatedVehicle extension
    @Override
    void autoPark() {
        System.out.println("Parking it myself");
    }
    // Implements autoDrive(), required by AutomatedVehicle extension
    @Override
    void autoDrive() {
        System.out.println("Driving it myself");
    }
    @Override
    public void makeNoise() {
        System.out.println("Beep Beep");
    }

    public static void main(String[] args) {
        AutomatedAuto automatedCar = new AutomatedAuto(VehicleType.Automobile,"Maartha","Tesla");
        System.out.println(automatedCar);
        // drive() and park() are not even methods on AutomatedAuto but we can use
        // them because of inheritance and best part of all, they execute autoDrive(),autoPark()
        // for this type of Object.
        automatedCar.drive();
        automatedCar.park();
        automatedCar.makeNoise();

    }
}
