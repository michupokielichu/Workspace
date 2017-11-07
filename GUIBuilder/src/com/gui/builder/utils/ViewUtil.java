package com.gui.builder.utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

import com.gui.builder.components.Table;
import com.gui.builder.variables.ISettings;

public class ViewUtil {

	private static Border DEFAULT_BORDER;
	private static Color DEFAULT_BACKGROUND;

	public static void setFocus(Component component) {
		FocusListener highlighter = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if (e.getComponent() instanceof JComponent && !(e.getComponent() instanceof Table)) {
					DEFAULT_BACKGROUND = ((JComponent) e.getComponent()).getBackground();
					e.getComponent().setBackground(ISettings.MENU_BAR_BACKGROUND_COLOR);
					DEFAULT_BORDER = ((JComponent) e.getComponent()).getBorder();
					Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
					((JComponent) e.getComponent()).setBorder(border);
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if (e.getComponent() instanceof JComponent ) {
					e.getComponent().setBackground(DEFAULT_BACKGROUND);
					((JComponent) e.getComponent()).setBorder(DEFAULT_BORDER);
				}
			}
		};
		
		component.addFocusListener(highlighter);
	}
}
