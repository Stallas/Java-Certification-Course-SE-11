// Create a class with a method marked as deprecated
public class HasDeprecatedMethod {

   /* using javadoc tag @deprecated
    @deprecated as of release 1.2, replaced by @link #dothat();
    */
    // Using annotation @Deprecated
//    @Deprecated
    @Deprecated(
            since = "1.3",
            forRemoval = true
    )
    public void doThis(){
        System.out.println("Doing this");
    }

    public void doThat() {
        System.out.println("Doing that");
    }

    @Deprecated(since = "1.5")
    public void doThisAlso() {
        System.out.println("Doing this also");
    }
}

class JavaLangAnnotation{
    @SuppressWarnings({"deprecation","removal"})
    public static void main(String[] args) {
        HasDeprecatedMethod hasDeprecatedMethod = new HasDeprecatedMethod();
        // Deprecated method usage...
        hasDeprecatedMethod.doThis(); // Same as below comment.
        hasDeprecatedMethod.doThisAlso(); // we get strike out error if we dont include deprecation in suppresswarnings
    }
}
