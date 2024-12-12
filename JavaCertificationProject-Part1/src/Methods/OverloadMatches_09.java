package Methods;
/*
    Section 7: Creating and Using Methods
    Topic: Create Methods and Constructors
    Sub-Topic: 9. Overloaded Methods
 */
class OverloadEx{
    public String thisOne(Integer i){
        return "Integer matched";
    }
    public String thisOne(long i){
        return "long matched";
    }
    public String thisOne(short i){
        return "short matched";
    }
    public String thisOne(char... i){
        return "char matched";
    }
    // Adding a method with matching wrapper
    public String thisOne(Character i){
        return "Character matched";
    }
}
public class OverloadMatches_09 {
    public static void main(String[] args) {
        OverloadEx e = new OverloadEx();
        char c = 'a';
        System.out.println("Method (" +e.thisOne(c) + ") was executed for "+ c);

    }
}
