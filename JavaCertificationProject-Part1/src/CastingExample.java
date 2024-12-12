public class CastingExample {
    public static void main(String[] args) {

        // Set up some local variables. Note that s2 is a short.
        short s2;
        int loopIterations = 0;

        int minValue = Short.MIN_VALUE-1; // our loop condition variable is an int, so this widening
        int maxValue = Short.MAX_VALUE+1;

        // we are forcing the for loop to stay in the valid range of a short
        for(int i = minValue; i <= maxValue ; i++){

            // We know because of the way we've written the code that will never be outside the range of
            // a short, so we confidently cast i to s2 as a short.
            s2 = (short) i; // we cast an int to a short

            //
            if( i == minValue) System.out.println("minimum short value = "+ s2);
            if( i == maxValue) System.out.println("maximum short value = "+ s2);

            callAMethodWithParameter((loopIterations + 1),s2);
            loopIterations++;
        }
        System.out.println("loopIterations = "+loopIterations);
    }

    private static void callAMethodWithParameter(int i, short s){
        // Do something here with your short that would not do with an int or long for eg

        // Really only want this to print once, though it's called in a loop...
        if(s == Short.MAX_VALUE) System.out.println("Iteration "+ i+"had the max value,my type is Short");
    }
}
