/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.innerClass.InnerClassTest
 * @description:TODO
 * @date:2016-4-5 下午4:21:11
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-5     WangHao       v1.0.0        create
 *
 *
 */
package corejava.innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;


//demonstrates the use of inner classes.

//A clock that prints the time in regular intervals.
/**
 * @className:corejava.innerClass.TalkingClock
 * @description:TODO
 * @version:v1.0.0 
 * @date:2016-4-5 下午4:25:18
 * @author:WangHao
 */
class TalkingClock
{
	private int interval;
	private boolean beep;
	
	/**
	 * Constructs a talking clock
	 * @param interval the interval between messages(in milliseconds)
	 * @param beep true if the clock should keep
	 */
	public TalkingClock(int interval, boolean beep)
	{
		this.interval=interval;
		this.beep=beep;
	}
	
	public void start()
	{
		ActionListener listener=new TimePrinter();
		Timer t=new Timer(interval, listener);
		t.start();
	}
	public class TimePrinter implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			Date now=new Date();
			System.out.println("At the tone, the time is "+now);
			if(TalkingClock.this.beep)
				Toolkit.getDefaultToolkit().beep();
		}
	}
}
public class InnerClassTest
{
	public static void main(String[] args)
	{
		TalkingClock clock=new TalkingClock(10000, true);
		clock.start();
		//keep program running until user selects "Ok"
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}
