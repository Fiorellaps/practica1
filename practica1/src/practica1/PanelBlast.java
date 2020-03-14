package practica1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import blast.BlastController;

public class eventoBlast extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JRadioButton rp;
	private JRadioButton rn;
	private JComboBox<String> combo;
	private ButtonGroup group;
	private JTextField text;
	private JTextField tPorc;
	private JButton boton;
	private JLabel intro;
	private JLabel porcentaje;
	private JLabel sec;
	private static final String dataBaseFile = new String("yeast.aa");
	private static final String dataBaseIndexes = new String("yeast.aa.indexs");



	public eventoBlast() {
		rp = new JRadioButton("Proteina");
		rn = new JRadioButton("Nucleotido");
		group = new ButtonGroup();
		group.add(rp);
		group.add(rn);
		rp.setSelected(true);
		intro = new JLabel();
		intro.setText("Elige el tipo de secuencia");
		JPanel p1 = new JPanel(new BorderLayout());
		p1.add(rp, BorderLayout.WEST);
		p1.add(rn, BorderLayout.EAST);
		p1.add(intro, BorderLayout.NORTH);
		combo = new JComboBox<>();
		combo.setEditable(true);
		sec=new JLabel();
		sec.setText("Introduce la secuencia");
		text=new JTextField(30);
		text.setMinimumSize(new Dimension(100,100));
		JPanel p2= new JPanel(new GridLayout(3,1));
		p2.add(sec);
		p2.add(combo);
		p2.add(text);		
		porcentaje = new JLabel();
		porcentaje.setText("Introduce el porcentaje");
		tPorc = new JTextField(30);
		JPanel p3= new JPanel();	
		p3.add(porcentaje, BorderLayout.NORTH);
		p3.add(tPorc, BorderLayout.SOUTH);
		JPanel p4= new JPanel();
		boton = new JButton("BLAST");
		p4.add(boton, BorderLayout.CENTER);
		add(p1, BorderLayout.WEST);
		add(p2,BorderLayout.SOUTH);	
		add(p3, BorderLayout.CENTER);
		add(p4, BorderLayout.EAST);
		
	}
	/*public static void main(String args[]){
		BlastController bCnt = new BlastController();
		try{
			String result = bCnt.blastQuery('p', dataBaseFile, 
					dataBaseIndexes, (float) 0.9, "GKGKGKGKGK");
			System.out.println(result);
		} catch(Exception exc){
			System.out.println("Error en la llamada: " + exc.toString());
		}

	}
	*/
	public void changeTextSeq(String t) {
		this.text.setText(t);
	}
	public JTextField getTextPorc() {
		return this.tPorc;
	}
	public JButton getBoton() {
		return this.boton;

	}
	public  JComboBox<String> getCombo (){
		return this.combo;
	}
	public ButtonGroup getGrupo() {
	return group;
	}



}
