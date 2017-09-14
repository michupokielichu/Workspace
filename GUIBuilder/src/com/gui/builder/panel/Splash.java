package com.gui.builder.panel;

import javax.swing.JWindow;
import javax.swing.SwingConstants;

import com.gui.builder.components.Image;

public class Splash extends JWindow {
	public Splash() {
		getContentPane().add(new Image("rsrc/logo.png"), SwingConstants.CENTER);
		setBounds(500, 150, 300, 200);
		setVisible(true);
////		try {
////			Thread.sleep(5000);
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////		}
////		setVisible(false);
//		dispose();
	}
}
