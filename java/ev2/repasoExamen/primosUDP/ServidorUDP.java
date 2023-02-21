package repasoExamen.primosUDP;

import java.net.Socket;
import java.net.SocketException;

public class ServidorUDP{
    public static void main(String[] args) throws SocketException{
        if(args.length<1){
            System.out.println("Se debe ingresar el puerto del servidor por parámetro");
            System.exit(0);
        }
        int puerto = Integer.parseInt(args[0]);
        SocketUdp socket = new SocketUdp(puerto);
        System.out.println("Servidor UDP iniciado en el puerto " +puerto);
        while (true) {
            try {
                String mensaje = socket.recibirMensaje();
                System.out.println("Mensaje recibido: "+mensaje);
                if(esNumero(mensaje)){
                    int numero = Integer.parseInt(mensaje);
                    if(esPrimo(numero)){
                        socket.enviarMensaje("El numero "+mensaje+" es primo", socket.getIpPaquete().toString(), socket.getPuertoPaquete());
                    }
                    else{
                        System.out.println("No es primo");
                    }
                }
                else{
                    socket.enviarMensaje(mensaje+" no es un número", socket.getIpPaquete().toString(), socket.getPuertoPaquete());
                }
                //socket.enviarMensaje(mensaje, socket.getIpPaquete().toString(), socket.getPuertoPaquete());
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
    public static boolean esNumero(String mensaje){
        boolean numero = true;
        for (int i = 0; i < mensaje.length(); i++) {
            if ((mensaje.charAt(i)<'0')||(mensaje.charAt(i)>'9')) {
                numero=false;
            }
        }
        return numero;
    }
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}