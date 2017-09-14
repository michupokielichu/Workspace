package com.gui.builder.frame;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.gui.builder.main.Builder;
import com.gui.builder.main.GUIHelper;

/**
 * 
 * @author michu
 *
 */
public abstract class AbstractMainFrame extends JFrame {


	private static final long serialVersionUID = 5525080776506928031L;
	private List<Component> mComponents = null;

	public AbstractMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mComponents = new ArrayList<Component>();
		Builder builder = new Builder();
		try {
			String subPath = getClass().getPackage().getName().replace(".", "/") + "/" ;
			builder.loadProperties(subPath+getPropertyFile());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		builder.buidWindowFrame(this);
		
		mComponents.addAll(builder.getComponents());
//		setVisible(true);
		setSize(1024, 768);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		GUIHelper.setLookAndFeel(this);
	}

	public abstract String getPropertyFile();

	public List<Component> getGUIComponents() {
		return mComponents;
	}
	
}
