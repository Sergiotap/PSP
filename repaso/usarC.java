package repaso;

import java.io.InputStream;

public class usarC {
   public static void main(String[] args) {
    try {
        Process p = new ProcessBuilder("/home/sergiotap/Documentos/PSP/repaso/ejercicioC","ejercicioC").start();
        InputStream is=p.getInputStream();
        int c;
        System.out.println("Antes del bucle");
        while((c=is.read())!=-1){
            System.out.print(c=is.read());
        }
        System.out.println("Después del bucle");
        is.close();
    } catch (Exception e) {
        e.printStackTrace();
    }	   
	   
   }
}//Ejemplo1