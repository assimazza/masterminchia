/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//19 Ottobre 2006

//ha passato lo unit testing


public class Combinazione {

	public static final int VUOTO=0;
	public static final int ROSSO=1;
	public static final int GIALLO=2;
	public static final int NERO=3;
	public static final int VERDE=4;
	public static final int BIANCO=5;
	public static final int BLU=6;
	
	public static final int ULTIMO=6;
	
	public static final int LUNGHEZZA=4;
	
	private int combinazione[];
	
	public Combinazione(Combinazione fratello) {
		
		// TODO Auto-generated constructor stub
		this.combinazione = fratello.getCombinazione();
	}

	public Combinazione(int a,int b,int c,int d)
	{
		if(a>BLU || a<VUOTO || b>BLU || b<VUOTO || c>BLU || c<VUOTO || d>BLU || d<VUOTO)
			throw new RuntimeException("Colore errato");
		
		combinazione=new int[LUNGHEZZA];
		
		combinazione[0]=a;
		combinazione[1]=b;
		combinazione[2]=c;
		combinazione[3]=d;
	}
	
	public Combinazione(int [] colori)
	{
		if (colori.length!=LUNGHEZZA)
			throw new RuntimeException("Lunghezza combinazione errata");
		
		if(colori[0]>BLU || colori[0]<VUOTO || colori[1]>BLU || colori[1]<VUOTO || colori[2]>BLU || colori[2]<VUOTO || colori[3]>BLU || colori[3]<VUOTO)
			throw new RuntimeException("Colore errato");		
		
		combinazione=new int [LUNGHEZZA];
		
		combinazione[0]=colori[0];
		combinazione[1]=colori[1];
		combinazione[2]=colori[2];
		combinazione[3]=colori[3];
	}

	public int[] getCombinazione() {
		return combinazione;
	}
	
	public int getElem(int i) {
		return combinazione[i];
	}

	public void setElem(int i,int value) {
		if (value<VUOTO || i>ULTIMO)
			throw new IllegalArgumentException("Colore non valido:"+value);
		else
			combinazione[i]=value;
	}
	
	public int getLUNGHEZZA() {
		return LUNGHEZZA;
	}
	
	public boolean equals(Object o)
	{
		if (!(o instanceof Combinazione))
			return false;
		
		Combinazione c2=(Combinazione)o;
		
		for(int i=0;i<LUNGHEZZA;i++)
			if(c2.getElem(i)!=combinazione[i])
				return false;
		
		return true;
	}
	
	public String toString()			//usato solo nel testing
	{
		String ris="";
		for(int i=0;i<LUNGHEZZA;i++)
		{
			switch(combinazione[i])
			{
				case VUOTO:
					ris=ris+"VUOTO ";
					break;
				case ROSSO:
					ris=ris+"ROSSO ";
					break;
				case GIALLO:
					ris=ris+"GIALLO ";
					break;
				case NERO:
					ris=ris+"NERO ";
					break;
				case VERDE:
					ris=ris+"VERDE ";
					break;
				case BIANCO:
					ris=ris+"BIANCO ";
					break;
				case BLU:
					ris=ris+"BLU ";
					break;
			}
			
		}
		return ris;
	}
	
}

