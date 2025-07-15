/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

import java.util.concurrent.atomic.*;

//ha passato il test

//avvia e conteggio vanno internate in run

public class Clock extends Thread {

	private boolean fermo;
	private AtomicLong time;		//millisecondi
	//private Partita partita;
	private boolean rovescia;
	private boolean fine;
	private ServizioSveglia user;
	
	public Clock(/*Partita partita //ServizioSveglia who*/) {
		// TODO Auto-generated constructor stub
		
		//this.partita=partita;
		fermo=true;
		time=new AtomicLong(0);
		rovescia=false;
		fine=false;
		user=null;//who;
		//System.out.println("sono nato "+fermo);
	}

	public void conteggio(long time) {
		// TODO Auto-generated method stub
		//System.out.println("sono tornato "+fermo);
		if (fermo==false)
			throw new IllegalThreadStateException("Orologio attivo!!!");
		if(user==null)
			throw new  IllegalStateException("Nessuna classe da notificare!!! Aggiungere un ServizioSveglia");
		this.time=new AtomicLong(time);
		rovescia=true;
		fermo=false;
		start();
	}

	public void avvia() {					//converrebbe internarla nella start
		// TODO Auto-generated method stub
		if (fermo==false)
			throw new IllegalThreadStateException("Orologio attivo!!!");
		
		fermo=false;
		start();
	//	join(this);
	}
/*
	public long arresta() {			//controllare consistenza
		// TODO Auto-generated method stub
		if (fermo==true)
			throw new IllegalThreadStateException("Orologio fermo!!!");
		
		fermo=true;
		return time.get();
	}
*/
	public void run()//throws TempoException
	{
		//	if (fermo==false)
			//	throw new IllegalThreadStateException("Orologio attivo!!!");
		
			//fermo=false;
			//System.out.println("Sono partito");
			//System.out.println(fermo);
			if(rovescia)
			{
				fine=true;
				//long cnt=time.get();
				//for(int i=0;i<cnt && !isInterrupted()/*!fermo*/;i++)
				//	time.decrementAndGet();
				//if(fermo)
				//	throw new InterruptedException();//throw new TempoException("Tempo finito");
				while(time.get()>0 && !isInterrupted())
					try {
						
						time.decrementAndGet();
						sleep(1000);//,1000000000); //nanosec //1000);	//millisec
						
						
						//System.out.println(time.get());
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						fine=false;
						//System.out.println("mi hanno fatto la bua");
						break;
					}
					//System.out.println("Ho finito");
					if(fine)
						user.avvisa();
			}
			else
			{
				while(!isInterrupted())
					try {
						
						time.incrementAndGet();
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						break;
					}
					
			}
			fermo=true;
			
	}

	public boolean tempoScaduto()
	{
		if(rovescia=false)
			return true;
			
		if(fine==true && fermo==true)
			return true;
		else
			return false;
	}
	
	/*public void reset()
	{
		time.set(0);
		rovescia=false;
		fine=false;
		fermo=true;
	
	}*/
	
	public long getTime()
	{
		return time.get();
	}

	public boolean isRovescia() {
		return rovescia;
	}

	public boolean isFermo() {
		return fermo;
	}

	public ServizioSveglia getServizio() {
		// TODO Auto-generated method stub
		return user;
	}

	public void associa(ServizioSveglia avviso) {
		// TODO Auto-generated method stub
		user=avviso;
	}
}
