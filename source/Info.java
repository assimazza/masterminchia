/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

import java.awt.BorderLayout;
//import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Info extends JFrame {

	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JLabel about = null;
	private JButton okButton = null;
	private JLabel about1;
	private JLabel about2;

	/**
	 * This is the default constructor
	 */
	public Info() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		addWindowListener(new Ascoltatore());
		//this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Riconoscimenti...");
		pack();
		this.setResizable(false);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension size = this.getSize();
		screenSize.height = screenSize.height / 2;
		screenSize.width = screenSize.width / 2;
		size.height = size.height / 2;
		size.width = size.width / 2;
		int y = screenSize.height - size.height;
		int x = screenSize.width - size.width;
		this.setLocation(x, y);
		
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
			jContentPane.setLayout(new BorderLayout(10,10));
			jContentPane.add(getJPanel(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getJPanel1(), java.awt.BorderLayout.EAST);
			jContentPane.add(new JLabel("     "), java.awt.BorderLayout.WEST);
			jContentPane.add(getJPanel2(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(new JLabel(""), java.awt.BorderLayout.NORTH);
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
			jPanel = new JPanel();
			//jPanel.setLayout();
			jPanel.setLayout(new BoxLayout(jPanel,BoxLayout.Y_AXIS));
			jPanel.add(new JLabel("     "),null);
			jPanel.add(new JLabel(getSubIcon()),null);//,BorderLayout.NORTH);
			jPanel.add(new JLabel("     "),null);
			jPanel.add(new JLabel(getDEISIcon()),null);//,BorderLayout.SOUTH);
			
		}
		return jPanel;
	}

	private ImageIcon getDEISIcon() {
		// TODO Auto-generated method stub
		ImageIcon deis=new ImageIcon("DEIS.jpg");
		return deis;
	}

	private ImageIcon getSubIcon() {
		// TODO Auto-generated method stub
		ImageIcon io=new ImageIcon("Sub.jpg");
		return io;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			about = new JLabel();
			about.setText(" - MASTERMINCHIA -      ");
			about1=new JLabel();
			about1.setText("Sviluppato da...     ");
			about2=new JLabel("SUBCOMANDANTE PEPPOS     ");
			jPanel1 = new JPanel();
			jPanel1.setLayout(new BoxLayout(jPanel1,BoxLayout.Y_AXIS));
			jPanel1.add(new JLabel("     "),null);
			jPanel1.add(about, null);
			jPanel1.add(new JLabel("     "),null);
			jPanel1.add(new JLabel("     "),null);
			jPanel1.add(new JLabel("     "),null);
			jPanel1.add(about1, null);
			jPanel1.add(new JLabel("     "),null);
			jPanel1.add(about2, null);
			jPanel1.add(new JLabel("     "),null);
			jPanel1.add(new JLabel("     "),null);
						
			jPanel1.add(new JLabel("     "),null);
			jPanel1.add(new JLabel("Militante presso:"),null);
			jPanel1.add(new JLabel("     "),null);
			jPanel1.add(new JLabel("     "),null);
			jPanel1.add(new JLabel("UniCazz"),null);
			jPanel1.add(new JLabel("(Università della Calafrica)"),null);
			jPanel1.add(new JLabel("     "),null);
			jPanel1.add(new JLabel("Arcasbracata"),null);
			jPanel1.add(new JLabel("Cusenza"),null);
			jPanel1.add(new JLabel("     "),null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.add(getOkButton(), null);
		}
		return jPanel2;
	}

	/**
	 * This method initializes okButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getOkButton() {
		if (okButton == null) {
			okButton = new JButton("Cià");
			
			okButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
					JOptionPane.showMessageDialog(null,"Fotografia dedicata al compagno Andrea De Francesco\n\nHASTA LA FIGA SIEMPRE COMANDANTE!!!","Dedica....",JOptionPane.INFORMATION_MESSAGE);
					dispose();
					//chiudi finestra
				}
			});
		}
		return okButton;
	}

	class Ascoltatore implements WindowListener
	{
		
		
		public void windowClosing(WindowEvent arg0) {
		
			JOptionPane.showMessageDialog(null,"Sono staaaaaanco.","ZiziRoberts dice:",JOptionPane.INFORMATION_MESSAGE);
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

}
