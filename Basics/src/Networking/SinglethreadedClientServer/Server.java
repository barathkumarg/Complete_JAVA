package Networking.SinglethreadedClientServer;

/*
Networking involves sockets TCP ,UDP Connection , here using sockets
Here creating the client - server application to communicate between them

Single threaded can send one request at a time


Functionality here is the thread will go sleep for 1 sec after getting the client request

here in single threaded approach on 6 th request the process hangs while in multithreaded approach it is not.
*/


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        //request counter to count request
        int request_count = 1;

        System.out.println("Started server and listening ....");


        //creating the serversocket to listen the client connections
        ServerSocket serversocket = new ServerSocket(9999);

        //continously receive the request
        while(true) {

            System.out.println("Waiting for client connection ....");

            //Create the socket to process the client request as server accept the connection
            Socket socket = serversocket.accept();

            //streams to read and write
            InputStream inputstream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            byte buffer[] = new byte[1024];
            inputstream.read(buffer);

            System.out.println("Request: " + request_count + " "+new String(buffer).trim());



            // Block condition for the 6 th request intentionally created
            if (request_count == 6) while(true);

            //Core do functionality
            Thread.sleep(1000); // --> do operation from server side can be any business logic to

            //pass message ack to client
            outputStream.write("I am response to client".getBytes());

            //increment the conter
            request_count++;

            //close the socket alone current request
            socket.close();

            //end loop when on 100 th request
            if (request_count == 10) break;
        }

        //close the  socketserver
        serversocket.close();






    }
}
