package Interface;
/*
Section 10: Programming Abstractly Through Interfaces
Topic:6. Create and implement interfaces
Sub-Topic: Abstract class and Interface Comparisons
 */

// We have a global class keeping track of instance counts
class GlobalInformation{
    public static int DogCount;
    public static int CatCount;
    public static int TreeCount;
}
// This abstract class's sole purpose is to increment counts
abstract class CounterClass{
    public abstract void countMyInstances();
}
/*
Now we want every other class to execute the countMyInstances method Without interfaces,
this means extending every entity from the abstract class that enforces subclasses to implement
the method.
Here is an Animal class, also abstract so it does not have to implement method.
 */
abstract class Animal extends CounterClass{
    public Animal(String name, String type){
        this.name = name;
        this.type = type;
        countMyInstances();
    }
    private String name;
    private String type;
}
// We add a concrete Animal call Dog which must implement countMyInstances()
class Dog extends Animal{
    public Dog(String name, String type) {
        super(name, type);
    }
    @Override
    public void countMyInstances() {
        GlobalInformation.DogCount++;
    }
}
// We add a concrete Animal call Cat which must implement countMyInstances()
class Cat extends Animal{
    public Cat(String name, String type) {
        super(name, type);
    }
    @Override
    public void countMyInstances() {
        GlobalInformation.CatCount++;
    }
}
// We add a disparate class that will also implement countMyInstances()
class Tree extends CounterClass{
    public Tree() {
        countMyInstances();
    }
    @Override
    public void countMyInstances() {
        GlobalInformation.TreeCount++;
    }
}
/*
Our main method will create some objects of disparate types and verify that
our counters are being incremented.
 */
public class CompareExamples {
    public static void main(String[] args) {
        Dog d;
        Cat c;
        Tree t;
        for(int i=0;i<5;i++){
            d = new Dog("DOG_"+ (i+1), "dog");
        }
        for(int i=0;i<5;i++){
            c = new Cat("CAT_"+ (i+1), "cat");
        }
        for(int i=0;i<5;i++){
            t = new Tree();
        }

       System.out.println(GlobalInformation.DogCount);
       System.out.println( GlobalInformation.CatCount);
       System.out.println(GlobalInformation.TreeCount);
    }
}
