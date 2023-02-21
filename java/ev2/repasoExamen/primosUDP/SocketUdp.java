package repasoExamen.primosUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SocketUdp {
    private DatagramSocket socket;
    private final int MAX_LENGTH = 65507;
    private final InetAddress IP_LOCAL;
    private final int PUERTO_LOCAL;
    private int puertoPaquete;
    private InetAddress ipPaquete;
    public SocketUdp(int puerto) throws SocketException{
        try {
            socket= new DatagramSocket(puerto);
        } catch (Exception e) {
            System.out.println("PUERTO USADO, ASIGNANDO OTRO");
            socket = new DatagramSocket();
            // TODO: handle exception
        }
        IP_LOCAL=socket.getLocalAddress();
        PUERTO_LOCAL= socket.getLocalPort();
    }
    public void enviarMensaje(String mensaje, String ip, int puerto) throws IOException {
        ip= ip.replace("/", "");
        byte[] buffer = mensaje.getBytes();
        DatagramPacket paquete = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(ip), puerto);
        this.socket.send(paquete);
    }
    public String recibirMensaje() throws IOException{
        byte [] buffer = new byte[MAX_LENGTH];
        DatagramPacket paquete = new DatagramPacket(buffer, MAX_LENGTH);
        this.socket.receive(paquete);
        this.ipPaquete = paquete.getAddress();
        this.puertoPaquete = paquete.getPort();
        return new String(paquete.getData(), 0, paquete.getLength());
    }
    public void cerrar() {
        this.socket.close();
    }
    public int getPuertoPaquete(){
        return puertoPaquete;
    }
    public InetAddress getIpPaquete(){
        return ipPaquete;
    }
    public InetAddress getIpLocal(){
        return IP_LOCAL;
    }
    public int getPuertoLocal(){
        return PUERTO_LOCAL;
    }
}
