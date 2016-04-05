/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.TimerTest
 * @description:TODO
 * @date:2016-4-5 下午4:03:31
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
package corejava;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

class TimePrinter implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Date now=new Date();
		System.out.println("At the tone, the time is "+now);
		Toolkit.getDefaultToolkit().beep();
	}
	
}

public class TimerTest
{
	public static void main(String[] args)
	{
		ActionListener listener = new TimePrinter();
		
		//construct a timer that calls the listener
		//once every 10 seconds
		Timer t=new Timer(10000, listener);
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}
