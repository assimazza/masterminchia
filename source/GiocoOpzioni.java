/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

import java.awt.BorderLayout;
//import java.awt.Component;
import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.HeadlessException;
import java.awt.Toolkit;
//import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
//import javax.swing.JComboBox;


public class GiocoOpzioni extends JFrame {

	private JTabbedPane jTabbedPane = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	//private JPanel jPanel2 = null;
	private Giocatore cojocojo;
	private Gestione gest;
	private JCheckBox vuoto = null;
	private JCheckBox tempo = null;
	private JTextField minuti = null;
	//private JComboBox difficoltà = null;
	//private JLabel jLabel = null;
	private JTextField nome = null;
	private JLabel nomeLabel = null;
	//private JLabel jLabel2 = null;
	private JLabel vinte = null;
	//private JLabel jLabel3 = null;
	private JLabel media = null;
	private JLabel tempoLabel = null;
	private JButton reset;
	private JLabel perse;
	private JPanel jPanel3;
	private JPanel jPanel4 = null;
	private JPanel jPanel5 = null;
	private JPanel jPanel6 = null;
	private JPanel jPanel7 = null;
	private JPanel jPanel8 = null;
	/**
	 * This is the default constructor
	 */
	public GiocoOpzioni(Gestione gigi) {
		super();
		gest=gigi;
		cojocojo=gest.getGiocatore();
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
		this.setContentPane(getJTabbedPane());
		this.setTitle("Opzioni");
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
	 * This method initializes jTabbedPane	
	 * 	
	 * @return javax.swing.JTabbedPane	
	 */
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.addTab("Gioco", null, getJPanel(), "Configura i dettagli di gioco");
			jTabbedPane.addTab("Giocatore", null, getJPanel1(), "Visualizza il profilo giocatore");
			//jTabbedPane.addTab("Multiplayer", null, getJPanel2(), "Configura le impostazioni multigiocatore");
		}
		return jTabbedPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			
			jPanel = new JPanel();
			jPanel.setLayout(new BorderLayout());
			
			
			jPanel.add(getJPanel6(), java.awt.BorderLayout.SOUTH);
			jPanel.add(getJPanel7(), java.awt.BorderLayout.NORTH);
			
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new BorderLayout());
			jPanel1.add(getJPanel4(), java.awt.BorderLayout.CENTER);

			jPanel1.add(getJPanel3(), java.awt.BorderLayout.NORTH);
			jPanel1.add(getJPanel5(), java.awt.BorderLayout.SOUTH);
			//jPanel1.add(reset, java.awt.BorderLayout.SOUTH);
		}
		return jPanel1;
	}

	private JPanel getJPanel3() {
		// TODO Auto-generated method stub
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setLayout(new BorderLayout(10,10));
			nomeLabel = new JLabel();
			nomeLabel.setText("                                    Nome:");
			jPanel3.add(nomeLabel, java.awt.BorderLayout.CENTER);
			jPanel3.add(getNome(), java.awt.BorderLayout.SOUTH);
		}
		return jPanel3;
	}
