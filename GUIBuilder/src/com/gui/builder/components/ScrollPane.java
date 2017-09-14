package com.gui.builder.components;
import java.awt.Component;

import javax.swing.JScrollPane;

import org.apache.log4j.Logger;

import com.gui.builder.variables.IComponent;

public class ScrollPane extends JScrollPane implements IComponent{
	private static final long serialVersionUID = 5806185082966166096L;

	private String mId;

	private boolean mObligatory;
	final static Logger logger = Logger.getLogger(ScrollPane.class);
	
	
	public ScrollPane(String id, Component component, int i0, int i1) {
		super(component, i0, i1);
		mId = id;
	}

	public ScrollPane(String id) {
		mId = id;
	}
	
	@Override
	public void initialise(String id, String text) {
		
	}

	@Override
	public String getId() {
		return mId;
	}

	@Override
	public void setObligatory(boolean obligatory) {
		mObligatory = obligatory;
	}

	@Override
	public void setValue(String type) {
		
	}

	@Override
	public void check() {
		
	}
	
	
	@Override
	public void setDisabled(boolean disabled) {
		setEnabled(!disabled);
	}
}
