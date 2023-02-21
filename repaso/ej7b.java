package repaso;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class ej7b {
	
	public static void main(String[] args) throws IOException {
		
		File directorio = new File("/home/sergiotap/.config/Code/User/workspaceStorage/772d8a9671cd0c9fdf6f7e3dc6d3d57f/redhat.java/jdt_ws/PSP_7e39c477/bin");
		ProcessBuilder pb = new ProcessBuilder("java", "repaso.ej7");
		pb.directory(directorio);
		
		System.out.printf("Directorio de trabajo: %s%n",pb.directory());
		Process p = pb.start();
		
		OutputStream os=p.getOutputStream();
		
		
		Scanner sc = new Scanner(System.in);
		String envio ="";
		while (!envio.contains("*")) {
			envio = sc .next();
			os.write((envio+"\n").getBytes());
			os.flush();
		}
		
		sc.close();
		
		InputStream is=p.getInputStream();
		
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		is.close();
	}
}