package NioPackage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


// Simple Read Operation using NIO Package
public class NIOExample {
    public static void main(String[] args) {
        Path filePath = Paths.get("/home/barath/Desktop/java/Basics/src/NioPackage/example.txt");
        try (FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int bytesRead;
            while ((bytesRead = fileChannel.read(buffer)) != -1) {
                buffer.flip(); // Switch to read mode

                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get()); // Print each character
                }

                buffer.clear(); // Switch to write mode
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
