import javax.swing.JLabel;

public class Contador implements Runnable{
    private static final long INTERVALO=100;
    JLabel jSalida;
    int cont =0;
    public Contador(JLabel salida){
        jSalida=salida;
    }
    public void run(){
        try {
            while(true){
                cont++;
                jSalida.setText(Integer.toString(cont));
                Thread.sleep(INTERVALO);
            }
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}