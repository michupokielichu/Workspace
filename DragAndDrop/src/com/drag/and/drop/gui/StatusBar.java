package com.drag.and.drop.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
	private JLabel mSize;

	public StatusBar() {
		super();
		mSize = new JLabel();
		setLayout(new BorderLayout());
		mSize.setText("2 GB");
		add(mSize, BorderLayout.EAST);
	}

	public void setSize(long size) {
		mSize.setText(size + "");
	}
}
