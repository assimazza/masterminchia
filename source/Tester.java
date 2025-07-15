/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//7 Novembre 2006

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((1.3-1)*10);
		System.out.println((int)Math.round((1.4-1)*10));
		Combinazione segreto=new Combinazione(2,0,3,1);
		Suggerimento sugg=Suggerimento.valuta(segreto,new Combinazione(1,2,3,5));
		System.out.println("esito="+sugg.getSugg()+" ed è "+sugg.vincente());
		//OUTPUT ERRATI:
		//segreto=n,v,r,b	tentativo=r,v,b,g
//		segreto=n,v,r,b		tentativo=r,v,n,vuoto
		
		//Combinazione fratello=new Combinazione(segreto);
		//int vett[]=fratello.getCombinazione();
		//for(int i=0;i<vett.length;i++)	
		//	System.out.println(vett[i]);
		/*
		char finito='x';
		Tabellone tabula=new Tabellone(segreto);
		while(finito=='x')
		{
			
			System.out.println(tabula);
			System.out.println("Hai perso="+tabula.isPerso());
			System.out.println("Tentativi eseguiti="+tabula.getNumTent());
			int comba[]=new int[4];
			for(int i=0;i<4;i++)
				comba[i]=readInt("Inserire colore "+i+" : ");
			tabula.verifica(new Combinazione(comba[0],comba[1],comba[2],comba[3]));
			finito=readChar("Vuoi uscire? x se no");
		}
		*/
//		for(int i=0;i<1000;i++)
	//		System.out.print((int)(Math.round(Math.random()*5))+1+" ");
	
	/*	
		Clock timer=new Clock();
		timer.conteggio(18);
		try {
			sleep(10000);
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		timer.interrupt();
		System.out.println("Tempo: "+timer.getTime()+" finito: "+timer.tempoScaduto());
		timer.reset();
		System.out.println("RESETTAGGIO\nTempo: "+timer.getTime()+" finito: "+timer.tempoScaduto());
	*/
	
		/*
		Partita gioco=new Singola(new Giocatore(),new Opzioni(0,true,10,true));
		//gioco.creaTabellone();
		
		char finito='x';
		while(finito=='x')
		{
			
			System.out.println("Hai perso="+gioco.sconfitto());
			int comba[]=new int[4];
			for(int i=0;i<4;i++)
				comba[i]=readInt("Inserire colore "+i+" : ");
			gioco.confronta(new Combinazione(comba[0],comba[1],comba[2],comba[3]));
			finito=readChar("Vuoi uscire? x se no");
		}
		System.out.println("Punteggio: "+gioco.calcolaPunteggio());
		*/
		//JOptionPane who=new JOptionPane("fanculo",JOptionPane.QUESTION_MESSAGE);
		//JOptionPane who=new JOptionPane();
		//who.setWantsInput(true);
		//who.setWantsInput(true);
		//who.setLocation(50,50);
