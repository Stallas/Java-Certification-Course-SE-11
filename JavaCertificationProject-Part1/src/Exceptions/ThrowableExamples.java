package Exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;

/*
Section 11: Handling Exception
Topic: Describe Exception Handling and types of exceptions
Sub-Topic: Review.. This is a generic example which didn't discriminate between Error or Exception,
or between the 2 significant categories of Exception, Checked and Unchecked.
Error,Runtime Exception --> Unchecked Exception --> no compile error(defined outside try/catch), catches exception on screen.
Checked Exception --> eg.filenotfoundException -->compile error(unhandled exception in try/catch block.)
 */
public class ThrowableExamples {
    public static void main(String[] args) {

        ThrowableExamples ts = new ThrowableExamples();
        String fileName = "This_File_Does_not_Exist.out";
       //ts.throwAnError(); // This verifies that IOError is a unchecked exception ...
//  no compiler error when not enclosed in try/catch but throws exception on screen. try same for fis.
        // try to open a file with filename defined above

//        FileInputStream fis = new FileInputStream(fileName);
        try{
            ts.throwAnError();
            FileInputStream fis = new FileInputStream(fileName);// compile error for checked exception
            // when not enclosed in try/catch block.

        }// This statement catches anything thrown at you.
        catch (Throwable error) {
            // Check to see if it's an IOException and print something..
            if(error instanceof IOException){
                System.out.println("Something went wrong with the processing of "+fileName);
            }
            printErrorStructure(error);
        }
    }

    // This method will print the hierarchy of the exception
    private static void printErrorStructure(Object o) {
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

    // Mocking an IOError...
    private void throwAnError() throws IOError{
        throw new IOError(new Throwable("Testing"));
    }
}
