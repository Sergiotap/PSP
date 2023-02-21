class HiloB extends Thread {
	//Se declara el contador
	private Contador contador;
	//Se define el hilo
	public HiloB(String n , Contador c) {
		setName(n);
		contador = c;
	}
	//Se define el método run
	public void run(){
		for (int j = 0; j < 300; j++) {
			// 2º.- Posible sincro
			synchronized(contador){
				contador.decrementa(); //decrementa el contador
			}
			try {
				sleep(10);
			}catch (InterruptedException e) {}
		}
	}
}//FIN HILOB