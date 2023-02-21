import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class HolaSocket {
    public static void main(String[] args) {
        try{
            Socket con = new Socket("192.168.1.130", 8000);//se han de introducir la ip y el puerto
            BufferedOutputStream out = new BufferedOutputStream(con.getOutputStream());
            out.write("Hola mundo!".getBytes());
            out.close();
            con.close();
        }
        catch(UnknownHostException e){
            e.printStackTrace();
        }
        catch(ConnectException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        

    }
}
