package Interface;
/*
Section 10: Programming Abstractly Through Interfaces
Topic:6. Create and implement interfaces
Sub-Topic: Abstract class and Interface Comparisons
 */

// We have a global class keeping track of instance counts
class GlobalInformations{
    public static int DogCount;
    public static int CatCount;
    public static int TreeCount;
}
// This abstract class's sole purpose is to increment counts
interface Countable{
    public abstract void countMyInstances();
}
/*
Now we want every other class to execute the countMyInstances method Without interfaces,
this means extending every entity from the abstract class that enforces subclasses to implement
the method.
Here is an Animal class, also abstract so it does not have to implement method.
 */
abstract class Animals implements Countable{
    public Animals(String name, String type){
        this.name = name;
        this.type = type;
        countMyInstances();
    }
    private String name;
    private String type;
}
// We add a concrete Animal call Dog which must implement countMyInstances()
class Dogs extends Animals{
    public Dogs(String name, String type) {
        super(name, type);
    }
    @Override
    public void countMyInstances() {
        GlobalInformations.DogCount++;
    }
}
// We add a concrete Animal call Cat which must implement countMyInstances()
class Cats extends Animals{
    public Cats(String name, String type) {
        super(name, type);
    }
    @Override
    public void countMyInstances() {
        GlobalInformations.CatCount++;
    }
}
// We add a disparate class that will also implement countMyInstances()
class Trees implements Countable{
    public Trees() {
        countMyInstances();
    }
    @Override
    public void countMyInstances() {
        GlobalInformations.TreeCount++;
    }
}
/*
Our main method will create some objects of disparate types and verify that
our counters are being incremented.
 */
public class CompareExamples2 {
    public static void main(String[] args) {
        Dogs d;
        Cats c;
        Trees t;
        for(int i=0;i<5;i++){
            d = new Dogs("DOG_"+ (i+1), "dog");
        }
        for(int i=0;i<5;i++){
            c = new Cats("CAT_"+ (i+1), "cat");
        }
        for(int i=0;i<5;i++){
            t = new Trees();
        }

        System.out.println(GlobalInformations.DogCount);
        System.out.println( GlobalInformations.CatCount);
        System.out.println(GlobalInformations.TreeCount);
    }
}
