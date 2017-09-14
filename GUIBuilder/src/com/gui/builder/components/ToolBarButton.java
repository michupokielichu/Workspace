package com.gui.builder.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.gui.builder.variables.IFonts;

public class ToolBarButton extends JButton implements ActionListener {

	JInternalFrame mInternalFrame = null;
	
	String mId = null;

	public ToolBarButton(JInternalFrame internalFrame) {
		mInternalFrame = internalFrame;
		setFont(IFonts.BUTTON_TOOLBAR);
		setPreferredSize(new Dimension(100, 25));
		setText(internalFrame.getTitle());
		setToolTipText(internalFrame.getTitle());
		mId = ((InternalFrame) internalFrame).getId();
		addActionListener(this);

		setForeground(Color.BLACK);
		setBackground(Color.WHITE);
		Border line = new LineBorder(Color.BLACK);
		Border margin = new EmptyBorder(5, 15, 5, 15);
		Border compound = new CompoundBorder(line, margin);
		setBorder(compound);
	}

	public boolean getState() {
		return mInternalFrame.isIcon();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			mInternalFrame.setIcon(!mInternalFrame.isIcon());
			mInternalFrame.setVisible(!mInternalFrame.isIcon());
		} catch (PropertyVetoException pvEx) {
			pvEx.printStackTrace();
		}
	}
	
	public String getId(){
		return mId;
	}

}
