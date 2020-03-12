package practica1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class BlastGUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities . invokeLater(new Runnable ( ) {
			public void run ( ) {
				JFrame frame = new JFrame("miBlast");

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				eventoBlast panel= new eventoBlast();
				comboActionListener Listener= new comboActionListener(panel);
				frame.setContentPane(panel);
				panel.getBoton().addActionListener(Listener);
				frame.pack();
				frame.setVisible(true);

			}
		});

	}
}
