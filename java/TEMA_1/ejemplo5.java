import java.io.*;

public class ejemplo5 {
	public static void main(String[] args) throws IOException {

		Process p = new ProcessBuilder("bash", "-c", "ifconfig").start();
		String cadena="";
		try {

			InputStream is = p.getInputStream();

			// mostramos en pantalla caracter a caracter
			 int c;
			 while ((c = is.read()) != -1){ 
				cadena=String.valueOf((char) c);
				System.out.print(cadena);
			 }
			 is.close();

		
		} catch (Exception e) {
			e.printStackTrace();
		}

		// COMPROBACION DE ERROR - 0 bien - 1 mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}// Ejemplo5
