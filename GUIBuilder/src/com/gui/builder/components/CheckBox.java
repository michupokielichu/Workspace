package com.gui.builder.components;

import javax.swing.JCheckBox;

import com.gui.builder.variables.IFonts;
import com.gui.builder.variables.IComponent;

public class CheckBox extends JCheckBox implements IComponent {

	private static final long serialVersionUID = 4489767466362373840L;
	private String mId;
	private boolean mObligatory;

	public CheckBox() {
		super();
	}
	
	@Override
	public void initialise(String id, String text) {
		mId = id;
		setFont(IFonts.TEXT_FONT);		
		setValue(text);
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
	public void check() {

	}

	@Override
	public void setValue(String text) {
		setText(text);
	}

	

	@Override
	public void setDisabled(boolean disabled) {
		setEnabled(!disabled);
	}

}
