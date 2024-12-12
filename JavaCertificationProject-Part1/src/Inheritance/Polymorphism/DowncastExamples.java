package Inheritance.Polymorphism;
/*
    Section 9: Reusing Implementations Through Inheritance
    Topic: 12. Utilize polymorphism to cast and call methods
    Sub-Topic: downcasting
 */
// Animal is our base class
class Animal{
    public void printAnimal(){
        System.out.println("I am an Animal");
    }
}
// Dog is a subclass of Animal
class Dog extends Animal{
    public void printDog(){
        System.out.println("I am a Dog");
    }
    public String getDogString(){
        return "dog";
    }
    /* Testing purpose
    public void printAnimal(){
        System.out.println("I am an Animal in Dog class");
    }*/
}
// Cat is also a subclass of Animal
class Cat extends Animal{
    public void printCat(){
        System.out.println("I am a Cat");
    }
}
public class DowncastExamples {
    public static void main(String[] args) {
        DowncastExamples dex = new DowncastExamples();

        // We create instances of Dog ,Cat but assign them to variables of Animal.
        Animal genericDog = new Dog();
        Animal genericCat = new Cat();
        //genericDog.printAnimal();//Testing purpose

        // We cast now:
        dex.testDog((Dog) genericDog);
        dex.testCat((Cat) genericCat);

        // try the overloaded methods with specifically typed variables
        dex.testAnimal((Dog) genericDog);
        dex.testAnimal((Cat) genericCat);

        // try the overloaded methods with specifically typed variables
        dex.testAnimal(genericDog);
        dex.testAnimal(genericCat);
        /*
        We dont get compiler error, however on running it throws ClassCastException
        // First, call the specifically named methods by downcasting generically typed variables
        // to the object types
        dex.testAnimal((Cat) genericDog);
        dex.testAnimal((Dog) genericCat);
        // Try the overloaded methods downcasting generically typed variables to the object types
        dex.testAnimal((Cat) genericDog);
        dex.testAnimal((Dog) genericCat);
        */
        // Adding mixed up declarations - compiler error
//        Dog specificDog = new Cat();
//        Cat specificCat = new Dog();

        // Test till these below are common mistakes.
        // Downcasting in an expression to access a specific method on a more specific type
        if(((Dog)genericDog).getDogString().equals("dog")){
            System.out.println("Matched !");
        }

        // downcasting a method return type
        Cat c = (Cat) dex.passThrough(genericCat);
        c.printCat();
    }

    //Three overloaded methods
    public void testAnimal(Animal animal){
        System.out.println("Executing test animal with animal type");
        animal.printAnimal();
    }
    public void testAnimal(Cat cat){
        System.out.println("Executing test animal with Cat type");
        cat.printAnimal();
    }
    public void testAnimal(Dog dog){
        System.out.println("Executing test animal with Dog type");
        dog.printAnimal();
    }
    //Specifically typed method calls
    public void testDog(Dog dog){
        dog.printDog();
    }
    public void testCat(Cat cat){
        cat.printCat();
    }
    public Object passThrough(Object o){
        return o;
    }
}