/*
	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
/*	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new BorderLayout());
		}
		return jPanel2;
	}
*/
	/**
	 * This method initializes vuoto	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getVuoto() {
		if (vuoto == null) {
			vuoto = new JCheckBox("Piolo vuoto abilitato",gest.isVuoto());
			vuoto.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					//System.out.println("stateChanged()"); // TODO Auto-generated Event stub stateChanged()
					gest.setVuoto(vuoto.isSelected());
				}
			});
		}
		return vuoto;
	}

	/**
	 * This method initializes tempo	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getTempo() {
		if (tempo == null) {
			tempo = new JCheckBox("Tempo attivato",gest.isTempo());
			tempo.addChangeListener(new javax.swing.event.ChangeListener() {
				public void stateChanged(javax.swing.event.ChangeEvent e) {
					//System.out.println("stateChanged()"); // TODO Auto-generated Event stub stateChanged()
					gest.setTempo(tempo.isSelected());
				}
			});
		}
		return tempo;
	}

	/**
	 * This method initializes minuti	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getMinuti() {
		if (minuti == null) {
			minuti = new JTextField((gest.getTempoMax()/60)+"");
			minuti.setColumns(3);
			minuti.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					//System.out.println("caretUpdate()"); // TODO Auto-generated Event stub caretUpdate()
						try {
							gest.setTempoMax(new Long(minuti.getText())*60);
							if(new Integer(minuti.getText())> Partita.BOUND_MAX)
								JOptionPane.showMessageDialog(null,"Tempi limiti maggiori a "+Partita.BOUND_MAX+"\ngenerano un malus di -"+Partita.MALUS_MIN+"\nper ogni minuto extra.\n\nTempi limite minori di "+Partita.BOUND_MIN+"\n danno diritto ad un bonus di "+Partita.BONUS_MIN+" / n. minuti.","Informazione",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Info.gif"));
						} catch (NumberFormatException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
							//System.out.println("ecco pippo!!!-"+minuti.getText()+"!");
							if(minuti.getText()!="")		//se cancello char non dovrebbe entrare
								JOptionPane.showMessageDialog(null,"INSERISCI UN NUMERO, CAZZO!!!","Errore!!!",JOptionPane.ERROR_MESSAGE);
						}
				}
			});
		}
		return minuti;
	}
/*
	/**
	 * This method initializes difficoltà	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
/*	private JComboBox getDifficoltà() {
		if (difficoltà == null) {
			difficoltà = new JComboBox();
			difficoltà.addItem("Ingenuo");
			difficoltà.addItem("Facile");
			difficoltà.addItem("Medio");
			difficoltà.addItem("Difficile");
			difficoltà.setSelectedIndex(gest.getDifficoltà());
			difficoltà.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					System.out.println("itemStateChanged()"); // TODO Auto-generated Event stub itemStateChanged()
					gest.setDifficoltà(difficoltà.getSelectedIndex());
				}
			});
		}
		return difficoltà;
	}
*/
	/**
	 * This method initializes nome	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNome() {
		if (nome == null) {
			nome = new JTextField(cojocojo.getNome(),HighScore.MAX_LONG);		//bisogna impedire di digitare più di 25char
			
			//nome.setColumns(HighScore.MAX_LONG);
			//System.out.println(nome.getColumns());
			nome.addCaretListener(new javax.swing.event.CaretListener() {
				public void caretUpdate(javax.swing.event.CaretEvent e) {
					//System.out.println("caretUpdate()"); // TODO Auto-generated Event stub caretUpdate()
					if(nome.getText().length()<=HighScore.MAX_LONG)
						cojocojo.setNome(nome.getText());
					else
						{
							JOptionPane.showMessageDialog(null,"\nHEY HEY!!!\n\nAddì cazzu và?\n\nCaratteri massimi consentiti: "+HighScore.MAX_LONG,"Errore!!!",JOptionPane.ERROR_MESSAGE,new ImageIcon("Errore.gif"));
							//nome.setText(nome.getText().substring(0,HighScore.MAX_LONG));	//spara eccezzione della minchia

							//nome.select(HighScore.MAX_LONG,nome.getText().length());
							//nome.replaceSelection("");
						}
					//System.out.println(cojocojo.getNome());
				}
			});
		}
		return nome;
	}

	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.setLayout(new BoxLayout(jPanel4,BoxLayout.Y_AXIS));
			tempoLabel = new JLabel();
			media = new JLabel();
			vinte = new JLabel();
			perse=new JLabel();
			this.setLabels();
			jPanel4.add(new JLabel(" "),null);
			jPanel4.add(vinte,null); //java.awt.BorderLayout.NORTH);
			jPanel4.add(new JLabel(" "),null);
			jPanel4.add(perse,null);// BorderLayout.CENTER);//perse.getName());
			jPanel4.add(new JLabel(" "),null);
			jPanel4.add(media, null);//java.awt.BorderLayout.WEST);
			jPanel4.add(new JLabel(" "),null);
			jPanel4.add(tempoLabel, null);//java.awt.BorderLayout.SOUTH);
			jPanel4.add(new JLabel(" "),null);
		}
		return jPanel4;
	}

	private void setLabels() {
		// TODO Auto-generated method stub
		//tempoLabel = new JLabel();
		tempoLabel.setText("Tempo di gioco totale:   "+cojocojo.getTempoGioco()+" secondi");
		//media = new JLabel();
		media.setText("Media vittorie:    "+cojocojo.getMedia()+"%");
		//vinte = new JLabel();
		vinte.setText("Partite vinte:     "+cojocojo.getVinte());
		perse.setText("Partite perse:     "+cojocojo.getPerse());
	}

	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			reset=new JButton("Resetta");
			//final GiocoOpzioni who=this;
			reset.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					int esito=JOptionPane.showConfirmDialog(null,"Sei sicuro di voler resettare le statistiche?","Resettare???", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);	
					if(esito==0)
					{
						cojocojo.reset();
						//non si visualizzano i cambiamenti
						//who.setVisible(false);
						//who.update(who.getGraphics());
						//who.setVisible(true);
						//jPanel4=null;
						//jPanel4=getJPanel4();
						//jPanel1.add(jPanel4,BorderLayout.CENTER);
						setLabels();
						//who.repaint();
						repaint();
					}
				}
			});
			jPanel5.add(reset);//,FlowLayout.LEADING);
		}
		return jPanel5;
	}
/*
	protected void ridisegna() {
		// TODO Auto-generated method stub
		this.repaint();
		System.out.println("neanche la facoltà d'ingegneria intera può niente contro il repaint!!!");
	}
*/
	/**
	 * This method initializes jPanel6	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jPanel6 = new JPanel();
			//jLabel = new JLabel();
			//jLabel.setText("Difficoltà:    ");
			//jPanel6.add(jLabel);//, java.awt.BorderLayout.NORTH);
			//jPanel6.add(getDifficoltà());//, java.awt.BorderLayout.CENTER);
			jPanel6.add(new JLabel(" "),null);
		}
		return jPanel6;
	}

	/**
	 * This method initializes jPanel7	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel7() {
		if (jPanel7 == null) {
			jPanel7 = new JPanel();
			jPanel7.setLayout(new BoxLayout(jPanel7,BoxLayout.Y_AXIS));
			jPanel7.add(new JLabel(" "),null);
			jPanel7.add(new JLabel(" "),null);
			jPanel7.add(getVuoto(), null);
			jPanel7.add(new JLabel(" "),null);
			jPanel7.add(getTempo(), null);
			jPanel7.add(new JLabel(" "),null);
			jPanel7.add(new JLabel(" "),null);
			jPanel7.add(new JLabel("Tempo massimo (minuti):"),null);
			//jPanel7.add(new JLabel(" "),null);
			jPanel7.add(getJPanel8(), null);
			jPanel7.add(new JLabel(" "),null);
			
		}
		return jPanel7;
	}

	/**
	 * This method initializes jPanel8	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel8() {
		if (jPanel8 == null) {
			jPanel8 = new JPanel();
			jPanel8.add(getMinuti(), null);
		}
		return jPanel8;
	}
/*
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
*/
}


