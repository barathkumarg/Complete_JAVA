package Streams;

import java.io.*;

public class Bufferreader {


    public static void main(String[] args) throws IOException {
        char chr;
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // integrate the inputstream with buffer
        System.out.println(br);
        do {
           // chr = (char) br.read(); // read character wise
            str = br.readLine();
            System.out.println(str);


        }while (!str.equals("stop"));
    }
}
