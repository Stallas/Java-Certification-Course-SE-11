package String_;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Topic: Create and Manipulate Strings
    Sub-Topic:7. Searching Text
 */
public class TextSearch {
    public static void main(String[] args) {
        String fullText = "testwordtestwordtestword";

        // String below is so just there to help to see the index easier
        String showIndex = "012345678901234567890123456789";

        String searchString = "word";
        int lastIndex = fullText.lastIndexOf(searchString);
        System.out.println("lastIndex = "+ lastIndex);

        // last index with fromindex means it takes first 19 chars and checks in it
        lastIndex = fullText.lastIndexOf(searchString,19);
        System.out.println(" And now the lastIndex = "+ lastIndex);

        lastIndex = fullText.lastIndexOf(searchString,15);
        System.out.println(" And now the lastIndex = "+ lastIndex);

        // Matches uses regexp pattern matching, so will NOT match a substring
        // directly,unless it is a String
        String mississippi = "mississippi";
        boolean matches = mississippi.matches("miss");
        boolean indexMatch = (mississippi.indexOf("miss") > -1);
        System.out.println("matches method returns "+ matches + " on 'miss' But indexOf>-1 on" +
                " 'miss' = "+ indexMatch);

        // Let's try the whole string now...
         matches = mississippi.matches("mississippi");
        System.out.println("matches method matches on the entire string "+ matches);

        // Why is it useful then? You can match on a partial string.
        //If using regexp expressions surrounding substring

        // Code below matches "miss" at he beginning of the string .
        // Note that (.*) which matches to anything after "miss"
        matches = mississippi.matches("^miss(.*)");
        System.out.println("matches method returns  "+matches + " on '^miss(.*)'");

        /*
            Code below matches "iss" in the middle of a string.
            Note that (.*) which matches all/nothing before/after "miss"
         */
        matches = mississippi.matches("(.*)iss(.*)");
        System.out.println("matches method returns  "+matches + " on '(.*)iss(.*)'");

        // We can use Pattern & Matcher to do same thing...
        Pattern p = Pattern.compile("(.*)miss(.*)");
        Matcher m = p.matcher("mississippi");
        System.out.println("Pattern & Matcher give same result, matches on ''(.*)miss(.*)' = "+
                m.matches());

        // Region Matches, exact case, exact substring
        System.out.println(mississippi.regionMatches(0,"miss",0,4));
        // Region Matches, ignore case, exact substring
        System.out.println(mississippi.regionMatches(true,0,"MISS",0,4));
        // Looks for "miss" starting at index 1 in mississippi, no match found
        System.out.println(mississippi.regionMatches(1,"miss",0,4));
        // Looks for "iss" starting at index 2 in mississippi, no match found
        System.out.println(mississippi.regionMatches(2,"miss",1,3));
        // Looks for "iss" starting at index 4 in mississippi, no match found
        System.out.println(mississippi.regionMatches(4,"miss",1,3));
    }
}
