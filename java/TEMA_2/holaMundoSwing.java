import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class holaMundoSwing extends JFrame  {
    public holaMundoSwing(){
        super("Mi primera ventana");
        JLabel label = new JLabel("Hola Mundo");
        getContentPane().add(label);
        JButton boton=new JButton("Púlsame");
        boton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                label.setText("Pulsado");
            }
        }
        );
        
        getContentPane().add(boton);
        setLayout(new FlowLayout());
        setSize(200,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new holaMundoSwing();
        
      }
}
