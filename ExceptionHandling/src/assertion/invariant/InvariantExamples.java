/*
The Learn Programming Academy
Java SE 11 Developer 1Z0-819 OCP Course - Part 2
Section 2: Exception Handling and Assertions
Topic:  Using assertions
*/

package assertion.invariant;

import java.util.ArrayList;
import java.util.Arrays;

public class InvariantExamples {

    // 4 pet types supported
    private enum PetType {
        DOG, CAT, HAMSTER, GERBIL, PARROT
    }

    public static void main(String[] args) {
        InvariantExamples ex = new InvariantExamples();
        // Print formulary for each pet type
        for (PetType pt : PetType.values()) {
            // Check baby animal description...
            System.out.println("A juvenile " + pt + " is called a " +
                    ex.getPetTypeAgeDescription(pt, 0));
        }
    }

    //  Method demonstrates assertion for a Control-Flow invariant
    private String getPetTypeDietaryNeeds(PetType petType) {
    // Add/Remove enum Parrot and test this method
        switch (petType) {
            case DOG:
                return "Some formulary for dog";
            case CAT:
                return "Some formulary for cat";
            case HAMSTER:
                return "Some formulary for hamster";
            case GERBIL:
                return "Some formulary for gerbil";
            default:
                // --- Control-Flow invariant assertion ----
                // Assumption: code not reachable, all types referenced above
                assert false : "Formulary does not exist for " + petType;
        }
        return null;

    }

    // Examples of pre and post condition invariants and internal invariant
    public String getPetTypeAgeDescription(PetType petType, int petAge) {
        // public methods should include tests for validity of data  passed
        if (petAge < 0) throw new IllegalArgumentException("Age cannot be negative"); // assuming assertions are disabled by default.

        // **Bad Practice: Assertion to check validity of public method parameters
        assert petAge >= 0;

        String description = "ADULT";

        if (petType == PetType.CAT || petType == PetType.DOG) {
            if (petAge > 7) description = "SENIOR";
            else if (petAge < 1)
                description = (petType == PetType.CAT) ? "KITTEN" : "PUPPY";
        }
        // Add else if section for PARROT
        else if (petType == PetType.PARROT) {
            if (petAge > 45) description = "SENIOR";
            else if (petAge < 1) description = "CHICK";
        }
        // Catch all for everything else
        else {
            // ** Internal Invariant Assertion
            // Assumes if pet not CAT/DOG, must be GERBIL/HAMSTER
            assert (petType == PetType.GERBIL || petType == PetType.HAMSTER);

            if (petAge > 3) description = "SENIOR";
            else if (petAge < 1)
                description = "PUP";
        }

        // ** Good Practice:  Post-Condition Assertion case1
        assert (new ArrayList(Arrays.asList(
                new String[]{"ADULT", "SENIOR", "KITTEN", "PUPPY", "PUP"})).
                indexOf(description) > -1) : "No Description exists for " +
                petType + " age " + petAge;

        // problem here is if assertions aren't enabled then, A juvenile PARROT is called a PUP
        // which is incorrect.... so Add else if section for PARROT...

       /* case2
       Comment the above assert and include this part. Purpose of this code is
       it is bad practice to create objects i.e.assertArrayList only for assert statements
       because the outputs from both the code snippets are same when assertions are disabled..
        // Creating data just for assertion (not contained in assertion)
        ArrayList assertArrayList = new ArrayList(Arrays.asList(
                new String[]{"ADULT", "SENIOR", "KITTEN", "PUPPY", "PUP", "CHICK"}));
        // ** Good Practice: Post-Condition Assertion
        assert(assertArrayList.indexOf(description) > -1) :
                "No Description exists for "+ petType + " age " + petAge;
        */
        /* case3: outputs of petage will be different when assertions are enabled/disabled...comment case1 and execute.

        assert (new ArrayList(Arrays.asList(
                new String[]{"ADULT", "SENIOR", "KITTEN", "PUPPY", "PUP"})).
                indexOf(description) > -1 && petAge++ == 0): "No Description exists for " +
                petType + " age " + petAge;
         System.out.print("petAge (" + petAge + ") : "); //petage is 1 when assertions enabled else 0 .This could possibly change the output in live environment.
         */
        return description;
    }
}