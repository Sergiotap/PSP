import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteBroadcast {
    public static void main(String args[]) throws IOException
    {
        try {
            DatagramSocket ds = new DatagramSocket();
            ds.setBroadcast(true);
            String ip="255.255.255.255";
            byte buffer[]= "Hola Mundo".getBytes();
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), 12121);
            ds.send(dp);
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
