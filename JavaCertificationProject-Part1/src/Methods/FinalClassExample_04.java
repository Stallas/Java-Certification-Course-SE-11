package Methods;
/*
    Section 7: Creating and Using Methods
    Topic: Create Methods and Constructors
    Sub-Topic: 4. Final Class ?
 */
final class FinalEntity{
    private String name;
    FinalEntity(String name){
        this.name = name;
    }
    void doSomething(){
        System.out.println("Doing something for "+this.name);
    }
}
public class FinalClassExample_04 {
    public static void main(String[] args) {

        // You can create as many instances of a final class as per wish
        FinalEntity f1 = new FinalEntity("a");
        FinalEntity f2 = new FinalEntity("b");
        f1.doSomething();
        f2.doSomething();
    }
}
