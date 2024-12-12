package modular;
/*
Section 12: Understanding modules
Topic: Describe how a modular project is compiled and run.
1.Run in usual way, we observe classpath in our command line means we aren't executing a module.
2.Right click on src and create a module-info.java and now it execute the program ... It runs as a module
we see -p and -m means path and module in command line.
3. Manually execute the code from command-line..
out/production directory --> where our compiled classes are present.This should have either directories or
jar files..here, we have module-info.class file
Right click ModuleTesting and open the terminal.
java --module-path out\production\ -m MyFirstModule
Throws this module doesn't have ModularMainClass attribute, use -m <module>/<main-class>

java --module-path out\production\ -m MyFirstModule/module.HelloWorld
Runs successfully printing the output.

This creates a jar file.
java --module-path out\production\ -m MyFirstModule/module.HelloWorld -C out\production\MyFirstModule\ .

To examine the jar:
    jar -f MyFirstModule.jar --list
To describe the jar: (Note that even our module is in current directory we have to describe path in case of java cmd)
    jar -f MyFirstModule.jar -d  or java --modular-path --describe-module MyFirstModule

exit the terminal and type below:
java -p.-d MyFirstModule --> This shows that java.base mandated and contains modular.

jdeps MyFirstModule.jar --> view via jdep
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello new modular world");
    }
}
