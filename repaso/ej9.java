package repaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ej9 {
    public static void main(String[] args) throws IOException{
        File directorio = new File("/home/sergiotap/.config/Code/User/workspaceStorage/772d8a9671cd0c9fdf6f7e3dc6d3d57f/redhat.java/jdt_ws/PSP_7e39c477/bin");
		File entrada =new File("variables.txt");
		BufferedReader br = new BufferedReader(new FileReader(entrada));
		String str = br.readLine();
		br.close();
		ProcessBuilder pb = new ProcessBuilder("java", "repaso.ej7");
		pb.directory(directorio);
		System.out.printf("Directorio de trabajo: %s%n",pb.directory());
		Process p = pb.start();
		System.out.println("Cadena a enviar "+str);
		OutputStream os=p.getOutputStream();
		os.write((str+"\n").getBytes());
		os.flush();
		InputStream is = p.getInputStream();		
 		int c;
 		while ((c = is.read()) != -1)
			System.out.print((char) c);
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