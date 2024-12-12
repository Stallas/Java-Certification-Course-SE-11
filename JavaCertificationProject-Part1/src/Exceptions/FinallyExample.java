package Exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
Section 11: Handling Exception
Topic: Describe Exception Handling and types of exceptions
Sub-Topic: Try/Catch/Finally
S1: Execute ,S2: Create FinallyProperties.txt and execute, S3: Change split 1 to 2,
S4: have IndexOutOfBoundException, S5:Create AnotherProperties.txt and using Split[2] leads to RTE
 */
public class FinallyExample {
    public static void main(String[] args) {
        FinallyExample fex = new FinallyExample();
        try {
            System.out.println("Outer try block starts here....");
            String property = fex.getPropertyFromFile("FinallyProperties.txt");
        }catch (IOException | ArrayIndexOutOfBoundsException io){
            System.out.println("Outer catch exception block starts here....");
            try{
                //Retry;
                System.out.println("Inner try block attempts retry....");
                String property = fex.getPropertyFromFile("AnotherProperties.txt");
            }
            catch (IOException e) {
                System.out.println("Outer catch exception block starts here....");
            }
        }
    }

    private String getPropertyFromFile(String fileName) throws IOException {
        String property;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try{
            String line = br.readLine();
            property = line.split("\\s")[1];// Change to 2 for S3 results in IndexOutfBoundException
            System.out.println("Property value = "+property);
        } finally {// Cleaning resources such as closing file.
            if(br != null) br.close();
        }
        return property;
    }
}
