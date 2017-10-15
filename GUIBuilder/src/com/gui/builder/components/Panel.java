package com.gui.builder.components;
import javax.swing.JPanel;

import com.gui.builder.variables.IComponent;

public class Panel extends JPanel implements IComponent{
	private static final long serialVersionUID = 5806185082966166096L;
	private boolean mObligatory;

	private String mId;
	
	public Panel(){
		
	}

	@Override
	public String getId() {
		return mId;
	}
	
	@Override
	public void initialise(String id, String text) {
		mId = id;
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

	@Override
	public void addParameter(String strArg) {
		// TODO Auto-generated method stub
		
	}
}
