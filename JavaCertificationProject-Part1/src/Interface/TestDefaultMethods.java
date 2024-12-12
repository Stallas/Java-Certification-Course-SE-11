package Interface;
/*
Section 10: Programming Abstractly Through Interfaces
Topic:4. Create and implement interfaces
 */

// Teachable interface with abstract method teach and default method teachTheseLessons
interface Teachable{

    // default method
    default void teachTheseLessons(){
        System.out.println("Everyone should learn art and music");
    }
    void teach();
}
// Trainable interface with abstract method train and default method teachTheseLessons
interface Trainable{
    void train();
    default void teachTheseLessons(){
        System.out.println("Train them to do this");
    }
}
/* Test it with only Teachable, what happens when both it implements both interface
compile error stating inherits default methods i.e.has same method signature so either
remove one interface or override default method.
 */
public class TestDefaultMethods implements Teachable,Trainable{
    // we implement teach and call the default method
    public void teach() {
        teachTheseLessons();
    }

    // we implement train for later use
    public void train(){
        System.out.println("Everyone can be trained to get up early");
    }
    // default method override
    @Override
    public void teachTheseLessons() {
        Teachable.super.teachTheseLessons();
        System.out.println("Everyone should learn math and science");
    }

    public static void main(String[] args) {
        TestDefaultMethods t = new TestDefaultMethods();
        t.teach();
        t.train();
    }
}
