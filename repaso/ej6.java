package repaso;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ej6 {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		
		System.out.println("La cadena es:"+str);
		
		File salida = new File("salida.txt");
		File path = new File("/home/sergiotap/.config/Code/User/workspaceStorage/772d8a9671cd0c9fdf6f7e3dc6d3d57f/redhat.java/jdt_ws/PSP_7e39c477/bin");
		ProcessBuilder pb = new ProcessBuilder("java","repaso.ej5",str);
		pb.directory(path);
		
		pb.redirectOutput(salida);
		
		pb.start();		
	}
}
