package repasoExamen.primosTCP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ProcesadorCliente implements Runnable {
    private Socket clienteSocket;

    public ProcesadorCliente(Socket clienteSocket) {
        this.clienteSocket = clienteSocket;
    }

    public void run() {
        try (
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);
        ) {
            int numero;
            do{
                String inputLine = entrada.readLine();
                numero = Integer.parseInt(inputLine);

                boolean esPrimo = esPrimo(numero);
                if(esPrimo&&numero>0){
                    salida.println(numero);
                }
            }while(numero>0);
        } catch (IOException e) {
            System.err.println("Error al procesar la solicitud del cliente: " + e.getMessage());
        } finally {
            try {
                clienteSocket.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el socket del cliente: " + e.getMessage());
            }
        }
    }

    public boolean esPrimo(int numero) {
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
