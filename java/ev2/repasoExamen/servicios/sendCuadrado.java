package repasoExamen.servicios;

public class sendCuadrado {
    public static void main(String[] args) {
        if (args.length<=1) {
            System.out.println("Se deben introducir el alto y el ancho");
        }
        else{
            int ancho=Integer.parseInt(args[0]);
            int alto=Integer.parseInt(args[1]);
            //int alto=5;
            //int ancho=5;
            dibujarCuadrado(ancho, alto);
        }
    }
    public static void dibujarCuadrado(int ancho, int alto) {
        for (int i = 0; i < alto; i++) {
                for (int j = 0; j < ancho; j++) {
                if(i==0||i==alto-1){
                    System.out.print("*");
                }
                else if(j==0||j==ancho-1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}