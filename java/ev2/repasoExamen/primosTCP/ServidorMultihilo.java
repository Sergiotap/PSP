package repasoExamen.primosTCP;

import java.net.*;
import java.io.*;

public class ServidorMultihilo {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Uso: java ServidorMultiHilo <puerto>");
            System.exit(1);
        }

        int puerto = Integer.parseInt(args[0]);

        try (ServerSocket servidorSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor escuchando en el puerto " + puerto);

            while (true) {
                Socket clienteSocket = servidorSocket.accept();
                System.out.println("Conexión aceptada desde " + clienteSocket.getInetAddress().getHostAddress());

                // Crear un nuevo hilo para procesar la solicitud del cliente
                Thread hilo = new Thread(new ProcesadorCliente(clienteSocket));
                hilo.start();
            }
        } catch (IOException e) {
            System.err.println("Error al escuchar en el puerto " + puerto);
            System.exit(1);
        }
    }
}

