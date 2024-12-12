package String_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringJoiner;

/*
    Topic: Create and Manipulate Strings
    Sub-Topic:8. Splitting and joining strings
 */
public class StringSpliceAndDice {
    public static void main(String[] args) {

        String[] wordArray = new String[]{"hello","world","how","are","you ?"};
        ArrayList<String>  wordList = new ArrayList<>(Arrays.asList(wordArray));

        // public String concat(String str)

        String sentence = "";
        for (String word: wordArray) {
            sentence += word;
        }

        System.out.println("Our sentence using concat: "+sentence);

        // You can use join with a variable list of CharSequence elements ..
        sentence = String.join(" ","hello","world","how","are","you ?");
        System.out.println("Our sentence using join,variable list of string: "+sentence);

        // You can use join with iterable elements, such as array of string
        sentence = String.join(" ",wordArray);
        System.out.println("Our sentence using join, Array of String: "+sentence);

        // You can use join with iterable elements, such as list of string
        sentence = String.join(" ",wordList);
        System.out.println("Our sentence using join, list of String: "+sentence);

        // StringJoiner introduced in Java 8 as well..
        StringJoiner sj = new StringJoiner(" ");
        for (String word:wordArray) {
            sj.add(word);
        }
        System.out.println("Our sentence using String Joiner = " +sj.toString());

        // Following code demonstrates :
        // public String[] split(String regEx)
        // First make sure our sentence is delimited by space to test

        sentence = String.join(" ",wordList);
        String[] splitWords = sentence.split(" ");
        System.out.println("Arrays.toString(splitWords)"+Arrays.toString(splitWords));

        // first create a sentence with multiple white space
        sentence = String.join("\u0020\t\u0020\n",wordList);
        System.out.println("Our sentence with spaces tabs carriage return is "+ sentence);

        // regex to split any whitespace
        splitWords = sentence.split("\\s+");
        System.out.println("Arrays.toString(splitWords)"+Arrays.toString(splitWords));

        sentence = String.join(" ",wordList);
        splitWords = sentence.split(" ",2);
        System.out.println("Arrays.toString(splitWords)"+Arrays.toString(splitWords));



    }
}
