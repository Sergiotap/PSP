import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class RecibeSocket {
    public static void main(String[] args) {
        String ip="192.168.1.137";
        int puerto=8000;
        try (
            Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket(ip, puerto);
        ){
            // Conectar al host y puerto especificado
            System.out.println("Conectado al servidor");

            // Crear los objetos de lectura y escritura
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Crear un Scanner para leer mensajes del usuario

            while(true) {
                // Leer un mensaje del usuario
                System.out.print("Mensaje a enviar: ");
                String message = scanner.nextLine();

                // Enviar el mensaje al servidor
                output.println(message);

                // Leer una respuesta del servidor
                String respuesta = input.readLine();
                System.out.println("Servidor: " + respuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}