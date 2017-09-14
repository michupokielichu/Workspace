package com.gui.builder.components;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.gui.builder.variables.IFonts;

public class Label extends JLabel {
	private static final long serialVersionUID = -2804683057008176085L;

	public Label(String string) {
		super(string, SwingConstants.RIGHT);
		setFont(IFonts.LABEL_FONT);
		if (string != null) {
			setToolTipText(string.replace(":", ""));
		}
	}
}
