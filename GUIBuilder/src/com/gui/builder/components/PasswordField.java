package com.gui.builder.components;

import java.awt.Color;

import javax.swing.JPasswordField;

import com.gui.builder.variables.IComponent;

public class PasswordField extends JPasswordField implements IComponent {

	private String mId;
	private boolean mObligatory;

	public PasswordField() {
	}
	
	@Override
	public void initialise(String id, String text) {
		mId = id;
	}

	@Override
	public String getId() {
		return mId;
	}

	@Override
	public void setObligatory(boolean obligatory) {
		mObligatory = obligatory;
		this.setBackground(Color.YELLOW);
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

	@Override
	public void addParameter(String strArg) {
		// TODO Auto-generated method stub
		
	}
}
