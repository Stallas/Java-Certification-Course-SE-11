package Exceptions;

import java.io.FileInputStream;
import java.io.IOException;

/*
Section 11: Handling Exception
Topic: Describe Exception Handling and types of exceptions
Sub-Topic: Try/Catch
S1: just 3 statements, S2: Enclose in try/catch, S3: create a method s4: change divisor 0->1
S5: multiple catch
 */
public class TryCatchExamples {
    public static void main(String[] args) {
        /*
        try{
            System.out.println("Statement 1 is just fine");
//            System.out.println("Statement 2 will cause the error "+ (2/0));
            //S2 :Now , enclose it in try/catch ,it effectively hids the error.
            try{
                System.out.println("Statement 2 will cause the error "+ (2/0));
            }
            catch (RuntimeException re){

            }
            System.out.println("Statement 3 is just fine");
        }
        catch (Throwable t){
            t.printStackTrace(System.out);
            printErrorStructure(t);
        }*/
       /* //S3 & S4
        TryCatchExamples te = new TryCatchExamples();
        te.printThreeStatements("Before Try Block",0);// Here, the execution gets
        // completely stopped since we have declared outside of try/catch block.(Change 0 -> 1)
        try{
           te.printThreeStatements("In Try Block",0);
        }
        catch (Throwable t){
            t.printStackTrace(System.out);
            printErrorStructure(t);
        }
        te.printThreeStatements("After Try Block",0);
        */
        TryCatchExamples te = new TryCatchExamples();
        te.printThreeStatements("Before Try Block",1);
        try{
            FileInputStream fis = new FileInputStream("ApplicationProperties.txt");
        }
        catch (IOException ie){
            System.out.println("Maybe I want to do something specifically, like" +
                    " populate data as a default if file was properties file "+ (5/0));
            // the execution gets stops here because of uncaught error thrown at IOException,
            //though it is handled by catch(runtimeexe) defined or not.catch blocks are mutually exclusive.
        }
        catch (Throwable t){
            t.printStackTrace(System.out);
            printErrorStructure(t);
        }

    }
    // This method will just print the hierarchy of the exception
    public static void printErrorStructure(Object o) {
        Class parent = o.getClass();
        String prefix = "";
        System.out.println("Error caught was: ");
        do{
            System.out.println(prefix + " "+ parent.getName());
            prefix += "--";
            parent = parent.getSuperclass();
            if(parent == null) break;
        }
        while (parent.getSuperclass() != null);
    }

    private void printThreeStatements(String section, int divisor){
        System.out.println(section + ": Statement 1 is just fine");
        System.out.println(section + ": Statement 2 will cause the error "+ (2/divisor));
        System.out.println(section + ": Statement 3 is just fine");
    }
}
