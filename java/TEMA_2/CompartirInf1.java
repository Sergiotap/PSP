public class CompartirInf1 {
	public static void main(String[] args) {
		Contador contador = new Contador(100);
		HiloA a = new HiloA("HiloA", contador);
		HiloB b = new HiloB("HiloB", contador);
		a.start();
		b.start();
		try {
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