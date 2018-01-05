package com.gui.builder.main;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.gui.builder.components.Panel;
import com.gui.builder.components.TextField;
import com.gui.builder.panel.AbstractPanel;

public class GUIHelper {
	
	private static Logger logger = Logger.getLogger(GUIHelper.class);

	public static void setLookAndFeel(Component component) {
		String os = System.getProperty("os.name");
		try {
			if (os.startsWith("Windows")) {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} else if (os.startsWith("Linux")) {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				


			}
			SwingUtilities.updateComponentTreeUI(component);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void checkTextField(Component[] list) {
		for (Component component : list) {
			if (component instanceof Panel) {
				checkTextField(((Panel) component).getComponents());
			}
			if (component instanceof TextField) {
				((TextField) component).check();
			}
		}	
	}

	public static void printComponentSize(Component component) {
		logger.debug("Width: " + component.getWidth());
		logger.debug("Height: " + component.getHeight());
	}
	
	public static List<Component> loadAllComponents(List<Component> components) {
		List<Component> allComponents = new ArrayList<>();
		for (Component component : components) {
			if (component instanceof Panel) {
				allComponents.addAll( loadAllComponents(((AbstractPanel) component).getGUIComponents()));
			} else {
				allComponents.add(component);
			}
		}
		return allComponents;
	}
}
