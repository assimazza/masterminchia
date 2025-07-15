/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
//import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Punteggi extends JFrame {

	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JLabel jLabel = null;
	private HighScore high;

	/**
	 * This is the default constructor
	 */
	public Punteggi(HighScore high) {
		super();
		this.high=high;
		initialize();

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		//addWindowListener(new Ascoltatore());
		//this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Punteggi migliori");
		pack();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension size = this.getSize();
		screenSize.height = screenSize.height / 2;
		screenSize.width = screenSize.width / 2;
		size.height = size.height / 2;
		size.width = size.width / 2;
		int y = screenSize.height - size.height;
		int x = screenSize.width - size.width;
		this.setLocation(x, y);
		
		setResizable(false);
		setSize(250,this.getHeight());
		setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel(), java.awt.BorderLayout.CENTER);
			jContentPane.add(new JLabel("         "),BorderLayout.WEST);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel = new JLabel();
			jLabel.setText(" ");
			jPanel = new JPanel();
			jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
			jPanel.add(jLabel,null);
			for(int i=0;!high.isLast(i);i++)
			{	
				jPanel.add(new JLabel(high.getLine(i)), null);
				jPanel.add(new JLabel(" "),null);
			}
			jPanel.add(new JLabel(" "),null);
		}
		return jPanel;
	}
/*
	class Ascoltatore implements WindowListener
	{
		
		
		public void windowClosing(WindowEvent arg0) {
		
			dispose();
		}

		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
*/
}
