/*
	This file is part of Masterminchia.

    Masterminchia is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

    Masterminchia is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along with Masterminchia. If not, see <https://www.gnu.org/licenses/>.

    Copyright (C) 2006, Assimazza - GC - Webiste: https://emigratoinviperito.wordpress.com/ - Contact: https://github.com/assimazza
*/
//8 Novembre 2006

//import javax.swing.JPanel;
import javax.swing.JLabel;

public class TimerUpdater extends Thread{

	private long LAST_CALL=30;
	
	private JLabel warn;
	private JLabel update;
	private Clock timer;
	private Console frame;
	
	public TimerUpdater(Console update) {
		super();
		// TODO Auto-generated constructor stub
		this.timer = update.askClock();
		this.frame = update;
		warn=update.getAttenzione();
		this.update=update.getCnt();
	}
	
	public void run()
	{
		while(!interrupted())
		{
			long time=timer.getTime();
			if(time==0 || timer.isFermo())
			{
				timer=frame.askClock();
				time=timer.getTime();
			}
			frame.setCnt(time/60+":"+time%60);
			if((time%60)<=LAST_CALL && time/60==0 && timer.isRovescia())
				warn.setVisible(true);
			else
				warn.setVisible(false);
			update.update(update.getGraphics());
		}
	}
}
