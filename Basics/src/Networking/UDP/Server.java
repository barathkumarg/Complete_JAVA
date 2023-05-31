package Networking.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {

        //create the socket for connection
        DatagramSocket socket = new DatagramSocket(8999);

        //Packet intialization to get the message
        DatagramPacket packet = new DatagramPacket(new byte[1000],1000);

        //receive the message
        socket.receive(packet);

        //Printing the useful information
        System.out.println(new String(packet.getData()));
        System.out.println("Obtaining from IP "+ packet.getAddress());
        System.out.println("Obtaining from port "+packet.getPort());




    }

}
