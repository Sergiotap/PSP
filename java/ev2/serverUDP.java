import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class serverUDP {
    public static final int MAX_LENGTH=6555;
    public static void main(String[] args) {
        try (DatagramSocket ds = new DatagramSocket(8888, InetAddress.getLoopbackAddress())){
            byte[] buffer= new byte[MAX_LENGTH];
            DatagramPacket dp = new DatagramPacket(buffer, MAX_LENGTH);
            ds.receive(dp);
            System.out.println(new String(dp.getData(), 0, dp.getLength()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
