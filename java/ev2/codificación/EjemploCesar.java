import java.util.InputMismatchException;
import java.util.Scanner;

public class EjemploCesar {
    final static int NUMCARACTERES = 26;
    final static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {
        String cadena = SC.nextLine();
        while(!contieneSoloTexto(cadena)){
            System.out.println("No se pueden introducir números");
            cadena = SC.nextLine();
        }
        System.out.println("La cadena introducida es "+cadena);
        int num=0;
        String numero="";
        System.out.println("Introduce el valor de cifrado: ");
        numero = SC.next();
        if(contieneSoloNumeros(numero)){
            num=Integer.parseInt(numero);
        }
        else{
            while(!contieneSoloNumeros(numero)){
                numero="";
                System.out.println("Introduce el valor de cifrado: ");
                numero = SC.next();
                if(contieneSoloNumeros(numero)){
                    num=Integer.parseInt(numero);
                }
            }
        }
        if(num>NUMCARACTERES){
            num=num-NUMCARACTERES;
        } 
        System.out.println("La cadena original es "+cadena);
        cadena = hacerCadena(cadena, num);
        System.out.println("El número de rotaciones es "+numero);
        System.out.println("La nueva cadena es "+cadena);
        
    }
    public static String hacerCadena(String cadena, int num) {
        String nuevaPalabra = "";
        for (int i = 0; i < cadena.length(); i++) {
            // System.out.println(cadena.charAt(i));
            char letra = cadena.charAt(i);
            if (cadena.charAt(i) == ' ') {
                letra = ' ';
            }
            else if(Character.isUpperCase(cadena.charAt(i))){
                if((cadena.charAt(i) + num) > 'Z'){
                    letra -= (NUMCARACTERES - num);
                }
                else if((cadena.charAt(i) + num) < 'A'){
                    letra += (NUMCARACTERES + num);
                }
                else{
                    letra += num;
                }
            }
            else if ((cadena.charAt(i) + num) > 'z') {
                // System.out.println(letra);
                letra -= (NUMCARACTERES - num);
            }
            else if((cadena.charAt(i) + num) < 'a'){
                letra += (NUMCARACTERES + num);
            }
            else {
                letra += num;
            }
            nuevaPalabra += letra;
        }
        return nuevaPalabra;
    }
    public static boolean contieneSoloTexto(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }
    public static boolean contieneSoloNumeros(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if (Character.isLetter(c) || Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }
}