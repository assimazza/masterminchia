/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
//import javax.swing.border.Border;
//import javax.swing.border.LineBorder;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GUIgestione extends JFrame implements Soundable {

	
/**
 * @label Apre
 */
/*#Regole Dependency_Link*/


	//private Sfondo lnkSfondo;

/**
 * @label Apre
 */
/*#Info Dependency_Link1*/


/**
 * @label Apre
 */

/*#GiocoOpzioni Dependency_Link2*/





private static final int SPAZIETTO = 10;

	private final int INTERSTIZIO = 50;

	private Gestione gest;

	private JPanel jContentPane = null;
	private JMenuBar menu = null;
	private JMenu partitaMenu = null;
	private JMenuItem singola = null;
//	private JMenuItem doppia = null;
//	private JMenuItem multiplayer = null;
	private JMenu giocoMenu = null;
	private JMenuItem opzioniGioco = null;
	private JMenuItem esci = null;
	private JMenu aiuto = null;
	private JMenuItem regole = null;
	private JMenuItem infos = null;
	//private JMenu opzioniMenu = null;
	private JMenuItem highScore = null;
	private JMenuItem resetScore = null;
	//private JPanel sfondo;
	private Console consob;
	private Grafica tabula;
	//private JMenuItem pausa = null;
	private JMenuItem termina = null;

	/**
	 * This is the default constructor
	 */
	public GUIgestione() {
		super();
		initialize();
		String name = JOptionPane.showInputDialog(this, "Benvenuto in "
				+ this.getTitle() + "!!\nInserisci il tuo nome:");//,JOptionPane.QUESTION_MESSAGE);
		if (name == null)
			name = "Sconosciuto";
		gest = new Gestione(name);
	}

	public GUIgestione(Gestione gigi) {
		super();
		initialize();
		gest = gigi;
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		addWindowListener(new GUIgestione.Ascoltatore());
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//System.out.println((Grafica.LARGHEZZA * 2) + INTERSTIZIO + "Ciao");
		//System.out.println(Grafica.ALTEZZA + Console.ALTEZZA + 10 + "zizì");
		this.setSize((Grafica.LARGHEZZA * 2) + INTERSTIZIO, Grafica.ALTEZZA
				+ Console.ALTEZZA + /*(SPAZIETTO)*/+50);//600, 682);		//275x2+50=X=600	521+150(=console)+20=Y=682
		this.setJMenuBar(getMenu());
		this.setContentPane(getJContentPane());
		this.setTitle("MASTERMINCHIA");
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

		//setLocation(unnu sacciu);

		setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new Sfondo();//new JPanel();
			jContentPane.setLayout(null);//new BorderLayout());
			jContentPane.setBounds(0, 0, (Grafica.LARGHEZZA * 2) + INTERSTIZIO,
					Grafica.ALTEZZA + Console.ALTEZZA + (SPAZIETTO));
			//System.out.println("campo da gioco di="
			//		+ ((Grafica.LARGHEZZA * 2) + INTERSTIZIO) + "larghezza e"
			//		+ (Grafica.ALTEZZA + Console.ALTEZZA + SPAZIETTO)
			//		+ "altezza");
			//ImageIcon sfondo=new ImageIcon("Sfondo.jpg");
			//JLabel back=new JLabel(sfondo);

			//System.out.println(jContentPane.getHeight());

			//back.setBounds(0,0/*(jContentPane.getHeight()-sfondo.getIconHeight())/2*/,sfondo.getIconWidth(),sfondo.getIconHeight());
			//System.out.println((jContentPane.getHeight()-back.getHeight())/2);
			//sfondo=new Sfondo();
			//jContentPane.add(sfondo);
			//back.setEnabled(false);
			//jContentPane.add(back);
		}
		return jContentPane;
	}

	/**
	 * This method initializes menu
	 *
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getMenu() {
		if (menu == null) {
			menu = new JMenuBar();
			menu.add(getGiocoMenu());

			//menu.add(getOpzioniMenu());
			menu.add(getAiuto());
		}
		return menu;
	}

	/**
	 * This method initializes partitaMenu
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getPartitaMenu() {
		if (partitaMenu == null) {
			partitaMenu = new JMenu("Nuova partita...");
			partitaMenu.add(getSingola());
			//partitaMenu.add(getDoppia());
			//partitaMenu.add(getMultiplayer());
		}
		return partitaMenu;
	}

	/**
	 * This method initializes singola
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getSingola() {
		if (singola == null) {
			singola = new JMenuItem("...singola");
			final GUIgestione io = this; //trucchettoso
			singola.addActionListener(new java.awt.event.ActionListener() {

				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()ci sei o ci fai?"); // TODO Auto-generated Event stub actionPerformed()
					//crea console
					//System.out.println("ho il tabellone:" + (tabula != null));

					if (tabula != null) //&&
					{
						//System.out.println("ho il sbunnatu u juacu:"
						//		+ tabula.isOver());
						if (tabula.isOver()) {
							//System.out
							//		.println("Ci signu zizì!! Pulizzu tutti cosi");
							jContentPane.remove(tabula);
							jContentPane.remove(consob);
							tabula = null;
							jContentPane.update(jContentPane.getGraphics());
						}
					}
					if (tabula == null) {
						//System.out.println(Gestione.SINGOLA);
						Partita gioco = gest.creaPartita(Gestione.SINGOLA);

						ServizioSveglia avviso = new ServizioSveglia();
						gioco.getClock().associa(avviso);
						avviso.subscribe(gioco);

						//tabula=new Grafica(gioco.getSegreto());
						tabula = gioco.tabellone.getGrafica(); //ma questo nbon si dovrebbe fare!!!
						tabula.setBounds(0, 0, tabula.getWidth(), tabula
								.getHeight());
						jContentPane.add(tabula);

						consob = new Console(gioco, tabula);//,BorderLayout.CENTER);
						consob
								.setBounds(
										0,
										tabula.getHeight()/*+SPAZIETTO/*jContentPane.getHeight()-consob.getHeight()*/,
										consob.getWidth(), consob.getHeight());

						avviso.subscribe(consob);

						ServizioSveglia telefonino = new ServizioSveglia();
						telefonino.subscribe(io); //trucchettoso
						consob.setAvvisabili(telefonino);

						//System.out.println(INTERSTIZIO + " buco dellechiappe");
						//System.out.println("sono in" + tabula.getHeight()
						//		+ INTERSTIZIO);
						//System.out.println(tabula.getHeight()
						//		+ "diametro della chiappa");

						jContentPane.add(consob);
						//	consob.update(consob.getGraphics());
						//	crea timer
						partitaMenu.setEnabled(false);
						opzioniGioco.setEnabled(false);
						resetScore.setEnabled(false);
						termina.setEnabled(true);
						//pausa.setEnabled(true);

						//non funge
						/*Border bordo = new LineBorder(Color.YELLOW, 10);//BevelBorder.RAISED,Color.YELLOW,Color.DARK_GRAY);
						bordo.paintBorder(consob, consob.getGraphics(), consob
								.getX() + 10, consob.getY() + 10, consob
								.getWidth() + 50, consob.getHeight() + 50);
						System.out.println(bordo);*/
						gioco.startTempo();
						jContentPane.update(jContentPane.getGraphics());
					}
				}
			});
		}
		return singola;
	}

	/*
	 /**
	 * This method initializes doppia
	 *
	 * @return javax.swing.JMenuItem
	 */
	/*	private JMenuItem getDoppia() {
	 if (doppia == null) {
	 doppia = new JMenuItem("...contro il computer");
	 }
	 return doppia;
	 }
	 */
	/*
	 /**
	 * This method initializes multiplayer
	 *
	 * @return javax.swing.JMenuItem
	 */
	/*	private JMenuItem getMultiplayer() {
	 if (multiplayer == null) {
	 multiplayer = new JMenuItem("...in rete");
	 }
	 return multiplayer;
	 }
	 */
	/**
	 * This method initializes giocoMenu
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getGiocoMenu() {
		if (giocoMenu == null) {
			giocoMenu = new JMenu("Gioco");
			giocoMenu.add(getPartitaMenu());
			//			giocoMenu.add(getPausa());
			giocoMenu.add(getTermina());
			giocoMenu.add(new JSeparator());
			giocoMenu.add(getOpzioniGioco());
			giocoMenu.add(new JSeparator());
			giocoMenu.add(getHighScore());
			giocoMenu.add(getResetScore());
			giocoMenu.add(new JSeparator());
			giocoMenu.add(getEsci());
		}
		return giocoMenu;
	}

	/**
	 * This method initializes opzioniGioco
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getOpzioniGioco() {
		if (opzioniGioco == null) {
			opzioniGioco = new JMenuItem("Opzioni...");
			opzioniGioco.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					new GiocoOpzioni(gest);
				}
			});
		}
		return opzioniGioco;
	}

	/**
	 * This method initializes opzioniGiocatore
	 *
	 * @return javax.swing.JMenuItem
	 */
	/*	private JMenuItem getOpzioniGiocatore() {
	 if (opzioniGiocatore == null) {
	 opzioniGiocatore = new JMenuItem("...del giocatore");
	 }
	 return opzioniGiocatore;
	 }
	 */
	/**
	 * This method initializes opzioniMultiplayer
	 *
	 * @return javax.swing.JMenuItem
	 */
	/*	private JMenuItem getOpzioniMultiplayer() {
	 if (opzioniMultiplayer == null) {
	 opzioniMultiplayer = new JMenuItem("...multiplayer");
	 }
	 return opzioniMultiplayer;
	 }
	 */
	/**
	 * This method initializes esci
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getEsci() {
		if (esci == null) {
			esci = new JMenuItem("Esci");
			esci.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					esci();

				}
			});
		}
		return esci;
	}

	private void esci() {
		// TODO Auto-generated method stub
		boolean go = true;

		if (gest.getGioco() != null) {
			go = terminaPartita();
		}

		if (go) {
			try {
				//System.out.println("Minni vaju");
				gest.salva();

			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("Errore scrittura file");
				JOptionPane
						.showMessageDialog(
								null,
								"Errore nella scrittura del file, le impostazioni non saranno salvate",
								"Errore!!!", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("Errore scrittura dei dati");
				JOptionPane
						.showMessageDialog(
								null,
								"Errore nella scrittura dei dati, le impostazioni non sono state salvate correttamente",
								"Errore!!!", JOptionPane.ERROR_MESSAGE);
			}
			this.dispose();
			System.out.println("\nDedicato a Lena....");
			System.exit(0);
		}
	}

	/**
	 * This method initializes aiuto
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getAiuto() {
		if (aiuto == null) {
			aiuto = new JMenu("Aiuto");
			aiuto.add(getRegole());
			aiuto.add(new JSeparator());
			aiuto.add(getInfos());
		}
		return aiuto;
	}

	/**
	 * This method initializes regole
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getRegole() {
		if (regole == null) {
			regole = new JMenuItem("Regole");
			regole.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					new Regole();
				}
			});
		}
		return regole;
	}

	/**
	 * This method initializes infos
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getInfos() {
		if (infos == null) {
			infos = new JMenuItem("Informazioni su...");
			infos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					new Info();
				}
			});
		}
		return infos;
	}

	/**
	 * This method initializes opzioniMenu
	 *
	 * @return javax.swing.JMenu
	 */
	/*	private JMenu getOpzioniMenu() {
	 if (opzioniMenu == null) {
	 opzioniMenu = new JMenu("Opzioni...");
	 opzioniMenu.add(getOpzioniGiocatore());
	 opzioniMenu.add(getOpzioniMultiplayer());
	 }
	 return opzioniMenu;
	 }
	 */
	/**
	 * This method initializes highScore
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getHighScore() {
		if (highScore == null) {
			highScore = new JMenuItem("Punteggi migliori...");
			highScore.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					new Punteggi(gest.getHighScore());
				}
			});
		}
		return highScore;
	}

	/**
	 * This method initializes resetScore
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getResetScore() {
		if (resetScore == null) {
			resetScore = new JMenuItem("Azzera punteggi");
			resetScore.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					int ris = JOptionPane.showConfirmDialog(null,
							"Sei sicuro di voler resettare i punteggi?",
							"Resetti?", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (ris == 0)
						gest.resetHighScore();
				}
			});
		}
		return resetScore;
	}

	/**
	 * This method initializes termina
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getTermina() {
		if (termina == null) {
			termina = new JMenuItem("Termina partita");
			termina.setEnabled(false);
			termina.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()

					terminaPartita();
				}
			});
		}
		return termina;
	}

	private boolean terminaPartita() {
		int ris = JOptionPane.showConfirmDialog(null,
				"Sei sicuro di voler terminare la partita con una sconfitta?",
				"Getti la spugna?", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
		//System.out.println("mi chiamo topolino:" + ris);
		if (ris == 0) {
			//termina partita
			//System.out.println("Viva topolino!!");
			gest.forceEnd();
			consob.endGame();
			tabula.forceOver();
			partitaMenu.setEnabled(true);
			termina.setEnabled(false);
			opzioniGioco.setEnabled(true);
			resetScore.setEnabled(true);
			//andrebbe fatta la interrupt del clock?
			return true;
		}
		return false;
	}

	public void ring() {
		// TODO Auto-generated method stub
		//System.out.println("Ho finito con tabula:" + tabula.isOver());

		termina.setEnabled(false);
		partitaMenu.setEnabled(true);
		opzioniGioco.setEnabled(true);
		resetScore.setEnabled(true);

		if (gest.getGiocatore().isWin()) {
			JOptionPane.showMessageDialog(null, "UDITE! UDITE!\n\nSignori e signore le statistiche.\n\nPunteggio guadagnato: \n"
					+ gest.getGiocatore().getPunteggio(), "PUNTEGGIO",
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
							"Punteggio.png"));
			gest.getGiocatore().reload();
		}

		if (gest.isNewRecord()) {
			gest.resetNewRecord();
			JOptionPane
					.showMessageDialog(
							null,
							"EVVIVA "
									+ gest.getGiocatore().getNome()
									+ "!!!!\n\nSEI DIVENTATO FAMOSO!!!!\n\nSei entrato nella high score!",
							"      !!!!!!! - NUOVO RECORD - !!!!!!!!",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
									"Bravo.gif"));
			new Punteggi(gest.getHighScore());
		}
	}

	class Ascoltatore implements WindowListener {
	
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println("nculuaopened");
		}
	
		public void windowClosing(WindowEvent arg0) {
			//			 TODO Auto-generated method stub
			esci();
			//arg0.getWindow().setVisible(true);//.update(arg0.getWindow().getGraphics());
			//System.out.println("nculamammata");
			/*
			 boolean go=false;
			 
			 if(gest.getGioco()!=null)
			 {
			 go=terminaPartita();
			 }
			 
			 System.out.println("mammata è puttana?:"+go);
			 if(go)
			 {
			 try {
			 System.out.println("Minni vaju");
			 gest.salva();
			 
			 } catch (FileNotFoundException e1) {
			 // TODO Auto-generated catch block
			 e1.printStackTrace();
			 System.out.println("Errore scrittura file");
			 JOptionPane.showMessageDialog(null,"Errore nella scrittura del file, le impostazioni non saranno salvate","Errore!!!",JOptionPane.ERROR_MESSAGE);
			 } catch (IOException e1) {
			 // TODO Auto-generated catch block
			 e1.printStackTrace();
			 System.out.println("Errore scrittura dei dati");
			 JOptionPane.showMessageDialog(null,"Errore nella scrittura dei dati, le impostazioni non sono state salvate correttamente","Errore!!!",JOptionPane.ERROR_MESSAGE);
			 }
			 System.out.println("Signu da mammata");
			 dispose();
			 System.exit(0);		//non esce da tutto
			 }
			 */
		}
	
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println("nculaquantimuartiteni");
	
		}
	
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println("nculaiconifed");
		}
	
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println("nculuadeiconifed");
		}
	
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println("nculuaactivated");
		}
	
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println("nuculuadeactivated");
		}
	
	}

}

/*
 /**
 * This method initializes pausa
 *
 * @return javax.swing.JMenuItem
 */
/*	private JMenuItem getPausa() {
 if (pausa == null) {
 pausa = new JMenuItem("Pausa");
 pausa.setEnabled(false);
 }
 return pausa;
 }
 */

class Sfondo extends JPanel {
	private final String SFONDO = "Sfondo.jpg";

	/*public Sfondo()
	 {super();}*/

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(0, 0, 0));
		Image image1 = null; //commentare da qui per togliere sfondo
		try {
			image1 = ImageIO.read(new File(SFONDO));
		} catch (Exception e) {
			e.printStackTrace();
		}
		ImageIcon img = new ImageIcon(SFONDO);
		g.drawImage(image1, 0, (this.getHeight() - img.getIconHeight()) / 2,
				img.getIconWidth(), img.getIconHeight(), null);

	}
}
