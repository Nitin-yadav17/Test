import java.net.*;
import java.io.*;

class Server {
    //Server using udp protocol
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // buffered reader to take input from user
        DatagramSocket server_socket = new DatagramSocket(8080); //socket
        System.out.println("Enter file name/path by which you want to save the recieved file");
        String file = reader.readLine(); // reading file path provided by user
        FileOutputStream output = new FileOutputStream(file);
        byte[] buffer = new byte[1024]; // buffer
        DatagramPacket packet = new DatagramPacket(buffer, 1024); // packet

        int counter = 0; // counter to count how many pakcets have been received so far.
        while (true) {
            server_socket.receive(packet);
            counter++;
            output.write(buffer);
            if (counter >= 50)
                break;
        }

        server_socket.close();
        reader.close();
    }
}