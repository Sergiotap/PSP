package repaso;

public class ej8 {
    public static void main(String[] args) {
        String cadInvertida=InvertirCadena(args[0]);
        //if(args.length<1||args[0].equals("\n")||args[0].equals("")){
        if(args[0].isEmpty()){
            System.out.println("La cadena esta vacía");
        }
        else if(cadInvertida.equals(args[0])){
            System.out.println("La cadena es un palíndromo");
        }
        else{
            System.out.println("la cadena no es un palíndromo");
        }
    }
    public static String InvertirCadena(String cadena) {
        String cadenaInvertida = "";
        for (int x = cadena.length() - 1; x >= 0; x--)
        cadenaInvertida = cadenaInvertida + cadena.charAt(x);
        return cadenaInvertida;
    }
}
