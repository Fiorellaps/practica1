package miBlastGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import blast.BlastController;

public class BlastActionListener implements ActionListener {
	private miPanelBlast panel;
	private static final String dataBaseFile = new String("yeast.aa");
	private static final String dataBaseIndexes = new String("yeast.aa.indexs");
	private BlastController blastC;

	public BlastActionListener(miPanelBlast e, BlastController bCnt) {
		this.panel=e;
		this.blastC= bCnt;
	}

	public void actionPerformed(ActionEvent e) {
		JDialog d = new JDialog();
		String seq= null;
		try {
			seq=panel.getCombo().getSelectedItem().toString().toLowerCase();
			if(encontrada(seq)==false) panel.getCombo().addItem(seq);
			
		}
		catch(NullPointerException n) {
			System.out.println("Error al introducir la secuencia");
			d.add(new JLabel("Error al introducir la secuencia"));
			d.setVisible(true);
		}

		float perc= -1; 

		try {
			perc= Float.parseFloat(panel.getTextPorc().getText());
		}
		catch(NumberFormatException nf) {
			if(perc<0 || perc>1) {
				System.out.println("Porcentaje:"+ perc+" introducido fuera de rango");
				d.add(new JLabel("Porcentaje:"+ perc+ " introducido fuera de rango"));
				d.setVisible(true);
			}
			else {
				System.out.println("Pocentaje:" +perc+" incorrecto");	
				d.add(new JLabel("Porcentaje:"+ perc+" incorrecto"));
				d.setVisible(true);
			}

		}

		Boolean pSelec= panel.getRp().isSelected();
		
		if (pSelec==true) {
			String result = null;

			try{
				result = blastC.blastQuery('p', dataBaseFile, 
						dataBaseIndexes, (float) perc, seq);
			} catch(Exception exc){
				System.out.println("Error en la llamada: " + exc.toString());
				d.add(new JLabel("Error en la llamada"));
				d.setVisible(true);
			}
			panel.getResultado().setText(result);
		}
		else {
			System.out.println("No se pueden buscar secuencias de nucleótidos");
			d.add(new JLabel("No se pueden buscar secuencias de nucleótidos"));
			d.setVisible(true);
			
		}
		

	}
	public boolean encontrada( String seq) {
		boolean encontrada = false;
		for(int i = 0; i<panel.getCombo().getItemCount();i++) {
			if(seq.equals(panel.getCombo().getItemAt(i).toString())){
				encontrada=true;
			}
	}
		return encontrada;
		
	}

}


