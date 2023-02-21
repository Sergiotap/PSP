
public class ejercicio1 extends Thread{
    private static int numHijos=4;
    private static int numSaludos=1;
    public void run() {
        for (int i=0;i<numSaludos;i++)
        System.out.println("En el Hilo "+getName()+" .. . ");
	}
    
    public static void main(String[] args){
        for (int i=1;i<numHijos+1;i++){
            ejercicio1 hs = new ejercicio1();
            hs.setName("hijo "+i);
            hs.start();
        }
        
        
		System.out.println("Fuera de los hilos ..");
	}
}
