/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

import java.awt.Color;
//import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
//import javax.swing.SwingConstants;
//import javax.swing.border.BevelBorder;
//import javax.swing.border.Border;
//import javax.swing.border.LineBorder;


public class Console extends JPanel implements Soundable{

	private static final int SPAZIO_COLORI = 50;
	private static final int SPAZIO_POSTI=35;
	private static final int INIZIO_POSTI=115;

	private Partita gioco;
	private int index;
	//private int color;
	private TimerUpdater upd;
	private int delta;
	private int tent;
	private boolean on;
	private ServizioSveglia rubrica;
	
	private final ImageIcon SELECT=new ImageIcon("Selettore.png");
/*	public final static ImageIcon rosso=new ImageIcon("rosso.png");
	public final static ImageIcon giallo=new ImageIcon("giallo.png");
	public final static ImageIcon verde=new ImageIcon("verde.png");
	public final static ImageIcon blu=new ImageIcon("blu.png");
	public final static ImageIcon bianco=new ImageIcon("bianco.png");
	public final static ImageIcon nero=new ImageIcon("nero.png");
*/
	private final ImageIcon VUOTO=new ImageIcon("vuoto.png");
	public final static int ALTEZZA=150+10;//150;//100+50;

	private Grafica tabula;
	
	private JLabel colori[] = null;
	private JLabel nome=null;
	private JCheckBox posti[]=null;
	private JLabel attenzione;
	private JButton conferma;
	private JLabel tempo;
	private JLabel cnt;
	private JLabel select;
	/**
	 * This is the default constructor
	 */
	public Console(Partita gioco,Grafica tabula) {
		super();
		this.gioco=gioco;
		colori=new JLabel[Grafica.COLORI.length+1];
		posti=new JCheckBox[Combinazione.LUNGHEZZA];
		index=0;
		//color=Combinazione.VUOTO;
		this.tabula=tabula;
		tent=0;
		on=true;
		rubrica=null;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(Grafica.LARGHEZZA, ALTEZZA);
		//System.out.println("Ci signu");
		setLayout(null);

		
		addPioli();
		
		addCheckBox();
		
		nome=new JLabel(gioco.getNome());
		//nome.setBounds(SPAZIO_COLORI*3,ALTEZZA-50-nome.getHeight(),nome.getWidth()+50,nome.getHeight()+50);
		nome.setBounds(SPAZIO_COLORI+(delta*2)+30,this.getHeight()-25,this.getWidth(),15);//nome.getHeight());
		add(nome);
		
		attenzione=new JLabel("ATTENZIONE!!!");
		attenzione.setBounds((INIZIO_POSTI-14)+SPAZIO_POSTI/2,30,120,25);
		attenzione.setForeground(Color.RED);
		//nome.setAlignmentX(SwingConstants.CENTER);
		add(attenzione);
		attenzione.setVisible(true);//false);
		
		addButton();
		
		tempo=new JLabel("TEMPO:");
		tempo.setBounds(conferma.getX(),posti[0].getY(),50,25);
		add(tempo);
		
		addCnt();
		
		addSelect();
	}

	private void addSelect() {			
		// TODO Auto-generated method stub
		select=new JLabel(SELECT);
		select.setBounds(colori[0].getX()-((SELECT.getIconWidth()-colori[0].getWidth())/2),colori[0].getY()-((SELECT.getIconHeight()-colori[0].getIcon().getIconHeight())/2),SELECT.getIconWidth(),SELECT.getIconHeight());
		add(select);
	}

	private void addCnt() {
		// TODO Auto-generated method stub
		
		cnt=new JLabel("00:00");
		cnt.setBounds(tempo.getX()+5,tempo.getY()+15,50,25);
		upd=new TimerUpdater(this);
		add(cnt);
		upd.start();		//upd non permette di piazzare i pioli della soluzione al loro posto
	}

