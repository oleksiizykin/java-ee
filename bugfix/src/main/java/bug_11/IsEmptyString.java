package bug_11;

/**
 * uncommented this piece of code
 *
 * remember for min changes
 */
public class IsEmptyString {
    private /*final*/ static String CUSTOM_DEFAULT_VALUE;// not initialize it in declaration

    public static void main(String[] args) {

        /*alt+shift+F10 + Edit line "Program arguments = "" "*/
        if (args[0].equals(CUSTOM_DEFAULT_VALUE)) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }
    }
}
