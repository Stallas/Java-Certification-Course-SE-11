package Inheritance.Polymorphism;

import java.util.Arrays;

/*
    Section 9: Reusing Implementations Through Inheritance
    Topic: 13. Utilize polymorphism to cast and call methods
    Sub-Topic: Array casting and generics.
 */
public class CastExtras {
    // Just want a few classes to play with

    static class BaseClass{
        String name = "Base case";
        public String toString(){
            return getClass().getName();
        }
    }

    static class NextClass extends BaseClass{
        String name = "Next Base case";
    }

    // main method , we'll test out some more casting examples
    public static void main(String[] args) {

        // Let's create the most generic of arrays
        Object[] myObjectArray = new Object[10];
        Arrays.fill(myObjectArray,new NextClass());

        // Ypu can put any object in there
        myObjectArray[5] = new StringBuilder("test");
        System.out.println(myObjectArray.getClass().getTypeName());
        System.out.println(Arrays.toString(myObjectArray));

        /*
        We are going to loop through our array and cast each object first to a
        NextClass to print the name attribute on NextClass, and then we cast to BaseClass to
        print the name attributes on the BaseClass.
         */
        try{
            for(Object o:myObjectArray){
                // Cast to most specific class
                NextClass n = (NextClass) o;
                System.out.println(n.name);
                // Cast to less specific class
                BaseClass b = (BaseClass) o;
                System.out.println(b.name);
            }
        }
        catch (Exception e){
            // Not to mention any object might be in your array....
            e.printStackTrace(System.out);
        }

        // Next we'll create an array of mixed types, using the common denominator BaseClass
        // where first 3 items are filled with Next class followed by Base class.
        BaseClass mixedArray[] = new BaseClass[6];
        Arrays.fill(mixedArray,0,3,new NextClass());
        Arrays.fill(mixedArray,3,6,new BaseClass());
        System.out.println(Arrays.toString(mixedArray));

        for(BaseClass b:mixedArray){
            // We can cast if we want NextClass's more specific name...
            System.out.println( b + ":"+((b instanceof NextClass) ? ((NextClass)b).name:b.name));
        }

        /*
        Compiler let's you get away with it, it's feasible that mixedArray could be populated with
        objects of its subtype only. But JVM won't allow it.
         */
        NextClass[] nextArray = (NextClass[]) mixedArray;
        System.out.println(Arrays.toString(nextArray));

        // let's actually fill it just with NextClass Objects...
        Arrays.fill(nextArray,new NextClass());
        System.out.println(Arrays.toString(nextArray));

        // JVM still doesn't allow it.
        NextClass[] nextArray2 = (NextClass[]) mixedArray;
        System.out.println(Arrays.toString(nextArray2));


    }

}
