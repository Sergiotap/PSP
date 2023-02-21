package repaso;

import java.io.InputStream;
import java.io.OutputStream;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class usarC {
   public static void main(String[] args) {
    try {
        Process p = new ProcessBuilder("/home/sergiotap/Documentos/PSP/repaso/ejercicioC","ejercicioC").start();
        InputStream is=p.getInputStream();
        int c;
        System.out.println("Antes del bucle");
        System.out.println();
        OutputStream os = p.getOutputStream();
        os.write('3');
        os.write('3');
        os.write('3');
        os.flush();
        while((c=is.read())!=-1){
            System.out.print((char)c);
        }
        
        is.close();
    } catch (Exception e) {
        e.printStackTrace();
    }	   
	   
   }
}//Ejemplo1