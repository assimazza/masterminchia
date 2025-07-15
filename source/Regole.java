/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
//import javax.swing.text.BadLocationException;
//import javax.swing.text.Document;
//import javax.swing.text.PlainDocument;
import javax.swing.JTextArea;


public class Regole extends JFrame {

	private JPanel jContentPane = null;
	/*private JPanel jPanel = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JTextPane jTextPane = null;*/
	private JTextArea jTextArea = null;
	/**
	 * This is the default constructor
	 */
	public Regole() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		//addWindowListener(new Ascoltatore());
		//this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("REGOLE");
		pack();
		this.setResizable(false);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension size = this.getSize();
		screenSize.height = screenSize.height / 2;
		screenSize.width = screenSize.width / 2;
		size.height = size.height / 2;
		size.width = size.width / 2;
		int y = screenSize.height - size.height;
		int x = screenSize.width - size.width;
		this.setLocation(x, y);
		
		setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			//jContentPane.add(getJPanel(), java.awt.BorderLayout.NORTH);
			//jContentPane.add(getJTextPane(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getJTextArea(), java.awt.BorderLayout.CENTER);
			jContentPane.add(new JLabel("   "),BorderLayout.EAST);
			jContentPane.add(new JLabel("   "),BorderLayout.WEST);
			jContentPane.add(new JLabel("   "),BorderLayout.NORTH);
			jContentPane.add(new JLabel("   "),BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
/*
	private JPanel getJPanel() {
		if (jPanel == null) {
			//jLabel2 = new JLabel();
			//jLabel2.setText("Per di ogni tentativo, viene comunicato un suggerimento figurato. Un piolo bianco indica che il colore è giusto ma la collocazione errata, un piolo nero indica che sia la collocazione che il colore sono giusti, l'assenza di un piolo indica che il colore è sbagliato. La posizione dei pioli di suggerimento non è collegata a quella dei pioli della combinazione provata.");
			//jLabel1 = new JLabel();
			//jLabel1.setText("La combinazione è formata da sei colori (più a scelta il piolo vuoto) che possono essere ripetuti quante volte si vuole nella stessa combinazione.");
			//jLabel = new JLabel();
			//jLabel.setText("Masterminchia è un gioco di logica per due giocatori. Scopo del gioco è indovinare la combinazione scelta dall'altro giocatore.");
			jPanel = new JPanel();
			jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
			//jPanel.add(jLabel, null);
			//jPanel.add(jLabel1, null);
			//jPanel.add(jLabel2, null);
		}
		return jPanel;
	}
*/
	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {		//bisogn andare a capo decentemente!!!
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setOpaque(false);
			jTextArea.setWrapStyleWord(true);
			jTextArea.setLineWrap(true);
			jTextArea.setColumns(45);
			jTextArea.setRows(33);
			//jTextArea.setText("\nMasterminchia è un gioco di logica per due giocatori.\n Scopo del gioco è indovinare la combinazione \nscelta dall'altro giocatore. La combinazione è formata\n da sei colori (più a scelta il piolo vuoto) che possono \nessere ripetuti quante volte si vuole nella stessa combinazione.\n Per di ogni tentativo, viene comunicato un suggerimento figurato.\n Un piolo bianco indica che il colore è giusto ma la collocazione errata, \nun piolo nero indica che sia la collocazione che il colore sono giusti,\n l'assenza di un piolo indica che il colore è sbagliato.\n La posizione dei pioli di suggerimento\n non è collegata a quella dei pioli della combinazione provata.\nSi vince se si riesce ad indovinare la combinazione\n entro i primi 10 tentativi.\n");
			jTextArea.setText("\nMasterminchia è un gioco di logica per due giocatori.\n\nScopo del gioco è indovinare la combinazione scelta segretamente dall'altro giocatore. La combinazione è formata da sei colori (più a scelta il piolo vuoto) che possono essere ripetuti quante volte si vuole nella stessa combinazione. \n\nPer ogni tentativo eseguito, viene comunicato un suggerimento figurato: \nUn piolo bianco indica che un colore è giusto ma la sua collocazione errata. \nUn piolo nero indica che un colore e sua la collocazione sono giusti. \nL'assenza di un piolo indica che un colore è sbagliato. \nLa posizione dei pioli di suggerimento non dà alcuna informazione aggiuntiva sui pioli della combinazione segreta. \n\nESEMPIO:\n\nCombinazione segreta: ROSSO, VERDE, GIALLO, ROSSO\n\nS'immagini di tentare questa combinazione: ROSSO, GIALLO, BIANCO, VERDE.\n\nIl programma visualizzerà un piolo nero (in quanto il primo ROSSO è al posto giusto) e un piolo bianco (in quanto il GIALLO non è al posto corretto); poiché BIANCO e VERDE non sono presenti nella combinazione segreta, non verrà visualizzato alcun piolo aggiuntivo. \n\nSi vince se si riesce ad indovinare la combinazione nascosta entro i primi 10 tentativi.\n\nScegliere un limite di tempo pari o inferiore ai "+Partita.BOUND_MIN+" minuti da' diritto ad un bonus di punteggio di "+Partita.BONUS_MIN+"/num. minuti max. Scegliere un limite di tempo superiore ai "+Partita.BOUND_MAX+" implica un malus al punteggio di "+Partita.MALUS_MIN+" per ogni minuto extra.\nE' sempre possibile disattivare il tempo limite rinunciando a tutti i punti extra.\n\nE' possibile escludere dalla combinazione segreta i pioli vuoto.");
			jTextArea.setEditable(false);
		}
		return jTextArea;
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
/*	private JTextPane getJTextPane() {
		if (jTextPane == null) {
			Document doc=new PlainDocument();
			try {
				doc.insertString(0,"Masterminchia è un gioco di logica per due giocatori. Scopo del gioco è indovinare la combinazione scelta dall'altro giocatore. La combinazione è formata da sei colori (più a scelta il piolo vuoto) che possono essere ripetuti quante volte si vuole nella stessa combinazione. Per di ogni tentativo, viene comunicato un suggerimento figurato. Un piolo bianco indica che il colore è giusto ma la collocazione errata, un piolo nero indica che sia la collocazione che il colore sono giusti, l'assenza di un piolo indica che il colore è sbagliato. La posizione dei pioli di suggerimento non è collegata a quella dei pioli della combinazione provata.",null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			jTextPane = new JTextPane();
			jTextPane.setDocument(doc);
		}
		return jTextPane;
	}
*/
	class Ascoltatore implements WindowListener
	{
		
		
		public void windowClosing(WindowEvent arg0) {
		
			dispose();
		}

		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}