	private void addButton() {
		// TODO Auto-generated method stub
		conferma=new JButton("OK");
		conferma.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				if (rubrica==null)
					throw new IllegalStateException("Errore nella creazione del gioco: nessuna GUI iscritta al ServizioSveglia!!!");
					
				if(!gioco.isFine())
				{	
					gioco.confronta();			//segreto: G,R,R,B combinazione: R,G,R,G risultato: 3B 1N invece di 2B 1N
					
					refresh();
				}
				//se il gioco è finito la pressione di ok non scatena alcunché
			}
		});
		conferma.setBounds(10,nome.getY()-25,55,20);
		add(conferma);
	}

	private void addCheckBox() {
		// TODO Auto-generated method stub
		for(int i=0;i<posti.length;i++)
		{
			posti[i]=new JCheckBox();
			posti[i].setBounds(INIZIO_POSTI-14+(SPAZIO_POSTI*i),1,21,21);
			
				
			add(posti[i]);
		}
		posti[0].setSelected(true);
		for(int i=0;i<posti.length;i++){										//RINCOGLIONITO!!!
			posti[i].addActionListener(new ActionListener()
				{
				public void actionPerformed(java.awt.event.ActionEvent e) {
				for(int i=0;i<posti.length;i++)
				{
				//System.out.println("ciao:"+index);
					posti[i].setSelected(false);
					if(e.getSource().equals(posti[i]))
						index=i;
				}
				//index=(index+1)%(Combinazione.LUNGHEZZA-1);
				posti[index].setSelected(true);
				//System.out.println("Addio:"+posti[index-1%Combinazione.LUNGHEZZA-1].isEnabled());
				}});
		}
	}

	private void addPioli() {
		// TODO Auto-generated method stub
		int i=0;
		delta=0;
		for(i=0;i<Grafica.COLORI.length;i++)
		{
			ImageIcon img=new ImageIcon(Grafica.COLORI[i]);
			colori[i]=new JLabel(img);
			colori[i].setBounds(SPAZIO_COLORI+(img.getIconWidth()*i)+((SELECT.getIconWidth()-img.getIconWidth())/2)+(5*i)/*SPAZIO_COLORI*(i+1)*/,55,img.getIconWidth(),img.getIconHeight());//60+50);
			delta=img.getIconWidth();
			colori[i].addMouseListener(new java.awt.event.MouseAdapter() {
				

				public void mouseClicked(java.awt.event.MouseEvent e) {
					//System.out.println("mouseClicked()"); // TODO Auto-generated Event stub mouseClicked()
					if(on) {
						JLabel who=(JLabel)e.getSource();
						select.setLocation(who.getX()-((SELECT.getIconWidth()-who.getWidth())/2),who.getY()-((SELECT.getIconHeight()-who.getIcon().getIconHeight())/2));
						int i=0;
						for(i=0;i<colori.length;i++)
							if(colori[i].equals(who))
								break;
						//System.out.println(i);
						//if(i<colori.length-1)
						gioco.setTentativo(index,i+1);
						//else
						//gioco.setTentativo(index,0);
						index=(index+1)%(Combinazione.LUNGHEZZA);
						Combinazione comb=gioco.getTentativo();
						//questo pezzo di codice si può cancellare se si modifica Tabellone.VUOTO in COLORI.length (cioé 7) e se tutti i colori di tabellone vengano decrementati di 1
						/*for(int j=0;j<comb.LUNGHEZZA;j++)
						{	
							comb.setElem(i,comb.getElem(j)+1);
							if(comb.getElem(j)<0)
								comb.setElem(j,Grafica.COLORI.length);
						}*/
						//alternativamente si può piazzare il VUOTO sulla grafica a sinistra del rosso e modificare tutti gli array grafici in modo che vuoto=0 e rosso e camperi siano il valore vecchio+1
						tabula.pianta(comb,tent,false);
						tabula.update(tabula.getGraphics());
						aggiornaCheckBox();
					}//if
				}
			});
			
			add(colori[i]);
		}
		
		
		ImageIcon img=VUOTO;
		colori[i]=new JLabel(img);
		colori[i].setBounds(SPAZIO_COLORI+(delta*(i))+((SELECT.getIconWidth()-delta)/2)+(5*(i)),55/*SPAZIO_COLORI*(i+1),105*/,img.getIconWidth(),img.getIconHeight());//55+50);
		colori[i].addMouseListener(new java.awt.event.MouseAdapter() {
			
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if(!gioco.isFine())
				{
					JLabel who=(JLabel)e.getSource();
					select.setLocation(who.getX()-((SELECT.getIconWidth()-who.getWidth())/2),who.getY()-((SELECT.getIconHeight()-who.getIcon().getIconHeight())/2));
					gioco.setTentativo(index,0);
					index=(index+1)%(Combinazione.LUNGHEZZA);
					tabula.pianta(gioco.getTentativo(),tent,false);
					tabula.update(tabula.getGraphics());
					aggiornaCheckBox();
				}
			}

			
			});
			
		add(colori[i]);
		/*
		ImageIcon img=new ImageIcon(Grafica.ROSSO);
		JLabel icona=new JLabel(img);
		icona.setBounds(img.getIconHeight(),img.getIconWidth(),INTERSPAZIO,60);
		add(icona);
		
		
//		larghezza img=22, larghezza selettore=30, interspazio img-select=(30-22)/2=4, interspazio selet-selet=5, distanza=4+5=9
		img=new ImageIcon(Grafica.BIANCO);
		icona=new JLabel(img);
		//icona.setBounds(img.getIconHeight(),img.getIconWidth(),(SPAZIO_COLORI*i)+img.getIconWidth()+img.getIconWidth()/2)+((SELECT.getIconWidth()-img.getIconWidth())/2)+SPAZIO_COLORI*///,60);
		/*add(icona);
		
		img=new ImageIcon(Grafica.VERDE);
		icona=new JLabel(img);
		icona.setBounds(img.getIconHeight(),img.getIconWidth(),(INTERSPAZIO*3),60);
		add(icona);
		
		img=new ImageIcon(Grafica.BLU);
		icona=new JLabel(img);
		icona.setBounds(img.getIconHeight(),img.getIconWidth(),(INTERSPAZIO*4),60);
		add(icona);
		
		img=new ImageIcon(Grafica.GIALLO);
		icona=new JLabel(img);
		icona.setBounds(img.getIconHeight(),img.getIconWidth(),(INTERSPAZIO*5),60);
		add(icona);
		
		img=new ImageIcon(Grafica.NERO);
		icona=new JLabel(img);
		icona.setBounds(img.getIconHeight(),img.getIconWidth(),(INTERSPAZIO*6),60);
		add(icona);
		*/
	}

	private void aggiornaCheckBox() {
		// TODO Auto-generated method stub
		for(int i=0;i<posti.length;i++)
		{
			if(i==index)
				posti[i].setSelected(true);
			else
				posti[i].setSelected(false);
		}
	}

	public JLabel getAttenzione() {
		return attenzione;
	}


	//public JLabel getCnt() {
		//return cnt;
	//}

	public void setCnt(String txt) {
		this.cnt.setText(txt);
	}
	
	public JLabel getCnt() {
		return this.cnt;
	}

	public Clock askClock() {
		// TODO Auto-generated method stub
		return gioco.getClock();
	}
	
	public void endGame()
	{
		upd.interrupt();
		
		on=false;	//disattiva grafica e pulsanti
		
		if(/*gioco.isFine() && */gioco.isSconfitto())
		{
			JOptionPane.showMessageDialog(null,"Ahi ahi, caro "+gioco.getNome()+", \nsei stato sconfitto un'altra volta!!!","HAI PERSO (ihihi...)",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Perdi.gif"));
			//upd.interrupt();
			//JOptionPane.showMessageDialog(null,"Punteggio guadagnato: "+giocatore.getPunteggio(),"PUNTEGGIO",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Punteggio.png"));		questa riga va messa in guigestione
		}
		else if(/*gioco.isFine() && */!gioco.isSconfitto())
		{
			JOptionPane.showMessageDialog(null,"BRAVO "+gioco.getNome()+"!!! \nHAI INDOVINATO LA COMBINAZIONE \n(per questa volta)","HAI VINTO (nooooo!!!!)",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Vinci.gif"));
			//upd.interrupt();
			//JOptionPane.showMessageDialog(null,"Punteggio guadagnato: "+giocatore.getPunteggio(),"PUNTEGGIO",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("Punteggio.png"));		//questa riga va messa in guigestione
		}
		//System.out.println("Oi mà ca mò chiamu");
		rubrica.avvisa();
	}

	public void ring() {
		// TODO Auto-generated method stub
		refresh();
	}
	
	private void refresh()
	{
		tabula.update(tabula.getGraphics());
		tent++;
		//						qui si deve aggiungere codice
		if(gioco.isFine())// && gioco.isSconfitto())
			endGame();
		//else if(gioco.isFine() && !gioco.isSconfitto())
		//	endGame();
		
		if(on){		//fa riapparire l'ultima combinazione
			tabula.pianta(gioco.getTentativo(),tent,false);
			tabula.update(tabula.getGraphics());
		}
	}

	public void setAvvisabili(ServizioSveglia telefonino) {
		// TODO Auto-generated method stub
		rubrica=telefonino;
	}
}
