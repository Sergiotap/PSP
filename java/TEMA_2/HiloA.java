class HiloA extends Thread {
	//Se declara el contador
	private Contador contador;
	//Se define el hilo
	public HiloA (String n , Contador c) {
		setName(n);
		contador = c ;
	}
	//Se define el método run
	public void run(){
		for (int j = 0; j < 200; j++) {
			// 2º.- Posible sincro
			synchronized(contador){
				contador.incrementa();
			}
			try {
				sleep(10);
			} catch (InterruptedException e ) {}
		}
	}
}
