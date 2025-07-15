/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

//import java.awt.CardLayout;
//import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Grafica extends JPanel {

	private final static JLabel TABELLONE=new JLabel(new ImageIcon("Tabellone.jpg"));

	private static final long serialVersionUID = 584149615083540990L;

	private final static String TABELLONEFILE="Tabellone.jpg";
	
	public static final int LARGHEZZA = TABELLONE.getIcon().getIconWidth();
	public static final int ALTEZZA = TABELLONE.getIcon().getIconHeight();

	private static final String SUGGBIANCO = "PioloB.png";

	private static final String SUGGNERO = "PioloN.png";
	
	public final static String []COLORI={new String ("Rosso.png"),new String ("Giallo.png"),new String ("Nero.png"),new String ("Verde.png"),new String ("Bianco.png"),new String ("Blu.png")};
	public final static String VUOTO="Vuoto.png";
	/*public final static String ROSSO=new String ("Rosso.png");
	public final static String GIALLO=new String ("Giallo.png");
	public final static String VERDE=new String ("Verde.png");
	public final static String BLU=new String ("Blu.png");
	public final static String BIANCO=new String ("Bianco.png");
	public final static String NERO=new String ("Nero.png");
	*/
/*	
	private JLabel rosso=new JLabel(new ImageIcon(COLORI[0]));//new ImageIcon(ROSSO);
	private JLabel giallo=new JLabel(new ImageIcon(COLORI[1]));//GIALLO);
	private JLabel verde=new JLabel(new ImageIcon(COLORI[2]));//VERDE);
	private JLabel blu=new JLabel(new ImageIcon(COLORI[3]));//BLU);
	private JLabel bianco=new JLabel(new ImageIcon(COLORI[4]));//BIANCO);
	private JLabel nero=new JLabel(new ImageIcon(COLORI[5]));//NERO);
*/	
	private boolean over;
	private Combinazione soluzione;
	private JLabel color[];

	private final int XCOLOR=106;//100;//115;
	private final int YCOLOR=456;//448;//465; //II=425
	private final int YDELTA_COLOR=40;
	private final int XDELTA_COLOR=33;
	
	private final int XSUGG=51;
	private final int YSUGG=453; 
	private final int XDELTA_SUGG=17;
	private final int YDELTA_SUGG=16;
	private final int NEXTSUGG=40;
	
	private static final int XSOLUZ=78;
	private static final int YSOLUZ=8;
	
	/**
	 * This is the default constructor
	 */
	public Grafica(Combinazione incognita){
		super();
		//System.out.println(TABELLONE.getIcon().getIconHeight()+"grafica è...");
		over=false;
		soluzione=incognita;
		color=new JLabel[Combinazione.LUNGHEZZA];
		initialize();
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		setLayout(null);

		this.setSize(TABELLONE.getIcon().getIconWidth(), TABELLONE.getIcon().getIconHeight());
		TABELLONE.setBounds(0,0,TABELLONE.getIcon().getIconWidth(),TABELLONE.getIcon().getIconHeight());
		//add(TABELLONE);
	}
	
	/**
	 * @model.uin <code>design:node:::tq87glesbvimuj-p7usog:-tdsqjuesa8p17xjpnh5a</code>
	 */
//	public void disegna() {
		/* default generated stub *///;

