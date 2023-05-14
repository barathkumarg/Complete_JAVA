package Streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * File stream to read and write the files
 */



public class Readingfile {
    public static void main(String[] args) {

        int i; // indicated the code where file content.
        FileInputStream fin = null;

        try {
            fin = new FileInputStream("/home/barath/Desktop/java/Basics/src/Streams/Text.txt");

            do {
                i = fin.read(); //read the content in binary
                System.out.println((char) i); //print the content in character

            } while (i != -1);

        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException e1) {
                System.out.println("Unable to close");
            }
        }


    }


}