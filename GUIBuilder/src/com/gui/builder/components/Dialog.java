package com.gui.builder.components;
import javax.swing.JDialog;

public class Dialog extends JDialog{
	private static final long serialVersionUID = 5806185082966166096L;

	private Object mObject = null;
	
	public Dialog(){
		setModal(true);
	}
	
	public void setValue(Object object){
		mObject = object;
	}
	
	public Object showDialog(){
		setVisible(true);
		return mObject;
	}
}
