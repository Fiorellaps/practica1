package practica1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import blast.BlastController;


public class comboActionListener implements ActionListener {
	private eventoBlast panel;
	private static final String dataBaseFile = new String("yeast.aa");
	private static final String dataBaseIndexes = new String("yeast.aa.indexs");

	public comboActionListener(eventoBlast e) {
		this.panel=e;
	}

	public void actionPerformed(ActionEvent e) {
		String tipo = panel.getGrupo().getSelection().toString();

		char seleccionada = 'p';
		if(tipo.equals("Proteina")) {
			seleccionada = 'p';
		}
		else{
			seleccionada='n';
		}
		JComboBox<String> combo= panel.getCombo();
		String seq = combo.getSelectedItem().toString();
		Float perc = Float.parseFloat(panel.getTextPorc().getText());
		BlastController bCnt = new BlastController();
		try{
			String result = bCnt.blastQuery(seleccionada, dataBaseFile, 
					dataBaseIndexes, (float) perc, seq);
			panel.changeTextSeq(result);
		} catch(Exception exc){
			System.out.println("Error en la llamada: " + exc.toString());
		}
	}



}
