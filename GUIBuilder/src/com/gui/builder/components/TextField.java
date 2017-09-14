package com.gui.builder.components;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigDecimal;

import javax.swing.JTextField;

import com.gui.builder.variables.IFonts;
import com.gui.builder.variables.IComponent;

public class TextField extends JTextField implements IComponent {
	private static final long serialVersionUID = 4085675198919370979L;
	private boolean mObligatory = false;
	private BigDecimal mMin = null;
	private BigDecimal mMax = null;
	private String mId;

	public TextField(){
		super();
		setFont(IFonts.TEXT_FONT);
	}
	
	@Override
	public void initialise(String id, String text) {
		mId = id;
		setValue(text);
		addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent e) {
				parse();
			}
		});
	}

	private void parse() {
	}

	public void setObligatory(boolean obligatory) {
		mObligatory = obligatory;
		this.setBackground(Color.YELLOW);
	}

	public void check() {
	}


	public String getId() {
		return mId;
	}

	public void setValue(String text) {
		setText(text);
	}
	
	
	@Override
	public void setDisabled(boolean disabled) {
		setEnabled(!disabled);
	}
}
