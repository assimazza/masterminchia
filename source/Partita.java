/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

//va testato


public abstract class Partita implements Soundable{

	protected Giocatore giocatore;
	protected long[] vettTempi;
	protected Tabellone tabellone;
	protected Clock timer;
	protected Opzioni opz;
	protected String nome;
	protected Combinazione tentativo;
	private Endable ender;
	protected boolean fine;
	
	protected final int TOT=1000;
	protected final int PENALITA=100;
	protected final int BONUS_SEC=10;
	public static final int MALUS_MIN=1;
	public static final int BONUS_MIN=6;
	public static final int BOUND_MIN=3;
	public static final int BOUND_MAX=10;
	
	public Partita(Giocatore gigi,Opzioni opz, Endable who)
	{
		//ServizioSveglia usciere=new ServizioSveglia();
		//usciere.subscribe(this);
		timer=new Clock();
		vettTempi=new long[Tabellone.MAX];
		giocatore=gigi;
		this.opz=opz;
		//System.out.println("Sopra la campa la crapa panca");
		nome=giocatore.getNome();
		tentativo=new Combinazione(Combinazione.VUOTO,Combinazione.VUOTO,Combinazione.VUOTO,Combinazione.VUOTO);
		ender=who;
		fine=false;
		creaTabellone();
	}
	
	protected abstract void confronta(/*Combinazione comb*/);
	
	protected abstract boolean isSconfitto();
	
	protected abstract int calcolaPunteggio();
	
	protected abstract void creaTabellone();
	
	protected void comunicaEsito()			//non testato
	{
		if(isSconfitto())
			{
				giocatore.haiVinto(vettTempi,tabellone.getNumTent(),0/*calcolaPunteggio()*/,false);
				ender.termina();
			}
		else
			{
				giocatore.haiVinto(vettTempi,tabellone.getNumTent(),calcolaPunteggio(),true);
				ender.termina();
			}
		fine=true;
	}
	
	public Clock getClock()
	{
		return timer;
	}

	public String getNome() {
		return nome;
	}

	public Combinazione getTentativo() {
		return tentativo;
	}
	
	public void setTentativo(int i,int value)
	{
		tentativo.setElem(i,value);
		//System.out.println(tentativo);
	}

	public void ring()
	{
		confronta();
	}

	public boolean isFine() {
		return fine;
	}
	
	public void surrender()
	{
		//fine=true;
		tabellone.forcePerso();
		//avvisaTutti();
		comunicaEsito();
	}
	
	public void startTempo()
	{
		if(opz.tempoOn())
			timer.conteggio(opz.getTime());
		else
			timer.avvia();
	}
	
//	public Combinazione getSegreto()
//	{return tabellone.getIncognita();}
}
