package repaso;

import java.io.IOException;
import java.io.InputStreamReader;

public class ej7 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("Programa ejecutado");
		InputStreamReader in = new InputStreamReader(System.in);
		
		char c;
		while ((c=(char) in.read())!='*') System.out.print(c);
		
		in.close();
	}
}