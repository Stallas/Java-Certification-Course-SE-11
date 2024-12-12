/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 2: Exception Handling and Assertions
Topic:  try-with-resources
Sub-topic:  Suppressed Exceptions
*/

public class SeasonTest {

    public static void main(String[] args) {
        /* Note that when exception occurs in inner try block then
         inner try resources closes the conn and even  outer try block attempts to close the conn.
         So, first loop : both resources close prints stacktrace
         second loop : same as above
         finally , outer try closes the resources as well.
         */
        // First try-with-resources statement (basic)
        try (Season s = new Season(1)) {
            for (int i = 0; i < 2; i++) {
                // Nested try-with-resources statement
                // Extended - includes catch clause
                try (s;  // Passing the variable s for Season
                     Season.Episode e = s.new Episode(i + 1)) {
                    e.run();
                } catch (Exception ex) {
                    // This will print exception along with suppressed
                    // exception information
                    ex.printStackTrace(System.out);
                }
            }
        }
    }
}