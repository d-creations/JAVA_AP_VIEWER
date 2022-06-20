package ch.dcreations.apviewer.fileHandler;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FileHandler {

    private static File file;

    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    public FileHandler(Stage stage) throws IOException {
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(stage);
        if (file == null) {
            throw new IOException("file not found");
        }
    }


    public void getAFile() throws IOException {
        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
            readTheText(reader);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }

    private void readTheText(Reader reader) throws IOException {
        int charValue;
        do {
            charValue = reader.read(); // read next char from file
            System.out.print((char)charValue);
        } while (charValue != -1); // reached end of file ?
    }

    static public void insertLine(String text){
        Path tempPath = null;
        try {
            tempPath = Files.createTempFile("testfile", "txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert tempPath != null;
        File tempFile = new File(tempPath.toUri());
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(tempFile));
             Reader reader = new InputStreamReader(new FileInputStream(file))) {
            addText(text, writer, reader);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
        // neu Datei Schreiben
        try {
            Files.delete(file.toPath());
            Files.copy(tempPath, file.toPath());
        } catch (IOException e) {
            System.out.println("Error write temp");
            e.printStackTrace();
        }
    }

    private static void addText(String text, Writer writer, Reader reader) throws IOException {
        int charValue; // variable to hold a value
        do {
            charValue = reader.read(); // read next char from file
            if (charValue != -1) // if not end of file
                writer.write(charValue); // write char value to console
        } while (charValue != -1); // reached end of file ?
        writer.write(text+"\n");
        writer.write("sdfsfsadf");
    };


}
