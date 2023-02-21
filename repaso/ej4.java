package repaso;

public class ej4 {
    public static void main(String args[]){
        System.out.println("Programa ejecutado");
        if(args.length<1){
            System.out.println("El número de argumentos es menor que 1");
            System.exit(1);
        }
        try {
            int num=Integer.valueOf(args[0]);
            if(num<0){
                System.out.println("El argumento es un número menor que 1");
                System.exit(3);
            }
        } catch (NumberFormatException e) {
            System.out.println("Es una cadena");
            System.exit(2);
            // TODO: handle exception
        }
        System.out.println("Otra situación");
        System.exit(0);
        
    }
}
