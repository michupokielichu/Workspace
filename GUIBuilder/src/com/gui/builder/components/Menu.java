package com.gui.builder.components;

import javax.swing.JMenu;

import com.gui.builder.variables.IFonts;
import com.gui.builder.variables.ISettings;

public class Menu extends JMenu {

	private static final long serialVersionUID = -8452141628224278367L;
	private String mName = null;

	public Menu(String string) {
		super(string);
		mName = string;
		setFont(IFonts.LABEL_FONT);
		setBackground(ISettings.MENU_BAR_BACKGROUND_COLOR);
	}
}
