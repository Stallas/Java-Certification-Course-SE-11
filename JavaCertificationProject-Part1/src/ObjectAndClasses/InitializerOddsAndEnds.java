package ObjectAndClasses;
  /*
      Section 6: Describing and Using Objects and classes.
      Topic : Declare and Instantiate Objects/
      Sub-Topic: 5. Out of the Ordinary
   */
class ASuperClass{
    String name;
    ASuperClass(){
        System.out.println("Parent constructor executes");
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return "My name is "+ this.name;
    }
}
class ASubClass extends ASuperClass{
    ASubClass(){
        System.out.println("Child no-args constructor executes");
    }
    ASubClass(String name){
        this();//Child no-args constructor executes
       // super(); // above no-args wont be executed.
        System.out.println("Child single argument constructor executes");
        setName(name);
    }
    // Initializer code
    {
        this.name = "Override";
        System.out.println("Child initializer executes");
        System.out.println(this);
    }
}
public class InitializerOddsAndEnds {
    public static void main(String[] args) {
        ASubClass joe = new ASubClass("Joe");
        System.out.println(joe);
    }
}
