package com.gui.builder.components;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.gui.builder.variables.IComponent;

public class List extends JList<DefaultListModel> implements IComponent{
	private static final long serialVersionUID = -2804683057008176085L;
	private String mId;
	public List() {
	}

	@Override
	public String getId() {
		return mId;
	}

	@Override
	public void initialise(String id, String text) {
		mId=id;
		
	}

	@Override
	public void setObligatory(boolean obligatory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValue(String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisabled(boolean disabled) {
		
	}

	@Override
	public void addParameter(String strArg) {
		// TODO Auto-generated method stub
		
	}
}
