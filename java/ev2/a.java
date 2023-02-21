import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class a {
    public static void main(String[] args) {
        ServerSocket server;
        int port=Integer.parseInt(args[0]);
        String msg=args[1];
        try {
            server=new ServerSocket(port);
            Socket connCliente = server.accept();
            System.out.println("Escuchando en puerto: "+port);
            BufferedOutputStream out = new BufferedOutputStream(connCliente.getOutputStream());
            msg=msg+"/n";
            out.write(msg.getBytes());
            out.flush();
            BufferedInputStream input=new BufferedInputStream(connCliente.getInputStream());
            byte[] info=input.readAllBytes();
            String cadena = new String(info);
            System.out.println("Cliente nos manda :"+cadena);
            out.close();
            connCliente.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
