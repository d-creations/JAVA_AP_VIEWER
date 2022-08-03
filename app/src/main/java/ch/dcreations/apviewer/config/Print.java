package ch.dcreations.apviewer.config;
/**
 * <p>
 * <p>
 *  Print function that can be set do DEBUG
 * <p>
 *
 * @author Damian www.d-creations.org
 * @version 1.0
 * @since 2022-08-03
 */
public class Print {
    private final static boolean DEBUG = false;


    static public void printMessage(String text) {
        if (DEBUG) System.out.println(text);
    }

    static public void printError(String text) {
        if (DEBUG) System.out.println(text);
    }
}
