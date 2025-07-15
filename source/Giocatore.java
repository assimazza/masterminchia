/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006


import java.io.Serializable;

/**
 * @model.uin <code>design:node:::-tdsqjuesa964honvxd4u</code>
 */
public class Giocatore implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1815075489553836127L;
	//public Gestione gestione;
	//public StartUp startUp;
	//public Partita partita;
	private String nome;
	private Combinazione combinazione;
	private int vinte;
	private int perse;
	private long tempoGioco;
	private long ultimoTempo;
	private int punteggio;
	private double media;
	private int tentTot;
	
	private boolean win;

	public Giocatore(String nome) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.perse = 0;
		tempoGioco = 0;
		this.vinte = 0;
		combinazione=null;
		ultimoTempo=0;
		punteggio=0;
		this.media=0;
		tentTot=0;
		win=false;
	}

	public Giocatore(String nome, int perse, long tempo, int vinte, double media, int tent) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.perse = perse;
		tempoGioco = tempo;
		this.vinte = vinte;
		combinazione=null;
		ultimoTempo=0;
		punteggio=0;
		this.media=media;
		tentTot=tent;
	}

	public Combinazione getCombinazione() {
		return combinazione;
	}

	public void setCombinazione(Combinazione combinazione) {
		this.combinazione = combinazione;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void resetPunteggio() {
		this.punteggio = 0;
	}

	public int getPerse() {
		return perse;
	}

	public long getTempoGioco() {
		return tempoGioco;
	}

	public long getUltimoTempo() {
		return ultimoTempo;
	}

	public int getVinte() {
		return vinte;
	}
	
	public double getMedia() {
		return media;
	}

	public void reset()
	{
		this.perse = 0;
		tempoGioco = 0;
		this.vinte = 0;
		combinazione=null;
		ultimoTempo=0;
		punteggio=0;
		media=0;
		tentTot=0;
	}

	public void haiVinto(long[] vettTempi, int numTent, int punt,boolean vittoria) {
		// TODO Auto-generated method stub
		tentTot+=numTent;
		
		if(vittoria)
		{
			vinte++;
//			media=vinte/(vinte+perse);//tentTot;
		}
		else
			perse++;
		
		media=((double)vinte/(vinte+perse))*100;
		//System.out.println("media:"+media+"zio gigi dice:"+(vinte+perse)+"vinte:"+vinte+"perse:"+perse);
		ultimoTempo=0;
		for(int i=0;i<vettTempi.length;i++)
			ultimoTempo+=vettTempi[i];
		
		tempoGioco+=ultimoTempo;
		
		punteggio=punt;

		
	}

	public void forceWin() {
		// TODO Auto-generated method stub
		win=true;
	}

	public boolean isWin() {
		// TODO Auto-generated method stub
		return win;
	}

	public void reload() {
		// TODO Auto-generated method stub
		win=false;
	}


}
