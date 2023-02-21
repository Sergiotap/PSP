package repaso;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ejRepaso2 {
    public static void main(String[] args) throws IOException{
        
        int num=numAleatorio();
        System.out.println("El numero generado es "+num);
        File directorio = new File("/home/sergiotap/.config/Code/User/workspaceStorage/772d8a9671cd0c9fdf6f7e3dc6d3d57f/redhat.java/jdt_ws/PSP_7e39c477/bin");
        ProcessBuilder pb = new ProcessBuilder("java", "repaso.ejRepaso1", Integer.toString(num),args[0]);
		pb.directory(directorio);
        System.out.printf("Directorio de trabajo: %s%n",pb.directory());
        Process p =pb.start();
        InputStream is2=p.getInputStream();
		int c;
		while ((c = is2.read()) != -1) {
			System.out.print((char) c);
		}
        is2.close();
    }
    public static int numAleatorio(){
        int num=(int)(Math.random()*10);
        return num;
    }
}
