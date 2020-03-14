package miBlastGUI;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import blast.BlastController;

public class BlastPrincipal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities . invokeLater(new Runnable ( ) {
			public void run ( ) {
				JFrame frame = new JFrame("miBlast");

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				miPanelBlast panel= new miPanelBlast();
				BlastController bCnt = new BlastController();
				BlastActionListener Listener= new BlastActionListener(panel, bCnt);
				frame.getContentPane().add(panel);
				panel.getBoton().addActionListener(Listener);
				frame.pack();
				frame.setVisible(true);

			}
		});

	}
}


