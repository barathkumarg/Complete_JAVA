package Networking.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Client {

    public static void main(String[] args) throws IOException {

        //creating the socket
        DatagramSocket socket = new DatagramSocket();


        //fetching the method
        String message = "I am a message from client";
        byte[] data = message.getBytes();

        //creating the packet
        DatagramPacket packet = new DatagramPacket(data,data.length, InetAddress.getLocalHost(),8999);

        //sending the packet
        socket.send(packet);

        socket.close();

    }
}
