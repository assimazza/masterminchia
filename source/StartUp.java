/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

//import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @model.uin <code>design:node:::-tdsqjuesa98h6a-a4lysy</code>
 */
public class StartUp {


	
/**
 * @label Avvia
 */

/*#GUIgestione Dependency_Link*/

public static void main(String args[])
	{
			Gestione gest;
			try {
				gest = Gestione.carica();
				new GUIgestione(gest);
			} catch (FileNotFoundException e) {
		
				new GUIgestione();
				
			} catch (ClassCastException e) {
				e.printStackTrace();
				System.out.println("Errore nel salvataggio del file vecchio");	
				JOptionPane.showMessageDialog(null,"Errore nel caricamento del file, il programma sarà resettato","Errore!!!",JOptionPane.ERROR_MESSAGE);
				new GUIgestione();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Errore lettura file");
				JOptionPane.showMessageDialog(null,"Errore nella lettura del file, il programma sarà resettato","Errore!!!",JOptionPane.ERROR_MESSAGE);
				new GUIgestione();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Errore critico!!! Il computer potrebbe autodistruggersi, riavviare il sistema e riprovare.","Errore!!!",JOptionPane.ERROR_MESSAGE);
				return;
			}

			System.out.println("MASTERMINCHIA - BY Peppone");
		}
	}

