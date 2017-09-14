package com.gui.builder.components;

import java.awt.Dimension;

import javax.swing.JButton;

import com.gui.builder.variables.IFonts;

public class Button extends JButton {
	private static final long serialVersionUID = -3120053343697085986L;

	public Button() {
		setFont(IFonts.BUTTON_FONT);
		setPreferredSize(new Dimension(100, 25));
		setMinimumSize(new Dimension(100, 25));
	}
	
	public Button(String string) {
		super(string);
		setFont(IFonts.BUTTON_FONT);
		setPreferredSize(new Dimension(100, 25));
		setToolTipText(string.replace(":", ""));
	}
}
