/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006


import java.io.*;


//computer va fatto ereditare da giocatore

/**
 * @model.uin <code>design:node:::-tdsqjuesa91cso-gkouy</code>
 */
public class Gestione implements Endable{
	public final static String FILE="dati.dat";
/*	public final static int INGENUO=0;
	public final static int FACILE=1;
	public final static int MEDIO=2;
	public final static int DIFFICILE=3;
	*/public final static int SINGOLA=0;
	//public final static int DOPPIA=1;
	//public final static int MULTIPLAYER=2;
	//public Computer computer;
	private Giocatore giocatore;
	private Partita gioco;
	private boolean tempo;
	private long tempoMax;
	private HighScore highScore;	//farlo ad oggetto?
	//private int difficoltà;
	private boolean vuoto;
	private boolean newRecord;
	
	public Gestione(String nome)
	{
		gioco=null;
		tempo=true;
		tempoMax=180;
		highScore=new HighScore();
		//difficoltà=MEDIO;
		vuoto=true;
		//JOptionPane who=new JOptionPane("fanculo",JOptionPane.QUESTION_MESSAGE);
		giocatore=new Giocatore(nome);
		newRecord=false;
	}
	
	public Gestione(Opzioni opz, HighScore highScore2, Giocatore giocatore2) {
		// TODO Auto-generated constructor stub
		gioco=null;
		tempo=opz.tempoOn();
		tempoMax=opz.getTime();
		highScore=highScore2;
		//difficoltà=opz.getDifficoltà();
		vuoto=opz.vuotoOn();
		giocatore=giocatore2;
		newRecord=false;
	}

	private Opzioni esportaOpzioni()
	{
		return new Opzioni(/*difficoltà,*/tempo,tempoMax,vuoto);
	}
	
	public Partita creaPartita(int tipo)
	{
		switch(tipo)
		{
		case SINGOLA:
			giocatore.resetPunteggio();
			gioco=new Singola(giocatore,esportaOpzioni(),this);
			return gioco;
/*			
		
		case DOPPIA:
			return null;
		
		case MULTIPLAYER:
			return null;
		*/
		default:
			return null;
		}
	}
	
	public boolean aggiornaHighScore()
	{
		return highScore.aggiungi(giocatore.getNome(),giocatore.getPunteggio());
	}
	
	public void salva() throws FileNotFoundException, IOException		//ha senso fare un salva dinamico e un carica statico?
	{
		File save=new File(FILE);
		if(save.exists())
			save.delete();
		
		save.createNewFile();
		
		ObjectOutputStream scriba=new ObjectOutputStream(new FileOutputStream(save));
		
		scriba.writeObject(esportaOpzioni());
		scriba.writeObject(highScore);
		scriba.writeObject(giocatore);
		
		scriba.flush();
		scriba.close();
	}
	
	public static Gestione carica() throws FileNotFoundException, IOException, ClassNotFoundException, ClassCastException
	{
		File store=new File(FILE);
		
		ObjectInputStream leggione=new ObjectInputStream(new FileInputStream(store));
		
		
		Opzioni opz=(Opzioni)leggione.readObject();
		HighScore highScore=(HighScore)leggione.readObject();
		Giocatore giocatore=(Giocatore)leggione.readObject();
		
		return new Gestione(opz,highScore,giocatore);
	}
	
	public void resetHighScore()
	{
		highScore=null;
		highScore=new HighScore();
	}
/*
	public int getDifficoltà() {
		return difficoltà;
	}

	public void setDifficoltà(int difficoltà) {
		this.difficoltà = difficoltà;
	}
*/
	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {	//modificare
		this.giocatore = giocatore;
	}

	public boolean isTempo() {
		return tempo;
	}

	public void setTempo(boolean tempo) {
		this.tempo = tempo;
		//System.out.println(this.tempo);
	}

	public long getTempoMax() {
		return tempoMax;
	}

	public void setTempoMax(long tempoMax) {
		this.tempoMax = tempoMax;
	}

	public boolean isVuoto() {
		return vuoto;
	}

	public void setVuoto(boolean vuoto) {
		this.vuoto = vuoto;
	}

	public Partita getGioco() {
		return gioco;
	}

	public HighScore getHighScore() {
		return highScore;
	}

	public boolean isNewRecord() {
		return newRecord;
	}

	public void resetNewRecord() {
		this.newRecord = false;
	}
	
	public void termina() {
		// TODO Auto-generated method stub
		//gioco.surrender();		//si invoca ricorsivamente
		gioco=null;
		if(giocatore.getPunteggio()>0)
		{
			newRecord=highScore.aggiungi(giocatore.getNome(),giocatore.getPunteggio());
			giocatore.forceWin();
		}
		//avvisa gui che è tutto finito
	}

	public void forceEnd() {
		// TODO Auto-generated method stub
		gioco.surrender();
	}
	

}
