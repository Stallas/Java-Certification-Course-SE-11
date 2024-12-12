/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Using Files to create, read from, write to, and delete files.
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FilesManagement {
    public static void main(String[] args) {

        // Create a path to a file in current working directory;
        // This file was created in example above
        Path testFile = Path.of("TestingFile.txt");
        try {
            // Use Files.readAllLines to open a file, read all lines
            // and close the file.
            System.out.println("Read each line of a file");
            List<String> fileLines = Files.readAllLines(testFile);
            fileLines.forEach(System.out::println);

            // Use Files.readAllBytes to open a file, read all data
            // and close the file.
            System.out.println("Read entire file into byte array");
            byte[] byteArray = Files.readAllBytes(testFile);
            System.out.println(new String(byteArray));

            // Use first line of previous file to create a new file
            Path byteFile = Path.of(fileLines.get(0).split("\\s")[1] + ".txt");

            System.out.println("Creating " + byteFile);
            // Write bytes to this file, creating a new file each time.

            try {
                // Exception occurs if file already exists
                Files.write(byteFile, "Secret sauce".getBytes(),
                        StandardOpenOption.CREATE_NEW);
            } catch (IOException e) {
                System.out.println(e);
                Files.write(byteFile, "Secret sauce".getBytes(),
                        StandardOpenOption.CREATE);// does not throw exception if it exists...

            }

            Path byteFile2 = Path.of(fileLines.get(1).split("\\s")[1] + ".txt");

            System.out.println("Creating " + byteFile2);
            // Write bytes to file, truncating data in file if it exists
//            Files.write(byteFile2, "Extra secret sauce\n".getBytes(),
//                    StandardOpenOption.CREATE,
//                    StandardOpenOption.TRUNCATE_EXISTING);

//  line written overwrites the existing file and subsequent writes using APPEND added those lines to the file.
            Files.write(byteFile2, "Extra secret sauce1\n".getBytes(),
                    StandardOpenOption.CREATE);
//            Files.write(byteFile2, "Extra secret sauce\n".getBytes(),
//                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            // Write a String to file, but do not append it
            Files.writeString(byteFile2, "Secret Ingredient OneTwoThree\n",
                    StandardOpenOption.WRITE);

            // Write a String to file, appending it
            Files.writeString(byteFile2, "Secret Ingredient One\n",
                    StandardOpenOption.APPEND);

            System.out.println("Appending to " + byteFile2);
            Files.writeString(byteFile2, "Secret Ingredient Two\n",
//                    StandardOpenOption.DELETE_ON_CLOSE, // this command deletes the file
                    StandardOpenOption.APPEND);

//            Files.writeString(byteFile2, "Secret Ingredient Two\n",
//                    StandardOpenOption.READ);// java.lang.IllegalArgumentException: READ not allowed
//            Files.writeString(byteFile2, "Secret Ingredient Two\n",
//                    StandardOpenOption.APPEND,StandardOpenOption.TRUNCATE_EXISTING); // java.lang.IllegalArgumentException: APPEND + TRUNCATE_EXISTING not allowed

//            Files.newInputStream(byteFile,StandardOpenOption.WRITE);//Exception in thread "main" java.lang.UnsupportedOperationException: 'WRITE' not allowed
//            Files.newInputStream(byteFile,StandardOpenOption.APPEND);//Exception in thread "main" java.lang.UnsupportedOperationException: 'APPEND' not allowed
        } catch (IOException io) {
            System.out.println(io);
        }
    }
}