/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

import java.util.ListIterator;
import java.util.LinkedList;
import java.util.List;

public class ServizioSveglia {

	private List<Soundable> utenti;
	
	public ServizioSveglia()
	{
		utenti=new LinkedList<Soundable>();
	}
	
	public void subscribe(Soundable cliente) {
		// TODO Auto-generated method stub
		utenti.add(cliente);
	}

	public void avvisa() {
		// TODO Auto-generated method stub
		ListIterator <Soundable> scroller=utenti.listIterator();
		for(int i=scroller.nextIndex();scroller.hasNext();i++)
			{
				//System.out.println("sto telefonando a "+i);
				scroller.next().ring();
			}
	}


}
