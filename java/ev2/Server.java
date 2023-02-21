import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java Server <ip address> <port number>");
            System.exit(1);
        }
        String ip = args[0];
        int port = Integer.parseInt(args[1]);
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.bind(new InetSocketAddress(ip, port));
            System.out.println("Server is listening on " + ip + ":" + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + port + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            out.println("Bienvenido al servidor!");
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Cliente escribió: " + inputLine);
                if (inputLine.equals("adiós")) {
                    out.println("Cerrando conexión");
                    break;
                }
            }
            clientSocket.close();
            out.close();
            in.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
