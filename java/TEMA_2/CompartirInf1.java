public class CompartirInf1 {
	public static void main(String[] args) {
		//Se declara la variable contador
		Contador contador = new Contador(100);
		//Se declaran los hilos
		HiloA a = new HiloA("HiloA", contador);
		HiloB b = new HiloB("HiloB", contador);
		//Se inician los hilos
		a.start();
		b.start();
		try {
			//Se espera a que los hilos finalicen
			a.join();
			b.join();
		// 1º.- ¿Qué ocurre?
		System.out.println("Contador vale " + contador.valor());
		}
		catch (Exception e) {
			// TODO: handle exception
		}	
	}
}