import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSend {
    public static void main(String[] args) {
        try {
            MulticastSocket ms = new MulticastSocket();
            InetAddress group = InetAddress.getByName("250.0.0.0");
        } catch (Exception e) {
            // TODO: handle exception
        } 
    }
}
