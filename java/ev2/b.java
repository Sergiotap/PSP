import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class b {
    static final String FINAL="adiós";
    public static void main(String[] args) {
        String ip=args[0];
        int port=Integer.parseInt(args[1]);
        try {
            Socket conn = new Socket(ip, port);
            DataOutputStream outTCP = new DataOutputStream(conn.getOutputStream());
            DataInputStream inTCP=new DataInputStream(conn.getInputStream());
            System.out.println("Server dice: "+inTCP.readUTF());
            String msg;
            Scanner sc = new Scanner(System.in);
            do{
                msg=sc.nextLine();
                outTCP.writeUTF(msg);
                String msgOut =inTCP.readUTF();
                System.out.println("El server dice "+msgOut);
            }while(msg.equalsIgnoreCase(FINAL));
            outTCP.close();
            inTCP.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
