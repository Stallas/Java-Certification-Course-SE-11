package Methods;
/*
    Section 7: Creating and Using Methods
    Topic: Create Methods and Constructors

 */

// Create a class - no constructor defined
class ATest{
    /* //Step 1: implicit noargs invoked if undefined
    ATest(){
        System.out.println("I am super");
    }
    */
    /* Step3: you will get error in BTest stating there is no no-args constructor, as code has implied
    call to super() from Btest constructor.This can be resolved either by adding a no-args construc
    in ATest or adding super(parameter) in BTest constr.
	ATest(String name){
        System.out.println("I am super "+ name);
    }

     */
}
// Create a subclass
class BTest extends ATest{
    private String name;

    // constructor has one parameter
    BTest(String name){
        //super();  //step2: call to super() hasnt changed
        // super(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
public class ConstructorExample_02 {
    public static void main(String[] args) {
        // Instantiate the object with the one parameter constructor
        // when BTest gets called, ATEST constructor is actually invoked though noargs constru isnt defined.
        BTest btest = new BTest("sri");
        System.out.println(btest.getName());
    }
}
