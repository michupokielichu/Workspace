package com.gui.builder.components;

import javax.swing.JInternalFrame;

public class InternalFrame extends JInternalFrame {
	private static final long serialVersionUID = -3120053343697085986L;

	protected String mId = null;
	

	public InternalFrame(String name) {
		super(name, true, true, true, true);
		setSize(1200, 700);
	}

	public InternalFrame() {
		super("", true, true, true, true);
		setSize(1200, 700);
	}

	public String getId() {
		return mId;
	}

	public void setId(String mId) {
		this.mId = mId;
	}

}
