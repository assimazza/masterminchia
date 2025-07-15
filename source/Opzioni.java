/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//7 Novembre 2006

import java.io.Serializable;

public class Opzioni implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2143714360947226232L;
	private boolean tempo;
	private long time;		//secondi
	private boolean vuoto;
	//private int difficoltà;
	
	
	public Opzioni(/*int difficoltà,*/ boolean tempo, long time, boolean vuoto) {
		// TODO Auto-generated constructor stub
		//this.difficoltà = difficoltà;
		this.tempo = tempo;
		this.time = time;
		this.vuoto = vuoto;
	}

	public long getTime()
	{return time;}

	public boolean tempoOn() {
		// TODO Auto-generated method stub
		return tempo;
	}

	public boolean vuotoOn() {
		// TODO Auto-generated method stub
		return vuoto;
	}
/*
	public int getDifficoltà() {
		return difficoltà;
	}
*/
}
