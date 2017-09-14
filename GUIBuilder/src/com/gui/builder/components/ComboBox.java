package com.gui.builder.components;

import javax.swing.JComboBox;

import com.gui.builder.variables.IFonts;
import com.gui.builder.variables.IComponent;

public class ComboBox extends JComboBox<String> implements IComponent {

	private static final long serialVersionUID = 1941888493109127503L;
	private String mId;
	private boolean mObligatory;

	public ComboBox(){
		
	}
	
	@Override
	public void initialise(String id, String text) {
		mId = id;
		setFont(IFonts.TEXT_FONT);		
		setValue(text);
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return mId;
	}

	@Override
	public void setObligatory(boolean obligatory) {
		mObligatory = obligatory;
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValue(String values) {
		if (values != null) {
			for (String item : values.split(";")) {
				addItem(item);
			}
		}
	}

	
	@Override
	public void setDisabled(boolean disabled) {
		setEnabled(!disabled);
	}
}
