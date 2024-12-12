package Interface;
/*
Section 10: Programming Abstractly Through Interfaces
Topic:3. Create and implement interfaces
 */

// Very simple interface with one method
interface Laughable{
    void laugh();
}

// A class that implements the interface
class Joke implements Laughable{
    @Override
    public void laugh() {
        System.out.println("That joke is laughable.");
    }
}
// A class that does not implement the interface i.e. concrete class
class Story{
    public void read(){
        System.out.println("This story is a good read.");
    }
}
// A class that extends Story class and implements interface
class FunnyStory extends Story implements Laughable {
    // implements laugh() method from laughable
    public void laugh() {
        System.out.println("That story is funny.");
    }
    // overrides read() method from Story
    public void read() {
        System.out.println("That story is good giggle.");
    }
}

//  class Farce will be both a Story and laughable
class Farce extends Story implements Laughable{
    @Override
    public void laugh() {
        System.out.println("That story is funny in a farcical way.");
    }
}
public class InterfaceCast {
    public static void main(String[] args) {
        Story story = new Story();
//        Story story = new Farce(); //Uncomment it when casting method invoked.
        FunnyStory funnyStory = new FunnyStory();
        Joke joke = new Joke();

        // call pass through method on different types of objects
        testLaughable(joke);
        testLaughable(funnyStory);

        // call pass through method on different types of objects
        testStory(story);
        testStory(funnyStory);

        // Cast objects and pass to our methods
        /*
         Here, Story class doesn't extend or implements the Laughable class
         but there is no compiler error as compiler assumes that subclass of story
         might implement it. Rules being more restrictive for class than interface.
         Compiler might allow but JVM doesn't which results in
         class Interface.Story cannot be cast to class Interface.Laughable
         To avoid it Story story = new Farce();
         */
         testLaughable((Laughable) story);
//        testStory((Story)joke); Compiler error as joke class doesnt extend story class.
    }
    public static void testLaughable(Laughable l) {
        l.laugh();
    }
    public static void testStory(Story story) {
        story.read();
    }
}
