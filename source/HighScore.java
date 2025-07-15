/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//7 Novembre 2006

import java.io.Serializable;

//da testare


public class HighScore implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4017645578337416115L;

	public final static int MAX_LONG=25;
	
	private final int NUM=10;
	private final int RECORD=2;
	
	private Object [][]tabella;
	
	public HighScore()
	{
		tabella=new Object[NUM][RECORD];
		for(int i=0;i<NUM;i++)
			for(int j=0;j<RECORD;j++)
				if(j%RECORD==0)
					tabella[i][j]="";
				else
					tabella[i][j]=0;
	}
	
	public String toString()
	{
		String ris="";
		for(int i=0;i<NUM;i++)
		{
			ris=ris+(i+1)+"    ";					//numero record
			for(int j=0;j<RECORD;j++)
				if(j%RECORD==0)			//distingue stringa
				{
					String tmp=(String)tabella[i][j];
					ris=ris+tmp;
					if(tmp.length()<MAX_LONG)		//controlla se il campo è completamente riempito
					{
						int cnt=MAX_LONG-tmp.length();
						for(int k=0;k<cnt;k++)		//aggiunge spazi vuoti
							ris=ris+" ";
					}
				}
				else
					ris=ris+"\t"+tabella[i][j]+"\n";		//aggiunge punteggio
		}		
		return ris;
	}
	
	public boolean aggiungi(String nome,int punteggio)
	{
		for(int i=0;i<NUM;i++)
			if((Integer)tabella[i][RECORD-1]<=punteggio)
			{
				shift(i);
				tabella[i][RECORD-2]=nome;
				tabella[i][RECORD-1]=punteggio;
				return true;
			}
		return false;
	}
	
	private void shift(int j)	//c'è un errore grosso quanto una casa
	{
		String tmpNome="";
		int tmpPunt=0;
		for(int i=j;i<NUM-1;i++)	
		{
			//if(i==NUM-2)
			//	break;
			/*
			String tmpNome=(String)tabella[i+1][RECORD-2];
			int tmpPunt=(Integer)tabella[i+1][RECORD-1];
			System.out.println(tmpNome);
			System.out.println(toString());
			tabella[i+1][RECORD-2]=tabella[i][RECORD-2];
			tabella[i+1][RECORD-1]=tabella[i][RECORD-1];
			System.out.println(toString());
			//tabella[i+2][RECORD-2]=tmpNome;
			//tabella[i+2][RECORD-1]=tmpPunt;
			//System.out.println(toString());
			punto=
			*/
		//	tabella[i-1][RECORD-2]=tabella[i][RECORD-2];
		//	tabella[i-1][RECORD-1]=tabella[i][RECORD-1];
		//	System.out.println(toString());
			if(i==j)
			{
				tmpNome=(String)tabella[i+1][RECORD-2];
				tmpPunt=(Integer)tabella[i+1][RECORD-1];
				tabella[i+1][RECORD-2]=tabella[i][RECORD-2];
				tabella[i+1][RECORD-1]=tabella[i][RECORD-1];
			}
			else
			{
				String saveNome=(String)tabella[i+1][RECORD-2];
				Integer savePunt=(Integer)tabella[i+1][RECORD-1];
				tabella[i+1][RECORD-2]=tmpNome;
				tabella[i+1][RECORD-1]=tmpPunt;
				tmpNome=saveNome;
				tmpPunt=savePunt;
			}
		}
	}
	
	public String getLine(int i)
	{
		if(i>NUM || i<0)
			throw new IllegalArgumentException("Record richiesto fuori classifica");
		
		String ris="  "+(i+1)+"    ";					//numero record
		for(int j=0;j<RECORD;j++)
			if(j%RECORD==0)			//distingue stringa
			{
				String tmp=(String)tabella[i][j];
				ris=ris+tmp;
				if(tmp.length()<MAX_LONG)		//controlla se il campo è completamente riempito
				{
					int cnt=MAX_LONG-tmp.length();
					for(int k=0;k<cnt;k++)		//aggiunge spazi vuoti
						ris=ris+" ";
				}
			}
			else
				ris=ris+"\t"+tabella[i][j]+"\n";		//aggiunge punteggio
		return ris;
	}
	
	public boolean isLast(int i)
	{
		if (i>=NUM)
			return true;
		return false;
	}
}
