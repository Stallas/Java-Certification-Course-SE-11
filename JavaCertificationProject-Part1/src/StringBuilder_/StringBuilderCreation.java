package StringBuilder_;
/*
    Topic: Create and Manipulate Strings
    Topic : StringBuilder
    Sub-Topic:1. Creation and Capacity
 */
public class StringBuilderCreation {
    public static void main(String[] args) {

        /*
        Creates a empty builder .
        An empty StringBuilder always has initial capacity of 16
        When SB is full, then (previouscapacity + 1)*2
         */
        StringBuilder sb = new StringBuilder();
        // adds 5 characters at the beginning of string
        sb.append("hello");
        System.out.println("sb.length() = "+sb.length());
        System.out.println("sb.capacity() = "+sb.capacity());

        StringBuilder sb2 = new StringBuilder("hello");
        // capacity is the initial capacity of (16) + "Hello".length
        System.out.println("sb2.length() = "+sb2.length());
        System.out.println("sb2.capacity() = "+sb2.capacity());

        StringBuilder sb3 = new StringBuilder();
        // Add 26 characters at the beginning of string , which exceeds the initial capacity of 16
        sb3.append("abcdefghijklmnopqrstuvwxyz");
        System.out.println("sb3.length() = "+sb3.length());
        System.out.println("sb3.capacity() = "+sb3.capacity());

        // You can set the initial capacity manually
        StringBuilder sb4 = new StringBuilder(26);
//        System.out.println("sb4.capacity() = "+sb4.capacity());
        // Add 26 characters at the beginning of string , which exceeds the initial capacity of 16
        sb4.append("abcdefghijklmnopqrstuvwxyz");
        System.out.println("sb4.length() = "+sb4.length());
        System.out.println("sb4.capacity() = "+sb4.capacity());
//        sb4.append("h");
//        System.out.println("sb4.capacity() = "+sb4.capacity());
    }
}
