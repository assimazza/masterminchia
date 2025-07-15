/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

/**
 * @model.uin <code>design:node:::-tdsqjuesa8b6vexrouow</code>
 */

//va testato
//il timer si deve spostare nella console!!!
public class Singola extends Partita {

	
	public Singola(Giocatore gigi,Opzioni opz,Endable who) {
		super(gigi,opz,who);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void creaTabellone() {
		// TODO Auto-generated method stub
		//System.out.println("Augh io essere figlio di "+vocentur);
		int segreto[]=new int [Combinazione.LUNGHEZZA];
		//System.out.println("Ci sono");

		//crea combinazione casuale

		if(opz.vuotoOn())
		{	for(int i=0;i<Combinazione.LUNGHEZZA;i++)
				{segreto[i]=(int)Math.round(Math.random()*Combinazione.ULTIMO);
				 //System.out.println(segreto[i]+" giro numero"+i);
				}
		}
		else
		{	
			for(int i=0;i<Combinazione.LUNGHEZZA;i++)
				segreto[i]=(int)Math.round(Math.random()*Combinazione.ULTIMO-1)+1;	//ammette solo i 6 colori		
		}
		tabellone=new Tabellone(new Combinazione(segreto));
		

		
	}

	@Override
	protected void confronta(/*Combinazione tentativo*/) {
		// TODO Auto-generated method stub
		//System.out.println("confronto...");
		if(timer.getState()==Thread.State.NEW)
			throw new IllegalStateException("Non è stato avviato l'orologio!!!");
		
		if(opz.tempoOn())	
			{
				timer.interrupt();
				vettTempi[tabellone.getNumTent()]=timer.getTime();
				
				//System.out.println("Tempo usato: "+vettTempi[tabellone.getNumTent()]);
			}
		
		boolean vittoria=tabellone.verifica(tentativo);
		
		//System.out.println("Tentativi eseguiti: "+tabellone.getNumTent());
		if (!vittoria && !tabellone.isPerso())		//si può cacciare l'else e mettere l'if senza ! al suo posto
		{
			if(opz.tempoOn())
			{
				//timer.reset();
				ServizioSveglia vecchio=timer.getServizio();
				timer=new Clock();
				timer.associa(vecchio);
				
			//	try {
					//timer.join();
				//} catch (InterruptedException e) {
					// TODO Auto-generated catch block
			//		e.printStackTrace();
			//	}
				timer.conteggio(opz.getTime());
			}
		}
		else
			comunicaEsito();
		
	}

	@Override
	protected boolean isSconfitto() {
		// TODO Auto-generated method stub
		return tabellone.isPerso();
	}

	@Override
	protected int calcolaPunteggio() {
		// TODO Auto-generated method stub
		int punt=0;
		if(opz.tempoOn())
		{
			int max=tabellone.getNumTent();
			for(int i=0;i<=max;i++)
				punt=(int) (punt+((((opz.getTime()-vettTempi[i])*100)/opz.getTime())*BONUS_SEC));	//% tempo rimasto
			
			if((opz.getTime()/60) <= BOUND_MIN)					//Bonus se pochi minuti
				punt=punt+(BONUS_MIN/((int)opz.getTime()/60));
			else if((opz.getTime()/60) > BOUND_MAX)				//Malus se molti minuti
				for(int i=0;i<(opz.getTime()/60)-BOUND_MAX;i++)
					punt=punt-MALUS_MIN;
		}
		punt=punt+(TOT-((tabellone.getNumTent()-1)*PENALITA));
		return punt;
	}
}
