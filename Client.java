//201951108
//Nitin Kumar Yadav
import java.net.*;
import java.io.*;

class Client {
    // client using udp protocol
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // buffered reader for taking input from user
        DatagramSocket client_socket = new DatagramSocket(); // socket
        InetAddress ip = InetAddress.getByName("127.0.0.1"); // ip address 
        System.out.println("Enter File path which you want to send");
        String path = reader.readLine(); // input file path from user
        File file = new File(path); // creating new object of type file to refer the target file with given path 
        FileInputStream target = new FileInputStream(file);
        byte[] data = new byte[1024];
        for (int i = 0; i < 1024; i++) {
            int read = target.read();
            if (read == -1) {
                break;
            }
            data[i] = (byte) read;
        }

        DatagramPacket packet = new DatagramPacket(data, data.length, ip, 8080);
        client_socket.send(packet);

    }
}