//		String minchiajava=(String)JOptionPane.showInputDialog(null,"fanculo",(String)"mammata",JOptionPane.QUESTION_MESSAGE,null,null,"culo");
//		System.out.println("Sting canta "+minchiajava);
//		JOptionPane.showConfirmDialog(who,"fanculotto",(String)"nculammammata",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE);
		//who.setVisible(true);
		//who.createDialog(who,"nculammamata");
		//System.out.println(who.isVisible()+"-"+who.getX()+who.getY());
	/*	
		HighScore gigi=new HighScore();
		System.out.println(gigi);
		gigi.aggiungi("Cazzillo",1000);
		System.out.println("Aggiunto cazzillo");
		System.out.println(gigi);
		gigi.aggiungi("Minchiux",500);
		System.out.println("Aggiunto Minchiux");
		System.out.println(gigi);
		gigi.aggiungi("Irachetor",2000);
		System.out.println("Aggiunto Irachetor");
		System.out.println(gigi);
		gigi.aggiungi("Inculator",2500);
		System.out.println(gigi);
		gigi.aggiungi("Merdarion",1500);
		System.out.println(gigi);
		gigi.aggiungi("Zunnannata",2300);
		System.out.println(gigi);
		gigi.aggiungi("CristinaIngalera",2500);
		System.out.println(gigi);
		gigi.aggiungi("Tuttincul",1500);
		System.out.println(gigi);
		gigi.aggiungi("Zio Gigi",700);
		System.out.println(gigi);
		gigi.aggiungi("Gran Nilo",3000);
		System.out.println(gigi);
		gigi.aggiungi("Cuddhiunix",100);
		System.out.println(gigi);
		System.out.println(gigi.aggiungi("Merdows",10));
		System.out.println(gigi);
	*/
		//int ris=JOptionPane.showConfirmDialog(null,"Sei sicuro di voler resettare i punteggi?","Resetti?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		//System.out.println(ris);
		//new Punteggi(new HighScore());
		//new Info();
		//new GUIgestione();
		//new GiocoOpzioni(new Gestione("Pippo"));
		//new Regole();
		/*
		JFrame minchio=new JFrame("TEST DRIVE");
		//Console consob=new Console(null);
		
		JMenu antipasti=new JMenu("Antipasti");
		JMenu primi=new JMenu("Primi");
		JMenuItem calabrese=new JMenuItem("Calabrese");
		JMenuItem funghi=new JMenuItem("Ai funghi");
		JMenuItem gnocchi=new JMenuItem("Gnocchi");
		JMenuItem fusilli=new JMenuItem("Fusilli");
		antipasti.add(calabrese);
		antipasti.add(funghi);
		primi.add(gnocchi);
		primi.add(fusilli);
		JMenuBar pasto=new JMenuBar();
		pasto.add(antipasti);
		pasto.add(primi);
		minchio.setJMenuBar(pasto);
		
		Grafica consob=new Grafica(new Combinazione(2,3,4,5));
		minchio.setContentPane(consob);

		//minchio.add(consob);
		minchio.setBounds(100,100,consob.getWidth(),consob.getHeight());
		//minchio.pack();
		minchio.setVisible(true);
		minchio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consob.aggiorna(new Combinazione(1,2,3,4),Suggerimento.valuta(new Combinazione(1,2,3,4),new Combinazione(1,2,4,3)),9);
		//SegretoPanel sp=new SegretoPanel();
		//minchio.add(sp);
		consob.aggiorna(new Combinazione(2,3,4,5),Suggerimento.valuta(new Combinazione(2,3,6,4),new Combinazione(2,3,4,5)),1);
		*/
		/*
		consob.aggiorna(new Combinazione(3,4,5,6),Suggerimento.valuta(new Combinazione(2,3,5,4),new Combinazione(2,3,4,5)),2);
		consob.aggiorna(new Combinazione(2,3,4,5),Suggerimento.valuta(new Combinazione(5,4,3,2),new Combinazione(2,3,4,5)),3);
		consob.aggiorna(new Combinazione(2,3,4,5),Suggerimento.valuta(new Combinazione(2,3,4,5),new Combinazione(1,1,1,1)),4);
		consob.aggiorna(new Combinazione(2,3,4,5),Suggerimento.valuta(new Combinazione(1,3,4,5),new Combinazione(1,1,1,1)),5);
		//consob.aggiorna(new Combinazione(2,3,4,5),Suggerimento.valuta(new Combinazione(1,1,1,1),new Combinazione(1,1,1,1)),10);
		consob.aggiorna(new Combinazione(2,3,4,5),Suggerimento.valuta(new Combinazione(1,1,1,1),new Combinazione(1,1,1,1)),9);
		consob.aggiorna(new Combinazione(2,3,4,5),Suggerimento.valuta(new Combinazione(1,1,1,1),new Combinazione(1,1,1,1)),8);
		consob.aggiorna(new Combinazione(2,3,4,5),Suggerimento.valuta(new Combinazione(1,1,1,1),new Combinazione(1,1,1,1)),7);
		consob.aggiorna(new Combinazione(2,3,4,5),Suggerimento.valuta(new Combinazione(1,1,1,1),new Combinazione(1,1,1,1)),6);
		*/
		/*
		minchio.update(minchio.getGraphics());
		System.out.println(2%4+" "+4%4);
		System.out.println(((double)1/(1+1)));
		*/
	}

	
	//copiati da console
	   public static void printPrompt(String prompt)
	   {  System.out.print(prompt + " ");
	      System.out.flush();
	   }

	   /**
	    * read a string from the console. The string is
	    * terminated by a newline
	    * @return the input string (without the newline)
	    */

	   public static String readString()
	   {  int ch;
	      String r = "";
	      boolean done = false;
	      while (!done)
	      {  try
	         {  ch = System.in.read();
	            if (ch < 0 || (char)ch == '\n')
	               done = true;
	            else if ((char)ch != '\r') // weird--it used to do \r\n translation
	               r = r + (char) ch;
	         }
	         catch(java.io.IOException e)
	         {  done = true;
	         }
	      }
	      return r;
	   }

	   /**
	    * read a string from the console. The string is
	    * terminated by a newline
	    * @param prompt the prompt string to display
	    * @return the input string (without the newline)
	    */

	   public static String readString(String prompt)
	   {  printPrompt(prompt);
	      return readString();
	   }

	   /**
	    * read a word from the console. The word is
	    * any set of characters terminated by whitespace
	    * @return the 'word' entered
	    */

	   public static String readWord()
	   {  int ch;
	      String r = "";
	      boolean done = false;
	      while (!done)
	      {  try
	         {  ch = System.in.read();
	            if (ch < 0
	               || java.lang.Character.isWhitespace((char)ch))
	               done = true;
	            else
	               r = r + (char) ch;
	         }
	         catch(java.io.IOException e)
	         {  done = true;
	         }
	      }
	      return r;
	   }

	   /**
	    * read an integer from the console. The input is
	    * terminated by a newline
	    * @param prompt the prompt string to display
	    * @return the input value as an int
	    * @exception NumberFormatException if bad input
	    */

	   public static int readInt(String prompt)
	   {  while(true)
	      {  printPrompt(prompt);
	         try
	         {  return Integer.valueOf
	               (readString().trim()).intValue();
	         } catch(NumberFormatException e)
	         {  System.out.println
	               ("Forkert valg, Prøv igen!");
	         }
	      }
	   }

	   /**
	    * read a floating point number from the console.
	    * The input is terminated by a newline
	    * @param prompt the prompt string to display
	    * @return the input value as a double
	    * @exception NumberFormatException if bad input
	    */

	   public static double readDouble(String prompt)
	   {  while(true)
	      {  printPrompt(prompt);
	         try
	         {  return Double.valueOf
	               (readString().trim()).doubleValue();
	         } catch(NumberFormatException e)
	         {  System.out.println
	         ("Not a floating point number. Please try again!");
	         }
	      }
	   }

	   /*
	    Legge 1 char in input, non va daccapo
	   */


	   public static char readChar(String prompt)
	   {
	        printPrompt(prompt);        //stampa ciò che gli si passa come argomento

	        String ris=readString();
	        return ris.charAt(0);
	    }
}
