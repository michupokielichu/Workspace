package com.gui.builder.components;

import com.gui.builder.variables.IFonts;
import com.gui.builder.variables.IComponent;
import com.toedter.calendar.JDateChooser;

public class DateChooser extends JDateChooser implements IComponent{

	private static final long serialVersionUID = -2358991569289426482L;
	private String mId;
	private boolean mObligatory;

	
	public DateChooser(){
		
	}
	
	@Override
	public void initialise(String id, String text) {
		mId = id;
		setFont(IFonts.TEXT_FONT);		
	}

	public void testMode() {

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
	public void setValue(String type) {
		
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void setDisabled(boolean disabled) {
		setEnabled(!disabled);
	}
}
