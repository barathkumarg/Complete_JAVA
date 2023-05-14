package Streams;


/*
* File writing with try with resources that closing the file automatically and releasing the memory without finally
*Opening the file in fin , fout
*To get the contents from fin and push to fout
* */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writingfile {

    public static void main(String[] args) {

        int i ;
        try(FileInputStream fin = new FileInputStream("/home/barath/Desktop/java/Basics/src/Streams/Text.txt");
            FileOutputStream fout = new FileOutputStream("/home/barath/Desktop/java/Basics/src/Streams/dummy.txt")){

            do {
                i = fin.read();
                if (i!=-1) fout.write(i);

            }while(i != -1);
        }catch (IOException e){
            System.out.println("Files not found");
        }



    }
}
