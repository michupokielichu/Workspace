package com.gui.builder.components;

import javax.swing.DefaultDesktopManager;
import javax.swing.DesktopManager;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import org.apache.log4j.Logger;

import com.gui.builder.variables.ISettings;

public class DesktopPane extends JDesktopPane {
	private static final long serialVersionUID = 5806185082966166096L;

	final static Logger logger = Logger.getLogger(DesktopPane.class);

	DesktopManager mManager = null;

	public DesktopPane() {
		putClientProperty("JDesktopPane.dragMode", "outline");
		setBackground(ISettings.DESKTOP_PANE_BACKGROUND_COLOR);

		mManager = new DefaultDesktopManager() {
			public void activateFrame(JInternalFrame f) {
				super.activateFrame(f);
			}
		};
		setDesktopManager(mManager);
	}
}
