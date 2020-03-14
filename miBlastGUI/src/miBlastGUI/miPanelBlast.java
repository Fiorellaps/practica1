package miBlastGUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class miPanelBlast extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton rp;
	private JRadioButton rn;
	private JComboBox<String> combo;
	private JTextField tPorc;
	private JButton botonB;
	private JLabel intro;
	private JLabel Lporcentaje;
	private JLabel Lsec;
	private JTextArea Tresultado;

	public miPanelBlast() {
		// añadimos el primer Jpanel

		JPanel p1 = new JPanel(new BorderLayout());
		rp = new JRadioButton("Proteina");
		rn = new JRadioButton("Nucleotido");
		ButtonGroup group = new ButtonGroup();
		group.add(rp);
		group.add(rn);
		rp.setSelected(true);
		rn.setSelected(false);
		intro = new JLabel();
		intro.setText("Elige el tipo de secuencia");
		p1.add(rp, BorderLayout.WEST);
		p1.add(rn, BorderLayout.EAST);
		p1.add(intro, BorderLayout.NORTH);
		// añadimos el segundo Jpanel
		JPanel p2= new JPanel(new GridLayout(2,1));
		combo = new JComboBox<>();
		combo.setEditable(true);
		Lsec=new JLabel();
		Lsec.setText("Introduce la secuencia    ");
		p2.add(Lsec);
		p2.add(combo);
		// añadimos el tercer JPanel
		JPanel p3= new JPanel(new GridLayout(2,1));
		Lporcentaje = new JLabel();
		Lporcentaje.setText("Introduce el porcentaje");
		tPorc = new JTextField(30);
		p3.add(Lporcentaje);
		p3.add(tPorc);
		//añadimos resultado de la búsqueda
		Tresultado= new JTextArea(50,70);
		JScrollPane scroll= new JScrollPane(Tresultado);
		Tresultado.setEditable(false);
		
		

		//añadimos boton
		botonB = new JButton("BLAST");
		//añadimos paneles
		add(p1);
		add(p2);	
		add(p3);
		add(botonB);
		add(scroll);

	}


	public JTextField getTextPorc() {
		return this.tPorc;
	}
	public JButton getBoton() {
		return this.botonB;

	}
	public  JComboBox<String> getCombo (){
		return this.combo;
	}
	public JRadioButton getRp() {
		return this.rp;
	}
	
	public JTextArea getResultado() {
		return this.Tresultado;
	}
	public JLabel getSecuencia(){
		return this.Lsec;
	}





}
