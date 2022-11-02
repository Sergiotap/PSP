package TEMA_2;

public class ejercicio1 extends Thread{
    public void run() {
        System.out.println("En el Hilo "+getName()+" .. . ");
	}
    
    public static void main(String[] args){
		ejercicio1 hs1 = new ejercicio1();
        hs1.setName("hijo1");
        ejercicio1 hs2 = new ejercicio1();
        hs2.setName("hijo2");
        ejercicio1 hs3 = new ejercicio1();
        hs3.setName("hijo3");
        ejercicio1 hs4 = new ejercicio1();		
        hs4.setName("hijo4"); 
        hs1.run();
        hs2.run();
        hs3.run();
        hs4.run();
		System.out.println("Fuera de los hilos ..");
	}
}
