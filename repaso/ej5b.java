package repaso;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ej5b {
    public static void main(String[] args) throws IOException{
        File directorio = new File("/home/sergiotap/.config/Code/User/workspaceStorage/772d8a9671cd0c9fdf6f7e3dc6d3d57f/redhat.java/jdt_ws/PSP_7e39c477/bin");
		Scanner sc= new Scanner(System.in);
		System.out.println("Escribe la cadena: ");
		String cadena =sc.nextLine();
		ProcessBuilder pb = new ProcessBuilder("java", "repaso.ej5",cadena);
		pb.directory(directorio);
		
		System.out.printf("Directorio de trabajo: %s%n",pb.directory());
		Process p = pb.start();
		
		InputStream is=p.getInputStream();
		int c;
		while ((c = is.read()) != -1) {
			System.out.print((char) c);
		}
		is.close();
		
		int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
