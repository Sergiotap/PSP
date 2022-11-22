package repaso;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ejRepaso1 {
    public static void main(String[] args) throws IOException {
        if(args.length==0){
        int num=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el numero: ");
        num=sc.nextInt();
        sc.close();
        File directorio = new File("/home/sergiotap/.config/Code/User/workspaceStorage/772d8a9671cd0c9fdf6f7e3dc6d3d57f/redhat.java/jdt_ws/PSP_7e39c477/bin");
        ProcessBuilder pb = new ProcessBuilder("java", "repaso.ejRepaso2", Integer.toString(num));
		pb.directory(directorio);
        System.out.printf("Directorio de trabajo: %s%n",pb.directory());
        Process p=pb.start(); 
        InputStream is1=p.getInputStream();
		int c;
		while ((c = is1.read()) != -1) {
			System.out.print((char) c);
		}
        is1.close();
    }
    else{
        try{
            if(args[0].equals(args[1])){
                System.out.println("El numero es el mismo");
            }
            else{
                System.out.println("El numero es diferente");
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Fin con error del programa");
        }
    }
    }
}
