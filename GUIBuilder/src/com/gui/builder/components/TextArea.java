package com.gui.builder.components;

import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.gui.builder.translate.Translator;
import com.gui.builder.variables.IComponent;
import com.gui.builder.variables.IFonts;

public class TextArea extends JTextArea implements IComponent {
	private static final long serialVersionUID = -6995347366318656754L;
	private boolean mObligatory = false;
	private String mId;
	private int mHeight = 50;

	public TextArea() {
		super();
		setPreferredSize(new Dimension(0, mHeight));
		setLineWrap(true);
		setFont(IFonts.TEXT_FONT);

		getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				try {
					parse();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				try {
					parse();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				try {
					parse();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

		});
	}

	@Override
	public void initialise(String id, String text) {
		mId = id;
		setValue(text);
	}

	private void parse() throws ParseException {

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

	@Override
	public void setValue(String text) {
		String item = Translator.getLabel(text.split(":")[0], text.split(":")[1]);
		if (item != null) {
			setText(item);
		} else {
			setText(text);
		}
	}

	public void setHeight(int height) {
		mHeight = height;
		setPreferredSize(new Dimension(0, mHeight));
	}

	@Override
	public void setDisabled(boolean disabled) {
		setEnabled(!disabled);
	}

	@Override
	public void addParameter(String strArg) {
	}
}
