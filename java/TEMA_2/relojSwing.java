import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class relojSwing extends JFrame{

	public relojSwing() {
		super("Reloj");
		
		setLayout(new FlowLayout());
		
		JLabel l = new JLabel();
		l.setText("0");
		getContentPane().add(l);
		
		JButton b = new JButton("¡Comienza!");
		getContentPane().add(b);
		
		Object sync = new Object();
		
		ContadorSergio c = new ContadorSergio(l, sync);
		Thread t = new Thread(c);
		t.start();
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				synchronized(sync) {
					sync.notify();
				}
			}
		});
		
		JButton bPara = new JButton("¡Para!");
		getContentPane().add(bPara);
		bPara.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				t.interrupt();
			}
		});
		
		setSize(500,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new relojSwing();
	}
}