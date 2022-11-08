import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class relojSwing extends JFrame  {
    public relojSwing(){
        super("Reloj");
        JLabel l= new JLabel();
        l.setText("0");
        
        setLayout(new FlowLayout());

        getContentPane().add(l);

        JButton b = new JButton("¡Comienza!");
        getContentPane().add(b);

           
        Contador c= new Contador(l);
        Thread t= new Thread(c);
        b.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
            if(t.isAlive()){
                t.resume();
            }else{
              
              t.start();
            }
         }
        });
        JButton bPara = new JButton("¡Para!");
        getContentPane().add(bPara);
        bPara.addActionListener(new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e){
                    t.suspend();
                }
        });

        setSize(500, 400);
        setVisible(true); //
    }
    public static void main(String[] args) {
        new relojSwing();
        
      }
}
