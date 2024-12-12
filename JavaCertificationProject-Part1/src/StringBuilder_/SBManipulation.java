package StringBuilder_;
/*
    Topic: Manipulate Data With StringBuilder
    Sub-Topic:3. Append Methods
    deleteCharAt, delete, indexOf, reverse, substring checks the references
 */
public class SBManipulation {
    public static void main(String[] args) {

        // Create and initialize a StringBuilder object
        StringBuilder sb = new StringBuilder("World Hello, How are you ?");
        System.out.println("Original String = "+ sb);

        /*
        Delete the comma from String, use indexOf to retrive the index of string
         */
        System.out.println("sb.deleteCharAt(sb.indexOf(\",\") = "+ sb.deleteCharAt(sb.indexOf(",")));

        // Delete everything after the comma used to be
        System.out.println("sb.delete(11,sb.length()) = "+sb.delete(11,sb.length()));

        // Now reverse the entire String
        sb.reverse();
        System.out.println("sb after reverse method is called= "+sb);

        // You can assign a reverse method's to a different StringBuilder variable
        StringBuilder rb = sb.reverse();
        System.out.println("(sb == rb) =  "+ (sb == rb));

        // Now we have two StringBuilder references pointing to the same mutable text
        sb.append(" How are you ?");
        System.out.println("sb = "+sb);
        System.out.println("rb = "+rb);

        String substring = sb.substring(0,5);
        System.out.println("substring = "+substring);
        System.out.println("sb = "+sb);

    }
}
