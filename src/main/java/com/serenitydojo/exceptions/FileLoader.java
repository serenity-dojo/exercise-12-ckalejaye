package com.serenitydojo.exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import static java.nio.file.Files.*;

public class FileLoader {

       public static String readHelloWorld(String filename) throws IOException {
       String fileContents = Files.readString(Paths.get(filename));
         return readHelloWorld(fileContents);

      }

    public boolean fileContainsText(String filename, String expectedText) {

        try {
 //           String path = "src/main/resources/" + filename;
            String fileContents = Files.readString(Paths.get(filename));
            return (readString(Paths.get(filename)).contains(expectedText));
        } catch (IOException e) {
            return true;
        }
    }


    public boolean fileDoesNotContainsText(String filename, String expectedText) {

        try {
            //           String path = "src/main/resources/" + filename;
            String fileContents = Files.readString(Paths.get(filename));
            return (readString(Paths.get(filename)).contains(expectedText));
        } catch (NoSuchFileException e) {
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean fileHasText(String filename, String expectedText) {
        String path = "src/main/resources/" + filename;
        try {
            return (readString(Paths.get(path)).contains(expectedText));
        } catch (IOException e) {
            throw new MissingWelcomeFileException("Missing welcome file: " + filename, e);
        }
    }
 }
