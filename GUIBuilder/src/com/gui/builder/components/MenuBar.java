package com.gui.builder.components;

import javax.swing.JMenuBar;

import com.gui.builder.variables.IFonts;
import com.gui.builder.variables.ISettings;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = -8452141628224278367L;

	public MenuBar() {
		setFont(IFonts.LABEL_FONT);
		setBackground(ISettings.MENU_BAR_BACKGROUND_COLOR);
	}
}
