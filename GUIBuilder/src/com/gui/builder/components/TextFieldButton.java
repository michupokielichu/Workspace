package com.gui.builder.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.gui.builder.main.Builder;
import com.gui.builder.main.IAction;
import com.gui.builder.variables.IComponent;

public class TextFieldButton extends JPanel implements IComponent{
	Logger logger = Logger.getLogger(TextFieldButton.class);

	private String mId;
	private JTextField mTextField;
	private JButton mBtnNewButton;
	public TextFieldButton() {
		setBackground(Color.ORANGE);
		setLayout(new BorderLayout(0, 0));
		
		mTextField = new TextField();
		add(mTextField);
		
		mBtnNewButton = new Button("...");
		mBtnNewButton.setPreferredSize(new Dimension(20, mBtnNewButton.getHeight()));
		add(mBtnNewButton, BorderLayout.EAST);
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialise(String id, String text) {
		mId = id;
		mBtnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				ClassLoader classLoader = Builder.class.getClassLoader();
				IAction action = null;
				try {
					logger.info(text);
					action = (IAction) classLoader.loadClass(text).newInstance();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				action.execute(null);
			}
		});
	}

	@Override
	public void setObligatory(boolean obligatory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValue(String text) {
		mTextField.setText(text);
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisabled(boolean disabled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addParameter(String strArg) {
		// TODO Auto-generated method stub
		
	}

}
