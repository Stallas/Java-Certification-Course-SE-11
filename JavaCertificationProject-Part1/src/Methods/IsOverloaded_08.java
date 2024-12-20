package Methods;
/*
    Section 7: Creating and Using Methods
    Topic: Create Methods and Constructors
    Sub-Topic: 8.IsOverloaded Methods
 */
class Load{
    public void bestMethod(int i){
        System.out.println("bestMethod for int");
    }
    // Add method for parameter Integer
    public void bestMethod(Integer i){
        System.out.println("bestMethod for Integer");
    }
    // Add method for parameter Number (Integer is a Number)
    public void bestMethod(Number i){
        System.out.println("bestMethod for Number");
    }
    // Add method for parameter Comparable (Integer implements Comparable)
    public void bestMethod(Comparable i){
        System.out.println("bestMethod for Comparable");
    }
    // Add method for parameter Object (Integer is of course an Object)
    public void bestMethod(Object i){
        System.out.println("bestMethod for Object");
    }
    // Add method for parameter with an int var args
    public void bestMethod(int... i){
        System.out.println("bestMethod for varargs(int)");
    }
    // Add method for parameter with an Integer var args
//    public void bestMethod(Integer... i){
//        System.out.println("bestMethod for varargs(Integer)");
//    }
}
public class IsOverloaded_08 {
    public static void main(String[] args) throws NoSuchMethodException {
        Load n = new Load();
        int myInt = 1;
        Integer myInteger = Integer.valueOf(1);
        n.bestMethod(myInt);
        n.bestMethod(myInteger);
        n.bestMethod((Number)myInteger);
        n.bestMethod((Comparable) myInteger);
        n.bestMethod((Object)myInteger);
        int[] a = new int[]{1,2};
        n.getClass().getMethod("bestMethod", a.getClass());
//        n.bestMethod(1,2,3,4); // commenting Integer varargs as getting compuler ambiguous method call.

        // hese are acceptable.
        n.bestMethod(new int[]{1,2});
        n.bestMethod(new Integer[]{1,2});
    }
}
