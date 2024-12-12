/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 13:  I/O (Fundamentals and NIO2)
Topic: Path Basics
*/

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathBasics {

    // main method simply calls a method that shows multiple ways to
    // create Path instances
    public static void main(String[] args) {
        pathCreations();
        showData("");
        showData("characterData.txt");
        quiz();
    }

    // Method demonstrates many ways to create Path instances
    public static void pathCreations() {

        //--- Using Path as a reference to a directory

        // Path object to current working directory
        Path cwd = Paths.get("");
        System.out.println("cwd: "+cwd);
        System.out.println(cwd.toAbsolutePath());

        // Specifying a full path using windows back slashes
//        D:\Sri\New folder\JavaCert\IOProject
        Path currentdir = Paths.get("\\LearnProgrammingAcademy\\IOProject");
        System.out.println(currentdir.toAbsolutePath());

        // Using Paths.get with initial path as first argument and
        // remaining path as a single String, mixing back & forward slashes
//        Path cdir = Paths.get("C:\\LearnProgrammingAcademy",
//                "IOProject/out/production");
        Path cdir = Paths.get("D:\\Sri",
                "New folder/JavaCert/IOProject/out/production");
        System.out.println(cdir.toAbsolutePath());

        // Using Path.of to get a path using Strings
        Path cdir2 = Path.of("C:", "LearnProgrammingAcademy", "IOProject",
                "out", "production");
        System.out.println(cdir2.toAbsolutePath());

        //--- Using Path as a reference to a file

        // Use Paths.get to get a file reference with a URI
        Path filePath1 = Paths.get(URI.create(
                "file:///LearnProgrammingAcademy/IOProject/characterData.txt"));
        System.out.println(filePath1.toAbsolutePath());

        // FileSystems.getDefault() gives default file system object
        // which has a method getPath
        Path filePath2 = FileSystems.getDefault().getPath("C:",
                new String[]{
                        "LearnProgrammingAcademy",
                        "IOProject",
                        "characterData.txt"});
        System.out.println(filePath2.toAbsolutePath());
    }

    // Print Information about a Path object using path methods
    public static void showData(String pathName) {

        System.out.println("---- Path data for '" + pathName + "' ----");

        // Use the Paths.get factory method to obtain a Path object
        // and use toAbsolutePath method to get info
        Path path = Paths.get(pathName).toAbsolutePath();

        // Print out absolute path
        System.out.println("Absolute Path: " + path.toString() +
                "   [toString()]");

        // Get filename, in this case, current directory
        System.out.println("File/Dir of Path object: " +
                path.getFileName() + "   [getFileName()]");

        // Parent directory returned as a Path
        System.out.println("Parent Directory: " + path.getParent()
                + "   [getParent()]");


        // Get part of the path, using names
        System.out.println("Getting subpath: " + path.subpath(0, 2)
                + "   [subpath(0,2)]");

        // Number of sub directories in the path
        System.out.println("Number of Sub-Directories: " +
                path.getNameCount() + "   [getNameCount()]");

        // Use methods to 'draw' the directory structure
        System.out.println("Directory Structure using path.getName()");

        // Root directory returned as a path
        System.out.format("%s   [getRoot()]: %n", path.getRoot());
        for (int i = 0; i < path.getNameCount(); i++) {
            for (int j = 0; j <= i; j++) System.out.print("\t");

            // Note that getName returns a Path object
            System.out.println("---> " + path.getName(i) +
                    "   [getName(" + i + ")]");
        }

        System.out.println("Directory Structure using path iterator");
        // Alternately use the names iterator..
        int i = 0;
        for (Path name : path) {
            for (int j = 0; j <= i; j++) System.out.print("\t");
            System.out.println("---> " + name);
            i++;
        }
        System.out.println("------------------------------");
    }

   public static void quiz(){
       Path p = Path.of("c:/","test","root","f.txt");
       Path p1 = p.getParent().relativize(p);
       Path p2 = p.getName(0);
       Path p3 = p.subpath(2,3);

       System.out.println(p1 + " "+ p2 + " "+p3);
       //The relativize method could be rewritten as
       // Path.of("/test/root").relativize(Path.of("/test/root/f.txt"))
       /*
       It is important to note that getName(0) is not c:/ (the root) ,
       getName(0) returns the element closest to the root, test.*
       p.subPath(0,1) = test, p.subPath(1,2) = root, p.subPath(2,3) = f.txt
        */
   }
}