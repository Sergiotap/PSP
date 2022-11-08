import javax.swing.JLabel;

public class Contador implements Runnable{
    private static final long INTERVALO=1;
    JLabel jSalida;
    int cont =0;
    boolean prueba=true;
    public Contador(JLabel salida){
        jSalida=salida;
    }
    public void run(){
        try {
            //No entra aquí
            while(prueba ==true){
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