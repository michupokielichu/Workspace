package com.gui.builder.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

import com.gui.builder.components.ProgressBar;

public class ProgressBarWindow extends Thread {

	JProgressBar mPbar = null;

	static final int MIN = 0;
	static final int MAX = 100;
	private String mMessage = null;
	
	public ProgressBarWindow(String message) {
		mMessage = message;
		mPbar = new ProgressBar();
		mPbar.setMinimum(MIN);
		mPbar.setMaximum(MAX);
	}

	public void runBar() {

		Window w = new Window(null);
		w.setLayout(new BorderLayout());
		w.add(mPbar, BorderLayout.CENTER);

		w.add(new JLabel(mMessage), BorderLayout.NORTH);
		w.setVisible(true);
		w.setSize(600, 400);
		w.pack();
		w.setVisible(true);
		w.setBackground(Color.PINK);
		w.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - w.getSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - w.getSize().height) / 2);

		int i = MIN;
		while (true) {
			i = i++ > MAX ? MIN : i;
			final int percent = i;
			try {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						mPbar.setValue(percent);
					}
				});
				java.lang.Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void finishBar(){
		
	}

	public static void main(String[] args) {
		ProgressBarWindow b = new ProgressBarWindow("Generowanie raportu. Proszê czekaæ...");
		b.start();
		
	}

	@Override
	public void run() {
		runBar();
	}
}