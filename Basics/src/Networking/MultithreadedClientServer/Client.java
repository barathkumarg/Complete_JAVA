package Networking.MultithreadedClientServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {


        //Starting the timer
        long begin = System.currentTimeMillis();

        //send the 10 request

            System.out.println("Started sending request  ....");

            //Create the socket connection
            Socket socket = new Socket("127.0.0.1", 9999);

            //creating the streams to communicate
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            //send message to server
            outputStream.write("I am request to server".getBytes());

            //receive the message from server
            byte[] response = new byte[1024];
            inputStream.read(response);

            System.out.println("Request: " + " "+new String(response).trim());

            //close the socket
            socket.close();

        //end the timer
        long end = System.currentTimeMillis();
        System.out.println("Time taken "+ (end-begin) + " ms");

    }
}



