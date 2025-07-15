/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

//Ha passato lo Unit Testing, ma non sono stati verificati tutti i casi dei pioli bianchi (verificati solo 4.0,2.2,0.4)
//dovendo indovinare 1 2 3 4 e fornendo 0 1 2 3 il suggerimento ricevuto è stato 0.30000000000000004 invece di 0.3
//è stato fornito 5 4 3 2 dovendo indovinare 1 2 3 4 output 1.2


public class Suggerimento {

	public static final double/*int*/ QN=4.0;//8;		//Q=QUATTRO T=TRE D=DUE U=UNO
	public static final double/*int*/ TN=3.0;//6;		//N=NERO B=BIANCO NN=NIENTE
	public static final double/*int*/ DN=2.0;//4;
	public static final double/*int*/ UN=1.0;//2;
	public static final double/*int*/ NN=0.0;//0;
	public static final double/*int*/ UB=0.1;//1;
	public static final double/*int*/ DB=0.2;//3;
	public static final double/*int*/ TB=0.3;//5;
	public static final double/*int*/ QB=0.4;//7;
	public static final double/*int*/ UNTB=1.3;//11;
	public static final double/*int*/ UNDB=1.2;//10;
	public static final double/*int*/ UNUB=1.1;//9;
	public static final double/*int*/ DNUB=2.1;//12;
	public static final double/*int*/ DNDB=2.2;//13;
	public static final double/*int*/ TNUB=3.1;//14;
	
	private double sugg;
	
	private Suggerimento(int esito[]) {				
		// TODO Auto-generated constructor stub
		
		this.sugg = esito[0]+(esito[1]*0.1);		//troncare al primo decimale
	}

	public boolean vincente() {
		if (sugg==QN)
			return true;
		else
			return false;
	}

	public static Suggerimento valuta(Combinazione y, Combinazione x) {
		
		if(y.equals(x))
			return new Suggerimento((new int[]{4,0}));
		
		int nGiusti=0;									//inizializzazione dei giusti
		int nBianchi=0;
		
		boolean giusti[]=new boolean[x.getLUNGHEZZA()];
		boolean usati[]=new boolean[x.getLUNGHEZZA()];		//pioli tentativo usati
		
		for(int i=0;i<giusti.length;i++)		//giusti[]=colori di y azzeccati
		{
			giusti[i]=false;
			usati[i]=false;
		}
		
		for(int i=0;i<giusti.length;i++)		//conteggio pioli neri
			if(x.getElem(i)==y.getElem(i))
			{
				giusti[i]=true;
				usati[i]=true;
				//System.out.println("Ho beccato un nero:"+i+",colore:"+x.getElem(i));
				nGiusti++;
			}
		//for(int i=0;i<giusti.length;i++)			//usato per il tesing
			//System.out.println("colore "+(i+1)+"="+giusti[i]);
		
		for(int i=0;i<giusti.length;i++)	//conteggio pioli bianchi (si fissa un non giusto e si scorre la combinazione incognita)
			if(giusti[i]==false)			//andrebbe messo:giusti[j]==false
			{
				//System.out.println("Ho beccato uno sbagliato");
				for(int j=0;j<y.getLUNGHEZZA();j++)		//controllare
					if(x.getElem(i)==y.getElem(j) && usati[j]==false && giusti[j]==false)	//se è uguale e sia il piolo tentativo che quello segreto nn sono impegnati
					{
						//System.out.println("Ho beccato un bianco, è il numero "+j+",colore:"+x.getElem(j)+" è stato contato:"+giusti[j]);
						nBianchi++;
						usati[j]=true;
						//giusti[j]=true;
						/*giusti[j]=true;*/break;					//assicurarsi che quando viene beccato uno al posto sbagliato si interrompa il ciclo
						//for(int k=0;k<giusti.length;k++)			//usato per il tesing
						//	System.out.println("colore "+(k+1)+"="+giusti[k]);
					}
						
			}
		
		if(nBianchi+nGiusti>giusti.length)
			throw new RuntimeException("Errore nella valutazione della combinazione");
	
		return new Suggerimento(new int[]{nGiusti,nBianchi});
	}

	public double getSugg() {
		return sugg;
	}

	
	public String toString()			//usato solo nel testing
	{
		return ""+sugg;
	}
}
