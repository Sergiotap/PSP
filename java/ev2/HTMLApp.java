
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLApp {
  public static String DIR="www.cual-es-mi-ip.net";
  public static Pattern pattern = Pattern.compile("El IP \\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b");
  public static Matcher matcher;
  public static void main(String[] args) throws Exception {
    
    SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    Socket socket = sslsocketfactory.createSocket(DIR, 443);

    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    out.println("GET / HTTP/1.1");
    out.println("Host: "+DIR);
    out.println();
    out.flush();
    
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
      matcher = pattern.matcher(inputLine);
      while (matcher.find()) {
        System.out.println(matcher.group());
      }
    }
    in.close();
    out.close();
    socket.close();
  }
}