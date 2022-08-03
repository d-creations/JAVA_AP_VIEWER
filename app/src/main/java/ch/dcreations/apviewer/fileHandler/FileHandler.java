package ch.dcreations.apviewer.fileHandler;

import ch.dcreations.apviewer.config.Print;
import ch.rcreations.stepdecoder.Step3DModel;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
public class FileHandler {

    private static File file;
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    private final Step3DModel step3DModel;
        private final Stage stage;

    /**
     * File Handler to take a step file and decode it
     * @param stage is need for the File Open procedure
     * @param step3DModel the step Model
     * @throws IOException if the file selection was failed
     */
    public FileHandler(Stage stage, Step3DModel step3DModel) throws IOException {

        this.step3DModel = step3DModel;
        this.stage = stage;

    }


    /**
     * Ask the user to Select a File
     * @throws IOException when the file selection failed
     */
    public void getAFile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(stage);
        if (file == null) {
            throw new IOException("file not found");
        }
        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
            step3DModel.parseTheFile(reader);
        } catch (FileNotFoundException e) {
            Print.printError("File not found: " + e.getMessage());
        } catch (IOException e) {
            Print.printMessage("IO Error: " + e.getMessage());
        }
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
            Print.printError("File not found: " + e.getMessage());

        } catch (IOException e) {
            Print.printMessage("IO Error: " + e.getMessage());
        }
        // neu Datei Schreiben
        try {
            Files.delete(file.toPath());
            Files.copy(tempPath, file.toPath());
        } catch (IOException e) {
            Print.printMessage("Error write temp");
            e.printStackTrace();
        }
    }

    /**
     * Safes a file
     * @param text text
     */
    public void saveToNewFile(String text) {
        FileChooser fileChooser = new FileChooser();
        File saveFile = fileChooser.showSaveDialog(stage);
        try(Writer writer = new OutputStreamWriter(new FileOutputStream(saveFile))) {
             // variable to hold a value
            for (byte charValue : text.getBytes()){
                // read next char from file
                 // if not end of file
                writer.write(Character.toString(charValue)); // write char value to console
            }
        }catch(FileNotFoundException e) {
            Print.printMessage("File not found: " + e.getMessage());
        }
        catch(IOException e) {
            Print.printMessage("IO Error: " + e.getMessage());
        }

    }

    private static void addText(String text, Writer writer, Reader reader) throws IOException {
        int charValue; // variable to hold a value
        do {
            charValue = reader.read(); // read next char from file
            if (charValue != -1) // if not end of file
                writer.write(charValue); // write char value to console
        } while (charValue != -1); // reached end of file ?
    }

    public  String readText() throws IOException {
        Reader reader = new InputStreamReader(new FileInputStream(file)) ;
        int charValue; // variable to hold a value
        StringBuilder ret = new StringBuilder();
        do {
            charValue = reader.read(); // read next char from file
            if (charValue != -1) // if not end of file
                ret.append(Character.toString(charValue)); // write char value to console
        } while (charValue != -1); // reached end of file ?
        return ret.toString();
    }


    public String getFileName(){
        return file.getName();
    }


    public Step3DModel saveToFile(String text) {
        Step3DModel step3DModel1 = new Step3DModel("");
        try(Writer writer = new OutputStreamWriter(new FileOutputStream(file))) {
            // variable to hold a value
            for (byte charValue : text.getBytes()){
                // read next char from file
                // if not end of file
                writer.write(Character.toString(charValue)); // write char value to console
            }
        }catch(FileNotFoundException e) {
            Print.printMessage("File not found: " + e.getMessage());
        }
        catch(IOException e) {
            Print.printMessage("IO Error: " + e.getMessage());
        }
        try (Reader reader = new InputStreamReader(new FileInputStream(file))) {
            step3DModel1.parseTheFile(reader);
        } catch (FileNotFoundException e) {
            Print.printError("File not found: " + e.getMessage());
        } catch (IOException e) {
            Print.printMessage("IO Error: " + e.getMessage());
        }
        return step3DModel1;
    }
}
