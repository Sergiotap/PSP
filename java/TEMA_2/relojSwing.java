import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class relojSwing extends JFrame  {
    public relojSwing(){
        super("Reloj");
        JLabel label = new JLabel("Hola Mundo");
        getContentPane().add(label);
        JButton boton=new JButton("Púlsame");
        boton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Contador c=new Contador(label);
                Thread t=new Thread();
                t.start();
            }
        }
        );        
        getContentPane().add(boton);
        /*JButton bPara=new JButton("¡PARA!");
        getContentPane().add(bPara);
        bPara.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Thread t=new Thread();
                t.stop();
            }
        });*/
        setLayout(new FlowLayout());
        setSize(200,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new relojSwing();
        
      }
}