//	}
/*
	public void perdi() {
		// TODO Auto-generated method stub
		
	}
*/
/*	public void vinci() {
		// TODO Auto-generated method stub
		
	}
*/	
	public void pianta(Combinazione y,int numTent,boolean shift)
	{
		if(shift)
			color=new JLabel[Combinazione.LUNGHEZZA];
		for(int i=0;i<Combinazione.LUNGHEZZA;i++)
		{
			//System.out.println("Sono mister "+i);
			//System.out.println("Sono un giotto"+(COLORI[y.getElem(i)-1])+" che è meglio "+y.getElem(i));
					//va fatto ad array globale
			try{
				if(color[i]!=null)
					remove(color[i]);
				color[i]=new JLabel(new ImageIcon(COLORI[y.getElem(i)-1]));
				color[i].setBounds(XCOLOR+(XDELTA_COLOR*i),YCOLOR+(YDELTA_COLOR*-numTent),color[i].getIcon().getIconWidth(),color[i].getIcon().getIconHeight());
				add(color[i],i+"");
			}catch(ArrayIndexOutOfBoundsException aioobe)
			{
				//System.out.println("SystemOfADown"+(Combinazione.VUOTO-1));
				if(i>COLORI.length || i<Combinazione.VUOTO-1)
					aioobe.printStackTrace();
				//else
				//	remove(color[i]);
				//color=new JLabel(new ImageIcon(VUOTO));
			}
		}
		
	}

	public void aggiorna(Combinazione y, Suggerimento suggerimento, int numTent) {
		// TODO Auto-generated method stub
		
		//visualizzazione combinazione
		
		pianta(y,numTent,true);
		
		//visualizzazione suggerimenti
		//System.out.println("Ho un bel:"+suggerimento.getSugg());
		int neri=(int)suggerimento.getSugg();
		//System.out.println("caro amico ho un:"+suggerimento.getSugg()+"---------------------------");
		int bianchi=(int)Math.round((suggerimento.getSugg()-neri)*10);		//floor non approssima bene!!!
		
		for(int i=bianchi+neri;i>0;i--)		//se bianchi+neri=0 non entro nel for
		{
			//System.out.println("Sono al giro:"+i+" sono figo:"+i%2+" numero immigrati:"+neri+" numero razzisti:"+bianchi);
			//System.out.println("immigrati incazzati:"+((i+1)%2)+" immigrati non incazzati:"+i%2);
			
			//if(neri!=0)
			//{
			//System.out.println("Cioccolato");
			JLabel sugg=null;
			if(neri!=0)
			{
				sugg=new JLabel(new ImageIcon(SUGGNERO));
				neri--;
			}
			else
			{
				sugg=new JLabel(new ImageIcon(SUGGBIANCO));
				bianchi--;
			}
			//System.out.println((i%2==0)+" sbirulini su una cassa da morto");
			if((i+2)%4==0 || (i+2)%4==1)
			{
				//System.out.println("Posizione X:"+(i%2)+" Posizione Y:"+(((i%2)+1)%2));
				sugg.setBounds((XSUGG+((i%2))*XDELTA_SUGG),(YSUGG+((((i%2)+1)%2)*YDELTA_SUGG)+(NEXTSUGG*-numTent)),sugg.getIcon().getIconWidth(),sugg.getIcon().getIconHeight());
					//System.out.println("Posizione X:"+suggNero.getX()+"Posizione Y:"+suggNero.getY());
				
			}
			else
			{
				//System.out.println("indice 1:"+(((i%2)+1)%2)+" indice 2:"+(i%2));
				//(XSUGG+(((i+1)%2)*XDELTA_SUGG))+" Posizione Y:"+(YSUGG+((i%2)*YDELTA_SUGG)+(NEXTSUGG*-numTent)));
				sugg.setBounds(((XSUGG+((((i%2)+1)%2)*XDELTA_SUGG))),(YSUGG+((((i%2)+1)%2)*YDELTA_SUGG)+(NEXTSUGG*-numTent)),sugg.getIcon().getIconWidth(),sugg.getIcon().getIconHeight());
			//	System.out.println("Posizione X:"+suggNero.getX()+"Posizione Y:"+suggNero.getY());
				
			}
			add(sugg);
			
			//neri--;
		//}
		/*
		else if(bianchi!=0)
		{
			System.out.println("Pozzu fa u prievite?");
			JLabel suggBianco=new JLabel(new ImageIcon(SUGGBIANCO));
			if(i%2==0)
				suggBianco.setBounds(XSUGG+(((i+1)%2)*XDELTA_SUGG),YSUGG+(((i%2)*YDELTA_SUGG))+(NEXTSUGG*-numTent),suggBianco.getIcon().getIconWidth(),suggBianco.getIcon().getIconHeight());
			else
				suggBianco.setBounds(XSUGG+((i%2)*XDELTA_SUGG),YSUGG+((((i+1)%2)*YDELTA_SUGG)+(NEXTSUGG*-numTent)),suggBianco.getIcon().getIconWidth(),suggBianco.getIcon().getIconHeight());
			add(suggBianco);
			bianchi--;
		}
		*/
		}
		//this.update(this.getGraphics());
		if(numTent==Tabellone.MAX-1 || suggerimento.getSugg()==Suggerimento.QN)//;	//cacciare ;
			{
				mostraSoluzione();
				forceOver();
			}
	}

	public void forceOver() {
		// TODO Auto-generated method stub
		over=true;
	}

	private void mostraSoluzione() {
		// TODO Auto-generated method stub
		SegretoPanel secret=new SegretoPanel();
		secret.pianta(soluzione);
		secret.setLocation(XSOLUZ,YSOLUZ);
		//secret.repaint();
		add(secret);
		
	}

	public boolean isOver() {
		return over;
	}
	

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
//		setBackground(new Color(174, 227, 175));
		Image image1 = null;				//commentare da qui per togliere sfondo
		try {
			image1 = ImageIO.read(new File(TABELLONEFILE));
		} catch (Exception e) {
			e.printStackTrace();
		}
		g.drawImage(image1, 0, 0, TABELLONE.getIcon().getIconWidth(), TABELLONE.getIcon().getIconHeight(), null);

	}

}

class SegretoPanel extends JPanel
{
	//private Grafica lnkGrafica;
	private static final String SEGRETO="Combinazione.JPG";
	private static final int XCOLOR=33;
	private static final int YCOLOR=18;
	private static final int XDELTA_COLOR=33;
	
	//-8 pixel di diff su asse Y
	//private static final int YDELTA_COLOR=
	
	private int xDim;
	private int yDim;

	public  SegretoPanel()
	{
		super();
		ImageIcon img=new ImageIcon(SEGRETO);
		xDim=img.getIconWidth();
		yDim=img.getIconHeight();
		setBounds(0,0,xDim,yDim);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Image image1 = null;
		try {
			image1 = ImageIO.read(new File(SEGRETO));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("X è:"+xDim+" Y è:"+yDim);
		g.drawImage(image1, 0, 0, xDim, yDim, null);

	}
	
	public void pianta(Combinazione y)
	{
		for(int i=0;i<Combinazione.LUNGHEZZA;i++)
		{
			JLabel color;
			//System.out.println("Sono un giotto"+(COLORI[y.getElem(i)-1])+" che è meglio "+y.getElem(i));
					//va fatto ad array globale
			try{
				color=new JLabel(new ImageIcon(Grafica.COLORI[y.getElem(i)-1]));
				color.setBounds(XCOLOR+(XDELTA_COLOR*i),YCOLOR,color.getIcon().getIconWidth(),color.getIcon().getIconHeight());
				//System.out.println(i+"colore è stato piantato in "+color.getX()+","+color.getY());
				add(color);
			}catch(ArrayIndexOutOfBoundsException aioobe)
			{
				
				if(i>Grafica.COLORI.length || i<Combinazione.VUOTO-1)
					aioobe.printStackTrace();
				//else
				//	remove(color[i]);
				//color=new JLabel(new ImageIcon(VUOTO));
			}
		}
	}
}
