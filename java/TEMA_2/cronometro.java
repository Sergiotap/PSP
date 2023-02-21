import java.util.Timer;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class cronometro extends javax.swing.JFrame{
    JLabel l= new JLabel();
    private Timer tiempo;
    private int centesimasSegundo=0;
    private int segundos=0;
    private int minutos=0;
    private int horas=0;
    private ActionListener acciones =new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            centesimasSegundo++;
            if(centesimasSegundo==100){
                segundos++;
                centesimasSegundo=0;
            }
            if(segundos==60){
                minutos++;
                segundos=0;
            }
            if(minutos==60){
                horas++;
                minutos=0;
            }
        }

    };

    private void actualizarEtiquetaTiempo(){
        String texto = (horas<=9?"0":"")+horas+":"+(minutos<=9?"0":"")+minutos+":"+(segundos<=9?"0":"")+segundos+":"+(centesimasSegundo<=9?"0":"")+centesimasSegundo;
        l.setText(texto);
    }
    
    public cronometro(){
        this.setLocationRelativeTo(null);
        this.setTitle("cronómetro");
    }
}
