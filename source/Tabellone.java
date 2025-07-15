/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//1 Novembre 2006

public class Tabellone {

	public static final int MAX=10;

	private Grafica grafica;

	private Combinazione tentativi[];

	private int numTent;

	private final Combinazione incognita;

	private Suggerimento sugg[];

	private boolean perso;

	
	public Tabellone(Combinazione x) {

		tentativi=new Combinazione[MAX];
		numTent=0;
		perso=false;
		sugg=new Suggerimento[MAX];
		incognita=x;
		grafica=new Grafica(x);
	}

	public boolean verifica(Combinazione y) {
		
		sugg[numTent]=Suggerimento.valuta(incognita,y);
		//System.out.println("fatto"+sugg[numTent]);
		
		tentativi[numTent]=y;
		//System.out.println("piazzata"+tentativi[numTent]);
		
		grafica.aggiorna(y,sugg[numTent],numTent);
		
		numTent++;
		//System.out.println("aggiornato a"+numTent);
		
		if(sugg[numTent-1].vincente())
		{
			//grafica.vinci();
			return true;
		}
		else if(numTent==MAX)
		{
			//grafica.perdi();
			perso=true;
		}
		return false;

	}

	public int getNumTent() {
		return numTent;
	}

	public boolean isPerso() {
		return perso;
	}
	
	public String toString()
	{
		String ris="";
		ris=ris+"Stato tabellone:\n\n";
		
		for(int i=0;i<tentativi.length;i++)
			if(tentativi[i]!=null)
					ris=ris+tentativi[i].toString()+"\n";
		
		ris=ris+"\nStato suggerimenti:\n\n";
		
		for(int i=0;i<sugg.length;i++)
			if(sugg[i]!=null)
				ris=ris+sugg[i].toString()+"\n";
		
		return ris;
	}

	public Grafica getGrafica() {
		return grafica;
	}

	public void forcePerso() {
		// TODO Auto-generated method stub
		numTent=MAX;
		perso=true;
	}

//	public Combinazione getIncognita()
//	{return incognita;}
}
