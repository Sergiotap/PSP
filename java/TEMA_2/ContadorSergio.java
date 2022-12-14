import javax.swing.JLabel;

public class ContadorSergio implements Runnable {
	//Se declara la variable del intervalo
	private static final long INTERVALO = 1;
	//Se declara el label para la salida
	JLabel _salida;
	//Se declara el objeto para sincronizar
	Object _sync;
	//Se declara el contador
	int cont = 0;
	//Se define el objeto contador
	public ContadorSergio(JLabel salida, Object sync) {
		_salida = salida;
		_sync = sync;
	}
	//Se declara el método para parar
	private void parar() {
		try {
			//Se sincronizan los procesos y se dejan en espera
			synchronized(_sync) {
				_sync.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	//Se declara el método parta iniciar
	@Override
	public void run() {
		//Se llama al método para parar
		parar();
		
		while(true) {
			cont++;
			_salida.setText(Integer.toString(cont));
			
			try {
				Thread.sleep(INTERVALO);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				parar();
			}
		}
	}
}