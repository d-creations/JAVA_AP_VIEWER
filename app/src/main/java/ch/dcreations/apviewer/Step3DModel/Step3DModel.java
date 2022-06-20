package ch.dcreations.apviewer.Step3DModel;

import java.io.IOException;
import java.io.Reader;

public class Step3DModel {


    public void parseTheFile(Reader reader) throws IOException {
        int charValue;
        System.out.println("The Drawing From Damian ");
        do {
            charValue = reader.read(); // read next char from file
            System.out.print((char)charValue);
        } while (charValue != -1); // reached end of file ?
    }

}
