package com.gui.builder.variables;

public interface IComponent {

	public String getId();
	
	public void initialise(String id, String text);

	public void setObligatory(boolean obligatory);

	public void setValue(String text);

	public void check();
	
	public void setDisabled(boolean disabled) ;

	public void addParameter(String strArg);
}
