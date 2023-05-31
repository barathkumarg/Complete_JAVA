package Networking.MultithreadedClientServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/*
Multi thread client connection to accept the client connection in seperate thread so that request all are independent and server
will not hang due to it.

*/
class ServerThread extends Thread {

    Socket socket;
    int count;

    //Create the constructor to capture the socket
    ServerThread(Socket socket,int count) {
        this.socket = socket;
        this.count = count;
    }

    @Override
    public void run() {

        try {

            //Block condition intentionally for the 6 th request
            if (count == 6)while (true);

            //streams to read and write
            InputStream inputstream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            byte buffer[] = new byte[1024];
            inputstream.read(buffer);

            System.out.println("Request: " + " " + new String(buffer).trim());

            //Core do functionality
            Thread.sleep(1000); // --> do operation from server side can be any business logic to

            //pass message ack to client
            outputStream.write("I am response to client".getBytes());

            //close the socket alone current request
            socket.close();


        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }

    }
}



public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        //request counter to count request
        int request_count = 1;

        System.out.println("Started server and listening ....");


        //creating the serversocket to listen the client connections
        ServerSocket serversocket = new ServerSocket(9999);


        //continously receive the request
        while (true) {

            System.out.println("Waiting for client connection ....");

            //Create the socket to process the client request as server accept the connection
            Socket socket = serversocket.accept();
            //Start client connect as the thread
            System.out.println("Request count " + request_count);
            new ServerThread(socket,request_count).start();

            //end loop when on 100 th request
            if (request_count == 10) break;
            request_count++;
        }
        //close the  socketserver
        serversocket.close();

    }
}
