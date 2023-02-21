import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class clienteUDP {
    public static void main(String args[]) throws IOException
    {
        try {
            DatagramSocket ds = new DatagramSocket();
            byte buffer[]= "Hola Mundo".getBytes();
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getLoopbackAddress(), 8888);
            ds.send(dp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
